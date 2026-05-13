/*
 * Decompiled & Deobfuscated
 * Hex-string decoder yardimci sinifi
 * XOR anahtari: "ira" (0x69, 0x72, 0x61)
 */
package ira.m;

import java.nio.charset.StandardCharsets;

public class vk {
    // XOR sifrelemede kullanilan 3-karakterli anahtar: "ira"
    private static final String XOR_KEY = "ira";

    /**
     * Verilen hex stringi XOR_KEY ile cozumler.
     * Her byte, XOR_KEY'in (idx % 3). karakteriyle XOR'lanir.
     */
    public static String ve(Object[] objectArray) {
        String hexString = (String) objectArray[0];
        try {
            if (hexString == null || hexString.isEmpty()) {
                return "";
            }
            byte[] data = new byte[hexString.length() / 2];
            for (int i = 0; i < data.length; i++) {
                data[i] = (byte) Integer.parseInt(hexString.substring(i * 2, i * 2 + 2), 16);
            }
            for (int i = 0; i < data.length; i++) {
                data[i] = (byte) (data[i] ^ (byte) XOR_KEY.charAt(i % 3));
            }
            return new String(data, StandardCharsets.UTF_8);
        } catch (Exception e) {
            return "";
        }
    }
}
