import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class kontoAuszahlen extends JDialog{
    private JPanel auszahlenPanel;
    private JLabel ausText;
    private JLabel labelText;
    private JTextField textField1;
    private JComboBox kontonummer;
    private JTextField kontostand;
    private JTextField inhaber;
    private JLabel label;

    public kontoAuszahlen() {
        setTitle("Geld beheben");

        // Konten aus der Liste in die ComboBox einfügen
        List<Konto> konten = Konto.kontos; // Stelle sicher, dass Konto.kontos existiert
        if (konten != null) {
            for (Konto k : konten) {
                kontonummer.addItem(String.valueOf(k.getKontonummer())); // In String konvertieren
            }
        }

        // ActionListener für ComboBox
        kontonummer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                anzeigen((String) kontonummer.getSelectedItem());
            }
        });

        setContentPane(auszahlenPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void anzeigen(String kontoNr) {
        for (Konto konto : Konto.kontos) {
            String kNr = String.valueOf(konto.getKontonummer());
            if (kNr.equals(kontoNr)) {
                inhaber.setText(konto.getKontoinhaber());
                kontostand.setText(konto.getKontostand() + "€");
                return;
            }
        }
    }

    public static void main(String[] args) {
        new kontoAuszahlen();
    }
}
