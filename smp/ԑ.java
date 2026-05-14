import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 * Cleaned RoundedPanel (formerly ԑ.java)
 * A custom Swing component used to create modern-looking, rounded UI elements
 * for the RansomChatUI. It supports anti-aliased edges and custom themes.
 */
public class RoundedPanel extends JPanel {
    private final boolean isSolid;
    private final int cornerRadius = 15;

    public RoundedPanel(LayoutManager layout, boolean isSolid) {
        super(layout);
        this.isSolid = isSolid;
        setOpaque(false); // Required for transparent corners
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        
        // Enable smooth edges
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Set colors based on the theme (usually defined in RansomChatUI)
        Color bgColor = isSolid ? new Color(40, 40, 40) : new Color(30, 30, 30);
        g2.setColor(bgColor);
        
        // Draw the main rounded rectangle
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
        
        if (!isSolid) {
            // Draw a subtle border if not solid
            g2.setColor(new Color(255, 255, 255, 30)); // Faint white border
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
        }
        
        g2.dispose();
    }
}
