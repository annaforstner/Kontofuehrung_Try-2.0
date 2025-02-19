import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Konto g = new Konto("Anna Forstner", 1234, 13099, 200.00, 3.34, 6.27, "Giro");
        Giro g1 = new Giro("Mark Pock", 7896, 80188, 20000.00, 1.89, 13500.00, "Giro");
        Giro g2 = new Giro("Hermine Karner", 3224, 23456, 500.00,2.45, 5604.78, "Giro" );

        Kredit k = new Kredit("Marnie Blaise", 1247, 35578, 0.00, 3.05, -4500.78, "Kredit");
        Kredit k1 = new Kredit("Bernd Vihnanek", 3469, 43578, 0.00,2.85, -5890.99, "Kredit" );
        Kredit k2 = new Kredit("Shirley McAfton", 9517, 57327, 0.00,0.89,-100000, "Kredit");

        Spar s = new Spar("Gerhard Saul", 2478, 56780, 0.00,0.158,524.32, "Sparen");
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


       Main m = new Main();
       m.menu();


    }



    public void menu(){
        Giro giro = new Giro();
        Spar sparen = new Spar();
        Kredit kredit = new Kredit();
        Konto k = new Konto();
        System.out.println("Bankverwaltungssoftware Malibu- Bank\nWas können wir für Sie tun?");
        while(true) {
            System.out.println();
            System.out.println("1. Konto erstellen\n2. Konto Löschen\n3. Kontoauszug\n4. Einzahlen\n5. Auszahlen\n6. Überweisung tätigen\n7. alle Konten anzeigen\n0. Programm beenden");
            Scanner scan = new Scanner(System.in);
            int option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 0:
                    System.out.println("Wir verabschieden uns von Ihnen.");
                    System.exit(0);
                case 1 :
                    System.out.println("Welche Art von Konto soll erstellt werden?\n" +
                            "1. Girokonto: kann einen positiven oder negativen Kontostand haben\n" +
                            "2. Sparkonto: kann nur im Plus sein\n" +
                            "3. Kreditkonto: nach dem zurückzahlen des Kredits wird es von selbst geschlossen");
                    int x = scan.nextInt();
                    scan.nextLine();
                    if(x == 1){
                        giro.kontoAnlegen();
                    }else if(x == 2){
                        sparen.kontoAnlegen();
                    }else if(x == 3){
                        kredit.kontoAnlegen();
                    }else{
                        System.out.println("Etwas ist schiefgelaufen, das Konto konnte nicht erstellt werden.");
                    }
                    break;
                case 2 :
                    System.out.println("Welches Konto soll gelöscht werden?");
                    k.anzeigen();
                    int index1 = scan.nextInt();
                    scan.nextLine();
                    Konto ks = Konto.kontos.get(index1 -1);
                    String art1 = ks.getKontoart();
                    if(art1 == "Giro"){
                        giro.kontoLoeschen(index1);
                    }else if(art1 == "Sparen"){
                        sparen.kontoLoeschen(index1);
                    } else if(art1 == "Kredit"){
                        kredit.kontoLoeschen(index1);
                    }else{
                        System.out.println("Das Löschen des Kontos hat nicht funktioniert.");
                    }
                    break;
                case 3:
                    k.kontoAuszug();
                    break;
                case 4:
                    k.einzahlen();
                    break;
                case 5:
                    k.beheben();
                    break;
                case 6:
                    System.out.println("Von welchem Konto aus wollen Sie die Überweisung tätigen?");
                    k.anzeigen();
                    int index = scan.nextInt();
                    scan.nextLine();
                    Konto ki = Konto.kontos.get(index -1);
                    String art = ki.getKontoart();
                    if(art == "Giro"){
                        giro.ueberweisen(index);
                    }else if(art == "Sparen"){
                        sparen.ueberweisen(index);
                    } else if(art == "Kredit"){
                        kredit.ueberweisen(index);
                    }else{
                        System.out.println("Das funktioniert so nicht.");
                    }
                    break;
                case 7 :
                    k.anzeigen();
                    break;
                default:
                    System.out.println("Irgendetwas ist schiefgelaufen. Bitte überprüfen Sie die eingabe oder starten Sie das Programm erneut.");
                    break;
            }
        }
    }
}
