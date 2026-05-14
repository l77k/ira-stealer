import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * Cleaned ObjectAttributes (formerly ù.java)
 * Represents the native Windows OBJECT_ATTRIBUTES structure.
 * This is the primary structure used to provide a name and other 
 * attributes to Object Manager routines (like NtOpenFile or NtCreateFile).
 */
@Structure.FieldOrder(value={
    "length", 
    "rootDirectory", 
    "objectName", 
    "attributes", 
    "securityDescriptor", 
    "securityQualityOfService"
})
public class ObjectAttributes extends Structure {
    public int length;
    public Pointer rootDirectory;
    
    // Points to a UNICODE_STRING (ö.java / ö.java)
    public StructureReference objectName; 
    
    public int attributes;
    public Pointer securityDescriptor;
    public Pointer securityQualityOfService;

    public ObjectAttributes() {
        super();
        this.length = this.size();
        // OBJ_CASE_INSENSITIVE (0x00000040) is a common attribute used here
        this.attributes = 0x40; 
    }
}
