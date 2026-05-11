package Soal1.BangunRuang;
import Soal1.BangunDatar.Persegi;

public class Kubus extends Persegi {
    public Kubus(double sisi) {
        super(sisi);
    }

    public double luasPermukaan() {
        return 6 * luas();
    }

    public double volume() {
        return sisi * sisi * sisi;
    }
}