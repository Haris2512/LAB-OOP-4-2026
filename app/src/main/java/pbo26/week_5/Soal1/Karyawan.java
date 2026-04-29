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

    // GETTER
    public int getJumlahKehadiran() {
        return jumlahKehadiran;
    }

    public abstract double hitungGaji();
}