/*
 * Decompiled with CFR 0.152.
 */
import java.sql.ResultSet;
import java.util.Base64;

public class \u00e2
implements \u00aa {
    boolean method_FF;
    final s method_FE;
    private static final String[] a;

    \u00e2(\u00ec \u00ec2, s s2) {
        this.method_FE = s2;
        this.method_FF = true;
    }

    @Override
    public String method_FF(Object[] objectArray) throws Exception {
        String string;
        Object[] objectArray2;
        String string2;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        block25: {
            byte[] byArray;
            block26: {
                int n2;
                String string3;
                String string4;
                long l2;
                block24: {
                    String string5;
                    block22: {
                        block23: {
                            ResultSet resultSet = (ResultSet)objectArray[0];
                            l2 = (Long)objectArray[1];
                            long l3 = 51192255550195L;
                            string4 = resultSet.getString(1);
                            byte[] byArray2 = resultSet.getBytes(2);
                            Object[] objectArray3 = new Object[4];
                            objectArray3[3] = l3;
                            objectArray3[2] = false;
                            objectArray3[1] = this.method_FE;
                            objectArray3[0] = byArray2;
                            string3 = u.method_FE(objectArray3);
                            n2 = s.method_FD;
                            byArray = resultSet.getBytes(3);
                            string5 = string3;
                            if (n2 != 0) break block22;
                            if (string5 == null) break block23;
                            string5 = string3;
                            if (n2 != 0) break block22;
                            if (!string5.isEmpty()) break block24;
                        }
                        string5 = "";
                    }
                    return string5;
                }
                stringBuilder2 = new StringBuilder();
                if (l2 >= 0L && !this.method_FF) {
                    stringBuilder2.append(a[0]);
                }
                stringBuilder = stringBuilder2;
                string2 = a[1];
                Object[] objectArray4 = new Object[3];
                objectArray4[0] = string4;
                Object[] objectArray5 = objectArray4;
                objectArray2 = objectArray4;
                int n3 = 1;
                if (l2 > 0L) {
                    string = string3;
                    if (n2 != 0) break block25;
                    objectArray5[n3] = string;
                    objectArray5 = objectArray2;
                    objectArray2 = objectArray2;
                    n3 = 2;
                }
                if (byArray != null) break block26;
                string = "";
                break block25;
            }
            string = Base64.getEncoder().encodeToString(byArray);
        }
        objectArray5[n3] = string;
        stringBuilder.append(String.format(string2, objectArray2));
        this.method_FF = false;
        return stringBuilder2.toString();
    }

    /*
     * Unable to fully structure code
     */
    static {
        block12: {
            var5 = new String[2];
            var3_1 = 0;
            var2_2 = "\u001d\u0017\u001cJ?\u0016\u0019n\u0015/B?I\u0019 \u00150\u00138\u0016\u0019x\u0015h\u0013'G\u001e'\u0015w";
            var4_3 = "\u001d\u0017\u001cJ?\u0016\u0019n\u0015/B?I\u0019 \u00150\u00138\u0016\u0019x\u0015h\u0013'G\u001e'\u0015w".length();
            var1_4 = 2;
            var0_5 = -1;
lbl7:
            // 2 sources

            while (true) {
                continue;
                break;
            }
lbl9:
            // 1 sources

            while (true) {
                var5[var3_1++] = new String(v0).intern();
                if ((var0_5 += var1_4) < var4_3) {
                    var1_4 = var2_2.charAt(var0_5);
                    ** continue;
                }
                break block12;
                break;
            }
            v1 = ++var0_5;
            v2 = var2_2.substring(v1, v1 + var1_4).toCharArray();
            v0 = v2;
            v3 = v2.length;
            var6_6 = 0;
            if (true) ** GOTO lbl48
            do {
                v0 = v0;
                v4 = var6_6;
                v5 = v0[v4];
                switch (var6_6 % 7) {
                    case 0: {
                        v6 = 49;
                        break;
                    }
                    case 1: {
                        v6 = 29;
                        break;
                    }
                    case 2: {
                        v6 = 101;
                        break;
                    }
                    case 3: {
                        v6 = 59;
                        break;
                    }
                    case 4: {
                        v6 = 84;
                        break;
                    }
                    case 5: {
                        v6 = 55;
                        break;
                    }
                    default: {
                        v6 = 10;
                    }
                }
                v0[v4] = (char)(v5 ^ v6);
                ++var6_6;
lbl48:
                // 2 sources

                v3 = v3;
            } while (v3 > var6_6);
            ** while (true)
        }
        \u00e2.a = var5;
    }

    public static void main(String[] stringArray) {
        throw new RuntimeException("Invalid execution context: 0x19b371");
    }
}

