import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 * Cleaned CustomScrollBarUI (formerly ԋ.java)
 * Customizes the scrollbars in the RansomChatUI to match the dark theme.
 * Hides standard buttons and applies custom colors.
 */
public class CustomScrollBarUI extends BasicScrollBarUI {

    public CustomScrollBarUI() {
    }

    @Override
    protected void configureScrollBarColors() {
        // Dark grey thumb and track colors
        this.thumbColor = new Color(60, 60, 60);
        this.trackColor = new Color(30, 30, 30);
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return createEmptyButton();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return createEmptyButton();
    }

    private JButton createEmptyButton() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(0, 0));
        return button;
    }
}
