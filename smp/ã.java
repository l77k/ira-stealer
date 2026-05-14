/*
 * Decompiled with CFR 0.152.
 */
import java.sql.ResultSet;

public class \u00e3
implements \u00aa {
    final \u00e0 method_FF;
    private static final String[] a;

    \u00e3(\u00ec \u00ec2, \u00e0 \u00e02) {
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
            ++this.method_FF.method_FA;
        }
        long l3 = resultSet.getLong(3);
        String string = resultSet.getString(2);
        String string2 = resultSet.getString(1);
        String[] stringArray = a;
        return stringArray[0] + string2 + (String)((Object)"\n") + string + stringArray[2] + l3 + stringArray[1];
    }

    /*
     * Unable to fully structure code
     */
    static {
        block12: {
            var5 = new String[3];
            var3_1 = 0;
            var2_2 = "SIr\u00184->SIsl{qK\u0001\u001b$\u001b4->SIr\u00184->d\tN\u00166Qlc*d~\u0002N\\";
            var4_3 = "SIr\u00184->SIsl{qK\u0001\u001b$\u001b4->SIr\u00184->d\tN\u00166Qlc*d~\u0002N\\".length();
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
                        v6 = 110;
                        break;
                    }
                    case 1: {
                        v6 = 116;
                        break;
                    }
                    case 2: {
                        v6 = 79;
                        break;
                    }
                    case 3: {
                        v6 = 37;
                        break;
                    }
                    case 4: {
                        v6 = 9;
                        break;
                    }
                    case 5: {
                        v6 = 16;
                        break;
                    }
                    default: {
                        v6 = 3;
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
        \u00e3.a = var5;
    }

    public static void main(String[] stringArray) {
        throw new RuntimeException("Invalid execution context: 0xe31989");
    }
}

