/**
 * Cleaned SoftwareRecord (formerly ԡ.java)
 * A data record representing stolen software account information.
 */
public record SoftwareRecord(
    String accountId, 
    String username, 
    String sessionToken, 
    int level, 
    String status
) {
    // Record class handles toString, hashCode, and equals automatically
}
