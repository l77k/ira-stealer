/*
 * Decompiled with CFR 0.152.
 */
import java.sql.ResultSet;

public class \u00e1
implements \u00aa {
    final \u00e0 method_FF;
    private static final String[] a;
    private static final long[] b;
    private static final Integer[] c;

    \u00e1(\u00ec \u00ec2, \u00e0 \u00e02) {
        this.method_FF = \u00e02;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public String method_FF(Object[] objectArray) throws Exception {
        String string;
        Object[] objectArray2;
        String string2;
        long l2;
        ResultSet resultSet;
        block14: {
            block15: {
                int n2;
                resultSet = (ResultSet)objectArray[0];
                l2 = (Long)objectArray[1];
                long l3 = 38934054343465L;
                \u00e0 \u00e02 = this.method_FF;
                synchronized (\u00e02) {
                    n2 = s.method_FD;
                    ++this.method_FF.method_FE;
                }
                Object[] objectArray3 = new Object[4];
                objectArray3[3] = 1;
                objectArray3[2] = a[4];
                objectArray3[1] = a[1];
                objectArray3[0] = l3;
                this.method_FF.method_FE(objectArray3);
                string2 = a[2];
                Object[] objectArray4 = new Object[\u00e1.a(17250, 5090666132149929823L)];
                objectArray4[0] = resultSet.getString(1);
                Object[] objectArray5 = objectArray4;
                objectArray2 = objectArray4;
                int n3 = 1;
                ResultSet resultSet2 = resultSet;
                int n4 = 2;
                if (l2 >= 0L) {
                    string = resultSet2.getString(n4);
                    if (n2 != 0) break block14;
                    objectArray5[n3] = string;
                    objectArray5 = objectArray2;
                    objectArray2 = objectArray2;
                    n3 = 2;
                    resultSet2 = resultSet;
                    n4 = 3;
                }
                if (resultSet2.getInt(n4) != 1) break block15;
                string = a[0];
                break block14;
            }
            string = a[3];
        }
        objectArray5[n3] = string;
        objectArray2[3] = resultSet.getLong(4);
        objectArray2[4] = resultSet.getString(5);
        objectArray2[5] = resultSet.getString(\u00e1.a(1767, 2794111385997165275L));
        return String.format(string2, objectArray2);
    }

    /*
     * Unable to fully structure code
     */
    static {
        block23: {
            block22: {
                block21: {
                    block20: {
                        var13 = new String[5];
                        var11_1 = 0;
                        var10_2 = "]\bX-\u0007O3\u007f\r8\u0005O\u0017,)\u0004<\f?r\u0000\u007f~a{\u0019>,>\u0004M-c\u0012zP";
                        var12_3 = "]\bX-\u0007O3\u007f\r8\u0005O\u0017,)\u0004<\f?r\u0000\u007f~a{\u0019>,>\u0004M-c\u0012zP".length();
                        var9_4 = 4;
                        var8_5 = -1;
lbl7:
                        // 2 sources

                        while (true) {
                            v0 = ++var8_5;
                            v1 = var10_2.substring(v0, v0 + var9_4);
                            v2 = -1;
                            break block20;
                            break;
                        }
lbl12:
                        // 1 sources

                        while (true) {
                            var13[var11_1++] = v3.intern();
                            if ((var8_5 += var9_4) < var12_3) {
                                var9_4 = var10_2.charAt(var8_5);
                                ** continue;
                            }
                            var10_2 = "O\u001bA;\u001b\u0007J5b\u00037\u000fD";
                            var12_3 = "O\u001bA;\u001b\u0007J5b\u00037\u000fD".length();
                            var9_4 = 5;
                            var8_5 = -1;
lbl21:
                            // 2 sources

                            while (true) {
                                v4 = ++var8_5;
                                v1 = var10_2.substring(v4, v4 + var9_4);
                                v2 = 0;
                                break block20;
                                break;
                            }
                            break;
                        }
lbl26:
                        // 1 sources

                        while (true) {
                            var13[var11_1++] = v3.intern();
                            if ((var8_5 += var9_4) < var12_3) {
                                var9_4 = var10_2.charAt(var8_5);
                                ** continue;
                            }
                            break block21;
                            break;
                        }
                    }
                    v5 = v1.toCharArray();
                    v6 = v5;
                    v7 = v5.length;
                    var14_6 = 0;
                    if (true) ** GOTO lbl65
                    do {
                        v6 = v6;
                        v8 = var14_6;
                        v9 = v6[v8];
                        switch (var14_6 % 7) {
                            case 0: {
                                v10 = 9;
                                break;
                            }
                            case 1: {
                                v10 = 90;
                                break;
                            }
                            case 2: {
                                v10 = 13;
                                break;
                            }
                            case 3: {
                                v10 = 104;
                                break;
                            }
                            case 4: {
                                v10 = 94;
                                break;
                            }
                            case 5: {
                                v10 = 106;
                                break;
                            }
                            default: {
                                v10 = 55;
                            }
                        }
                        v6[v8] = (char)(v9 ^ v10);
                        ++var14_6;
lbl65:
                        // 2 sources

                        v7 = v7;
                    } while (v7 > var14_6);
                    v3 = new String(v6);
                    switch (v2) {
                        default: {
                            ** continue;
                        }
                        ** case 0:
lbl73:
                        // 1 sources

                        ** continue;
                    }
                }
                \u00e1.a = var13;
                var0_7 = 71353207848557L;
                var6_8 = new long[2];
                var3_9 = 0;
                var4_10 = "\u00c4H\u0087\u0099\u00a6y?S\u008bn@1method_FB\u00admethod_FA\u00d7";
                var5_11 = "\u00c4H\u0087\u0099\u00a6y?S\u008bn@1method_FB\u00admethod_FA\u00d7".length();
                var2_12 = 0;
                while (true) {
                    break block22;
                    break;
                }
lbl84:
                // 1 sources

                while (true) {
                    var6_8[v11] = (((long)var7_13[0] & 255L) << 56 | ((long)var7_13[1] & 255L) << 48 | ((long)var7_13[2] & 255L) << 40 | ((long)var7_13[3] & 255L) << 32 | ((long)var7_13[4] & 255L) << 24 | ((long)var7_13[5] & 255L) << 16 | ((long)var7_13[6] & 255L) << 8 | (long)var7_13[7] & 255L) ^ var0_7;
                    if (var2_12 < var5_11) ** continue;
                    break block23;
                    break;
                }
            }
            var7_13 = var4_10.substring(var2_12, var2_12 += 8).getBytes("ISO-8859-1");
            v11 = var3_9++;
            ** while (true)
        }
        \u00e1.b = var6_8;
        \u00e1.c = new Integer[2];
    }

    private static int a(int n2, long l2) {
        int n3 = n2 ^ (int)(l2 & 0x7FFFL) ^ 0x25A;
        if (c[n3] == null) {
            \u00e1.c[n3] = (int)(b[n3] ^ l2);
        }
        return c[n3];
    }

    public static void main(String[] stringArray) {
        throw new RuntimeException("Invalid execution context: 0xa3924c");
    }
}

