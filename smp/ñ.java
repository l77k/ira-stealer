import java.io.OutputStream;

/**
 * Cleaned SilentOutputStream (formerly ñ.java)
 * A "Null" output stream that discards everything written to it.
 * Used by the bootstrapper to silence the malware's console output.
 */
public class SilentOutputStream extends OutputStream {
    
    public SilentOutputStream() {
        // No initialization needed
    }

    @Override
    public void write(int b) {
        // Do nothing - effectively swallowing all log and error messages
    }
}
