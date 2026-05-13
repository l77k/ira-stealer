/*
 * Decompiled with CFR 0.152.
 */
package ira.m;

import ira.m.vm;

public class vl {
    private static String[] b;

    public void ve(Object[] objectArray) {
        vm.vf(new Object[0]);
    }

    public static void vf(String[] stringArray) {
        b = stringArray;
    }

    public static String[] vg() {
        return b;
    }

    static {
        if (vl.vg() == null) {
            vl.vf(new String[5]);
        }
    }
}

