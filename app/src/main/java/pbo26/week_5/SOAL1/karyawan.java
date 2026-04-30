package SOAL1;

abstract class Karyawan {
    private String Nama;
    private String IdKaryawan;
    private int JumlahKehadiran;
    
    public Karyawan(String Nama, String IdKaryawan) {
        this.Nama = Nama;
        this.IdKaryawan = IdKaryawan;
        this.JumlahKehadiran = 0;
    }

    public void absen() {
        JumlahKehadiran++;
    }

    public int JumlahKehadiran() {
        return JumlahKehadiran;
    }

    public String getNama(){
        return Nama;
    }

    public abstract double hitungGaji();


    
}

class KaryawanTetap extends Karyawan {
    private double GajiPokok;
    private double TunjanganMakan;

    public KaryawanTetap(String Nama, String IdKaryawan, double GajiPokok, double TunjanganMakan){
        super(Nama, IdKaryawan);
        this.GajiPokok = GajiPokok;
        this.TunjanganMakan = TunjanganMakan;
    }

    @Override
    public double hitungGaji(){
        return GajiPokok + (TunjanganMakan * JumlahKehadiran());
        

    }
    public double hitungGaji( double BonusKinerja){
        return hitungGaji() + BonusKinerja;

    }


}

class KaryawanKontrak extends Karyawan{
    private double UpahPerhari;

    public KaryawanKontrak(String Nama, String IdKaryawan, double UpahPerhari){
        super(Nama, IdKaryawan);
        this.UpahPerhari = UpahPerhari;
    }

    @Override
    public double hitungGaji(){
        double total = UpahPerhari * JumlahKehadiran();

        if (JumlahKehadiran() > 20) {
            total += 500000;
        }
        return total;

    }
}