/*
 * Decompiled with CFR 0.152.
 */
package ira.m;

import ira.m.vl;
import java.nio.charset.StandardCharsets;

public class vk {
    private static final String a;
    private static final long b;

    /*
     * Loose catch block
     * Could not resolve type clashes
     */
    public static String ve(Object[] objectArray) {
        String string = (String)objectArray[0];
        String[] stringArray = vl.vg();
        try {
            int n;
            byte[] byArray;
            block18: {
                int n2;
                block16: {
                    block17: {
                        String string2;
                        block15: {
                            block20: {
                                block21: {
                                    string2 = string;
                                    if (stringArray == null) break block15;
                                    if (string2 == null) break block20;
                                    break block21;
                                    catch (Exception exception) {
                                        throw vk.a(exception);
                                    }
                                }
                                try {
                                    block22: {
                                        n2 = string.isEmpty();
                                        if (stringArray == null) break block16;
                                        break block22;
                                        catch (Exception exception) {
                                            throw vk.a(exception);
                                        }
                                    }
                                    if (n2 == 0) break block17;
                                }
                                catch (Exception exception) {
                                    throw vk.a(exception);
                                }
                            }
                            string2 = "";
                        }
                        return string2;
                    }
                    n2 = string.length() / 2;
                }
                byArray = new byte[n2];
                for (n = 0; n < byArray.length; ++n) {
                    try {
                        byArray[n] = (byte)Integer.parseInt(string.substring(n * 2, n * 2 + 2), (int)b);
                        if (stringArray != null) {
                            if (stringArray != null) continue;
                            break;
                        }
                        break block18;
                    }
                    catch (Exception exception) {
                        throw vk.a(exception);
                    }
                }
                n = 0;
            }
            try {
                while (n < byArray.length) {
                    int n3 = n;
                    byArray[n3] = (byte)(byArray[n3] ^ (byte)a.charAt(n % 3));
                    ++n;
                    if (stringArray != null) continue;
                    break;
                }
            }
            catch (Exception exception) {
                throw vk.a(exception);
            }
            return new String(byArray, StandardCharsets.UTF_8);
        }
        catch (Exception exception) {
            return "";
        }
    }

    private static Exception a(Exception exception) {
        return exception;
    }

    /*
     * Handled impossible loop by duplicating code
     * Enabled aggressive block sorting
     */
    static {
        char[] cArray;
        block11: {
            int n;
            int n2;
            int n3;
            block10: {
                char[] cArray2 = "\u001c3\b".toCharArray();
                n3 = 78;
                cArray = cArray2;
                n2 = cArray2.length;
                n = 0;
                if (!true) break block10;
                n2 = n2;
                if (n2 <= n) break block11;
            }
            do {
                n3 = n3;
                cArray = cArray;
                int n4 = n;
                cArray[n4] = (char)(cArray[n4] ^ (n3 ^ (switch (n % 7) {
                    case 0 -> 59;
                    case 1 -> 15;
                    case 2 -> 39;
                    case 3 -> 36;
                    case 4 -> 56;
                    case 5 -> 57;
                    default -> 90;
                })));
                ++n;
                n2 = n2;
            } while (n2 > n);
        }
        a = new String(cArray).intern();
        long l = 1662369996676768152L;
        b = 0x87055CE1512FA188L ^ l;
    }
}

