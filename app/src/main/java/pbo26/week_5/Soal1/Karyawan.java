package Soal1;


abstract class Karyawan {
    private String nama;
    private String idKaryawan;
    private int jumlahKehadiran = 0;

    public Karyawan(String nama, String idKaryawan) {
        this.nama = nama;
        this.idKaryawan = idKaryawan;
    }

    public void absen() {
        jumlahKehadiran++;
    }

    abstract double hitungGaji();

    public int getJumlahKehadiran() {
        return jumlahKehadiran;
    }

    public String getNama() {
        return nama;
    }

    public String getIdKaryawan() {
        return idKaryawan;
    }

}