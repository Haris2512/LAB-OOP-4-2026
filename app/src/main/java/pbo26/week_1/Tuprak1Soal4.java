import java.util.Scanner;

public class Tuprak1Soal4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Input: ");
        int angka = input.nextInt();

        int hasil = faktorial(angka);

        // cek negatif/positif
        if (hasil >= 0) {
            System.out.println("Output: " + hasil);
        } else {
            System.out.println("Tidak Terdefinisi");
        }
    }

    public static int faktorial(int angka) {

        // kalau negatif
        if (angka < 0) { // kalau mines
            return angka; // kembalikan ke main method
        } else if (angka == 0 || angka == 1) { // kalau 0 atau 1
            return 1;
        } else { // kalau di atas 1
            return angka * faktorial(angka - 1);
        }
    }
}