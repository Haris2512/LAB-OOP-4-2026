import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Produk> daftarProduk = new ArrayList<>();
        boolean running = true;

        while (running) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Tambah Produk");
                System.out.println("2. Tampilkan Semua Produk");
                System.out.println("3. Beli Produk");
                System.out.println("4. Keluar");
                System.out.print("\n>>> Pilih menu (1-4): ");
                
                int menu = Integer.parseInt(sc.nextLine());

                switch (menu) {
                    case 1:
                        System.out.print("Masukkan nama produk: ");
                        String nama = sc.nextLine();
                        System.out.print("Masukkan nomor seri: ");
                        int seri = Integer.parseInt(sc.nextLine());
                        System.out.print("Masukkan harga: ");
                        double harga = Double.parseDouble(sc.nextLine());

                        System.out.println("Pilih tipe produk:");
                        System.out.println("1. Smartphone");
                        System.out.println("2. Laptop");
                        System.out.println("3. Camera");
                        System.out.print("Pilih tipe produk (1-3): ");
                        int tipe = Integer.parseInt(sc.nextLine());

                        if (tipe == 1) {
                            System.out.print("Masukkan ukuran layar (inci): ");
                            double layar = Double.parseDouble(sc.nextLine());
                            System.out.print("Masukkan kapasitas penyimpanan (GB): ");
                            int memori = Integer.parseInt(sc.nextLine());
                            
                            daftarProduk.add(new Smartphone(nama, seri, harga, layar, memori));
                            System.out.println("Berhasil menambahkan Smartphone!");

                        } else if (tipe == 2) {
                            System.out.print("Masukkan ukuran RAM (GB): ");
                            int ram = Integer.parseInt(sc.nextLine());
                            System.out.print("Masukkan tipe processor: ");
                            String prosesor = sc.nextLine();
                            
                            daftarProduk.add(new Laptop(nama, seri, harga, ram, prosesor));
                            System.out.println("Berhasil menambahkan Laptop!");

                        } else if (tipe == 3) {
                            System.out.print("Masukkan resolusi (MP): ");
                            int resolusi = Integer.parseInt(sc.nextLine());
                            System.out.print("Masukkan tipe lensa: ");
                            String lensa = sc.nextLine();
                            
                            daftarProduk.add(new Camera(nama, seri, harga, resolusi, lensa));
                            System.out.println("Berhasil menambahkan Camera!");
                        } else {
                            System.out.println("Tipe produk tidak valid!");
                        }
                        break;

                    case 2:
                        System.out.println("\n=== DAFTAR SEMUA PRODUK ===");
                        if (daftarProduk.isEmpty()) {
                            System.out.println("Stok produk masih kosong.");
                        } else {
                            for (Produk p : daftarProduk) {
                                p.displayinfo();
                            }
                        }
                        break;

                    case 3:
                        System.out.print("\nMasukkan nomor seri produk yang ingin dibeli: ");
                        int cariSeri = Integer.parseInt(sc.nextLine());
                        boolean ditemukan = false;

                        for (int i = 0; i < daftarProduk.size(); i++) {
                            if (daftarProduk.get(i).seriesnumber == cariSeri) {
                                System.out.println("\nProduk ditemukan!");
                                daftarProduk.get(i).displayinfo();
                                
                                System.out.println("Mengonfirmasi pembelian...");
                                daftarProduk.remove(i); 
                                System.out.println("Pembelian berhasil!");
                                ditemukan = true;
                                break; 
                            }
                        }

                        if (!ditemukan) {
                            System.out.println("Pesan: Produk dengan nomor seri " + cariSeri + " tidak ditemukan/stok habis.");
                        }
                        break;

                    case 4:
                        System.out.println("Keluar dari sistem. Terima kasih!");
                        running = false; 
                        break;

                    default:
                        System.out.println("Pilihan menu tidak valid. Silakan coba lagi.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n[Peringatan] Input tidak valid! Harap pastikan Anda memasukkan angka yang benar untuk Menu/Harga/Seri.");
            }
        }
    }
}