import java.util.ArrayList;
import java.util.Scanner;

// ===== SUPERCLASS =====
class Produk {
    String merk;
    String nomorSeri;
    double harga;

    Produk(String merk, String nomorSeri, double harga) {
        this.merk = merk;
        this.nomorSeri = nomorSeri;
        this.harga = harga;
    }

    void tampilkan() {
        System.out.println("Merk: " + merk);
        System.out.println("Nomor Seri: " + nomorSeri);
        System.out.println("Harga: " + harga);
    }
}

// ===== SMARTPHONE =====
class Smartphone extends Produk {
    double layar;
    int storage;

    Smartphone(String merk, String nomorSeri, double harga, double layar, int storage) {
        super(merk, nomorSeri, harga);
        this.layar = layar;
        this.storage = storage;
    }

    void tampilkan() {
        super.tampilkan();
        System.out.println("Ukuran Layar: " + layar);
        System.out.println("Storage: " + storage + "GB");
    }
}

// ===== LAPTOP =====
class Laptop extends Produk {
    String processor;

    Laptop(String merk, String nomorSeri, double harga, String processor) {
        super(merk, nomorSeri, harga);
        this.processor = processor;
    }

    void tampilkan() {
        super.tampilkan();
        System.out.println("Processor: " + processor);
    }
}

// ===== KAMERA =====
class Kamera extends Produk {
    int resolusi;

    Kamera(String merk, String nomorSeri, double harga, int resolusi) {
        super(merk, nomorSeri, harga);
        this.resolusi = resolusi;
    }

    void tampilkan() {
        super.tampilkan();
        System.out.println("Resolusi: " + resolusi + " MP");
    }
}

// ===== MAIN =====
public class Main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Produk> daftar = new ArrayList<>();

        int pilihan;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();
            input.nextLine();

            // ===== TAMBAH PRODUK =====
            if (pilihan == 1) {
                System.out.println("1. Smartphone");
                System.out.println("2. Laptop");
                System.out.println("3. Kamera");
                System.out.print("Pilih jenis: ");
                int jenis = input.nextInt();
                input.nextLine();

                System.out.print("Merk: ");
                String merk = input.nextLine();

                System.out.print("Nomor Seri: ");
                String ns = input.nextLine();

                System.out.print("Harga: ");
                double harga = input.nextDouble();

                if (jenis == 1) {
                    System.out.print("Ukuran Layar: ");
                    double layar = input.nextDouble();

                    System.out.print("Storage: ");
                    int storage = input.nextInt();

                    daftar.add(new Smartphone(merk, ns, harga, layar, storage));

                } else if (jenis == 2) {
                    input.nextLine();
                    System.out.print("Processor: ");
                    String proc = input.nextLine();

                    daftar.add(new Laptop(merk, ns, harga, proc));

                } else if (jenis == 3) {
                    System.out.print("Resolusi Kamera (MP): ");
                    int res = input.nextInt();

                    daftar.add(new Kamera(merk, ns, harga, res));
                }

                System.out.println("Produk berhasil ditambahkan!");

            }

            // ===== TAMPILKAN =====
            else if (pilihan == 2) {
                if (daftar.isEmpty()) {
                    System.out.println("Belum ada produk.");
                } else {
                    for (Produk p : daftar) {
                        System.out.println("------------");
                        p.tampilkan();
                    }
                }
            }

            // ===== BELI PRODUK =====
            else if (pilihan == 3) {
                System.out.print("Masukkan Nomor Seri: ");
                String cari = input.nextLine();

                boolean ditemukan = false;

                for (int i = 0; i < daftar.size(); i++) {
                    if (daftar.get(i).nomorSeri.equals(cari)) {
                        System.out.println("Produk ditemukan:");
                        daftar.get(i).tampilkan();

                        System.out.println("Pembelian berhasil!");
                        daftar.remove(i); // stok berkurang

                        ditemukan = true;
                        break;
                    }
                }

                if (!ditemukan) {
                    System.out.println("Produk tidak ditemukan!");
                }
            }

        } while (pilihan != 4);

        System.out.println("Terima kasih!");
    }
}