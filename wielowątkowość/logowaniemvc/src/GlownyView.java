import javax.swing.*;
import java.awt.*;

public class GlownyView extends JFrame {
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;
    private JLabel statusLabel;

    public GlownyView() {
        setTitle("System Logowania");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        userField = new JTextField();
        passField = new JPasswordField();
        loginButton = new JButton("Zaloguj");
        statusLabel = new JLabel(" ");

        add(new JLabel("nazwa użytkownika:"));
        add(userField);
        add(new JLabel("hasło:"));
        add(passField);
        add(loginButton);
        add(statusLabel);

        loginButton.setEnabled(true);
    }

    public JTextField getUserField() {
        return userField;
    }

    public JPasswordField getPassField() {
        return passField;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JLabel getStatusLabel() {
        return statusLabel;
    }
}
