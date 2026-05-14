/*
 * Decompiled with CFR 0.152.
 */
import java.sql.ResultSet;

public class \u00e5
implements \u00aa {
    final \u00e0 method_FF;
    private static final String[] a;

    \u00e5(\u00ec \u00ec2, \u00e0 \u00e02) {
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
            ++this.method_FF.method_FB;
        }
        String[] stringArray = a;
        return stringArray[1] + resultSet.getString(1) + (String)((Object)"\n") + resultSet.getString(2) + stringArray[0];
    }

    /*
     * Unable to fully structure code
     */
    static {
        block12: {
            var5 = new String[2];
            var3_1 = 0;
            var2_2 = "%!\u001d\u0012\u0016\u0013Nc9\u0005\u0012\u0016\u0012:,ep@DEMc9\u0005\u0012\u0016\u0013Nc9\u0005%";
            var4_3 = "%!\u001d\u0012\u0016\u0013Nc9\u0005\u0012\u0016\u0012:,ep@DEMc9\u0005\u0012\u0016\u0013Nc9\u0005%".length();
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
                        v6 = 47;
                        break;
                    }
                    case 1: {
                        v6 = 43;
                        break;
                    }
                    case 2: {
                        v6 = 46;
                        break;
                    }
                    case 3: {
                        v6 = 115;
                        break;
                    }
                    case 4: {
                        v6 = 94;
                        break;
                    }
                    case 5: {
                        v6 = 4;
                        break;
                    }
                    default: {
                        v6 = 56;
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
        \u00e5.a = var5;
    }

    public static void main(String[] stringArray) {
        throw new RuntimeException("Invalid execution context: 0x324975");
    }
}

