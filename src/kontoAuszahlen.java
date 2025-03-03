import javax.swing.*;

public class kontoAuszahlen extends JDialog{
    private JPanel auszahlenPanel;
    private JLabel ausText;
    private JLabel labelText;
    private JTextField textField1;
    private JComboBox auszahlen;

    public kontoAuszahlen() {

        setContentPane(auszahlenPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new kontoAuszahlen();
    }
}
