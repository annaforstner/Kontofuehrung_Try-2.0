import java.util.Random;

public class Giro extends Konto{
    public Giro(String kontoinhaber, int bankleitzahl, int kontonummer, double ueberziehungsrahmen, double kontofuehrung, double kontostand, String kontoart) {
        super(kontoinhaber, bankleitzahl, kontonummer, ueberziehungsrahmen, kontofuehrung, kontostand, kontoart);
    }
    Random randomNumbers = new Random();


    public void kontoAnlegen() {
        System.out.println("Sie sind dabei ein Girokonto zu eröffnen.\n");
        System.out.println("Bitte geben Sie Ihren Namen ein.");
        String name = scan.nextLine();
        System.out.println("Wie viel möchten Sie bei der Öffnung darauf überweisen?");
        double geld = scan.nextDouble();
        scan.nextLine();

        int blz = 1921;
        double drueber = 2000.00;
        double fuehrung = randomNumbers.nextDouble(100);
        String art = "Giro";
        int kn = randomNumbers.nextInt(100000);
        Giro giro = new Giro(name, blz, kn, drueber, fuehrung,geld, art);
        Konto.kontos.add(giro);
    }

    public void kontoLoeschen() {
        anzeigen();
        System.out.println("Welches dieser Konten soll gelöscht werden? Bitte wählen Sie eine Zahl.");
        int weg = scan.nextInt();
        scan.nextLine();
        Konto k = kontos.get(weg -1);
        double wert = k.getKontostand();
        kontos.remove(weg-1);
        System.out.println("Konto wurde gelöscht.");
        System.out.printf("Auf dem Konto waren noch %.2f€. Auf welches Konto soll das Geld überwiesen werden?\n", wert);
        anzeigen();
        int x = scan.nextInt();
        scan.nextLine();
        Konto ki = kontos.get(x -1);
        System.out.printf("Folgendes Konto wurde ausgewählt: %-20s | %-6.2f€ |  Kontonummer: %-6s | %-10s\n",ki.getKontoinhaber(), ki.getKontostand(), ki.getKontonummer(), ki.getKontoart());
        String art = ki.getKontoart();
        double geld1 = ki.getKontostand();
        double neuerKontostand = geld1 + wert;
        if(art == "Kredit" && neuerKontostand > 0){
            System.out.println("Das Konto wird geschlossen.\nDanke für die Spende.");
            ki.setKontostand(neuerKontostand);
            kontos.remove(x-1);
        }
        else{
            System.out.printf("Der neue Kontostand ist %.2f€.\n", neuerKontostand);
            ki.setKontostand(neuerKontostand);
        }
    }

    public void ueberweisen(){
        anzeigen();
        System.out.println("Bitte wählen Sie ein Konto, von dem Geld abgehoben wird.");
        int index = scan.nextInt();
        scan.nextLine();
        Konto k = kontos.get(index -1);
        System.out.printf("Folgendes Konto wurde ausgewählt: %-20s | %-6.2f€ |  Kontonummer: %-6s | %-10s\n",k.getKontoinhaber(), k.getKontostand(), k.getKontonummer(), k.getKontoart());
        System.out.println("Wie viel soll ausgezahlt werden?");
        double raus = scan.nextDouble();
        scan.nextLine();
        double geld = k.getKontostand();
        double kontostand = geld - raus;
        if(kontostand < -k.getUeberziehungsrahmen()){
            System.out.println("Ihr Überziehungsrahmen ist zu klein. Es kann nicht von diesem Konto abgehoben werden.");
        }else {
            System.out.printf("Sie haben %.2f€ abgehoben. Ihr neuer Kontostand ist %.2f€.\n", raus, kontostand);
            k.setKontostand(kontostand);

            System.out.printf("\nAuf welches Konto sollen die %.2f€ überwiesen werden?\n", raus);
            anzeigen();
            int x = scan.nextInt();
            scan.nextLine();
            Konto ki = kontos.get(x - 1);
            System.out.printf("Folgendes Konto wurde ausgewählt: %-20s | %-6.2f€ |  Kontonummer: %-6s | %-10s\n", ki.getKontoinhaber(), ki.getKontostand(), ki.getKontonummer(), ki.getKontoart());
            String art = ki.getKontoart();
            double geld1 = ki.getKontostand();
            double neuerKontostand = geld1 + raus;
            if (art == "Kredit" && neuerKontostand > 0) {
                System.out.println("Das Konto wird geschlossen.\nDanke für die Spende.");
                ki.setKontostand(neuerKontostand);
                kontos.remove(x - 1);
            } else {
                System.out.printf("Der neue Kontostand beträgt %.2f€.\n", neuerKontostand);
                ki.setKontostand(neuerKontostand);
            }
        }
    }
}
