abstract class Karyawan {
    private String nama;
    private String idkaryawan;
    private int jumlahkehadiran;

    public Karyawan(String nama, String idkaryawan) {
        this.nama = nama;
        this.idkaryawan = idkaryawan;
        this.jumlahkehadiran = 0;
    }   
    
    void absenkonkrit(){
        jumlahkehadiran++;
        
    }

    public abstract double hitunggaji();  
}
