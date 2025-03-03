import javax.swing.*;

public class giroKonto extends JDialog{
    private JPanel giroPanel;
    private JLabel begruessung;
    private JLabel fullnameText;
    private JTextField fullname;
    private JLabel money;
    private JTextField startkapital;
    private JButton speichernButton;
    private JLabel begruessung2;


    public giroKonto(){
        setContentPane((giroPanel));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new giroKonto();
    }
}
