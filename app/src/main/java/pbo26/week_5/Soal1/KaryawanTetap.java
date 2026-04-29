package Soal1;


class KaryawanTetap extends Karyawan {
    double gajiPokok;
    double tunjanganMakan;

    public KaryawanTetap(String nama, String idKaryawan, double gajiPokok, double tunjanganMakan) {
        super(nama, idKaryawan);
        this.gajiPokok = gajiPokok;
        this.tunjanganMakan = tunjanganMakan;
    }

    @Override
    public double hitungGaji() {
        return gajiPokok + (tunjanganMakan * getJumlahKehadiran());
    }

    // ini itu overload, karena parameternya beda sama method hitungGaji yg di atas
    public double hitungGaji(double bonusKinerja) {
        return hitungGaji() + bonusKinerja;
    }
}

