package Tuprak2;
public class Main {
    public static void main(String[] args) {
        Bola bola1 = new Bola("Nike", 7.0);
        Bola bola2 = new Bola("Molten", 6.5);

        PemainBasket p1 = new PemainBasket("Hanni Pham", 0, -5, bola1);
        PemainBasket p2 = new PemainBasket("Kim Minji", 0, 100, bola2);

        p1.checkStatus();
        pembatas();

        p2.checkStatus();
        pembatas();

        p1.shoot();
        p2.shoot();
        pembatas();

        p1.lawan(p2);
        p2.checkStatus();
        pembatas();
        p1.checkStatus();
        pembatas();

        p1.istirahat();
        p1.checkStatus();
        p2.istirahat();
        p2.checkStatus();
    }

    public static void pembatas() {
        System.out.println("=====================================");
    }
}