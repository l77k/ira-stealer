/*
 * Decompiled with CFR 0.152.
 */
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public interface \u0564
extends StdCallLibrary {
    public static final \u0564 method_FF;
    public static final String a;

    public static \u0564 method_FF(Object[] objectArray) {
        try {
            return (\u0564)((Object)g_0.a("load", "Oa%&r#H`&'vvIc'#q-Jb#$t/Kf$%p#Oa%&q%H`&'vuIc'#utJb#$puKf$%s.Oa%&r!H`&'rvIc'#wwJb#$p!Kf$%p$Oa%&rrH`&'u&Ic'#q%", "(Ljava/lang/String;Ljava/lang/Class;Ljava/util/Map;)Lcom/sun/jna/Library;", 2, a, \u0564.class, W32APIOptions.DEFAULT_OPTIONS));
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    public long method_FF(Object[] var1);

    public boolean method_FF(Object[] var1);

    public boolean method_FE(Object[] var1);

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
                char[] cArray2 = "\u0007c@s^\u000f\u0002^".toCharArray();
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
                    case 0 -> 108;
                    case 1 -> 6;
                    case 2 -> 50;
                    case 3 -> 29;
                    case 4 -> 59;
                    case 5 -> 99;
                    default -> 49;
                }));
                ++n2;
                n3 = n3;
            } while (n3 > n2);
        }
        a = new String(cArray).intern();
        method_FF = \u0564.method_FF(new Object[0]);
    }

    public static void main(String[] stringArray) {
        throw new RuntimeException("Invalid execution context: 0xed9d4f");
    }
}

