import com.sun.jna.Structure;
import com.sun.jna.WString;

/**
 * Cleaned UnicodeString (formerly ø.java)
 * Represents the native Windows UNICODE_STRING structure used in NT APIs.
 * It automatically prefixes paths with "\??\" to use native Object Manager
 * paths, which helps in bypassing user-mode security hooks.
 */
@Structure.FieldOrder(value={"length", "maximumLength", "buffer"})
public class UnicodeString extends Structure {
    public short length;
    public short maximumLength;
    public WString buffer;

    // The native NT path prefix: "\??\"
    private static final String NT_PATH_PREFIX = "\\??\\";

    public UnicodeString() {
        super();
    }

    /**
     * Constructs a UNICODE_STRING from a standard Java string,
     * adding the required NT prefix for native API compatibility.
     */
    public UnicodeString(String path) {
        String fullPath = path.startsWith("\\") ? path : NT_PATH_PREFIX + path;
        this.buffer = new WString(fullPath);
        this.length = (short) (fullPath.length() * 2);
        this.maximumLength = (short) (this.length + 2);
    }
}
