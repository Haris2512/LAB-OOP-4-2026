package Tuprak2;
import java.util.Random;

public class PemainBasket {
    String nama;
    int poin;
    int stamina;
    Bola bola; // atribut objek

    // Constructor default
    public PemainBasket() {
        this.nama = "Anonim";
        this.poin = 0;
        this.stamina = 100;
        this.bola = new Bola();
    }

    // Constructor dengan parameter
    public PemainBasket(String nama, int poin, int stamina, Bola bola) {
        this.nama = nama;
        this.poin = poin;
        this.stamina = stamina;
        this.bola = bola;
    }

    // Method shoot() → menggunakan atribut objek bola
    public void shoot() {
        if (stamina > 0) {
            poin += 2;
            stamina -= 5;
            System.out.printf("%s menembak bola %s! Poin sekarang: %d\n", nama, bola.getInfo(), poin);
        } else {
            System.out.println(nama + " terlalu lelah untuk menembak.");
        }
    }

    // Method lawan() → interaksi antar objek
    public void lawan(PemainBasket musuh) {
        if (stamina > 0) {
            Random rand = new Random();
            int serangan = rand.nextInt(10) + 5; // damage acak 5-14
            musuh.stamina -= serangan;
            System.out.printf("%s menantang %s, stamina %s berkurang %d\n", nama, musuh.nama, musuh.nama, serangan);
        } else {
            System.out.println(nama + " terlalu lelah untuk menyerang.");
        }
    }

    // Method istirahat → menambah stamina
    public void istirahat() {
        stamina += 10;
        System.out.printf("%s beristirahat, stamina sekarang: %d\n", nama, stamina);
    }

    // Method checkStatus → info pemain
    public void checkStatus() {
        System.out.printf("========== Status %s ==========\n", nama);
        System.out.println("Nama\t: " + nama);
        System.out.println("Poin\t: " + poin);
        System.out.println("Stamina\t: " + stamina);
        System.out.println("Bola\t: " + bola.getInfo());
    }
}