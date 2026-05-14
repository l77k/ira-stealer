import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

/**
 * Cleaned WindowDragListener (formerly ò.java)
 * Allows undecorated frames (like the RansomChatUI) to be dragged 
 * around the screen by clicking and moving the mouse.
 */
public class WindowDragListener extends MouseMotionAdapter {
    private final int[] mouseClickPoint;
    private final JFrame frame;

    public WindowDragListener(JFrame frame, int[] mouseClickPoint) {
        this.frame = frame;
        this.mouseClickPoint = mouseClickPoint;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Calculates the new position based on mouse movement
        int x = frame.getX() + e.getX() - mouseClickPoint[0];
        int y = frame.getY() + e.getY() - mouseClickPoint[1];
        frame.setLocation(x, y);
    }
}
