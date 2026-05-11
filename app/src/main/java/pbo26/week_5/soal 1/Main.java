import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.println("================================================");
        System.out.println("Data karyawan tetap");
        System.out.print("Nama : "); String namakt = x.nextLine();
        System.out.print("Id karyawan : "); String idkt = x.nextLine(); 
        System.out.print("Jumlah Kehadiran : "); int hkt = x.nextInt();
        System.out.print("Gaji pokok : "); int gjkt = x.nextInt();
        System.out.print("Tunjangan makan : "); int tmkt = x.nextInt();
        System.out.println("================================================");
        
        Karyawantetap kt = new Karyawantetap(namakt, idkt, gjkt, tmkt);
       

        for (int i = 0; i < hkt; i++){
            kt.absenkonkrit();
        }

        System.out.println("Gaji Karyawan Tetap : " + kt.hitunggaji(1000000));
        x.nextLine();

        System.out.println("===============================================");
        System.out.println("Data karyawan kontrak");
        System.out.print("Nama : "); String namakk = x.nextLine();
        System.out.print("Id karyawan : "); String idkk = x.nextLine(); 
        System.out.print("Jumlah Kehadiran : "); int hkk = x.nextInt();
        System.out.print("Upah perhari : "); int upkk = x.nextInt();
        System.out.println("================================================");

        Karyawankontrak kk = new Karyawankontrak(namakk, idkk, upkk);
        
        for (int i = 0; i < hkk; i++){
            kk.absenkonkrit();
        }

        System.out.println("Gaji Karyawan Kontrak : " + kk.hitunggaji()); 

    }
}