import javax.swing.*;
import java.util.Random;

public class SparKonto extends JDialog{
    private JLabel nameTxt;
    private JTextField fullname;
    private JTextField money;
    private JPanel moneyBox;
    private JLabel geldeingang;
    private JButton speichern;

    public SparKonto(){
        setTitle("Sparkonto erstellen");

        setContentPane(moneyBox);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        // ActionListener für den Speichern-Button
        speichern.addActionListener(e -> speichereKonto());
        setVisible(true);
    }

    private void speichereKonto() {
        try {
            Random randomNumbers = new Random();
            String name = fullname.getText().trim();
            double geld = Double.parseDouble(money.getText().trim());
            int blz = 1921;
            double drueber = 2000.00;
            double fuehrung = randomNumbers.nextDouble() * 100; // Zufällige Kontoführungsgebühr
            String art = "Spar";
            int kn = randomNumbers.nextInt(100000);
            Spar s = new Spar(name, blz, kn, drueber, fuehrung, geld, art);
            Konto.kontos.add(s);
            JOptionPane.showMessageDialog(this, "Konto erfolgreich erstellt!\nKontonummer: " + kn);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Bitte eine gültige Zahl für das Startkapital eingeben!", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new SparKonto();
    }
}
