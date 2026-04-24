package Soal2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Produk> daftarProduk = new ArrayList<>();

        int pilih;

        do {
            System.out.println("============= MENU =============");
            System.out.println("|1. Tambah Produk              |");
            System.out.println("|2. Tampilkan Semua Produk     |");
            System.out.println("|3. Beli Produk                |");
            System.out.println("|4. Keluar                     |");
            System.out.println("================================");
            System.out.print("Pilih pilih (1-4): ");
            pilih = input.nextInt();

            switch (pilih) {
                case 1:
                    input.nextLine();

                    System.out.print("Masukkan nama produk: ");
                    String brand = input.nextLine();

                    System.out.print("Masukkan nomor seri: ");
                    int seri = input.nextInt();

                    System.out.print("Masukkan harga: ");
                    double harga = input.nextDouble();

                    System.out.println("Pilih tipe produk:");
                    System.out.println("1. Hp");
                    System.out.println("2. Laptop");
                    System.out.println("3. Camera");
                    System.out.print("Pilih tipe produk (1-3): ");
                    int tipe = input.nextInt();

                    if (tipe == 1) {
                        System.out.print("Masukkan ukuran layar: ");
                        double screen = input.nextDouble();

                        System.out.print("Masukkan kapasitas penyimpanan: ");
                        int storage = input.nextInt();

                        daftarProduk.add(new Hp(brand, seri, harga, screen, storage));

                    } else if (tipe == 2) {
                        System.out.print("Masukkan RAM: ");
                        int ram = input.nextInt();
                        input.nextLine();

                        System.out.print("Masukkan prosesor: ");
                        String prosesor = input.nextLine();

                        daftarProduk.add(new Laptop(brand, seri, harga, ram, prosesor));

                    } else if (tipe == 3) {
                        System.out.print("Masukkan resolusi: ");
                        int resolution = input.nextInt();
                        input.nextLine();

                        System.out.print("Masukkan tipe lensa: ");
                        String lensa = input.nextLine();

                        daftarProduk.add(new Camera(brand, seri, harga, resolution, lensa));
                    }
                    break;

                case 2:
                    if (daftarProduk.size() == 0) {
                    System.out.println("Belum ada produk.");
                } 
                else {
                    for (int i = 0; i < daftarProduk.size(); i++) {
                    System.out.println("--------- " + (i+1) + " ----------");
                    daftarProduk.get(i).Info();
                    }
                }
                    break;

                case 3:
                    System.out.print("Masukkan nomor seri produk: ");
                    int cari = input.nextInt();
                    boolean ditemukan = false;

                    for (int i = 0; i < daftarProduk.size(); i++) {
                        if (daftarProduk.get(i).getNomorSeri() == cari) {
                            System.out.println("Produk ditemukan:");
                            daftarProduk.get(i).Info();
                            daftarProduk.remove(i);
                            System.out.println("Produk berhasil dibeli.");
                            ditemukan = true;
                            break;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Produk tidak ditemukan.");
                    }
                    break;

                case 4:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }

        } while (pilih != 4);

        input.close();
    }
}