/*
 * Decompiled & Deobfuscated
 * Global durum tutucusu — vl.vg() ile diger siniflardan erisilen String[] b dizisi
 * null degilse "zaten basladi" anlami tasir (bir tur kilit mekanizmasi)
 */
package ira.m;

public class vl {
    // Operasyon durum dizisi — null ise henuz baslamadi
    private static String[] b;

    // vm.vf() tarafindan cagrilir — payload is parcacigini baslatir
    public void ve(Object[] objectArray) {
        vm.vf(new Object[0]);
    }

    public static void vf(String[] stringArray) {
        b = stringArray;
    }

    // Durum dizisini dondurur — null kontrolu ile tekrarlayan calistirmayi onler
    public static String[] vg() {
        return b;
    }

    static {
        if (vl.vg() == null) {
            vl.vf(new String[5]);
        }
    }
}
