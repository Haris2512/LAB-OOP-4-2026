import java.util.Scanner;
public class TgsNo2 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.print("Masukkan Tanggal Lahir (dd-mm-yy): ");

        String[] date = x.nextLine().split("-");
        int tanggal = Integer.parseInt(date[0]);

        if (tanggal < 1 || tanggal > 31) {
            System.out.println("Tanggal tidak valid");
        }

        int bulan = Integer.parseInt(date[1]);
        if (bulan < 1 || bulan > 12) {
            System.out.println("Bulan tidak valid");
        }
        String mount = "";
        switch (bulan) {
            case 1:
                mount = "Januari";
                break;
            case 2:
                mount = "Februari";
                break;
            case 3:
                mount = "Maret";
                break;
            case 4:
                mount = "April";
                break;
            case 5:
                mount = "Mei";
                break;
            case 6:
                mount = "Juni";
                break;
            case 7:
                mount = "July";
                break;
            case 8:
                mount = "Agustus";
                break;
            case 9:
                mount = "September";
                break;
            case 10:
                mount = "Oktober";
                break;
            case 11:
                mount = "November";
                break;
            case 12:
                mount = "Desember";
                break;

        }

        int tahun = Integer.parseInt(date[2]);
        if (tahun > 26) {
            tahun += 1900;
        } else if (tahun <= 0) {
            System.out.println("Tahun tidak valid");
        } else {
            tahun += 2000;
        }
        System.out.println(tanggal + " " + mount + " " + tahun);
    }
}
