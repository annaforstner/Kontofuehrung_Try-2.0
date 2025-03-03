import javax.swing.*;

public class kontoUeberweisen extends JDialog{
    private JPanel panelUeberweisen;
    private JComboBox konto1;
    private JLabel labelQuery;
    private JLabel labelTxt;
    private JTextField textField1;
    private JLabel label2;
    private JComboBox comboBox1;


    public kontoUeberweisen(){
        setContentPane(panelUeberweisen);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new kontoUeberweisen();
    }
}
