package Soal1;

class KaryawanKontrak extends Karyawan {
    double upahPerHari;

    public KaryawanKontrak(String nama, String idKaryawan, double gajiPerHari) {
        super(nama, idKaryawan);
        this.upahPerHari = gajiPerHari;
    }

    @Override
    public double hitungGaji() {
        double total = upahPerHari * getJumlahKehadiran();

        if (getJumlahKehadiran() > 20) {
            total += 500000;
        }
        return total;
    }
}