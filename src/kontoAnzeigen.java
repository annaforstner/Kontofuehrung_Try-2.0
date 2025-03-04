import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class kontoAnzeigen extends JDialog {
    private JPanel kontoAnsehen;
    private JScrollPane scrollPane;
    private JTable kontoTabelle;

    public kontoAnzeigen() {
        setTitle("Kontoansicht");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tabelle erstellen
        String[] spalten = {"Name", "BLZ", "Kontonummer", "Kontostand", "Art"};
        DefaultTableModel tableModel = new DefaultTableModel( spalten, 0);
        List <Konto> konten = Konto.kontos;
        for (Konto konto : konten) {
            Object[] daten = {
                    konto.getKontoinhaber(),
                    konto.getBankleitzahl(),
                    konto.getKontonummer(),
                    konto.getKontostand() + "€",
                    konto.getKontoart()
            };
            tableModel.addRow(daten);
        }

        kontoTabelle.setModel(tableModel);
        setContentPane(kontoAnsehen);

        pack(); // Pack nach dem Hinzufügen aller Komponenten
        setVisible(true);
    }

    public static void main(String[] args) {
        new kontoAnzeigen();
    }
}
