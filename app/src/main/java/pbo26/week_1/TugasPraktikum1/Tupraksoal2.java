import java.util.Scanner;

public class Tupraksoal2 {
    
    public static void main(String[] args) {
        Scanner inputan = new Scanner(System.in);
        System.out.println("=================================");
        System.out.println("| MERUBAH BENTUK TANGGAL LAHIR  |");
        System.out.println("=================================");
        System.out.print  ("  Masukkan Tanggal Lahir (dd-mm-yy) : ");
        String[] date = inputan.nextLine().split("-");
            int tanggal = Integer.parseInt(date[0]);
            int bulan = Integer.parseInt(date[1]);
            int tahun = Integer.parseInt(date[2]);

            String month = "";
            int n = 31;
            switch (bulan) {
                case 1: month = "Januari"; break;
                case 2:
                    month = "Februari";
                    n = 28;
                    if (tahun % 4 == 0 && tahun % 100 != 0) {
                        n = 29;
                    }
                    break;
                case 3: month = "Maret"; break;
                case 4: month = "April"; n = 30; break;
                case 5: month = "Mei"; break;
                case 6: month = "Juni"; n = 30; break;
                case 7: month = "Juli"; break;
                case 8: month = "Agustus"; break;
                case 9: month = "September"; n = 30; break;
                case 10: month = "Oktober"; break;
                case 11: month = "November"; n = 30; break;
                case 12: month = "Desember"; break;
            }
            boolean valid = true;
            if (bulan <= 0 || bulan > 12){
                valid = false;
                System.out.println("bulan tidak valid");
            }
            if (tanggal <= 0 || tanggal > n) {
                valid = false;
                System.out.println("tanggal tidak valid.");
            }
            if (tahun >= 0 && tahun <= 26) {
                tahun += 2000;
            } else if (tahun >= 27 && tahun <= 99) {
                tahun += 1900;
            } else {
                valid = false;
                System.out.println("tahun tidak valid.");
            }
            if (valid){
                System.out.println(tanggal + " " + month + " " + tahun);
            }
    }
}
