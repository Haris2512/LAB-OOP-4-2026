import java.util.Scanner;

public class Tupraksoal1 {
    
    public static void main(String[] args) {
        Scanner inputan = new Scanner(System.in);
        System.out.println("==========================================");
        System.out.println("|   MERUBAH HURUF PERTAMA SETIAP KATA    |");
        System.out.println("==========================================");
        System.out.print  ("  Masukkan Kalimat : ");
        String[] kalimat = inputan.nextLine().toLowerCase().split(" ");
        String hasil = "";
        for (String kata : kalimat) {
            if (kata.length() > 0) {
                hasil += Character.toUpperCase(kata.charAt(0)) + kata.substring(1) + " ";
            }
        }
        System.out.println(hasil);
    }