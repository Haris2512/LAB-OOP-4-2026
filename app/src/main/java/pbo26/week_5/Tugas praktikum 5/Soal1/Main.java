package Soal1;

abstract class Karyawan {
    protected String nama;
    protected String idKaryawan;
    protected int jumlahKehadiran;

    public Karyawan(String nama, String idKaryawan) {
        this.nama = nama;
        this.idKaryawan = idKaryawan;
        this.jumlahKehadiran = 0;
    }

    public void absen() {
        this.jumlahKehadiran++;
    }

    public abstract double hitungGaji();
}

class KaryawanTetap extends Karyawan {
    private double gajiPokok;
    private double tunjanganMakan;

    public KaryawanTetap(String nama, String idKaryawan, double gajiPokok, double tunjanganMakan) {
        super(nama, idKaryawan);
        this.gajiPokok = gajiPokok;
        this.tunjanganMakan = tunjanganMakan;
    }

    @Override
    public double hitungGaji() {
        return gajiPokok + (tunjanganMakan * jumlahKehadiran);
    }

    public double hitungGaji(double bonus) {
        return hitungGaji() + bonus;
    }
}

class KaryawanKontrak extends Karyawan {
    private double upahPerHari;

    public KaryawanKontrak(String nama, String idKaryawan, double upahPerHari) {
        super(nama, idKaryawan);
        this.upahPerHari = upahPerHari;
    }

    @Override
    public double hitungGaji() {
        double total = upahPerHari * jumlahKehadiran;
        if (jumlahKehadiran > 20) {
            total += 500000;
        }
        return total;
    }
}

public class Main {
    public static void main(String[] args) {
        KaryawanTetap kt = new KaryawanTetap("Aren", "A123", 5000000, 50000);
        for (int i = 0; i < 11; i++) kt.absen();
        System.out.println("Gaji Karyawan Tetap: Rp" + kt.hitungGaji(1000000));

        KaryawanKontrak kk = new KaryawanKontrak("Nabila", "B321", 100000);
        for (int i = 0; i < 25; i++) kk.absen();
        System.out.println("Gaji Karyawan Kontrak: Rp" + kk.hitungGaji());
    }
}