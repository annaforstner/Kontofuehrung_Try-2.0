import javax.swing.*;
import java.util.Random;


public class KreditKonto extends JDialog{
    private JLabel welcomeTxt;
    private JPanel kreditPanel;
    private JTextField fullname;
    private JLabel nameTxt;
    private JLabel kreditTxt;
    private JTextField money;
    private JButton speichern;

    public KreditKonto(){
        setTitle("Kreditkonto Erstellen");

        setContentPane(kreditPanel);
        pack();
        setLocationRelativeTo(null);

        speichern.addActionListener(e -> speichereKonto());

        setVisible(true);
    }

    private void speichereKonto(){
        try {
            Random randomNumbers = new Random();
            String name = fullname.getText();
            double geld = Double.parseDouble(money.getText().trim());
            int blz = 1921;
            double drueber = 0.00;
            double fuehrung = (geld / 100) * 2.05;
            String art = "Kredit";
            int kn = randomNumbers.nextInt(100000);
            Kredit kredit = new Kredit(name, blz, kn, drueber, fuehrung, -geld, art);
            Konto.kontos.add(kredit);
            JOptionPane.showMessageDialog(this, "Konto erfolgreich erstellt!\nKontonummer: " + kn);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Bitte eine gültige Zahl für das Startkapital eingeben!", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new KreditKonto();
    }
}
