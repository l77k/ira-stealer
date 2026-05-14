import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;

/**
 * Cleaned PipeCommunicator (formerly m.java)
 * Establishes a communication channel between the Java loader and the 
 * native Windows payload (REAL_PAYLOAD.exe) using Named Pipes.
 */
public class PipeCommunicator {
    private WinNT.HANDLE pipeHandle;
    private final String pipeName;

    public PipeCommunicator(String pipeName) {
        this.pipeName = pipeName;
    }

    /**
     * Creates the named pipe and waits for the native payload to connect.
     */
    public void initializePipe() throws Exception {
        // Creates a duplex pipe with a 4096 byte buffer
        this.pipeHandle = NativeWinApi.INSTANCE.CreateNamedPipe(
            pipeName, 3, 0, 1, 4096, 4096, 0, null);
            
        if (WinBase.INVALID_HANDLE_VALUE.equals(this.pipeHandle)) {
            throw new Exception("Failed to create communication pipe.");
        }
    }

    /**
     * Sends a command or data to the native payload.
     */
    public void sendData(String data) {
        byte[] buffer = (data + "\n").getBytes();
        NativeWinApi.INSTANCE.WriteFile(
            pipeHandle, buffer, buffer.length, new IntByReference(), null);
    }

    /**
     * Reads a response from the native payload.
     */
    public String receiveData() {
        byte[] buffer = new byte[1024];
        IntByReference bytesRead = new IntByReference();
        
        boolean success = NativeWinApi.INSTANCE.ReadFile(
            pipeHandle, buffer, buffer.length, bytesRead, null);
            
        if (success && bytesRead.getValue() > 0) {
            return new String(buffer, 0, bytesRead.getValue()).trim();
        }
        return null;
    }

    /**
     * Closes the pipe and cleans up.
     */
    public void close() {
        if (pipeHandle != null) {
            NativeWinApi.INSTANCE.DisconnectNamedPipe(pipeHandle);
            NativeWinApi.INSTANCE.CloseHandle(pipeHandle);
        }
    }
}
