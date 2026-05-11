import java.util.Scanner;

public class Tupraksoal4 {
    
    public static void main(String[] args) {
        System.out.println("========================");
        System.out.println("| MENGHITUNG FAKTORIAL |");
        System.out.println("========================");
        System.out.print  ("  Masukkan Bilangan : ");
        Scanner inputan = new Scanner(System.in);
        int bilangan = inputan.nextInt();
        int faktorial = 1;
        for (int i =1 ; i<= bilangan; i++) {
            faktorial *= i;
        }

        if (bilangan >= 0) {
            System.out.println(faktorial);
        } else {
            System.out.println("mohon input bilangan positif dan tidak nol");
        }
    }
}