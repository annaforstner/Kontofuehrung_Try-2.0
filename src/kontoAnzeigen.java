import javax.swing.*;

public class kontoAnzeigen extends JDialog{
    private JLabel label;
    private JPanel kontoAnsehen;
    private JScrollPane jScrollKonto;
    private JTextField kontoAuszug;

    public kontoAnzeigen(){
        setContentPane(kontoAnsehen);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new kontoAnzeigen();
    }
}
