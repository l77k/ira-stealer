/*
 * Decompiled with CFR 0.152.
 */
import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public interface \u056b
extends StdCallLibrary {
    public static final \u056b method_FF;

    public int method_FF(Object[] var1);

    public boolean method_FF(Object[] var1);

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
                char[] cArray2 = "iP3JoRh".toCharArray();
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
                    case 0 -> 26;
                    case 1 -> 56;
                    case 2 -> 86;
                    case 3 -> 38;
                    case 4 -> 3;
                    case 5 -> 97;
                    default -> 90;
                }));
                ++n2;
                n3 = n3;
            } while (n3 > n2);
        }
        String string = new String(cArray).intern();
        method_FF = Native.load(string, \u056b.class, W32APIOptions.DEFAULT_OPTIONS);
    }

    public static void main(String[] stringArray) {
        throw new RuntimeException("Invalid execution context: 0x908177");
    }
}

