import javax.swing.*;

public class kontoAuszug extends JDialog{
    private JPanel kontoAnsehen;
    private JLabel label1;
    private JLabel labelDrinnen1;
    private JLabel labelDrinnen2;
    private JLabel inhaberTxt;
    private JLabel kontonummerTxt;
    private JLabel kontostandTxt;
    private JLabel kontostand;
    private JLabel kontonummer;
    private JLabel kontoinhaber;

    public kontoAuszug(){
        setContentPane(kontoAnsehen);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new kontoAuszug();
    }
}
