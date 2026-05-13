import java.util.Scanner;

public class no5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] data = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        try {
            System.out.print("Cari angka: ");
            int x = input.nextInt();

            boolean ketemu = false;

            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    if (data[i][j] == x) {
                        System.out.println("Found " + x + " di [" + i + "][" + j + "]");
                        ketemu = true;
                        break;
                    }
                }
                if (ketemu) break;
            }

            if (!ketemu) {
                System.out.println("Tidak ditemukan");
            }

        } catch (Exception e) {
            System.out.println("Input harus angka");
        }
    }
}