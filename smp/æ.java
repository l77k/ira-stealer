/*
 * Decompiled with CFR 0.152.
 */
import java.sql.ResultSet;

public class \u00e6
implements \u00aa {
    final s method_FF;
    final \u00e0 method_FE;
    private static final String[] a;

    \u00e6(\u00ec \u00ec2, s s2, \u00e0 \u00e02) {
        this.method_FF = s2;
        this.method_FE = \u00e02;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public String method_FF(Object[] objectArray) throws Exception {
        
        
        ResultSet resultSet = (ResultSet)objectArray[0];
        long l2 = (Long)objectArray[1];
        long l3 = 51192255550195L;
        Object[] objectArray2 = new Object[4];
        objectArray2[3] = l3;
        objectArray2[2] = true;
        objectArray2[1] = this.method_FF;
        objectArray2[0] = resultSet.getBytes(2);
        String string = u.method_FE(objectArray2);
        int n2 = s.method_FD;
        String string2 = string;
        if (n2 != 0) return string2;
        if (string2 == null) return "";
        string2 = string;
        if (n2 != 0) return string2;
        if (string2.isEmpty()) return "";
        \u00e0 \u00e02 = this.method_FE;
        synchronized (\u00e02) {
            ++this.method_FE.method_FD;
        }
        int n3 = resultSet.getInt(4);
        int n4 = resultSet.getInt(3);
        String string3 = string;
        String string4 = resultSet.getString(1);
        String[] stringArray = a;
        return stringArray[0] + string4 + (String)((Object)"\n") + string3 + stringArray[1] + n4 + (String)((Object)"/") + n3 + stringArray[2];
    }

    /*
     * Unable to fully structure code
     */
    static {
        block12: {
            var5 = new String[3];
            var3_1 = 0;
            var2_2 = "\u001cZmDapp\u001cZl0.,\u0005N\b;Gapp\u001cZmDapp+\u0003\u0001]p\u0002+m";
            var4_3 = "\u001cZmDapp\u001cZl0.,\u0005N\b;Gapp\u001cZmDapp+\u0003\u0001]p\u0002+m".length();
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
                        v6 = 33;
                        break;
                    }
                    case 1: {
                        v6 = 103;
                        break;
                    }
                    case 2: {
                        v6 = 80;
                        break;
                    }
                    case 3: {
                        v6 = 121;
                        break;
                    }
                    case 4: {
                        v6 = 92;
                        break;
                    }
                    case 5: {
                        v6 = 77;
                        break;
                    }
                    default: {
                        v6 = 77;
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
        \u00e6.a = var5;
    }

    public static void main(String[] stringArray) {
        throw new RuntimeException("Invalid execution context: 0x1dc704");
    }
}

