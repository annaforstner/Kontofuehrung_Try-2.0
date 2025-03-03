import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainFrame extends JFrame{
    private JButton kontoErstellenButton;
    private JButton kontoLöschenButton;
    private JButton kontoauszugButton;
    private JButton einzahlenButton;
    private JButton auszahlenButton;
    private JButton überweisenButton;
    private JButton alleAnzeigenButton;
    private JPanel mainPanel;

    public mainFrame() {
        setContentPane((mainPanel));
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);



        kontoErstellenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new btnKontoErstellen();
            }
        });
        alleAnzeigenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new kontoAnzeigen();
            }
        });
        kontoauszugButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new kontoAuszug();
            }
        });
        kontoLöschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new kontoEinzahlen();
            }
        });
        auszahlenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new kontoAuszahlen();
            }
        });
        einzahlenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new kontoEinzahlen();
            }
        });
        überweisenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new kontoUeberweisen();
            }
        });
    }


    public static void main(String[] args) {
        new mainFrame();
    }
}
