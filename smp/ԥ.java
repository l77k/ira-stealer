/*
 * Decompiled with CFR 0.152.
 */
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public record \u0525(String method_FC, int method_FB) {
    private final String method_FC;
    private final int method_FB;

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{\u0525.class, "method_FC;method_FB", "method_FC", "method_FB"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{\u0525.class, "method_FC;method_FB", "method_FC", "method_FB"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{\u0525.class, "method_FC;method_FB", "method_FC", "method_FB"}, this, object);
    }

    public String method_FC() {
        return this.method_FC;
    }

    public int method_FB() {
        return this.method_FB;
    }

    public static void main(String[] stringArray) {
        throw new RuntimeException("Invalid execution context: 0xb9db71");
    }
}

