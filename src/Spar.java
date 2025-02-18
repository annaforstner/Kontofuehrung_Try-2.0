import java.util.Random;

public class Spar extends Konto{

    public Spar(String kontoinhaber, int bankleitzahl, int kontonummer, double ueberziehungsrahmen, double kontofuehrung, double kontostand, String kontoart) {
        super(kontoinhaber, bankleitzahl, kontonummer, ueberziehungsrahmen, kontofuehrung, kontostand, kontoart);
    }
    Random randomNumbers = new Random();


    @Override
    public void kontoAnlegen() {
        System.out.println("Sie sind dabei ein Sparkonto zu eröffnen.\n");
        System.out.println("Bitte geben Sie Ihren Namen ein.");
        String name = scan.nextLine();
        System.out.println("Wie viel möchten Sie bei der Öffnung darauf überweisen?");
        double geld = scan.nextDouble();
        scan.nextLine();

        int blz = 1921;
        double drueber = 0.00;
        double fuehrung = 0.0125;
        String art = "Sparen";
        int kn = randomNumbers.nextInt(100000);
        Spar spar = new Spar (name, blz, kn, drueber, fuehrung,geld, art);
        Konto.kontos.add(spar);
    }

    @Override
    public void kontoLoeschen() {
        anzeigen();
        System.out.println("Welches dieser Konten soll gelöscht werden? Bitte wählen Sie eine Zahl.");
        int weg = scan.nextInt();
        scan.nextLine();
        kontos.remove(weg-1);
        System.out.println("Konto wurde gelöscht.");
    }

    @Override
    public void einzahlen() {
        System.out.println("Auf welches Konto soll eingezahlt werden?");
        anzeigen();
        System.out.println("\nBitte wählen Sie eine Zahl.");
        int einz = scan.nextInt();
        scan.nextLine();
        Konto k = kontos.get(einz -1);
        System.out.printf("Folgendes Konto wurde ausgewählt: %-20s | %-6.2f€ |  Kontonummer: %-6s | %-10s\n",k.getKontoinhaber(), k.getKontostand(), k.getKontonummer(), k.getKontoart());
        System.out.println("Wie viel Geld soll darauf eingezahlt werden?");
        double hinein = scan.nextDouble();
        scan.nextLine();
        double geld = k.getKontostand();
        double neuerKontostand = hinein + geld;
        k.setKontostand(neuerKontostand);
        System.out.printf("Der neue Kontostand beträgt %.2f€.\n", k.getKontostand());
    }

    @Override
    public void auszahlen() {

    }
}
