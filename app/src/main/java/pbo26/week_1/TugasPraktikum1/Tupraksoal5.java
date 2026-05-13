import java.util.Scanner;

public class Tupraksoal5 {
    
    public static void main(String[] args) {
        System.out.println("===============================");
        System.out.println("| MENCARI ANGKA DARI ARRAY 2D |");
        System.out.println("===============================");
        System.out.println("|         {1   2   3}         |");
        System.out.println("|         {4   5   6}         |");
        System.out.println("|         {7   8   9}         |");
        System.out.println("===============================");
        System.out.print  ("  Angka yang dicari : ");

        Scanner inputan = new Scanner(System.in);
        
        try {
            int[][] matriks = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };

            int pencarian = inputan.nextInt();
            boolean nilai = false;

            for (int baris = 0; baris < matriks.length; baris++) {
                for (int kolom = 0; kolom < matriks[baris ].length; kolom++) {
                    if (matriks[baris][kolom] == pencarian) {
                        System.out.printf("Found %d at [%d] [%d]", pencarian, baris, kolom);
                        nilai = true;
                        break;
                    }
                }
            }
            if (nilai == false) {
                System.out.println("Not Found");
            }
        }catch (Exception e) {
            System.out.println("Input tidak valid");
        }
    }
}