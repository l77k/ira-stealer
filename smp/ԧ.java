/*
 * Decompiled with CFR 0.152.
 */
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public record \u0527(String method_FF, String method_FE, long method_FD) {
    private final String method_FF;
    private final String method_FE;
    private final long method_FD;

    \u0527(String string, String string2, long l2) {
        block4: {
            boolean bl;
            block6: {
                block5: {
                    long l3 = 131305543244450L;
                    this.method_FF = string;
                    this.method_FE = string2;
                    int n2 = \u00ef.method_FC;
                    this.method_FD = l2;
                    if (n2 == 0) break block4;
                    if (!f.method_FA) break block5;
                    bl = false;
                    break block6;
                }
                bl = true;
            }
            f.method_FA = bl;
        }
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{\u0527.class, "method_FF;method_FE;method_FD", "method_FF", "method_FE", "method_FD"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{\u0527.class, "method_FF;method_FE;method_FD", "method_FF", "method_FE", "method_FD"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{\u0527.class, "method_FF;method_FE;method_FD", "method_FF", "method_FE", "method_FD"}, this, object);
    }

    public String method_FF() {
        return this.method_FF;
    }

    public String method_FE() {
        return this.method_FE;
    }

    public long method_FD() {
        return this.method_FD;
    }

    public static void main(String[] stringArray) {
        throw new RuntimeException("Invalid execution context: 0xb641ec");
    }
}

