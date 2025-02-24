import javax.swing.*;

public class giroKonto extends JFrame{
    private JPanel giroPanel;
    private JLabel begruessung;
    private JLabel fullnameText;
    private JTextField fullname;
    private JLabel money;
    private JTextField startkapital;
    private JButton speichernButton;

    
    public giroKonto(){
        setContentPane((giroPanel));
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new giroKonto();
    }
}
