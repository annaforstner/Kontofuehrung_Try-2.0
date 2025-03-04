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
                new GiroKonto();
            }
        });
        kreditkontoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new KreditKonto();
            }
        });
        sparkontoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SparKonto();
            }
        });
    }
}
