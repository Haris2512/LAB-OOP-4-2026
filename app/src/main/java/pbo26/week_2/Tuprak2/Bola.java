package Tuprak2;
public class Bola {
    String merk;
    double ukuran; // ukuran bola

    // Constructor default
    public Bola() {
        this.merk = "Standar";
        this.ukuran = 7.0;
    }

    // Constructor parameter
    public Bola(String merk, double ukuran) {
        this.merk = merk;
        this.ukuran = ukuran;
    }

    public String getInfo() {
        return merk + " ukuran " + ukuran;
    }
}
