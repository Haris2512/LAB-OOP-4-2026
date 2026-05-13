package Tuprak4.bangun;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilih;

        do {
            try {
                System.out.println("\n=== MENU BANGUN ===");
                System.out.println("\nBANGUN DATAR");
                System.out.println("1. Persegi");
                System.out.println("2. Persegi Panjang");
                System.out.println("3. Lingkaran");
                System.out.println("4. Trapesium");
                System.out.println("\nBANGUN RUANG");
                System.out.println("5. Kubus");
                System.out.println("6. Balok");
                System.out.println("7. Tabung");
                System.out.println("8. Bola\n");
                System.out.println("9. Keluar");

                System.out.print("Pilih: ");
                pilih = input.nextInt();

                if (pilih == 1) {
                    System.out.print("Sisi: ");
                    double sisi = input.nextDouble();

                    Persegi p = new Persegi(sisi);

                    System.out.println("Luas = " + p.luas());
                    System.out.println("Keliling = " + p.keliling());

                } else if (pilih == 2) {
                    System.out.print("Panjang: ");
                    double panjang = input.nextDouble();

                    System.out.print("Lebar: ");
                    double lebar = input.nextDouble();

                    PersegiPanjang pp = new PersegiPanjang(panjang, lebar);

                    System.out.println("Luas = " + pp.luas());
                    System.out.println("Keliling = " + pp.keliling());

                } else if (pilih == 3) {
                    System.out.print("Jari-jari: ");
                    double jariJari = input.nextDouble();

                    Lingkaran l = new Lingkaran(jariJari);

                    System.out.println("Luas = " + l.luas());
                    System.out.println("Keliling = " + l.keliling());

                } else if (pilih == 4) {
                    System.out.print("Sisi Sejajar 1: ");
                    double s1 = input.nextDouble();

                    System.out.print("Sisi Sejajar 2: ");
                    double s2 = input.nextDouble();

                    System.out.print("Sisi Miring 1: ");
                    double s3 = input.nextDouble();

                    System.out.print("Sisi Miring 2: ");
                    double s4 = input.nextDouble();

                    System.out.print("Tinggi: ");
                    double t = input.nextDouble();

                    Trapesium trapes = new Trapesium(s1, s2, s3, s4, t);

                    System.out.println("Luas = " + trapes.luas());
                    System.out.println("Keliling = " + trapes.keliling());

                } else if (pilih == 5) {
                    System.out.print("Sisi: ");
                    double sisi = input.nextDouble();

                    Kubus k = new Kubus(sisi);

                    System.out.println("Volume = " + k.volume());
                    System.out.println("Luas Permukaan = " + k.luasPermukaan());

                } else if (pilih == 6) {
                    System.out.print("Panjang: ");
                    double panjang = input.nextDouble();

                    System.out.print("Lebar: ");
                    double lebar = input.nextDouble();

                    System.out.print("Tinggi: ");
                    double tinggi = input.nextDouble();

                    Balok b = new Balok(panjang, lebar, tinggi);

                    System.out.println("Volume = " + b.volume());
                    System.out.println("Luas Permukaan = " + b.luasPermukaan());

                } else if (pilih == 7) {
                    System.out.print("Jari-jari: ");
                    double jariJari = input.nextDouble();

                    System.out.print("Tinggi: ");
                    double tinggi = input.nextDouble();

                    Tabung tb = new Tabung(jariJari, tinggi);

                    System.out.println("Volume = " + tb.volume());
                    System.out.println("Luas Permukaan = " + tb.luasPermukaan());

                } else if (pilih == 8) {
                    System.out.print("Jari-jari: ");
                    double jariJari = input.nextDouble();

                    Bola b = new Bola(jariJari);

                    System.out.println("Volume = " + b.volume());
                    System.out.println("Luas Permukaan = " + b.luasPermukaan());

                } else if (pilih == 9) {
                    System.out.println("Program selesai.");

                } else {
                    System.out.println("Pilihan tidak valid!");
                }

            } catch (Exception e) {
                System.out.println("Input harus angka!");
                input.nextLine();
                pilih = 0;
            }

        } while (pilih != 9);
    }
}