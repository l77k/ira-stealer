import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.win32.W32APIOptions;

/**
 * Cleaned Kernel32 (formerly d.java)
 * JNA interface for kernel32.dll.
 */
public interface Kernel32 extends Library {
    Kernel32 INSTANCE = Native.load("kernel32", Kernel32.class, W32APIOptions.UNICODE_OPTIONS);

    // Add native method signatures as needed by other modules
}
