package Soal1.BangunRuang;
import Soal1.BangunDatar.PersegiPanjang;

public class Balok extends PersegiPanjang {
    private double tinggi;

    public Balok(double panjang, double lebar, double tinggi) {
        super(panjang, lebar);
        this.tinggi = tinggi;
    }

    public double luasPermukaan() {
        return 2 * ((panjang * lebar) + (panjang * tinggi) + (lebar * tinggi));
    }

    public double volume() {
        return panjang * lebar * tinggi;
    }
}