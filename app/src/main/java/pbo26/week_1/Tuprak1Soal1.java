import java.util.Scanner;

public class Tuprak1Soal1 {
    public static void main (String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan judul film:\n > ");
        String judul = input.nextLine();

        String[] arrString = judul.split(" ");
        String kapital = "";

        for (int i = 0; i < arrString.length; i++){
            String kata = arrString[i];
            kata = kata.substring(0, 1).toUpperCase() + kata.substring(1).toLowerCase();
            
            kapital += kata;

            if (i < arrString.length - 1) {
                kapital += " ";
            }
        }

        System.out.println(kapital);

        input.close();
    }
}