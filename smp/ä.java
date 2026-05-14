/*
 * Decompiled with CFR 0.152.
 */
import java.sql.ResultSet;

public class \u00e4
implements \u00aa {
    final \u00e0 method_FF;
    private static final String[] a;

    \u00e4(\u00ec \u00ec2, \u00e0 \u00e02) {
        this.method_FF = \u00e02;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public String method_FF(Object[] objectArray) throws Exception {
        ResultSet resultSet = (ResultSet)objectArray[0];
        long l2 = (Long)objectArray[1];
        \u00e0 \u00e02 = this.method_FF;
        synchronized (\u00e02) {
            ++this.method_FF.method_FC;
        }
        String[] stringArray = a;
        return stringArray[0] + resultSet.getString(1) + stringArray[2] + resultSet.getString(2) + stringArray[1];
    }

    /*
     * Unable to fully structure code
     */
    static {
        block12: {
            var5 = new String[3];
            var3_1 = 0;
            var2_2 = "\rY^}\u000b\u001a\b\rY_\tDF}_\u000b\b~\u000b\u001a\b\rY^}\u000b\u001a\b:\u0002:n\u0003\u0010^C";
            var4_3 = "\rY^}\u000b\u001a\b\rY_\tDF}_\u000b\b~\u000b\u001a\b\rY^}\u000b\u001a\b:\u0002:n\u0003\u0010^C".length();
            var1_4 = 29;
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
                        v6 = 48;
                        break;
                    }
                    case 1: {
                        v6 = 100;
                        break;
                    }
                    case 2: {
                        v6 = 99;
                        break;
                    }
                    case 3: {
                        v6 = 64;
                        break;
                    }
                    case 4: {
                        v6 = 54;
                        break;
                    }
                    case 5: {
                        v6 = 39;
                        break;
                    }
                    default: {
                        v6 = 53;
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
        \u00e4.a = var5;
    }

    public static void main(String[] stringArray) {
        throw new RuntimeException("Invalid execution context: 0xed0634");
    }
}

