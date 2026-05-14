import java.nio.charset.StandardCharsets;

/**
 * Cleaned WinApiLoader (formerly i.java)
 * Responsible for loading core Windows DLLs via JNA for low-level system access.
 */
public class WinApiLoader {
    // Decoded DLL Name: "kernel32"
    public static final String KERNEL32_DLL = "kernel32";
    
    // Decoded DLL Name: "advapi32"
    public static final String ADVAPI32_DLL = "advapi32";

    /**
     * Logic extracted from the static block and method_FF.
     * Decodes byte arrays used for Native.load()
     */
    public static String decode(byte[] encrypted, int keySeed) {
        byte[] decrypted = new byte[encrypted.length];
        // The malware uses a specific XOR logic found in i.java:18-21
        for (int i = 0; i < encrypted.length; i++) {
            // Simulated XOR key from the ZKM key pool
            decrypted[i] = (byte)(encrypted[i] ^ (keySeed & 0xFF));
        }
        return new String(decrypted, StandardCharsets.UTF_8);
    }
}
