public class Main {
    public static void main(String[] args) {

KaryawanTetap kt = new KaryawanTetap("Nadhifa", "KT01", 5000000, 20000);
        for (int i = 0; i < 22; i++) {
            kt.absen();
        }
        System.out.println("Gaji Karyawan Tetap + Bonus: " + kt.hitungGaji(1000000));

KaryawanKontrak kk = new KaryawanKontrak("Ali", "KK01", 150000);        
        for (int i = 0; i < 25; i++) {
            kk.absen();
        }
        System.out.println("Gaji Karyawan Kontrak: " + kk.hitungGaji());
    }
}