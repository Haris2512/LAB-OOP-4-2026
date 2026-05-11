import java.util.Scanner;

public class Tuprak1Soal3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan password: ");
        String password = input.nextLine();

        if (password.length() >= 8) {

            boolean kapital = false;
            boolean kecil = false;
            boolean angka = false;

            for (int i = 0; i < password.length(); i++) {
                char huruf = password.charAt(i);

                if (huruf >= 'A' && huruf <= 'Z') {
                    kapital = true;
                } else if (huruf >= 'a' && huruf <= 'z') {
                    kecil = true;
                } else if (huruf >= '0' && huruf <= '9') {
                    angka = true;
                }
            }

            if (kapital && kecil && angka) {
                System.out.println("Password valid");
            } else {
                System.out.println("Password tidak valid");
            }

        } else {
            System.out.println("Password tidak valid");
        }
        
    }
}