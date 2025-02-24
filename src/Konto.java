import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Konto { // Anforderungen an das Konto
    private String kontoinhaber;
    private int bankleitzahl;
    private int kontonummer;
    private double ueberziehungsrahmen;
    private double kontofuehrung;
    private double kontostand;
    private String kontoart;

    static ArrayList<Konto> kontos = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    // Konstruktor
    public Konto(String kontoinhaber, int bankleitzahl, int kontonummer, double ueberziehungsrahmen, double kontofuehrung, double kontostand, String kontoart) {
        this.kontoinhaber = kontoinhaber;
        this.bankleitzahl = bankleitzahl;
        this.kontonummer = kontonummer;
        this.ueberziehungsrahmen = ueberziehungsrahmen;
        this.kontofuehrung = kontofuehrung;
        this.kontostand = kontostand;
        this.kontoart = kontoart;
    }

    public Konto() {
    }

    // den hier werden wir einige Male brauchen
    public void anzeigen(){ // damit wir uns den Code bei jeder Anwendung sparen können
        System.out.println();
        if (kontos.isEmpty()){
            System.out.println("Keine Konten vorhanden.");
            return;
        }
        int zahl = 1;
        for (int i = 0; i < kontos.size(); i++){
            Konto k = kontos.get(i);
            System.out.printf("%2d | Kontoinhaber: %-20s | Kontonummer: %-8s | %-10s: € %12.2f | Kontoart: %s\n", zahl, k.getKontoinhaber(), k.getKontonummer(),"Kontostand",  k.getKontostand(), k.getKontoart());
            zahl++;
        }
    }

    public void einzahlen() {
        try {
            anzeigen(); // see?
            // wir suchen uns ein Konto aus
            System.out.println("Auf welches Konto soll etwas eingezahlt werden?");
            int zahl = scan.nextInt();
            if (zahl < 1 || zahl > kontos.size()) {
                throw new IllegalArgumentException("Ungültige Kontonummer.");
            }
            Konto k = kontos.get(zahl - 1);
            System.out.printf("Folgendes Konto wurde ausgewählt: %-20s | %-6.2f€ |  Kontonummer: %-6s | %-10s\n", k.getKontoinhaber(), k.getKontostand(), k.getKontonummer(), k.getKontoart());
            // wie viel Geld soll eingezahlt werden
            System.out.println("Wie viel Geld soll darauf eingezahlt werden?");
            double hinein = scan.nextDouble();
            if (hinein <= 0) {
                throw new IllegalArgumentException("Der Betrag muss positiv sein.");
            }
            double geld = k.getKontostand();
            double neuerKontostand = hinein + geld;
            // wenn das Kreditkonto auf über 0,00€ ausgezahlt wurde, dann schließen wir es
            String art = getKontoart();
            if (art == "Kredit" && neuerKontostand > 0) {
                System.out.println("Der Kredit wurde abbezahlt. Danke für die Spende.");
                k.setKontostand(neuerKontostand);
                kontos.remove(zahl - 1);
            }
            k.setKontostand(neuerKontostand);
            System.out.printf("Der neue Kontostand beträgt %.2f€.\n", k.getKontostand());
        } catch (InputMismatchException e) {
        System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
        scan.nextLine(); // Scanner-Fehler beheben
    } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
    }

    public void beheben(){ // wie viel Geld soll behoben werden
        try{
            System.out.println("Von welchem Konto soll behoben werden?");
            anzeigen();
            System.out.println("Wählen Sie eine Zahl: ");
            int ausz = scan.nextInt();
            if (ausz < 1 || ausz > kontos.size()) {
                throw new IllegalArgumentException("Ungültige Kontonummer.");
            }
            Konto k = kontos.get(ausz-1);
            System.out.printf("Folgendes Konto wurde ausgewählt: %-20s | %-6.2f€ |  Kontonummer: %-6s | %-10s\n",k.getKontoinhaber(), k.getKontostand(), k.getKontonummer(), k.getKontoart());
            System.out.println("Wie viel soll ausgezahlt werden?");
            double raus = scan.nextDouble();
            if (raus <= 0) {
                throw new IllegalArgumentException("Der Betrag muss positiv sein.");
            }
            double geld = k.getKontostand();
            double neuerKontostand = geld - raus;
        // Ausnahmefälle beim Abheben
            String art = getKontoart();
            if(art == "Giro"){
                if( neuerKontostand < -k.getUeberziehungsrahmen()){
                    System.out.println("Ihr momentaner Überziehungsrahmen ist "+ k.getUeberziehungsrahmen()+"€. Da die Abbuchung aber über diesem Limit liegt, kann die Transaktion nicht durchgeführt werden.");
                    System.out.printf("Ihr momentaner Kontostand beträgt %.2f€.\n", k.getKontostand());
                } else if(neuerKontostand <= 0){
                    System.out.println("Sie haben zu viel Geld abgehoben, sind aber noch im Überziehungsrahmen. Bitte beachten Sie, dass diese Geld mit einem Tageszinssatz belegt wird.");
                    k.setKontostand(neuerKontostand);
                    System.out.printf("Ihr momentaner Kontostand beträgt %.2f€.\n", k.getKontostand());
                } else{
                    System.out.println("Transaktion erfolgreich.");
                    k.setKontostand(neuerKontostand);
                    System.out.printf("Ihr momentaner Kontostand beträgt %.2f€.\n", k.getKontostand());
                }
            }else if(art == "Sparen"){
                if(neuerKontostand < 0){
                     System.out.println("Sie können Ihr Sparkonto nicht überziehen.");
                } else{
                    System.out.println("Transaktion erfolgreich.");
                    k.setKontostand(neuerKontostand);
                    System.out.printf("Ihr momentaner Kontostand beträgt %.2f€.\n", k.getKontostand());
                }
            }else { // logikfehler: wenn er abhebt, wird hier die Schuld mehr nicht weniger
                k.setKontostand(neuerKontostand);
                System.out.printf("Ihr momentaner Kontostand beträgt %.2f€.\n", k.getKontostand());
            }
        } catch (InputMismatchException e) {
            System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
            scan.nextLine(); // Scanner-Fehler beheben
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public void kontoAuszug(){ // zeigt Informationen zum Konto an
        try {
            System.out.println("Von welchem Konto hätten Sie gerne einen Kontoauszug?");
            anzeigen();
            int auszug = scan.nextInt();
            if (auszug < 1 || auszug > kontos.size()) {
                throw new IllegalArgumentException("Ungültige Kontonummer.");
            }
            Konto k = kontos.get(auszug - 1);

            System.out.println("Kontoauszug");
            System.out.println("----------------------------------------");
            System.out.println("Kontoinhaber: " + k.getKontoinhaber());
            System.out.println("Kontonummer: " + k.getKontonummer());
            System.out.println("----------------------------------------");
            System.out.printf("Kontostand: %.2f€\n", k.getKontostand());
            System.out.println("========================================");
        }catch (InputMismatchException e) {
            System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
            scan.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // Getter und Setter (interessanter wirds nimmer)
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

    public int getKontonummer() {
        return kontonummer;
    }

    public void setKontonummer(int kontonummer) {
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

    public static ArrayList<Konto> getKontos(){
        return kontos;
    }

    public static void setKontos(ArrayList<Konto> kontos) {
        Konto.kontos = kontos;
    }
}
