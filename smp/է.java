/*
 * Decompiled with CFR 0.152.
 */
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.WinNT;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.invoke.CallSite;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class \u0567 {
    private static final String method_FF;
    private static final byte[] method_FE;
    private static final int method_FD;
    private static final byte method_FC;
    private static final int method_FB;
    private static final int method_FA;
    private static final String[] a;
    private static final long[] b;
    private static final Integer[] c;
    private static final long[] d;
    private static final Long[] e;

    public static void method_FF(Object[] objectArray) {
        File file = (File)objectArray[0];
        boolean bl = (Boolean)objectArray[1];
        long l2 = (Long)objectArray[2];
        String string = (String)objectArray[3];
        long l3 = l2;
        long l4 = 36518043868559L;
        long l5 = 36515967073603L;
        long l6 = 13045314843164L;
        if (file.length() == 0L) {
            return;
        }
        try {
            Thread.currentThread().setPriority(1);
            Object[] objectArray2 = new Object[2];
            objectArray2[1] = string;
            objectArray2[0] = l4;
            SecretKeySpec secretKeySpec = \u0567.method_FF(objectArray2);
            try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, a[0]);){
                FileChannel fileChannel;
                block27: {
                    fileChannel = randomAccessFile.getChannel();
                    try {
                        block26: {
                            if (!bl) break block26;
                            Object[] objectArray3 = new Object[4];
                            objectArray3[3] = l6;
                            objectArray3[2] = secretKeySpec;
                            objectArray3[1] = fileChannel;
                            objectArray3[0] = file;
                            \u0567.method_FE(objectArray3);
                            break block27;
                        }
                        Object[] objectArray4 = new Object[4];
                        objectArray4[3] = secretKeySpec;
                        objectArray4[2] = fileChannel;
                        objectArray4[1] = file;
                        objectArray4[0] = l5;
                        \u0567.method_FD(objectArray4);
                    }
                    catch (Throwable throwable) {
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            }
                            catch (Throwable throwable2) {
                                throwable.addSuppressed(throwable2);
                            }
                        }
                        throw throwable;
                    }
                }
                if (fileChannel != null) {
                    fileChannel.close();
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private static void method_FE(Object[] objectArray) throws Exception {
        File file = (File)objectArray[0];
        FileChannel fileChannel = (FileChannel)objectArray[1];
        SecretKeySpec secretKeySpec = (SecretKeySpec)objectArray[2];
        long l2 = (Long)objectArray[3];
        long l3 = l2;
        long l4 = 115452534181725L;
        long l5 = 86067407016880L;
        long l6 = 16874105774850L;
        long l7 = 25965512131723L;
        long l8 = 36523788675718L;
        byte[] byArray = new byte[\u0567.a(7307, 8020859125892928086L)];
        new SecureRandom().nextBytes(byArray);
        Object[] objectArray2 = new Object[3];
        objectArray2[2] = byArray;
        objectArray2[1] = secretKeySpec;
        objectArray2[0] = 1;
        Cipher cipher = \u0567.method_FF(objectArray2);
        Object[] objectArray3 = new Object[2];
        objectArray3[1] = l8;
        objectArray3[0] = file.getName();
        String string = \u0567.method_FF(objectArray3);
        byte[] byArray2 = string.getBytes(StandardCharsets.UTF_8);
        ByteBuffer byteBuffer = ByteBuffer.allocate(\u0567.a(28600, 2809944173747380599L));
        byteBuffer.put(byArray);
        byteBuffer.put((byte)Math.min(byArray2.length, \u0567.a(338, 3434439208705478533L)));
        byteBuffer.put(Arrays.copyOf(byArray2, \u0567.a(338, 3434439208705478533L)));
        byteBuffer.put((byte)\u0567.a(26193, 3301882618207611022L));
        byteBuffer.flip();
        long l9 = fileChannel.size();
        int n2 = (int)Math.min(l9, \u0567.b(2137, 7422259585484432715L));
        Object[] objectArray4 = new Object[4];
        objectArray4[3] = n2;
        objectArray4[2] = 0L;
        objectArray4[1] = fileChannel;
        objectArray4[0] = l7;
        byte[] byArray3 = \u0567.method_FF(objectArray4);
        CallSite callSite = g_0.a("update", "Ha$,ywHa,,q"Hi,$rq@i$"v,Id"#r'Mg#$t(Nf$%t&Oa%!trH`!"u$Id"#rtMg#$s#Nf$%t*Oa%!s$H`!"puId"#q&Mg#$s'Nf$%ttOa%!wwH`!"uv", "([B)[B", 1, (Object)cipher, (byte[])byArray3);
        if (l9 > \u0567.b(2137, 7422259585484432715L)) {
            long l10 = Math.min(l9, \u0567.b(9790, 3516137869464439595L));
            Object[] objectArray5 = new Object[5];
            objectArray5[4] = l4;
            objectArray5[3] = l10;
            objectArray5[2] = \u0567.b(2137, 7422259585484432715L);
            objectArray5[1] = cipher;
            objectArray5[0] = fileChannel;
            \u0567.method_FC(objectArray5);
        }
        fileChannel.position(l9);
        fileChannel.write(ByteBuffer.wrap((byte[])callSite));
        fileChannel.position(0L);
        fileChannel.write(byteBuffer);
        Object[] objectArray6 = new Object[2];
        objectArray6[1] = file.getName();
        objectArray6[0] = l5;
        String string2 = \u0567.method_FE(objectArray6);
        Object[] objectArray7 = new Object[3];
        objectArray7[2] = l6;
        objectArray7[1] = string2 + a[6];
        objectArray7[0] = file;
        \u0567.method_FB(objectArray7);
    }

    private static void method_FD(Object[] objectArray) throws Exception {
        byte[] byArray;
        int n2;
        long l2;
        File file;
        block15: {
            long l3;
            FileChannel fileChannel;
            block16: {
                long l4;
                CallSite callSite;
                block17: {
                    int n3;
                    long l5;
                    byte[] byArray2;
                    boolean bl;
                    long l6;
                    long l7;
                    SecretKeySpec secretKeySpec;
                    long l8;
                    block13: {
                        block14: {
                            l8 = (Long)objectArray[0];
                            file = (File)objectArray[1];
                            fileChannel = (FileChannel)objectArray[2];
                            secretKeySpec = (SecretKeySpec)objectArray[3];
                            long l9 = l8;
                            l7 = 74679602397186L;
                            l2 = 41453404367965L;
                            l6 = 67580257962964L;
                            ByteBuffer byteBuffer = ByteBuffer.allocate(\u0567.a(13584, 3008870672222876829L));
                            bl = \u0565.method_FA;
                            fileChannel.read(byteBuffer);
                            byteBuffer.flip();
                            byArray2 = new byte[\u0567.a(27120, 7672702998075975807L)];
                            byteBuffer.get(byArray2);
                            n2 = byteBuffer.get() & \u0567.a(24456, 3079884559256788506L);
                            byArray = new byte[\u0567.a(27129, 6708037488086886525L)];
                            byteBuffer.get(byArray);
                            if (byteBuffer.get() != \u0567.a(1258, 3824981830842893673L)) {
                                return;
                            }
                            l5 = fileChannel.size();
                            long l10 = l5 - \u0567.b(19275, 5572552921595472128L);
                            n3 = l10 == 0L ? 0 : (l10 < 0L ? -1 : 1);
                            if (bl) break block13;
                            if (n3 >= 0) break block14;
                            return;
                        }
                        n3 = (int)Math.min(l5 - \u0567.b(2137, 7422217165441083924L), \u0567.b(2137, 7422217165441083924L));
                    }
                    long l11 = n3;
                    l3 = l5 - (long)l11;
                    Object[] objectArray2 = new Object[3];
                    objectArray2[2] = byArray2;
                    objectArray2[1] = secretKeySpec;
                    objectArray2[0] = 2;
                    Cipher cipher = \u0567.method_FF(objectArray2);
                    Object[] objectArray3 = new Object[4];
                    objectArray3[3] = (int)l11;
                    objectArray3[2] = l3;
                    objectArray3[1] = fileChannel;
                    objectArray3[0] = l6;
                    byte[] byArray3 = \u0567.method_FF(objectArray3);
                    callSite = g_0.a("update", "Ha$,ywHa,,q"Hi,$rq@i$"v,Id"#r'Mg#$t(Nf$%t&Oa%!trH`!"u$Id"#rtMg#$s#Nf$%t*Oa%!s$H`!"puId"#q&Mg#$s'Nf$%ttOa%!wwH`!"uv", "([B)[B", 1, (Object)cipher, (byte[])byArray3);
                    if (l8 <= 0L) break block15;
                    long l12 = l3 - \u0567.b(2137, 7422217165441083924L);
                    l4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                    if (bl) break block16;
                    if (l4 <= 0) break block17;
                    long l13 = Math.min(l3, \u0567.b(20109, 1110525588973743301L));
                    Object[] objectArray4 = new Object[5];
                    objectArray4[4] = l7;
                    objectArray4[3] = l13;
                    objectArray4[2] = \u0567.b(2137, 7422217165441083924L);
                    objectArray4[1] = cipher;
                    objectArray4[0] = fileChannel;
                    \u0567.method_FC(objectArray4);
                }
                fileChannel.position(0L);
                l4 = fileChannel.write(ByteBuffer.wrap((byte[])callSite));
            }
            fileChannel.truncate(l3);
        }
        String string = new String(byArray, 0, n2, StandardCharsets.UTF_8).trim();
        String string2 = file.getName().substring(0, file.getName().length() - a[3].length());
        Object[] objectArray5 = new Object[3];
        objectArray5[2] = l2;
        objectArray5[1] = string2 + string;
        objectArray5[0] = file;
        \u0567.method_FB(objectArray5);
    }

    private static byte[] method_FF(Object[] objectArray) throws Exception {
        long l2 = (Long)objectArray[0];
        FileChannel fileChannel = (FileChannel)objectArray[1];
        long l3 = (Long)objectArray[2];
        int n2 = (Integer)objectArray[3];
        ByteBuffer byteBuffer = ByteBuffer.allocate(n2);
        fileChannel.position(l3);
        while (byteBuffer.hasRemaining() && fileChannel.read(byteBuffer) != -1) {
        }
        return byteBuffer.array();
    }

    private static void method_FC(Object[] objectArray) throws Exception {
        int n2;
        long l2;
        FileChannel fileChannel = (FileChannel)objectArray[0];
        Cipher cipher = (Cipher)objectArray[1];
        long l3 = (Long)objectArray[2];
        long l4 = (Long)objectArray[3];
        long l5 = (Long)objectArray[4];
        ByteBuffer byteBuffer = ByteBuffer.allocate(\u0567.a(271, 4897310576587112579L));
        fileChannel.position(l2);
        for (l2 = l3; l2 < l4; l2 += (long)n2) {
            byteBuffer.clear();
            int n3 = (int)Math.min(\u0567.b(24156, 7797537882251115543L), l4 - l2);
            byteBuffer.limit(n3);
            n2 = fileChannel.read(byteBuffer);
            if (n2 == -1) {
                break;
            }
            byteBuffer.flip();
            byte[] byArray = new byte[byteBuffer.remaining()];
            byteBuffer.get(byArray);
            CallSite callSite = g_0.a("update", "Ha$,ywHa,,q"Hi,$rq@i$"v,Id"#r'Mg#$t(Nf$%t&Oa%!trH`!"u$Id"#rtMg#$s#Nf$%t*Oa%!s$H`!"puId"#q&Mg#$s'Nf$%ttOa%!wwH`!"uv", "([B)[B", 1, (Object)cipher, (byte[])byArray);
            fileChannel.position(l2);
            fileChannel.write(ByteBuffer.wrap((byte[])callSite));
        }
    }

    private static SecretKeySpec method_FF(Object[] objectArray) {
        byte[] byArray;
        long l2;
        block11: {
            block10: {
                l2 = (Long)objectArray[0];
                String string = (String)objectArray[1];
                if (string == null || string.isEmpty()) break block10;
                byArray = string.getBytes(StandardCharsets.UTF_8);
                break block11;
            }
            byArray = method_FE;
        }
        byte[] byArray2 = byArray;
        byte[] byArray3 = new byte[\u0567.a(7307, 8020904387261988293L)];
        System.arraycopy(byArray2, 0, byArray3, 0, Math.min(byArray2.length, \u0567.a(7307, 8020904387261988293L)));
        return new SecretKeySpec(byArray3, a[5]);
    }

    private static Cipher method_FF(Object[] objectArray) throws Exception {
        int n2 = (Integer)objectArray[0];
        SecretKeySpec secretKeySpec = (SecretKeySpec)objectArray[1];
        byte[] byArray = (byte[])objectArray[2];
        CallSite callSite = g_0.a("getInstance", "Ha$,ywHa,,q"Hi,$rq@i$"v,Id"#r'Mg#$t(Nf$%t&Oa%!trH`!"u$Id"#rtMg#$s#Nf$%t*Oa%!s$H`!"puId"#q&Mg#$s'Nf$%ttOa%!wwH`!"uv", "(Ljava/lang/String;)Ljavax/crypto/Cipher;", 2, a[1]);
        g_0.a("init", "Ha$,ywHa,,q"Hi,$rq@i$"v,Id"#r'Mg#$t(Nf$%t&Oa%!trH`!"u$Id"#rtMg#$s#Nf$%t*Oa%!s$H`!"puId"#q&Mg#$s'Nf$%ttOa%!wwH`!"uv", "(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V", 1, (Object)callSite, n2, (Object)secretKeySpec, (Object)new IvParameterSpec(byArray));
        return callSite;
    }

    private static String method_FF(Object[] objectArray) {
        String string = (String)objectArray[0];
        long l2 = (Long)objectArray[1];
        int n2 = string.lastIndexOf(\u0567.a(6228, 3337756288404257796L));
        String string2 = n2 >= 0 ? string.substring(n2) : "";
        return string2;
    }

    private static String method_FE(Object[] objectArray) {
        long l2 = (Long)objectArray[0];
        String string = (String)objectArray[1];
        int n2 = string.lastIndexOf(\u0567.a(22345, 7411361743260240426L));
        String string2 = n2 >= 0 ? string.substring(0, n2) : string;
        return string2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void method_FB(Object[] objectArray) {
        Object object;
        CallSite callSite;
        String string;
        boolean bl;
        File file;
        long l2;
        long l3;
        File file2;
        block22: {
            Object object2;
            block21: {
                
                
                file2 = (File)objectArray[0];
                String string2 = (String)objectArray[1];
                l3 = (Long)objectArray[2];
                l2 = 85944215414824L;
                file = new File(file2.getParent(), string2);
                bl = \u0565.method_FA;
                string = a[2] + file.getAbsolutePath();
                callSite = g_0.a("CreateFile", "\u00e5\u00e8\u00e5\u00a6method_F9method_F3\u00e9\u00a7\u00e3\u00e4\u00e7\u00a8method_F8\u00e5\u00ebmethod_F2\u00e1\u00e7method_FB\u00e7\u00a9method_F0\u00e1\u00e7\u00b9\u00b4\u00a8\u00c3\u00ecmethod_F8\u00e8\u00e2\u00e4\u00ba\u00b8", "(Ljava/lang/String;IILcom/sun/jna/platform/win32/WinBase$SECURITY_ATTRIBUTES;IILcom/sun/jna/platform/win32/WinNT$HANDLE;)Lcom/sun/jna/platform/win32/WinNT$HANDLE;", 3, (Object)Kernel32.INSTANCE, (Object)file2.getAbsolutePath(), (int)\u0567.a(15428, 3192019023308280210L), (int)\u0567.a(3321, 3720848118728876323L), null, (int)3, (int)\u0567.a(2803, 6159364974512924477L), null);
                if (bl) return;
                if (callSite == null) break block21;
                if (l3 <= 0L) return;
                object2 = g_0.a("equals", "\u00e5\u00e8\u00e5\u00a6method_F9method_F3\u00e9\u00a7\u00e3\u00e4\u00e7\u00a8method_F8\u00e5\u00ebmethod_F2\u00e1\u00e7method_FB\u00e7\u00a9method_F0\u00e1\u00e7\u00b9\u00b4\u00a8\u00df\u00e0\u00e4\u00c8\u00d3\u00ac\u00c1\u00cb\u00c8\u00c3\u00c4\u00cc", "(Ljava/lang/Object;)Z", 1, (Object)WinNT.INVALID_HANDLE_VALUE, (Object)callSite);
                if (bl) return;
                if (!object2) break block22;
            }
            object2 = file2.renameTo(file);
            return;
        }
        try {
            method_F5 method_F52 = new method_F5(l2);
            method_F52.method_FF = 1;
            method_F52.method_FE = null;
            method_F52.method_FD = string.length() * 2;
            System.arraycopy(string.toCharArray(), 0, method_F52.method_FC, 0, string.length());
            method_F52.write();
            int n2 = method_F52.method_FF(new Object[0]) + method_F52.method_FD;
            method_F4 method_F42 = new method_F4();
            Object[] objectArray2 = new Object[5];
            objectArray2[4] = \u0567.a(3153, 4744500852439933322L);
            objectArray2[3] = n2;
            objectArray2[2] = method_F52.getPointer();
            objectArray2[1] = method_F42;
            objectArray2[0] = g_0.a("getPointer", "\u00e5\u00e8\u00e5\u00a6method_F9method_F3\u00e9\u00a7\u00e3\u00e4\u00e7\u00a8method_F8\u00e5\u00ebmethod_F2\u00e1\u00e7method_FB\u00e7\u00a9method_F0\u00e1\u00e7\u00b9\u00b4\u00a8\u00df\u00e0\u00e4\u00c8\u00d3\u00ac\u00c1\u00cb\u00c8\u00c3\u00c4\u00cc", "()Lcom/sun/jna/Pointer;", 1, (Object)callSite);
            int n3 = \u0566.method_FF.method_FF(objectArray2);
            if (l3 <= 0L) return;
            object = n3;
            if (bl) return;
            if (object != 0) {
                file2.renameTo(file);
            }
        }
        catch (Throwable throwable) {
            try {
                file2.renameTo(file);
                return;
            }
            catch (Throwable throwable2) {
                throw throwable2;
            }
            finally {
                g_0.a("CloseHandle", "\u00e5\u00e8\u00e5\u00a6method_F9method_F3\u00e9\u00a7\u00e3\u00e4\u00e7\u00a8method_F8\u00e5\u00ebmethod_F2\u00e1\u00e7method_FB\u00e7\u00a9method_F0\u00e1\u00e7\u00b9\u00b4\u00a8\u00c3\u00ecmethod_F8\u00e8\u00e2\u00e4\u00ba\u00b8", "(Lcom/sun/jna/platform/win32/WinNT$HANDLE;)Z", 3, (Object)Kernel32.INSTANCE, (Object)callSite);
            }
        }
        object = g_0.a("CloseHandle", "\u00e5\u00e8\u00e5\u00a6method_F9method_F3\u00e9\u00a7\u00e3\u00e4\u00e7\u00a8method_F8\u00e5\u00ebmethod_F2\u00e1\u00e7method_FB\u00e7\u00a9method_F0\u00e1\u00e7\u00b9\u00b4\u00a8\u00c3\u00ecmethod_F8\u00e8\u00e2\u00e4\u00ba\u00b8", "(Lcom/sun/jna/platform/win32/WinNT$HANDLE;)Z", 3, (Object)Kernel32.INSTANCE, (Object)callSite);
    }

    /*
     * Unable to fully structure code
     */
    // [DEOBF] Static initializer pool removed — values resolved inline
