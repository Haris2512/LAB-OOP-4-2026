package SOAL1;

public class Main {
    public static void main(String[] args) {
        KaryawanTetap kt = new KaryawanTetap ("Aidil", "H071", 5000000, 50000);

        for (int i = 0; i < 22; i++){
            kt.absen();
        }

        System.out.println("Gaji karyawan tetap + bonus: " + kt.hitungGaji(1000000));

        KaryawanKontrak kk = new KaryawanKontrak("Kazull", "H088", 150000);

        for (int i = 0; i < 25; i ++){
            kk.absen();
        }
        System.out.println("Gaji karyawan kontrak: " + kk.hitungGaji());


    }
    
}
