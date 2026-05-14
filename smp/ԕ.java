import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 * Cleaned GradientTitleBar (formerly ԕ.java)
 * A decorative title bar component with a color gradient.
 */
public class GradientTitleBar extends JPanel {
    private final RansomChatUI ui;

    public GradientTitleBar(RansomChatUI ui, LayoutManager layout) {
        super(layout);
        this.ui = ui;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Apply a vertical gradient
        g2.setPaint(new GradientPaint(
            0, 0, ui.titleStartColor, 
            0, getHeight(), ui.titleEndColor));
            
        g2.fillRoundRect(0, 0, getWidth(), getHeight() + 10, 15, 15);
        
        // Draw a top highlight line
        g2.setColor(new Color(255, 255, 255, 40));
        g2.drawLine(0, 0, getWidth(), 0);
        
        g2.dispose();
    }
}
