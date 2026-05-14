/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.JComponent;
import javax.swing.JWindow;
import javax.swing.Timer;

public class \u050d
extends JWindow {
    private static \u050d method_FF;
    private final Timer method_FE;
    private static final long a;

    public static synchronized void method_FF(Object[] objectArray) {
        block11: {
            \u050d \u050d2;
            long l2;
            block10: {
                long l3 = (Long)objectArray[0];
                long l4 = l3;
                l2 = 98077912123196L;
                long l5 = 105470862978543L;
                boolean bl = \u0565.method_FA;
                \u050d2 = method_FF;
                if (bl) break block10;
                if (\u050d2 != null) break block11;
                \u050d2 = new \u050d(l5);
            }
            method_FF = \u050d2;
            Object[] objectArray2 = new Object[1];
            objectArray2[0] = l2;
            \u0565.method_FE(objectArray2);
        }
    }

    public static synchronized void method_FE(Object[] objectArray) {
        long l2 = (Long)objectArray[0];
        long l3 = 131832968810736L;
        if (method_FF != null) {
            method_FF.dispose();
            method_FF = null;
            Object[] objectArray2 = new Object[1];
            objectArray2[0] = l3;
            \u0565.method_FD(objectArray2);
        }
    }

    private \u050d(long l2) {
        Object object;
        block6: {
            GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Rectangle rectangle = new Rectangle();
            object = graphicsEnvironment.getScreenDevices();
            boolean bl = \u0565.method_FA;
            int n2 = ((GraphicsDevice[])object).length;
            int n3 = 0;
            block2: while (n3 < n2) {
                GraphicsDevice graphicsDevice = object[n3];
                rectangle = rectangle.union(graphicsDevice.getDefaultConfiguration().getBounds());
                ++n3;
                do {
                    boolean bl2 = bl;
                    if (l2 >= 0L) {
                        if (bl2) break block6;
                        bl2 = bl;
                    }
                    if (!bl2) continue block2;
                } while (l2 < 0L);
                break;
            }
            this.setBounds(rectangle);
            this.setAlwaysOnTop(true);
            this.setBackground(new Color(0, 0, 0, 1));
        }
        object = new \u051b(this);
        ((JComponent)object).setOpaque(false);
        this.setContentPane((Container)object);
        this.method_FE = new Timer((int)a, this::lambda$new$0);
        this.method_FE.start();
        this.setVisible(true);
        this.toBack();
    }

    @Override
    public void dispose() {
        g_0.a("stop", "QYKSWK`#-/$KJ[A\If-/"!nSK[L", "()V", 1, (Object)this.method_FE);
        g_0.a("dispose", "QYKSWK`#-/$KJ[A\If-/"!pmOPZUM", "()V", 4, (Object)this);
    }

    private void lambda$new$0(ActionEvent actionEvent) {
        this.repaint();
    }

    /*
     * Enabled aggressive block sorting
     */
    static {
        long l2 = 78237973023137L;
        a = -2603377641738207192L;
    }

    public static void main(String[] stringArray) {
        throw new RuntimeException("Invalid execution context: 0x4e0e94");
    }
}

