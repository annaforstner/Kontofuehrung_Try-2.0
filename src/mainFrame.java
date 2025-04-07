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

        Konto g = new Konto("Anna Forstner", 1234, 13099, 200.00, 3.34, 6.27, "Giro");
        Giro g1 = new Giro("Mark Pock", 7896, 80188, 20000.00, 1.89, 13500.00, "Giro");
        Giro g2 = new Giro("Hermine Karner", 3224, 23456, 500.00,2.45, 5604.78, "Giro" );

        Kredit k = new Kredit("Marnie Blaise", 1247, 35578, 0.00, 3.05, -4500.78, "Kredit");
        Kredit k1 = new Kredit("Bernd Vihnanek", 3469, 43578, 0.00,2.85, -5890.99, "Kredit" );
        Kredit k2 = new Kredit("Shirley McAfton", 9517, 57327, 0.00,0.89,-100000, "Kredit");

        Spar s = new Spar("Gerhard Jakob", 2478, 56780, 0.00,0.158,524.32, "Sparen");
        Spar s1 = new Spar("Marvin Klein", 1835, 73361, 0.00,0.52, 500.00,"Sparen" );
        Spar s2 = new Spar("Sara Mila", 1834, 61214, 0.00,0.05,2500.00,"Sparen");

        Konto.kontos.add(g);
        Konto.kontos.add(g2);
        Konto.kontos.add(k);
        Konto.kontos.add(k1);
        Konto.kontos.add(s);
        Konto.kontos.add(k2);
        Konto.kontos.add(s2);
        Konto.kontos.add(s1);
        Konto.kontos.add(g1);

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
                new kontoLoeschen();
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


        setContentPane((mainPanel));
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public static void main(String[] args) {
        new mainFrame();
    }
}
