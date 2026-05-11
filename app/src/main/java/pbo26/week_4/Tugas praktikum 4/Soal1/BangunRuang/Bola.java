package Soal1.BangunRuang;
import Soal1.BangunDatar.Lingkaran;

public class Bola extends Lingkaran {
    public Bola(double r) {
        super(r);
    }

    public double luasPermukaan() {
        return 4 * luas();
    }

    public double volume() {
        return (4.0 / 3.0) * Math.PI * r * r * r;
    }
}