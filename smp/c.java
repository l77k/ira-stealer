import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

/**
 * Cleaned User32 (formerly c.java)
 * JNA interface for user32.dll.
 */
public interface User32 extends StdCallLibrary {
    User32 INSTANCE = Native.load("user32", User32.class, W32APIOptions.DEFAULT_OPTIONS);

    // Add native method signatures as needed by other modules
}
