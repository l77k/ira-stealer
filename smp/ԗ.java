/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Dimension;
import java.lang.invoke.CallSite;
import javax.swing.JPanel;

public class \u0517
extends JPanel {
    final \u051d method_FF;

    \u0517(\u051d \u051d2) {
        this.method_FF = \u051d2;
    }

    @Override
    public Dimension getPreferredSize() {
        long l2 = 65441516885151L;
        CallSite callSite = g_0.a("getPreferredSize", "IKC]EWK`#-$.Q\MAFIf-%&-atNOGG", "()Ljava/awt/Dimension;", 4, (Object)this);
        if (this.getParent() != null) {
            ((Dimension)((Object)callSite)).width = this.getParent().getWidth();
        }
        return callSite;
    }

    public static void main(String[] stringArray) {
        throw new RuntimeException("Invalid execution context: 0x3f4892");
    }
}

