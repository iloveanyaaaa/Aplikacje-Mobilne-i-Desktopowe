import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class ProductTableModel extends AbstractTableModel {
    private List<Product> produkty;
    private String[] nazwyKolumn = {"Nazwa", "Cena", "Ilość"};

    public ProductTableModel(List<Product> produkty) {
        this.produkty = produkty;
    }

    @Override
    public int getRowCount() {
        return produkty.size();
    }

    @Override
    public int getColumnCount() {
        return nazwyKolumn.length;
    }

    @Override
    public String getColumnName(int column) {
        return nazwyKolumn[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product p = produkty.get(rowIndex);
        switch (columnIndex) {
            case 0: return p.getNazwa();
            case 1: return p.getCena();
            case 2: return p.getIlosc();
            default: return null;
        }
    }
}

public class Main {
    public static void main(String[] args) {

        List<Product> produkty = new ArrayList<>();
        produkty.add(new Product("Produkt 1", 50, 50));
        produkty.add(new Product("Produkt 2", 5, 50));
        produkty.add(new Product("Produkt 3", 500, 5));

        ProductTableModel model = new ProductTableModel(produkty);

        JTable tabela = new JTable(model);

        tabela.setFillsViewportHeight(true);


        JFrame frame = new JFrame("Tabela Produktów");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(tabela), BorderLayout.CENTER);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
