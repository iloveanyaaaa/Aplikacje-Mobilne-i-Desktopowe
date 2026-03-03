import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class SystemRaportowaniaMagazynowego extends JFrame {

    private JTable tabela;

    public SystemRaportowaniaMagazynowego() {

        setTitle("System Raportowania Magazynowego");
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] kolumny = {"ID", "Nazwa Produktu", "Ilość", "Cena"};

        Object[][] dane = {
                {1, "Klawiatura", 10, 120.50},
                {2, "Mysz", 25, 59.99},
                {3, "Monitor", 5, 899.00},
                {4, "Drukarka", 3, 450.00}
        };
        DefaultTableModel model = new DefaultTableModel(dane, kolumny);
        tabela = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabela);
        JButton btnPDF = new JButton("Generuj Raport PDF");
        btnPDF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generujPDF();
            }
        });
        add(scrollPane, BorderLayout.CENTER);
        add(btnPDF, BorderLayout.SOUTH);
    }
    private void generujPDF() {

        JFileChooser chooser = new JFileChooser();
        int state = chooser.showSaveDialog(this);

        if (state == JFileChooser.APPROVE_OPTION) {

            Document document = new Document();

            try {
                PdfWriter.getInstance(document,
                        new FileOutputStream(chooser.getSelectedFile() + ".pdf"));

                document.open();

                // 📅 Aktualna data
                String data = new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new Date());

                Paragraph naglowek = new Paragraph(
                        "RAPORT MAGAZYNOWY\nData wygenerowania: " + data + "\n\n",
                        FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)
                );

                naglowek.setAlignment(Element.ALIGN_CENTER);
                document.add(naglowek);

                PdfPTable pdfTable = new PdfPTable(tabela.getColumnCount());
                pdfTable.setWidthPercentage(100);

                // 🔹 Nagłówki tabeli (wyśrodkowane)
                for (int i = 0; i < tabela.getColumnCount(); i++) {
                    PdfPCell cell = new PdfPCell(
                            new Phrase(tabela.getColumnName(i))
                    );
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfTable.addCell(cell);
                }

                // 🔹 Dane tabeli (wyśrodkowane)
                for (int rows = 0; rows < tabela.getRowCount(); rows++) {
                    for (int cols = 0; cols < tabela.getColumnCount(); cols++) {

                        PdfPCell cell = new PdfPCell(
                                new Phrase(tabela.getModel()
                                        .getValueAt(rows, cols).toString())
                        );

                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfTable.addCell(cell);
                    }
                }

                document.add(pdfTable);

                JOptionPane.showMessageDialog(this,
                        "Raport PDF wygenerowany poprawnie!");

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                document.close();
            }
        }
    }

    public static void main(String[] args) {
        new SystemRaportowaniaMagazynowego().setVisible(true);
    }
}