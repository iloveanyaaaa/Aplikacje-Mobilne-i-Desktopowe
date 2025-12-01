import javax.swing.*;
import java.awt.event.ActionListener;

public class KwadratView extends JFrame {
    private JTextField liczbaTextField = new JTextField(10);
    private JLabel wynikLabel = new JLabel("Wynik: ");
    private JButton obliczButton = new JButton("Oblicz");

    public KwadratView() {
        super("Kalkulator Kwadratu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        JPanel panel = new JPanel();
        panel.add(new JLabel("Wpisz liczbę: "));
        panel.add(liczbaTextField);
        panel.add(obliczButton);
        panel.add(wynikLabel);
        this.add(panel);
    }
    public void setWynik(int wynik) {
        wynikLabel.setText("Wynik: " + wynik);
    }
    public int getLiczba() {
        try {
            return Integer.parseInt(liczbaTextField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Samą liczbę.", "Błąd.", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }
    public void addObliczListener(ActionListener listener) {
        obliczButton.addActionListener(listener);
    }
}
