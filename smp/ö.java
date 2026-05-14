import com.sun.jna.Structure;

/**
 * Cleaned StructureReference (formerly ö.java)
 * A wrapper class that allows JNA structures to be passed 
 * "By Reference" (as pointers) to native Windows API functions.
 */
public class StructureReference extends WinNativeStructure implements Structure.ByReference {
    // This class is a marker/wrapper for passing structure pointers
}
