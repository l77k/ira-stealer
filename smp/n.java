import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.win32.StdCallLibrary;

/**
 * Cleaned NtDll (formerly n.java)
 * JNA interface for the Windows NT System Library (ntdll.dll).
 * Provides access to low-level system calls that bypass standard Win32 APIs.
 */
public interface NtDll extends StdCallLibrary {
    NtDll INSTANCE = Native.load("ntdll", NtDll.class);

    /**
     * Retrieves information about the specified process.
     * Often used by malware to detect debuggers or sandboxes.
     */
    int NtQueryInformationProcess(
        WinNT.HANDLE processHandle,
        int processInformationClass,
        Pointer processInformation,
        int processInformationLength,
        int[] returnLength
    );
}
