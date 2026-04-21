import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ShoppingListApp extends JFrame {
    private JTextField itemInput;
    private JButton addButton;
    private JList<String> itemsList;
    private JButton deleteButton;
    private JPanel mainPanel;
    private DefaultListModel<String> listModel;
    public ShoppingListApp() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        itemInput = new JTextField(20);
        addButton = new JButton("Dodaj");
        listModel = new DefaultListModel<>();
        itemsList = new JList<>(listModel);
        deleteButton = new JButton("Usuń");
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Produkt:"));
        topPanel.add(itemInput);
        topPanel.add(addButton);
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(itemsList), BorderLayout.CENTER);
        mainPanel.add(deleteButton, BorderLayout.SOUTH);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = itemInput.getText().trim();
                if (!text.isEmpty()) {
                    listModel.addElement(text);
                    itemInput.setText("");
                    itemInput.requestFocus();
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = itemsList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(null, "Wybierz produkt.");
                }
            }
        });
        setTitle("Lista");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(500, 300);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ShoppingListApp().setVisible(true);
        });
    }
}