/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JPanel;

public class \u050f
extends JPanel {
    final \u051d method_FF;
    private static final long a;

    \u050f(\u051d \u051d2, LayoutManager layoutManager) {
        this.method_FF = \u051d2;
        super(layoutManager);
    }

    @Override
    public Dimension getMaximumSize() {
        long l2 = 82361164013446L;
        return new Dimension((int)a, this.getPreferredSize().height);
    }

    /*
     * Enabled aggressive block sorting
     */
    static {
        long l2 = 22373726342146L;
        a = 1743478970935967743L;
    }

    public static void main(String[] stringArray) {
        throw new RuntimeException("Invalid execution context: 0x355200");
    }
}

