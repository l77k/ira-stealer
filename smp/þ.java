import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/**
 * Cleaned NativeDataBuffer (formerly þ.java)
 * A generic data structure used to exchange variable-length data
 * between the Java loader and the native payload via Named Pipes.
 */
public class NativeDataBuffer extends Structure {
    public int type;
    public Pointer data;
    public int length;

    @Override
    protected List<String> getFieldOrder() {
        // Standard JNA field order: type, data, length
        return Arrays.asList("type", "data", "length");
    }

    public NativeDataBuffer() {
        super();
    }
}
