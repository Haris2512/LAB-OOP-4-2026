package Soal2;

public class Produk {
    protected String brand;
    protected int nomorSeri;
    protected double harga;

    public Produk(String brand, int nomorSeri, double harga) {
        this.brand = brand;
        this.nomorSeri = nomorSeri;
        this.harga = harga;
    }

    public int getNomorSeri() {
        return nomorSeri;
    }

    public void Info() {
        System.out.println("Merek       : " + brand);
        System.out.println("Nomor Seri  : " + nomorSeri);
        System.out.println("Harga       : " + harga);
    }
}