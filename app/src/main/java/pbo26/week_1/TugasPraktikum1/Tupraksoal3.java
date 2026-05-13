import java.util.Scanner;

public class Tupraksoal3 {
    
    public static void main(String[] args) {
        Scanner inputan = new Scanner(System.in);
        System.out.println("============================");
        System.out.println("║  VERIFIKASI KATA SANDI   |");
        System.out.println("============================");
        System.out.print  ("   Masukkan Sandi Anda : ");
        String password = inputan.nextLine();
        boolean len = false;
        boolean upper = false;
        boolean lower = false;
        boolean digit = false;

        for (int i = 0 ; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                upper = true;
            } else if (Character.isLowerCase(c)) {
                lower = true;
            } else if (Character.isDigit(c)) {
                digit = true;
            }
        }
        if (password.length() >= 8) {
            len = true;
        }

        if (len && upper && lower && digit){
            System.out.println("Password Valid!");
        } else {
            System.out.println("Password Tidak Valid!");
        }
    }
}