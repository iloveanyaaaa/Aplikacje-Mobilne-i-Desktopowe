package org.example;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class SystemRaportowaniaMagazynowego extends JFrame {

    private JTable tabela;

    public SystemRaportowaniaMagazynowego() {

        setTitle("System Raportowania Magazynowego - OpenPDF");
        setSize(600, 400);
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
        JButton btnPDF = new JButton("Generuj Raport PDF");
        btnPDF.addActionListener((ActionEvent e) -> generujPDF());
        add(new JScrollPane(tabela), BorderLayout.CENTER);
        add(btnPDF, BorderLayout.SOUTH);
    }
    private void generujPDF() {
        JFileChooser chooser = new JFileChooser();
        int wybor = chooser.showSaveDialog(this);
        if (wybor == JFileChooser.APPROVE_OPTION) {
            Document document = new Document();
            try {
                PdfWriter.getInstance(document,
                        new FileOutputStream(chooser.getSelectedFile() + ".pdf"));
                document.open();
                String data = new SimpleDateFormat("dd.MM.yyyy HH:mm")
                        .format(new Date());
                Font naglowekFont = new Font(Font.HELVETICA, 14, Font.BOLD);
                Paragraph naglowek = new Paragraph(
                        "RAPORT MAGAZYNOWY\nData wygenerowania: " + data + "\n\n",
                        naglowekFont
                );
                naglowek.setAlignment(Element.ALIGN_CENTER);
                document.add(naglowek);
                PdfPTable pdfTable = new PdfPTable(tabela.getColumnCount());
                pdfTable.setWidthPercentage(100);
                for (int i = 0; i < tabela.getColumnCount(); i++) {
                    PdfPCell cell = new PdfPCell(
                            new Phrase(tabela.getColumnName(i))
                    );
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfTable.addCell(cell);
                }
                for (int rows = 0; rows < tabela.getRowCount(); rows++) {
                    for (int cols = 0; cols < tabela.getColumnCount(); cols++) {

                        PdfPCell cell = new PdfPCell(
                                new Phrase(
                                        tabela.getModel()
                                                .getValueAt(rows, cols)
                                                .toString()
                                )
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
        SwingUtilities.invokeLater(() ->
                new SystemRaportowaniaMagazynowego().setVisible(true));
    }
}