import java.util.Scanner;
import java.util.NoSuchElementException;

public class Main {
    static Library library = new Library();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Sistem Manajemen Perpustakaan ===");

        while (true) {
            printMenu();
            System.out.print("Pilih menu: ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1": tambahItem(); break;
                case "2": tambahAnggota(); break;
                case "3": pinjamItem(); break;
                case "4": kembalikanItem(); break;
                case "5": lihatStatus(); break;
                case "6": lihatLog(); break;
                case "7": lihatItemDipinjam(); break;
                case "8":
                    System.out.println("Terima kasih! Sampai jumpa.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.\n");
            }
        }
    }

    static void printMenu() {
        System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
        System.out.println("1. Tambah Item");
        System.out.println("2. Tambah Anggota");
        System.out.println("3. Pinjam Item");
        System.out.println("4. Kembalikan Item");
        System.out.println("5. Lihat Status Perpustakaan");
        System.out.println("6. Lihat Log Aktivitas");
        System.out.println("7. Lihat Item yang Dipinjam Anggota");
        System.out.println("8. Keluar");
    }

    static void tambahItem() {
        System.out.println("\n-- Tambah Item --");
        System.out.println("Jenis item:");
        System.out.println("1. Buku");
        System.out.println("2. DVD");
        System.out.print("Pilih jenis: ");
        String jenis = scanner.nextLine().trim();

        try {
            System.out.print("Masukkan ID item (angka): ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Masukkan judul: ");
            String title = scanner.nextLine().trim();

            if (jenis.equals("1")) {
                System.out.print("Masukkan nama penulis: ");
                String author = scanner.nextLine().trim();
                Book book = new Book(title, id, author);
                System.out.println(library.addItem(book));
            } else if (jenis.equals("2")) {
                System.out.print("Masukkan durasi (menit): ");
                int duration = Integer.parseInt(scanner.nextLine().trim());
                DVD dvd = new DVD(title, id, duration);
                System.out.println(library.addItem(dvd));
            } else {
                System.out.println("Jenis tidak valid.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
        }
    }

    static void tambahAnggota() {
        System.out.println("\n-- Tambah Anggota --");
        try {
            System.out.print("Masukkan ID anggota (angka): ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Masukkan nama anggota: ");
            String name = scanner.nextLine().trim();

            Member member = new Member(name, id);
            System.out.println(library.addMember(member));
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
        }
    }

    static void pinjamItem() {
        System.out.println("\n-- Pinjam Item --");
        try {
            System.out.print("Masukkan ID anggota: ");
            int memberId = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Masukkan ID item: ");
            int itemId = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Masukkan jumlah hari peminjaman: ");
            int days = Integer.parseInt(scanner.nextLine().trim());

            String result = library.borrowItem(memberId, itemId, days);
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException e) {
            System.out.println("Gagal: " + e.getMessage());
        }
    }

    static void kembalikanItem() {
        System.out.println("\n-- Kembalikan Item --");
        try {
            System.out.print("Masukkan ID anggota: ");
            int memberId = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Masukkan ID item: ");
            int itemId = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Masukkan jumlah hari keterlambatan (0 jika tidak terlambat): ");
            int daysLate = Integer.parseInt(scanner.nextLine().trim());

            String result = library.returnItem(memberId, itemId, daysLate);
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
        } catch (NoSuchElementException e) {
            System.out.println("Gagal: " + e.getMessage());
        }
    }

    static void lihatStatus() {
        System.out.println("\n-- Status Perpustakaan --");
        System.out.println(library.getLibraryStatus());
    }

    static void lihatLog() {
        System.out.println("\n-- Log Aktivitas --");
        System.out.println(library.getAllLogs());
    }

    static void lihatItemDipinjam() {
        System.out.println("\n-- Item yang Dipinjam Anggota --");
        try {
            System.out.print("Masukkan ID anggota: ");
            int memberId = Integer.parseInt(scanner.nextLine().trim());
            Member member = library.findMemberById(memberId);
            System.out.println("Item yang dipinjam oleh " + member.getName() + ":");
            member.getBorrowedItems();
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
        } catch (NoSuchElementException e) {
            System.out.println("Gagal: " + e.getMessage());
        }
    }
}
