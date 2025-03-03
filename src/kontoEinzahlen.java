import javax.swing.*;

public class kontoEinzahlen extends JDialog{
    private JLabel anweisung;
    private JComboBox einzahlenAufKonto;
    private JLabel moneyValue;
    private JTextField einzahlen;
    private JPanel kEinzahlen;

    public kontoEinzahlen(){
        setContentPane(kEinzahlen);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new kontoEinzahlen();
    }
}

