import javax.swing.*;

public class kreditKonto extends JDialog{
    private JPanel kreditPanel;
    private JLabel nameTxt;
    private JTextField fullname;
    private JLabel money;
    private JTextField kreditMoney;
    private JButton speichern;


    public kreditKonto(){
        setContentPane(kreditPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public static void main(String[] args) {
        new kreditKonto();
    }
}
