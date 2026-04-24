package Soal2;

public class Hp extends Produk {
    private double ukLayar;
    private int penyimpanan;

    public Hp(String brand, int NomorSeri, double price, double ukLayar, int penyimpanan) {
        super(brand, NomorSeri, price);
        this.ukLayar = ukLayar;
        this.penyimpanan = penyimpanan;
    }

    public void Info() {
        super.Info();
        System.out.println("Ukuran Layar: " + ukLayar + " inci");
        System.out.println("Storage     : " + penyimpanan + " GB");
    }
}