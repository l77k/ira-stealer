import com.sun.jna.ptr.IntByReference;

/**
 * Cleaned IntReference (formerly ÿ.java)
 * A wrapper for JNA's IntByReference.
 * Used to receive integer output values from native Windows API calls.
 */
public class IntReference extends IntByReference {
    public IntReference(int value) {
        super(value);
    }
}
