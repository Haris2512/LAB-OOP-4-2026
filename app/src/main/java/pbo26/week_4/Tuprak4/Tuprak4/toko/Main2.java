package Tuprak4.toko;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Product> product = new ArrayList<>();

        // data awal
        product.add(new Smartphone("Samsung", 1, 5000, 6.5, 128));
        product.add(new Laptop("Asus", 2, 8000, 16, "Ryzen"));
        product.add(new Camera("Canon", 3, 7000, 24, "Wide Lens"));

        int pilih;

        do {
            try {
                System.out.println("\n=== MENU TOKO ===");
                System.out.println("1. Tambah Produk");
                System.out.println("2. Tampilkan Produk");
                System.out.println("3. Beli Produk");
                System.out.println("4. Keluar");
                System.out.print("Pilih: ");

                pilih = input.nextInt();

                if (pilih == 1) {
                    input.nextLine();

                    // untuk brand
                    String brand;
                    do {
                        System.out.print("Brand: ");
                        brand = input.nextLine();
                        if (brand.isEmpty()) {
                            System.out.println("Brand tidak boleh kosong!");
                        }
                    } while (brand.isEmpty());

                    // serial nd boleh ada sama
                    int serialNumber;
                    boolean ada;

                    do {
                        System.out.print("Serial Number: ");
                        serialNumber = input.nextInt();

                        ada = false;
                        for (Product p : product) {
                            if (p.serialNumber == serialNumber) {
                                System.out.println("Serial Number sudah ada!");
                                ada = true;
                                break;
                            }
                        }
                    } while (ada);

                    System.out.print("Price: ");
                    double price = input.nextDouble();

                    System.out.println("1. Smartphone");
                    System.out.println("2. Laptop");
                    System.out.println("3. Camera");
                    System.out.print("Pilih jenis: ");
                    int jenis = input.nextInt();
                    input.nextLine();

                    if (jenis == 1) {
                        System.out.print("Screen Size: ");
                        double screenSize = input.nextDouble();

                        System.out.print("Storage: ");
                        int storage = input.nextInt();

                        product.add(new Smartphone(
                                brand, serialNumber, price, screenSize, storage
                        ));

                    } else if (jenis == 2) {
                        System.out.print("RAM: ");
                        int ram = input.nextInt();
                        input.nextLine();

                        String processor;
                        do {
                            System.out.print("Processor: ");
                            processor = input.nextLine();
                            if (processor.isEmpty()) {
                                System.out.println("Processor tidak boleh kosong!");
                            }
                        } while (processor.isEmpty());

                        product.add(new Laptop(
                                brand, serialNumber, price, ram, processor
                        ));

                    } else if (jenis == 3) {
                        System.out.print("Resolution: ");
                        int resolution = input.nextInt();
                        input.nextLine();

                        String lens;
                        do {
                            System.out.print("Lens: ");
                            lens = input.nextLine();
                            if (lens.isEmpty()) {
                                System.out.println("Lens tidak boleh kosong!");
                            }
                        } while (lens.isEmpty());

                        product.add(new Camera(
                                brand, serialNumber, price, resolution, lens
                        ));

                    } else {
                        System.out.println("Jenis tidak valid");
                    }

                } else if (pilih == 2) {
                    System.out.println("Daftar Produk:");

                    if (product.isEmpty()) {
                        System.out.println("Tidak ada produk.");
                    } else {
                        for (Product p : product) {
                            p.displayInfo();
                            System.out.println("------");
                        }
                    }

                } else if (pilih == 3) {
                    System.out.print("Masukkan Serial Number: ");
                    int cari = input.nextInt();

                    boolean ditemukan = false;

                    for (int i = 0; i < product.size(); i++) {
                        if (product.get(i).serialNumber == cari) {
                            System.out.println("Anda telah membeli produk:");
                            product.get(i).displayInfo();

                            product.remove(i); // hapus langsung
                            ditemukan = true;
                            break;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Produk tidak ada.");
                    }

                } else if (pilih == 4) {
                    System.out.println("Keluar");

                } else {
                    System.out.println("Pilihan tidak ada di menu!");
                }

            } catch (Exception e) {
                System.out.println("Input harus angka");
                input.nextLine();
                pilih = 0;
            }

        } while (pilih != 4);

        input.close();
    }
}