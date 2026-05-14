import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * Cleaned IoStatusBlock (formerly ô.java)
 * Represents the native Windows IO_STATUS_BLOCK structure.
 * Used for low-level NT system calls (e.g., NtOpenFile, NtDeviceIoControlFile)
 * to bypass standard security hooks.
 */
@Structure.FieldOrder(value={"status", "information"})
public class IoStatusBlock extends Structure {
    // The status of the I/O operation
    public int status;
    
    // Additional information (like the number of bytes transferred)
    public Pointer information;

    public IoStatusBlock() {
        super();
    }
}
