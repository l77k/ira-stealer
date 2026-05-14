/*
 * Decompiled with CFR 0.152.
 */
import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

public interface \u0566
extends StdCallLibrary {
    public static final \u0566 method_FF;

    public int method_FF(Object[] var1);

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
                char[] cArray2 = "a0\rh\u001b".toCharArray();
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
                    case 0 -> 15;
                    case 1 -> 68;
                    case 2 -> 105;
                    case 3 -> 4;
                    case 4 -> 119;
                    case 5 -> 13;
                    default -> 77;
                }));
                ++n2;
                n3 = n3;
            } while (n3 > n2);
        }
        String string = new String(cArray).intern();
        method_FF = Native.load(string, \u0566.class, W32APIOptions.DEFAULT_OPTIONS);
    }

    public static void main(String[] stringArray) {
        throw new RuntimeException("Invalid execution context: 0x6cddf7");
    }
}

