import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Cleaned MousePressListener (formerly ó.java)
 * Captures the initial mouse click coordinates on a JFrame.
 * Used in conjunction with WindowDragListener to enable window movement.
 */
public class MousePressListener extends MouseAdapter {
    private final int[] mouseClickPoint;

    public MousePressListener(int[] mouseClickPoint) {
        this.mouseClickPoint = mouseClickPoint;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Records the exact pixel where the user clicked within the frame
        this.mouseClickPoint[0] = e.getX();
        this.mouseClickPoint[1] = e.getY();
    }
}
