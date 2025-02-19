import java.util.Random;

public class Kredit extends Konto{
    public Kredit(String kontoinhaber, int bankleitzahl, int kontonummer, double ueberziehungsrahmen, double kontofuehrung, double kontostand, String kontoart) {
        super(kontoinhaber, bankleitzahl, kontonummer, ueberziehungsrahmen, kontofuehrung, kontostand, kontoart);
    }
    Random randomNumbers = new Random();

    public void kontoAnlegen() {
        System.out.println("Sie sind dabei ein Kreditkonto zu eröffnen.\n");
        System.out.println("Bitte geben Sie ihren Namen ein.");
        String name = scan.nextLine();
        System.out.println("Welche Kreditsumme wurde Ihnen gewährt?");
        double geld = scan.nextDouble();
        scan.nextLine();

        int blz = 1921;
        double drueber = 0.00;
        double fuehrung = (geld / 100) * 2.05;
        String art = "Kredit";
        int kn = randomNumbers.nextInt(100000);
        Kredit kredit = new Kredit(name, blz, kn, drueber, fuehrung, -geld, art);
        Konto.kontos.add(kredit);
    }

    public void kontoLoeschen() {
        anzeigen();
        System.out.println("Welches Kreditkonto soll gelöscht werden?");
        int weg = scan.nextInt();
        scan.nextLine();
        Konto k = kontos.get(weg -1);
        double wert = k.getKontostand();

        System.out.printf("Auf dem Konto waren noch %.2f€ Schulden.\n", wert);
        System.out.println("Auf welches Konto sollen die Schulden übertragen werden?\nBitte beachten Sie, dass hier der " +
                "Überziehungsrahmen nicht überschritten werden kann.");
        anzeigen();
        System.out.println("Bitte wählen Sie eine Zahl.");
        int einz = scan.nextInt();
        scan.nextLine();
        Konto ki = kontos.get(einz -1);
        System.out.printf("Folgendes Konto wurde ausgewählt: %-20s | %-6.2f€ |  Kontonummer: %-6s | %-10s\n",ki.getKontoinhaber(), ki.getKontostand(), ki.getKontonummer(), ki.getKontoart());
        double geld = ki.getKontostand();
        double neuerKontostand = geld - wert;
        String art = ki.getKontoart();
        if(art == "Giro" && -ki.getUeberziehungsrahmen() > neuerKontostand){
            System.out.println("Der Überziehungsrahmen "+getUeberziehungsrahmen()+" ist zu klein. Die Transaktion wird nicht genehmigt. Konto bleibt geöffnet.");
        }else if(art == "Sparen" && neuerKontostand < 0){
            System.out.println("Der Überziehungsrahmen ist zu klein. Die Transaktion wird nicht genehmigt. Konto bleibt geöffnet.");
        }else if(art == "Kredit" && neuerKontostand > 0 || neuerKontostand < geld){
            System.out.println("Dieses Konto kann nicht ins Positive gebracht werden.\nKonto wird geschlossen. Danke für die Spende.");
            ki.setKontostand(neuerKontostand);
            kontos.remove(weg -1);
        }else{
            ki.setKontostand(neuerKontostand);
            kontos.remove(weg-1);
            System.out.println("Transaktion konnte durchgeführt werden.");
            System.out.printf("Der neue Kontostand beträgt %.2f€.\n", ki.getKontostand());
        }
    }

    public void ueberweisen(){
        anzeigen();
        System.out.println("Bitte wählen Sie ein Konto, von dem Geld überwiesen werden soll.");
        int zahl = scan.nextInt();
        scan.nextLine();
        Konto k = kontos.get(zahl -1);
        System.out.printf("Folgendes Konto wurde ausgewählt: %-20s | %-6.2f€ |  Kontonummer: %-6s | %-10s\n",k.getKontoinhaber(), k.getKontostand(), k.getKontonummer(), k.getKontoart());
        System.out.println("Wie viel soll ausgezahlt werden?");
        double raus = scan.nextDouble();
        scan.nextLine();
        double geld = k.getKontostand();
        double money = geld - raus;
        k.setKontostand(money);
        System.out.printf("Auf dem Konto sind jetzt %.2f€.\nZu welchem Konto sollen die %.2f€ hinzugefügt werden?\n", money, raus);
        anzeigen();
        int auswahl = scan.nextInt();
        scan.nextLine();
        Konto ki = kontos.get(auswahl - 1);
        System.out.printf("Folgendes Konto wurde ausgewählt: %-20s | %-6.2f€ |  Kontonummer: %-6s | %-10s\n", ki.getKontoinhaber(), ki.getKontostand(), ki.getKontonummer(), ki.getKontoart());
        String art = ki.getKontoart();
        double geld1 = ki.getKontostand();
        double neuerKontostand = geld1 + raus;
        if (art == "Kredit" && neuerKontostand > 0) {
            System.out.println("Das Konto wird geschlossen.\nDanke für die Spende.");
            ki.setKontostand(neuerKontostand);
            kontos.remove(auswahl - 1);
        } else {
            System.out.printf("Der neue Kontostand beträgt %.2f€.\n", neuerKontostand);
            ki.setKontostand(neuerKontostand);
        }
    }



}
