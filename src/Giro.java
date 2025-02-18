import java.util.Random;

public class Giro extends Konto{
    public Giro(String kontoinhaber, int bankleitzahl, int kontonummer, double ueberziehungsrahmen, double kontofuehrung, double kontostand, String kontoart) {
        super(kontoinhaber, bankleitzahl, kontonummer, ueberziehungsrahmen, kontofuehrung, kontostand, kontoart);
    }
    Random randomNumbers = new Random();


    @Override
    public void kontoAnlegen() {
        System.out.println("Sie sind dabei ein Girokonto zu eröffnen.\n");
        System.out.println("Bitte geben Sie Ihren Namen ein.");
        String name = scan.nextLine();
        System.out.println("Wie viel möchten Sie bei der Öffnung darauf überweisen?");
        double geld = scan.nextDouble();
        scan.nextLine();

        int blz = 1921;
        double drueber = 2000.00;
        double fuehrung = 0.07;
        String art = "Giro";
        int kn = randomNumbers.nextInt(100000);
        Giro giro = new Giro(name, blz, kn, drueber, fuehrung,geld, art);
        Konto.kontos.add(giro);
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
        System.out.println("Von welchem Konto soll behoben werden?");
        anzeigen();
        System.out.println("Wählen Sie eine Zahl: ");
        int ausz = scan.nextInt();
        Konto k = kontos.get(ausz-1);
        System.out.printf("Folgendes Konto wurde ausgewählt: %-20s | %-6.2f€ |  Kontonummer: %-6s | %-10s\n",k.getKontoinhaber(), k.getKontostand(), k.getKontonummer(), k.getKontoart());
        System.out.println("Wie viel soll ausgezahlt werden?");
        double raus = scan.nextDouble();
        scan.nextLine();
        double geld = k.getKontostand();
        double neuerKontostand = geld - raus;

        if( neuerKontostand < -k.getUeberziehungsrahmen()){
            System.out.println("Ihr momentaner Überziehungsrahmen ist "+ k.getUeberziehungsrahmen()+"€. Da die Abbuchung aber über diesem Limit liegt, kann die Transaktion nicht durchgeführt werden.");
        } else if(neuerKontostand <= 0){
            System.out.println("Sie haben zu viel Geld abgehoben, sind aber noch im Überziehungsrahmen. Bitte beachten Sie, dass diese Geld mit einem Tageszinssatz belegt wird.");
            k.setKontostand(neuerKontostand);
        } else{
            System.out.println("Transaktion erfolgreich.");
            k.setKontostand(neuerKontostand);
        }

        System.out.printf("Ihr momentaner Kontostand beträgt %.2f€.", k.getKontostand());

    }
}
