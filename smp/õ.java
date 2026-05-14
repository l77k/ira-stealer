import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * Cleaned FileRenameInfo (formerly õ.java)
 * Represents the native Windows FILE_RENAME_INFORMATION structure.
 * Used with NtSetInformationFile to rename or move files at a low level,
 * bypassing standard file system protections.
 */
@Structure.FieldOrder(value={"replaceIfExists", "rootDirectory", "fileNameLength", "fileName"})
public class FileRenameInfo extends Structure {
    // If true, replace the file if it already exists
    public byte replaceIfExists;
    
    // Handle to the root directory (optional)
    public Pointer rootDirectory;
    
    // Length of the new file name in bytes
    public int fileNameLength;
    
    // The new file name buffer (variable length)
    public char[] fileName = new char[256];

    public FileRenameInfo() {
        super();
    }
}
