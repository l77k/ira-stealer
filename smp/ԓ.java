import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import javax.swing.JPanel;

/**
 * Cleaned HeaderPanel (formerly ԓ.java)
 * A simple UI panel with a border used at the top of the RansomChatUI window.
 */
public class HeaderPanel extends JPanel {
    private final RansomChatUI ui;

    public HeaderPanel(RansomChatUI ui, LayoutManager layout) {
        super(layout);
        this.ui = ui;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        
        // Draw the main background
        g2.setColor(ui.headerBackgroundColor);
        g2.fillRect(0, 0, getWidth(), getHeight());
        
        // Draw a top accent line
        g2.setColor(new Color(255, 255, 255, 20));
        g2.fillRect(0, 0, getWidth(), 1);
        
        g2.dispose();
    }
}
