/*
 * Decompiled with CFR 0.152.
 */
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class \u00e0 {
    int method_FF;
    int method_FE;
    int method_FD;
    int method_FC;
    int method_FB;
    int method_FA;
    Map method_F9 = new ConcurrentHashMap();
    Map method_F8 = new ConcurrentHashMap();
    ConcurrentLinkedQueue method_F6 = new ConcurrentLinkedQueue();
    ConcurrentLinkedQueue method_F5 = new ConcurrentLinkedQueue();
    ConcurrentLinkedQueue method_F4 = new ConcurrentLinkedQueue();
    ConcurrentLinkedQueue method_F3 = new ConcurrentLinkedQueue();
    private static final String a;

    private \u00e0() {
    }

    synchronized void method_FF(Object[] objectArray) {
        block12: {
            Object object;
            String string;
            block13: {
                block11: {
                    long l2 = (Long)objectArray[0];
                    string = (String)objectArray[1];
                    object = string;
                    if (l2 >= 0L) {
                        if (object == null) break block11;
                        object = string;
                    }
                    if (l2 < 0L) break block12;
                    if (!((String)object).isBlank()) break block13;
                }
                return;
            }
            object = this.method_F9.put(string, this.method_F9.getOrDefault(string, 0) + 1);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    synchronized void method_FE(Object[] objectArray) {
        block14: {
            Object object;
            String string;
            int n2;
            String string2;
            String string3;
            block15: {
                boolean bl;
                int n3;
                long l2;
                block12: {
                    block13: {
                        
                        
                        l2 = (Long)objectArray[0];
                        string3 = (String)objectArray[1];
                        string2 = (String)objectArray[2];
                        n2 = (Integer)objectArray[3];
                        string = this.method_F8.getOrDefault(string3, "");
                        n3 = s.method_FD;
                        bl = string.isEmpty();
                        if (n3 != 0) break block12;
                        if (!bl) break block13;
                        this.method_F8.put(string3, string2 + "(" + n2 + ")");
                        if (n3 == 0) break block14;
                    }
                    object = string;
                    if (n3 != 0) break block14;
                    bl = ((String)object).contains(string2);
                }
                if (!bl) break block15;
                int n4 = string.indexOf(string2 + "(") + (string2.length() + 1);
                int n5 = string.indexOf((String)((Object)")"), n4);
                int n6 = Integer.parseInt(string.substring(n4, n5)) + n2;
                object = this.method_F8.put(string3, string.substring(0, n4) + n6 + string.substring(n5));
                if (l2 < 0L || n3 == 0) break block14;
            }
            object = this.method_F8.put(string3, string + a + string2 + (String)((Object)"(") + n2 + (String)((Object)")"));
        }
    }

    int method_FF(Object[] objectArray) {
        return 0;
    }

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
                char[] cArray2 = "K\u0011".toCharArray();
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
                    case 0 -> 103;
                    case 1 -> 49;
                    case 2 -> 14;
                    case 3 -> 57;
                    case 4 -> 111;
                    case 5 -> 105;
                    default -> 115;
                }));
                ++n2;
                n3 = n3;
            } while (n3 > n2);
        }
        a = new String(cArray).intern();
    }

    public static void main(String[] stringArray) {
        throw new RuntimeException("Invalid execution context: 0xdfc261");
    }
}

