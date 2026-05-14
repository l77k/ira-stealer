import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Random;
import javax.swing.JPanel;

/**
 * Cleaned AnimatedBackground (formerly ԛ.java)
 * Provides a dynamic, animated background effect (matrix-style falling shapes)
 * for the RansomChatUI.
 */
public class AnimatedBackground extends JPanel {
    private final RansomChatUI ui;
    private static final long SEED = 0x6A6B6C6D6E6FL;

    public AnimatedBackground(RansomChatUI ui) {
        this.ui = ui;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int w = getWidth();
        int h = getHeight();
        
        // Draw base background
        g2.setColor(new Color(20, 20, 20, 240));
        g2.fillRect(0, 0, w, h);
        
        Random rand = new Random(SEED);
        for (int i = 0; i < 50; i++) {
            int x = rand.nextInt(w);
            float speed = 0.5f + rand.nextFloat() * 2.0f;
            int length = 50 + rand.nextInt(100);
            
            // Calculate vertical position based on animation state
            int y = (int)(ui.animationFrame * h * speed);
            int yPos = (y + i * (h / 50)) % h;
            
            // Draw falling rectangles/shapes
            g2.setColor(new Color(150, 0, 0, (int)(ui.opacity * 12.0f)));
            g2.fillRect(x, yPos, length, 2);
            
            // Draw small highlights
            g2.setColor(new Color(255, 0, 0, (int)(ui.opacity * 5.0f)));
            g2.fillPolygon(new int[]{x, x + length, x + length / 2}, 
                           new int[]{yPos, yPos, yPos - 5}, 3);
        }
        
        g2.dispose();
    }
}
