import java.util.ArrayList;
import java.util.List;

/**
 * Cleaned EncryptionState (formerly s.java)
 * A simple container that holds the Master Key and additional derived keys
 * or IVs used by the DPAPIDecryptor to recover browser secrets.
 */
public class EncryptionState {
    // The main Master Key (usually decrypted from 'Local State' file)
    public final byte[] masterKey;
    
    // A list of additional IVs or derived keys for different browser profiles
    public final List<byte[]> additionalKeys;

    public EncryptionState(byte[] masterKey, byte[] initialIV) {
        this.masterKey = masterKey;
        this.additionalKeys = new ArrayList<>();
        if (initialIV != null) {
            this.additionalKeys.add(initialIV);
        }
    }

    /**
     * Adds a new key or IV to the state.
     */
    public void addKey(byte[] key) {
        if (key != null) {
            this.additionalKeys.add(key);
        }
    }
}
