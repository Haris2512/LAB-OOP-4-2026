import java.util.Scanner;

public class Tuprak1Soal2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan tanggal (dd-mm-yy): ");
        String data = input.nextLine();

        String tanggal = data.substring(0, 2);
        String bulan = data.substring(3, 5);
        String tahun = data.substring(6, 8);

        // hilangkan nol depan
        if (tanggal.charAt(0) == '0') {
            tanggal = tanggal.substring(1);
        }

        // konversi bulan
        String month = "";
        switch (bulan) {
            case "01": month = "Januari"; break;
            case "02": month = "Februari"; break;
            case "03": month = "Maret"; break;
            case "04": month = "April"; break;
            case "05": month = "Mei"; break;
            case "06": month = "Juni"; break;
            case "07": month = "Juli"; break;
            case "08": month = "Agustus"; break;
            case "09": month = "September"; break;
            case "10": month = "Oktober"; break;
            case "11": month = "November"; break;
            case "12": month = "Desember"; break;
        }

        // harus ubah tahunnya
        String year;
        if (tahun.charAt(0) <= '2' && tahun.charAt(1) <= '6'){
            year = "20" + tahun;
        } else {
            year = "19" + tahun;
        }

        System.out.println("Output: " + tanggal + " " + month + " " + year);
    }
}
