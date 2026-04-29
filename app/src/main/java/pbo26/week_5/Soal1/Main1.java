package Soal1;


public class Main1 {
    public static void main(String[] args) {

        KaryawanTetap KarTep = new KaryawanTetap("Pham Hanni", "KARTEP1", 3000000, 50000);

        for (int i = 0; i < 5; i++) {
            KarTep.absen();
        }

        System.out.println("Nama: " + KarTep.getNama());
        System.out.println("ID: " + KarTep.getIdKaryawan());
        System.out.println("Gaji Karyawan Tetap + Bonus: " + KarTep.hitungGaji(1000000));



        KaryawanKontrak KarKontrak = new KaryawanKontrak("Kim Minji", "KARKONTRAK1", 100000);
        for (int i = 0; i < 26; i++) {
            KarKontrak.absen();
        }

        System.out.println("\nNama: " + KarKontrak.getNama());
        System.out.println("ID: " + KarKontrak.getIdKaryawan());
        System.out.println("Gaji Karyawan Kontrak: " + KarKontrak.hitungGaji());
    }
}