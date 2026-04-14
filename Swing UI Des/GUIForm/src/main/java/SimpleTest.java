import javax.swing.*;
import java.awt.*;
public class SimpleTest extends JFrame {
    private JPanel mainPanel;
    private JLabel myLabel;
    private JButton actionButton;
    public SimpleTest() {
        this.setTitle("Test GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        myLabel = new JLabel("Chwila.");
        actionButton = new JButton("Kliknij mnie!");
        mainPanel.add(myLabel);
        mainPanel.add(actionButton);
        this.setContentPane(mainPanel);
        actionButton.addActionListener(e -> {
            myLabel.setText("Witam.");
        });
        this.pack();
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
    }
}