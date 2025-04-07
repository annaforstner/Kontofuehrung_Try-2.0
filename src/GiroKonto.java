import javax.swing.*;
import java.util.Random;

public class GiroKonto extends JDialog {
    private JPanel giroPanel;
    private JLabel begruessung;
    private JLabel fullnameText;
    private JTextField fullname;
    private JLabel money;
    private JTextField startkapital;
    private JButton speichernButton;
    private JLabel begruessung2;

    public GiroKonto() {
        setTitle("Girokonto Erstellen");

        // Sicherstellen, dass `giroPanel` korrekt gesetzt wird
        setContentPane(giroPanel);
        pack();
        setLocationRelativeTo(null);

        // ActionListener für den Speichern-Button
        speichernButton.addActionListener(e -> speichereKonto());

        setVisible(true);
    }

    private void speichereKonto() {
        try {
            Random randomNumbers = new Random();
            String name = fullname.getText().trim();
            double geld = Double.parseDouble(startkapital.getText().trim());
            int blz = 1921;
            double drueber = 2000.00;
            double fuehrung = randomNumbers.nextDouble() * 100; // Zufällige Kontoführungsgebühr
            String art = "Giro";
            int kn = randomNumbers.nextInt(5, 100000);

            Giro g = new Giro(name, blz, kn, drueber, fuehrung, geld, art);
            Konto.kontos.add(g);

            JOptionPane.showMessageDialog(this, "Konto erfolgreich erstellt!\nKontonummer: " + kn);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Bitte eine gültige Zahl für das Startkapital eingeben!", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new GiroKonto();
    }
}
