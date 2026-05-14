/*
 * Decompiled with CFR 0.152.
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import javax.swing.JPanel;

public class \u0519
extends JPanel {
    final \u051d method_FF;
    private static final long[] a;
    private static final Integer[] b;

    \u0519(\u051d \u051d2, LayoutManager layoutManager) {
        this.method_FF = \u051d2;
        super(layoutManager);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        block11: {
            long l2 = 69126652325500L;
            Graphics2D graphics2D = (Graphics2D)graphics.create();
            boolean bl = \u0565.method_FA;
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int n2 = this.getWidth();
            int n3 = this.getHeight();
            Path2D.Double double_ = new Path2D.Double();
            double_.moveTo(20.0, 0.0);
            double_.lineTo(n2 - \u0519.a(13212, 3069170992284556125L), 0.0);
            double_.lineTo(n2, 40.0);
            double_.lineTo(n2 - \u0519.a(32399, 559239012621882947L), n3 / 2);
            double_.lineTo(n2, n3 - \u0519.a(11229, 4425554848250217247L));
            double_.lineTo(n2 - \u0519.a(21838, 8684428228333583755L), n3);
            double_.lineTo(30.0, n3);
            double_.lineTo(0.0, n3 - \u0519.a(18137, 3355940563661336094L));
            double_.lineTo(15.0, n3 / 2);
            double_.lineTo(0.0, 40.0);
            double_.closePath();
            for (int i2 = \u0519.a(25608, 4827491636600474824L); i2 > 0; --i2) {
                graphics2D.setStroke(new BasicStroke((float)i2 * 2.5f, 1, 1));
                graphics2D.setColor(new Color(\u0519.a(149, 5393975711186315350L), 0, 0, Math.max(0, Math.min(\u0519.a(15279, 7229863707075302251L), (int)(\u0565.method_FF * (float)(\u0519.a(9438, 1027080271880997912L) - i2 * 3))))));
                graphics2D.draw(double_);
                if (bl) break block11;
                if (!bl) continue;
                boolean bl2 = !f.method_FA;
                f.method_FA = bl2;
                break;
            }
            graphics2D.setClip(double_);
            graphics2D.setColor(\u051d.method_FF);
            graphics2D.fill(double_);
            graphics2D.setColor(new Color(\u0519.a(15279, 7229863707075302251L), \u0519.a(15279, 7229863707075302251L), \u0519.a(15279, 7229863707075302251L), \u0519.a(25978, 4033587734175255991L)));
            graphics2D.fill(double_);
            graphics2D.setClip(null);
            graphics2D.setStroke(new BasicStroke(2.0f));
            graphics2D.setColor(new Color(\u0519.a(15279, 7229863707075302251L), 0, 0, Math.max(0, Math.min(\u0519.a(15279, 7229863707075302251L), (int)(\u0565.method_FF * 255.0f)))));
            graphics2D.draw(double_);
            graphics2D.dispose();
        }
    }

    /*
     * Unable to fully structure code
     */
    static {
        block8: {
            block7: {
                var0 = 41727625785476L;
                var6_1 = new long[10];
                var3_2 = 0;
                var4_3 = "7\u00bcS[S}M'I\u00b6G\u0094\nmethod_F9\u00a3\u0010\u0086\u00c3\u00c7\u00dbmethod_F8\u0014^\u0084Y\u0098\u00a33\u00b1\b\u00bc\u00bf\u0011+\u00b8>\u00e6B+\u00c7\u00e05\u0089method_F9\u0083method_F2|D\u00bd\u0012\u0019\u00af\u00c8\u0017\u0098-\u00d3\u00d4\u0010\u00c2\u00af\u00b9\u00b3\u00a9";
                var5_4 = "7\u00bcS[S}M'I\u00b6G\u0094\nmethod_F9\u00a3\u0010\u0086\u00c3\u00c7\u00dbmethod_F8\u0014^\u0084Y\u0098\u00a33\u00b1\b\u00bc\u00bf\u0011+\u00b8>\u00e6B+\u00c7\u00e05\u0089method_F9\u0083method_F2|D\u00bd\u0012\u0019\u00af\u00c8\u0017\u0098-\u00d3\u00d4\u0010\u00c2\u00af\u00b9\u00b3\u00a9".length();
                var2_5 = 0;
                while (true) {
                    var7_6 = var4_3.substring(var2_5, var2_5 += 8).getBytes("ISO-8859-1");
                    v0 = var6_1;
                    v1 = var3_2++;
                    v2 = ((long)var7_6[0] & 255L) << 56 | ((long)var7_6[1] & 255L) << 48 | ((long)var7_6[2] & 255L) << 40 | ((long)var7_6[3] & 255L) << 32 | ((long)var7_6[4] & 255L) << 24 | ((long)var7_6[5] & 255L) << 16 | ((long)var7_6[6] & 255L) << 8 | (long)var7_6[7] & 255L;
                    v3 = -1;
                    break block7;
                    break;
                }
lbl14:
                // 1 sources

                while (true) {
                    v0[v1] = v4;
                    if (var2_5 < var5_4) ** continue;
                    var4_3 = "\u00c0method_F0\u001eq\u0019\u00ac}9e4\u00e7/;\u0091\u00e6\u00cd";
                    var5_4 = "\u00c0method_F0\u001eq\u0019\u00ac}9e4\u00e7/;\u0091\u00e6\u00cd".length();
                    var2_5 = 0;
                    while (true) {
                        var7_6 = var4_3.substring(var2_5, var2_5 += 8).getBytes("ISO-8859-1");
                        v0 = var6_1;
                        v1 = var3_2++;
                        v2 = ((long)var7_6[0] & 255L) << 56 | ((long)var7_6[1] & 255L) << 48 | ((long)var7_6[2] & 255L) << 40 | ((long)var7_6[3] & 255L) << 32 | ((long)var7_6[4] & 255L) << 24 | ((long)var7_6[5] & 255L) << 16 | ((long)var7_6[6] & 255L) << 8 | (long)var7_6[7] & 255L;
                        v3 = 0;
                        break block7;
                        break;
                    }
                    break;
                }
lbl27:
                // 1 sources

                while (true) {
                    v0[v1] = v4;
                    if (var2_5 < var5_4) ** continue;
                    break block8;
                    break;
                }
            }
            v4 = v2 ^ var0;
            switch (v3) {
                default: {
                    ** continue;
                }
                ** case 0:
lbl38:
                // 1 sources

                ** continue;
            }
        }
        \u0519.a = var6_1;
        \u0519.b = new Integer[10];
    }

    private static int a(int n2, long l2) {
        int n3 = n2 ^ (int)(l2 & 0x7FFFL) ^ 0x68C5;
        if (b[n3] == null) {
            \u0519.b[n3] = (int)(a[n3] ^ l2);
        }
        return b[n3];
    }

    public static void main(String[] stringArray) {
        throw new RuntimeException("Invalid execution context: 0xef40b3");
    }
}

