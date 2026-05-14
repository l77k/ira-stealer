/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.IOException;
import java.lang.invoke.CallSite;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class \u0587 {
    private static final SimpleDateFormat method_FF;
    private static final String[] a;
    private static final long[] b;
    private static final Integer[] c;
    private static final long[] d;
    private static final Long[] e;

    private \u0587() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String method_FF(Object[] objectArray) {
        
        
        String string = (String)objectArray[0];
        try {
            Path path;
            Path path2 = path = string == null || string.isBlank() ? \u0587.method_FF(new Object[0]) : Paths.get(string, new String[0]);
            if (!Files.exists(path, new LinkOption[0])) {
                String[] stringArray = a;
                return stringArray[3] + string;
            }
            if (!Files.isDirectory(path, new LinkOption[0])) {
                String[] stringArray = a;
                return stringArray[5] + string;
            }
            String[] stringArray = a;
            StringBuilder stringBuilder = new StringBuilder(stringArray[8]).append(path.toAbsolutePath()).append((String)((Object)"\n"));
            if (path.getParent() != null) {
                stringBuilder.append(stringArray[19]);
            }
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);){
                ArrayList arrayList = new ArrayList();
                directoryStream.forEach(arrayList::add);
                arrayList.sort(\u0587::lambda$list$0);
                for (Path path3 : arrayList) {
                    try {
                        boolean bl = Files.isDirectory(path3, new LinkOption[0]);
                        long l2 = bl ? 0L : Files.size(path3);
                        String string2 = method_FF.format(new Date(Files.getLastModifiedTime(path3, new LinkOption[0]).toMillis()));
                        stringBuilder.append(path3.getFileName()).append((String)((Object)"|")).append(l2).append((String)((Object)"|")).append(string2).append((String)((Object)"|")).append((String)((Object)(bl ? "d" : "f"))).append((String)((Object)"\n"));
                    }
                    catch (Exception exception) {}
                }
                return stringBuilder.toString().trim();
            }
        }
        catch (Exception exception) {
            return a[14] + exception.getMessage();
        }
    }

    public static String method_FE(Object[] objectArray) {
        String string = (String)objectArray[0];
        try {
            Path path = Paths.get(string, new String[0]);
            if (!Files.exists(path, new LinkOption[0])) {
                String[] stringArray = a;
                return stringArray[16] + string;
            }
            \u0587.method_FF(new Object[]{path});
            String[] stringArray = a;
            return stringArray[33] + string;
        }
        catch (Exception exception) {
            return a[14] + exception.getMessage();
        }
    }

    public static String method_FD(Object[] objectArray) {
        String string = (String)objectArray[0];
        try {
            Path path = Paths.get(string, new String[0]);
            if (!Files.exists(path, new LinkOption[0])) {
                String[] stringArray = a;
                return stringArray[16] + string;
            }
            String[] stringArray = new String[5];
            String[] stringArray2 = a;
            stringArray[0] = stringArray2[42];
            stringArray[1] = stringArray2[35];
            stringArray[2] = stringArray2[45];
            stringArray[3] = "";
            stringArray[4] = string;
            Runtime.getRuntime().exec(stringArray);
            return stringArray2[31] + string;
        }
        catch (Exception exception) {
            return a[14] + exception.getMessage();
        }
    }

    public static byte[] method_FF(Object[] objectArray) {
        String string = (String)objectArray[0];
        long l2 = (Long)objectArray[1];
        try {
            Path path;
            block11: {
                path = Paths.get(string, new String[0]);
                if (Files.exists(path, new LinkOption[0]) && !Files.isDirectory(path, new LinkOption[0])) break block11;
                return null;
            }
            if (Files.size(path) > \u0587.b(3754, 3242107893450408054L)) {
                return null;
            }
            return Files.readAllBytes(path);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static String method_FC(Object[] objectArray) {
        try {
            String[] stringArray = a;
            StringBuilder stringBuilder = new StringBuilder(stringArray[2]);
            for (File file : File.listRoots()) {
                long l2 = file.getTotalSpace();
                long l3 = l2 - file.getFreeSpace();
                String string = file.getAbsolutePath().replace((CharSequence)((Object)"\\"), "");
                Object[] objectArray2 = new Object[1];
                objectArray2[0] = l2;
                stringArray = a;
                stringBuilder.append(string).append((String)((Object)"|")).append(l3).append((String)((Object)"|")).append(\u0587.method_F2(objectArray2)).append(stringArray[36]);
            }
            return stringBuilder.toString().trim();
        }
        catch (Exception exception) {
            return a[14] + exception.getMessage();
        }
    }

    public static String method_FB(Object[] objectArray) {
        String string = (String)objectArray[0];
        String string2 = (String)objectArray[1];
        try {
            block15: {
                Path path;
                Path path2;
                block14: {
                    path2 = Paths.get(string.trim(), new String[0]);
                    path = Paths.get(string2.trim(), new String[0]);
                    if (!Files.exists(path2, new LinkOption[0])) {
                        String[] stringArray = a;
                        return stringArray[24] + string;
                    }
                    if (!Files.isDirectory(path2, new LinkOption[0])) break block14;
                    Object[] objectArray2 = new Object[2];
                    objectArray2[1] = path;
                    objectArray2[0] = path2;
                    \u0587.method_FE(objectArray2);
                    break block15;
                }
                if (path.getParent() != null) {
                    Files.createDirectories(path.getParent(), new FileAttribute[0]);
                }
                Files.copy(path2, path, StandardCopyOption.REPLACE_EXISTING);
            }
            String[] stringArray = a;
            return stringArray[1] + string2;
        }
        catch (Exception exception) {
            return a[14] + exception.getMessage();
        }
    }

    public static String method_FA(Object[] objectArray) {
        String string = (String)objectArray[0];
        String string2 = (String)objectArray[1];
        try {
            Path path = Paths.get(string.trim(), new String[0]);
            Path path2 = Paths.get(string2.trim(), new String[0]);
            if (!Files.exists(path, new LinkOption[0])) {
                String[] stringArray = a;
                return stringArray[0] + string;
            }
            if (path2.getParent() != null) {
                Files.createDirectories(path2.getParent(), new FileAttribute[0]);
            }
            Files.move(path, path2, StandardCopyOption.REPLACE_EXISTING);
            String[] stringArray = a;
            return stringArray[27] + string2;
        }
        catch (Exception exception) {
            return a[14] + exception.getMessage();
        }
    }

    public static String method_F9(Object[] objectArray) {
        String string = (String)objectArray[0];
        try {
            Files.createDirectories(Paths.get(string.trim(), new String[0]), new FileAttribute[0]);
            String[] stringArray = a;
            return stringArray[41] + string;
        }
        catch (Exception exception) {
            return a[21] + exception.getMessage();
        }
    }

    public static String method_F8(Object[] objectArray) {
        String string = (String)objectArray[0];
        try {
            Path path = Paths.get(string.trim(), new String[0]);
            if (path.getParent() != null) {
                Files.createDirectories(path.getParent(), new FileAttribute[0]);
            }
            if (!Files.exists(path, new LinkOption[0])) {
                Files.createFile(path, new FileAttribute[0]);
            }
            String[] stringArray = a;
            return stringArray[15] + string;
        }
        catch (Exception exception) {
            return a[14] + exception.getMessage();
        }
    }

    public static String method_F6(Object[] objectArray) {
        long l2 = (Long)objectArray[0];
        String string = (String)objectArray[1];
        try {
            Path path = Paths.get(string.trim(), new String[0]);
            if (!Files.exists(path, new LinkOption[0])) {
                String[] stringArray = a;
                return stringArray[16] + string;
            }
            if (Files.isDirectory(path, new LinkOption[0])) {
                String[] stringArray = a;
                return stringArray[28];
            }
            if (Files.size(path) > \u0587.b(30770, 6553863792281098906L)) {
                String[] stringArray = a;
                return stringArray[40];
            }
            String string2 = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
            String[] stringArray = a;
            return stringArray[11] + String.valueOf(path.toAbsolutePath()) + (String)((Object)"\n") + string2;
        }
        catch (Exception exception) {
            return a[39] + exception.getMessage();
        }
    }

    public static String method_F5(Object[] objectArray) {
        long l2 = (Long)objectArray[0];
        String string = (String)objectArray[1];
        long l3 = 51857383596104L;
        try {
            String string2;
            String string3;
            String string4;
            BasicFileAttributes basicFileAttributes;
            long l4;
            Path path;
            block14: {
                block13: {
                    path = Paths.get(string.trim(), new String[0]);
                    if (!Files.exists(path, new LinkOption[0])) {
                        String[] stringArray = a;
                        return stringArray[16] + string;
                    }
                    boolean bl = Files.isDirectory(path, new LinkOption[0]);
                    long l5 = bl ? \u0587.method_FF(new Object[]{path}) : Files.size(path);
                    l4 = l5;
                    basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class, new LinkOption[0]);
                    string4 = String.valueOf(path.getFileName());
                    string3 = String.valueOf(path.toAbsolutePath());
                    if (!bl) break block13;
                    string2 = a[32];
                    break block14;
                }
                Object[] objectArray2 = new Object[2];
                objectArray2[1] = l3;
                objectArray2[0] = path;
                string2 = \u0587.method_F3(objectArray2);
            }
            Object[] objectArray3 = new Object[1];
            objectArray3[0] = l4;
            boolean bl = Files.isHidden(path);
            boolean bl2 = Files.isWritable(path);
            boolean bl3 = Files.isReadable(path);
            String string5 = method_FF.format(new Date(basicFileAttributes.lastModifiedTime().toMillis()));
            String string6 = method_FF.format(new Date(basicFileAttributes.creationTime().toMillis()));
            long l6 = l4;
            String string7 = \u0587.method_F2(objectArray3);
            String string8 = string2;
            String string9 = string3;
            String string10 = string4;
            String[] stringArray = a;
            return stringArray[18] + string10 + stringArray[6] + string9 + stringArray[29] + string8 + stringArray[30] + string7 + stringArray[43] + l6 + stringArray[26] + string6 + stringArray[44] + string5 + stringArray[37] + bl3 + stringArray[20] + bl2 + stringArray[12] + bl;
        }
        catch (Exception exception) {
            return a[14] + exception.getMessage();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String method_F4(Object[] objectArray) {
        
        
        String string = (String)objectArray[0];
        String string2 = (String)objectArray[1];
        long l2 = (Long)objectArray[2];
        try {
            Path path;
            Path path2 = path = string == null || string.isBlank() ? \u0587.method_FF(new Object[0]) : Paths.get(string.trim(), new String[0]);
            if (!Files.exists(path, new LinkOption[0])) {
                String[] stringArray = a;
                return stringArray[16] + string;
            }
            String[] stringArray = a;
            StringBuilder stringBuilder = new StringBuilder(stringArray[4] + string2 + (String)((Object)"\n"));
            String string3 = string2.toLowerCase();
            try (Stream<Path> stream = Files.walk(path, \u0587.a(291, 5043165195045342856L), new FileVisitOption[0]);){
                stream.filter(arg_0 -> \u0587.lambda$search$1(string3, arg_0)).limit(\u0587.b(16215, 5789920029249200693L)).forEach(arg_0 -> \u0587.lambda$search$2(stringBuilder, arg_0));
                return stringBuilder.toString().trim();
            }
        }
        catch (Exception exception) {
            return a[14] + exception.getMessage();
        }
    }

    private static Path method_FF(Object[] objectArray) {
        return Paths.get(System.getProperty(a[23]), new String[0]);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void method_FF(Object[] objectArray) throws IOException {
        
        
        Path path = (Path)objectArray[0];
        if (Files.isDirectory(path, new LinkOption[0])) {
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);){
                for (Path path2 : directoryStream) {
                    \u0587.method_FF(new Object[]{path2});
                }
            }
        }
        Files.deleteIfExists(path);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void method_FE(Object[] objectArray) throws IOException {
        
        try {
            
        }
        catch (RuntimeException runtimeException) {}
        throw new IllegalStateException();
        Path path = (Path)objectArray[0];
        Path path2 = (Path)objectArray[1];
        Files.createDirectories(path2, new FileAttribute[0]);
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
        try {
            for (Path path3 : directoryStream) {
                Path path4 = path2.resolve(path.relativize(path3));
                if (Files.isDirectory(path3, new LinkOption[0])) {
                    Object[] objectArray2 = new Object[2];
                    objectArray2[1] = path4;
                    objectArray2[0] = path3;
                    \u0587.method_FE(objectArray2);
                    continue;
                }
                Files.copy(path3, path4, StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (Throwable throwable) {
            if (directoryStream == null) throw throwable;
            try {
                directoryStream.close();
                throw throwable;
            }
            catch (Throwable throwable2) {
                throwable.addSuppressed(throwable2);
            }
            throw throwable;
        }
        if (directoryStream == null) return;
        directoryStream.close();
        return;
    }

    private static long method_FF(Object[] objectArray) {
        long l2;
        Path path = (Path)objectArray[0];
        Stream<Path> stream = Files.walk(path, new FileVisitOption[0]);
        try {
            l2 = stream.filter(\u0587::lambda$getDirSize$3).mapToLong(\u0587::lambda$getDirSize$4).sum();
        }
        catch (Throwable throwable) {
            try {
                if (stream != null) {
                    try {
                        stream.close();
                    }
                    catch (Throwable throwable2) {
                        throwable.addSuppressed(throwable2);
                    }
                }
                throw throwable;
            }
            catch (Exception exception) {
                return 0L;
            }
        }
        if (stream != null) {
            stream.close();
        }
        return l2;
    }

    private static String method_F3(Object[] objectArray) {
        Path path = (Path)objectArray[0];
        long l2 = (Long)objectArray[1];
        String string = path.getFileName().toString();
        int n2 = string.lastIndexOf(\u0587.a(8863, 8326151525939621976L));
        Object object = n2 > 0 ? string.substring(n2).toUpperCase() + a[34] : a[25];
        return object;
    }

    private static String method_F2(Object[] objectArray) {
        long l2 = (Long)objectArray[0];
        if (l2 <= 0L) {
            return a[22];
        }
        String[] stringArray = new String[5];
        stringArray[0] = "B";
        String[] stringArray2 = a;
        stringArray[1] = stringArray2[9];
        stringArray[2] = stringArray2[38];
        stringArray[3] = stringArray2[13];
        stringArray[4] = stringArray2[17];
        String[] stringArray3 = stringArray;
        int n2 = (int)(Math.log(l2) / Math.log(1024.0));
        return String.format(stringArray2[10], (double)l2 / Math.pow(1024.0, n2), stringArray3[Math.min(n2, stringArray3.length - 1)]);
    }

    private static long lambda$getDirSize$4(Path path) {
        try {
            return Files.size(path);
        }
        catch (Exception exception) {
            return 0L;
        }
    }

    private static boolean lambda$getDirSize$3(Path path) {
        return Files.isRegularFile(path, new LinkOption[0]);
    }

    private static void lambda$search$2(StringBuilder stringBuilder, Path path) {
        try {
            boolean bl = Files.isDirectory(path, new LinkOption[0]);
            long l2 = bl ? 0L : Files.size(path);
            long l3 = l2;
            String string = method_FF.format(new Date(Files.getLastModifiedTime(path, new LinkOption[0]).toMillis()));
            StringBuilder stringBuilder2 = stringBuilder.append(path.toAbsolutePath()).append((String)((Object)"|")).append(l3).append((String)((Object)"|")).append(string).append((String)((Object)"|"));
            CallSite callSite = bl ? "d" : "f";
            stringBuilder2.append((String)((Object)callSite)).append((String)((Object)"\n"));
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private static boolean lambda$search$1(String string, Path path) {
        return path.getFileName().toString().toLowerCase().contains(string);
    }

    private static int lambda$list$0(Path path, Path path2) {
        block10: {
            int n2;
            block12: {
                block11: {
                    boolean bl = Files.isDirectory(path, new LinkOption[0]);
                    boolean bl2 = Files.isDirectory(path2, new LinkOption[0]);
                    if (bl == bl2) break block10;
                    if (!bl) break block11;
                    n2 = -1;
                    break block12;
                }
                n2 = 1;
            }
            return n2;
        }
        return path.getFileName().toString().compareToIgnoreCase(path2.getFileName().toString());
    }

    /*
     * Unable to fully structure code
     */
    // [DEOBF] Static initializer pool removed — values resolved inline
