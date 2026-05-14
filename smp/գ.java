/*
 * Decompiled with CFR 0.152.
 */
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

public interface \u0563
extends StdCallLibrary {
    public static final \u0563 INST;
    public static final String a;

    public static \u0563 create() {
        try {
            return (\u0563)((Object)g_0.a("load", "In-/x$Gh/-pxAj-"v-Ic"#utJg#$s#Nf$%p%Oa%&wwH`&"rvIc"#qsJg#$p.Nf$%s!Oa%&spH`&"puIc"#q!Jg#$s$Nf$%spOa%&t&H`&"v%", "(Ljava/lang/String;Ljava/lang/Class;Ljava/util/Map;)Lcom/sun/jna/Library;", 2, a, \u0563.class, W32APIOptions.DEFAULT_OPTIONS));
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    public boolean SetWindowPos(long var1, long var3, int var5, int var6, int var7, int var8, int var9);

    public int GetWindowLongW(long var1, int var3);

    public int SetWindowLongW(long var1, int var3, int var4);

    public long FindWindowW(char[] var1, char[] var2);

    public boolean ShowWindow(long var1, int var3);

    public boolean SetForegroundWindow(long var1);

    public short GetKeyState(int var1);

    public long SetWindowsHookExW(int var1, WinUser.LowLevelKeyboardProc var2, Pointer var3, int var4);

    public boolean UnhookWindowsHookEx(long var1);

    public long CallNextHookEx(long var1, int var3, int var4, Pointer var5);

    public boolean GetMessageW(WinUser.MSG var1, long var2, int var4, int var5);

    public boolean TranslateMessage(WinUser.MSG var1);

    public long DispatchMessageW(WinUser.MSG var1);

    public boolean PostMessage(long var1, int var3, Pointer var4, Pointer var5);

    public boolean EnumWindows(\u0562 var1, Pointer var2);

    public int GetWindowTextW(long var1, char[] var3, int var4);

    public boolean IsWindowVisible(long var1);

    public int GetWindowThreadProcessId(long var1, IntByReference var3);

    /*
     * Handled impossible loop by duplicating code
     * Enabled aggressive block sorting
     */
    static {
        char[] cArray;
        block11: {
            int n2;
            int n3;
            block10: {
                char[] cArray2 = "A\u0001d6P/".toCharArray();
                cArray = cArray2;
                n3 = cArray2.length;
                n2 = 0;
                if (!true) break block10;
                n3 = n3;
                if (n3 <= n2) break block11;
            }
            do {
                cArray = cArray;
                int n4 = n2;
                char c2 = cArray[n4];
                cArray[n4] = (char)(c2 ^ (switch (n2 % 7) {
                    case 0 -> 52;
                    case 1 -> 114;
                    case 2 -> 1;
                    case 3 -> 68;
                    case 4 -> 99;
                    case 5 -> 29;
                    default -> 7;
                }));
                ++n2;
                n3 = n3;
            } while (n3 > n2);
        }
        a = new String(cArray).intern();
        INST = \u0563.create();
    }

    public static void main(String[] stringArray) {
        throw new RuntimeException("Invalid execution context: 0x124a45");
    }
}

