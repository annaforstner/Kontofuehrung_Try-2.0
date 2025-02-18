public class Main {
    public static void main(String[] args) {
        Giro g = new Giro("Anna Forstner", 1234, 67875, 200.00, 3.34, 45.67, "Giro");
        Giro g1 = new Giro("Mark Pock", 7896, 87546, 2000.00, 1.89, 13500.00, "Giro");
        Giro g2 = new Giro("Hermine Karner", 3224, 23456, 500.00,2.45, 5604.78, "Giro" );

        Konto.kontos.add(g);
        Konto.kontos.add(g1);
        Konto.kontos.add(g2);

        g.kontoAnlegen();
        g.kontoLoeschen();


    }
}
