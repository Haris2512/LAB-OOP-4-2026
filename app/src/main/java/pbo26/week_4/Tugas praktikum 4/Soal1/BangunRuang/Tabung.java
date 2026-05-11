package Soal1.BangunRuang;
import Soal1.BangunDatar.Lingkaran;

public class Tabung extends Lingkaran {
    private double tinggi;

    public Tabung(double r, double tinggi) {
        super(r);
        this.tinggi = tinggi;
    }

    public double luasPermukaan() {
        return 2 * Math.PI * r * (r + tinggi);
    }

    public double volume() {
        return Math.PI * r * r * tinggi;
    }
}