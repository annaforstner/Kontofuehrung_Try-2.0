import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class btnKontoErstellen extends JDialog{
    private JButton girokontoButton;
    private JButton sparkontoButton;
    private JButton kreditkontoButton;
    private JPanel btnPanel;

    public btnKontoErstellen(){
        setContentPane((btnPanel));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        girokontoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new giroKonto();
            }
        });
        kreditkontoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new kreditKonto();
            }
        });
        sparkontoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new sparKonto();
            }
        });
    }
}
