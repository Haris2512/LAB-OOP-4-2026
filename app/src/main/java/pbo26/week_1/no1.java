import java.util.Scanner;

public class no1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan kalimat: ");
        String kalimat = input.nextLine();

        String[] kata = kalimat.split(" ");

        for (int i = 0; i < kata.length; i++) {
            String k = kata[i];
            System.out.print(Character.toUpperCase(k.charAt(0)) + k.substring(1) + " ");
        }
    }
}