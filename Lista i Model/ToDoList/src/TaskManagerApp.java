import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class TaskManagerApp extends JFrame {
    private JTextField taskInput;
    private JButton addButton;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private JLabel counterLabel;
    private JButton deleteButton;
    public TaskManagerApp() {
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskInput = new JTextField(40);
        addButton = new JButton("Dodaj zadanie");
        deleteButton = new JButton("Usuń zaznaczone");
        counterLabel = new JLabel("Liczba zadań: 0");
        setLayout(new BorderLayout(30, 30));
        JPanel northPanel = new JPanel(new FlowLayout());
        northPanel.add(new JLabel("Zadanie:"));
        northPanel.add(taskInput);
        northPanel.add(addButton);
        add(northPanel, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        centerPanel.add(counterLabel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);
        add(deleteButton, BorderLayout.SOUTH);
        addButton.addActionListener(e -> addTask());
        taskInput.addActionListener(e -> addTask());
        deleteButton.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if (index != -1) {
                listModel.remove(index);
                updateCounter();
            } else {
                JOptionPane.showMessageDialog(this, "Wybierz zadanie do usunięcia!");
            }
        });
        taskList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = taskList.locationToIndex(e.getPoint());
                    if (index != -1) {
                        listModel.remove(index);
                        updateCounter();
                    }
                }
            }
        });
        setTitle("Menedżer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 400);
        setLocationRelativeTo(null);
    }
    private void addTask() {
        String text = taskInput.getText().trim();
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Treść zadania nie może być pusta!", "Błąd", JOptionPane.ERROR_MESSAGE);
        } else {
            listModel.addElement(text);
            taskInput.setText("");
            updateCounter();
        }
    }
    private void updateCounter() {
        counterLabel.setText("Ilość zadań: " + listModel.getSize());
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TaskManagerApp().setVisible(true));
    }
}