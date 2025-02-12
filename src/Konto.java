import java.util.ArrayList;
import java.util.Scanner;

public abstract class Konto {
    private String kontoinhaber;
    private int bankleitzahl;
    private String kontonummer;
    private double ueberziehungsrahmen;
    private double kontofuehrung;
    private double kontostand;
    private String kontoart;

    private static ArrayList<Konto> kontos = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    // Konstruktor
    public Konto(String kontoinhaber, int bankleitzahl, String kontonummer, double ueberziehungsrahmen, double kontofuehrung, double kontostand, String kontoart) {
        this.kontoinhaber = kontoinhaber;
        this.bankleitzahl = bankleitzahl;
        this.kontonummer = kontonummer;
        this.ueberziehungsrahmen = ueberziehungsrahmen;
        this.kontofuehrung = kontofuehrung;
        this.kontostand = kontostand;
        this.kontoart = kontoart;
    }

    // den hier werden wir einige Male brauchen
    public void anzeigen(){
        int zahl = 1;
        for (int i = 0; i < kontos.size(); i++){
            Konto k = kontos.get(i);
            System.out.printf("%d | Kontoinhaber: %-20s | Kontonummer: %-10s | Kontostand: %-10.2f | Kontoart: %-20s\n", zahl, k.getKontoinhaber(), k.getKontonummer(), k.getKontostand(), k.getKontoart());
            zahl++;
        }
    }

    public abstract void kontoAnlegen();
    public abstract void kontoLoeschen();
    public abstract void einzahlen();
    public abstract void auszahlen();

    public void kontoAuszug(){
        System.out.println("Von welchem Konto hätten Sie gerne einen Kontoauszug?");
        anzeigen();
        int auszug = scan.nextInt();
        scan.nextLine();
        Konto k = kontos.get(auszug-1);
        int a = 12;
        System.out.println("Kontoauszug");
        for(int j = 0; j < a; j++) {
            System.out.println(" * *");
        }
        System.out.println("Kontoinhaber: "+k.getKontoinhaber());
        System.out.println("Kontonummer: "+k.getKontonummer());
        for(int j = 0; j < a; j++) {
            System.out.println(" * *");
        }
        System.out.println("Kontostand: "+k.getKontostand());
        for(int j = 0; j < a; j++) {
            System.out.println(" * *");
        }

    }

    // Getter und Setter
    public String getKontoinhaber() {
        return kontoinhaber;
    }

    public void setKontoinhaber(String kontoinhaber) {
        this.kontoinhaber = kontoinhaber;
    }

    public int getBankleitzahl() {
        return bankleitzahl;
    }

    public void setBankleitzahl(int bankleitzahl) {
        this.bankleitzahl = bankleitzahl;
    }

    public String getKontonummer() {
        return kontonummer;
    }

    public void setKontonummer(String kontonummer) {
        this.kontonummer = kontonummer;
    }

    public double getUeberziehungsrahmen() {
        return ueberziehungsrahmen;
    }

    public void setUeberziehungsrahmen(double ueberziehungsrahmen) {
        this.ueberziehungsrahmen = ueberziehungsrahmen;
    }

    public double getKontofuehrung() {
        return kontofuehrung;
    }

    public void setKontofuehrung(double kontofuehrung) {
        this.kontofuehrung = kontofuehrung;
    }

    public double getKontostand() {
        return kontostand;
    }

    public void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }

    public String getKontoart() {
        return kontoart;
    }

    public void setKontoart(String kontoart) {
        this.kontoart = kontoart;
    }

    public static ArrayList<Konto> getKontos() {
        return kontos;
    }

    public static void setKontos(ArrayList<Konto> kontos) {
        Konto.kontos = kontos;
    }
}
