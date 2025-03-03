import javax.swing.*;

public class sparKonto extends JDialog{
    private JLabel nameTxt;
    private JTextField fullname;
    private JTextField money;
    private JPanel moneyBox;
    private JLabel geldeingang;
    private JButton speichern;

    public sparKonto(){
        setContentPane(moneyBox);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new sparKonto();
    }
}
