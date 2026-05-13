import java.util.Scanner;

public class no2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan tanggal: ");
        String t = input.nextLine();

        String[] p = t.split("-");

        int hari = Integer.parseInt(p[0]);
        int bulan = Integer.parseInt(p[1]);
        int tahun = Integer.parseInt(p[2]);

        String[] nama = {"Januari","Februari","Maret","April","Mei","Juni",
                         "Juli","Agustus","September","Oktober","November","Desember"};

        if (tahun < 27) {
            tahun = 2000 + tahun;
        } else {
            tahun = 1900 + tahun;
        }

        System.out.println(hari + " " + nama[bulan-1] + " " + tahun);
    }
}