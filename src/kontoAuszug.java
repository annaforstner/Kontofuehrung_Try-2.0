import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class kontoAuszug extends JDialog{
    private JPanel kontoAnsehen;
    private JLabel label1;
    private JLabel labelDrinnen1;
    private JLabel labelDrinnen2;
    private JLabel inhaberTxt;
    private JLabel kontonummerTxt;
    private JLabel kontostandTxt;
    private JLabel kontostand;
    private JLabel kontonummer;
    private JLabel kontoinhaber;
    private JComboBox auswaehlen;

    public kontoAuszug(){
        setTitle("Kontoauszug");

        // Konten aus der Liste in die ComboBox einfügen
        List<Konto> konten = Konto.kontos; // Stelle sicher, dass Konto.kontos existiert
        if (konten != null) {
            for (Konto k : konten) {
                auswaehlen.addItem(String.valueOf(k.getKontonummer())); // In String konvertieren
            }
        }

        // ActionListener für ComboBox
        auswaehlen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                anzeigen((String) auswaehlen.getSelectedItem());
            }
        });

        setContentPane(kontoAnsehen);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void anzeigen(String kontoNr) {
        for (Konto konto : Konto.kontos) {
            String kNr = String.valueOf(konto.getKontonummer());
            if (kNr.equals(kontoNr)) {
                kontoinhaber.setText(konto.getKontoinhaber());
                kontonummer.setText(String.valueOf(konto.getKontonummer()));
                kontostand.setText(konto.getKontostand() + "€");
                return;
            }
        }
    }

    public static void main(String[] args) {
        new kontoAuszug();
    }
}
