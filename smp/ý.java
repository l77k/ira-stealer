import com.sun.jna.Structure;

/**
 * Cleaned FileBasicInfo (formerly ý.java)
 * Represents the native Windows FILE_BASIC_INFORMATION structure.
 * Used for "Timestomping" - modifying file creation and access times
 * to make malicious files appear as legitimate, old system files.
 */
@Structure.FieldOrder(value={
    "creationTime", 
    "lastAccessTime", 
    "lastWriteTime", 
    "changeTime", 
    "fileAttributes"
})
public class FileBasicInfo extends Structure {
    public long creationTime;
    public long lastAccessTime;
    public long lastWriteTime;
    public long changeTime;
    public int fileAttributes;

    public FileBasicInfo() {
        super();
    }
}
