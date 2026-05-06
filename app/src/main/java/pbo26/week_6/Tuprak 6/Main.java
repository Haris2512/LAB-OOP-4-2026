import java.util.Scanner;

public class Main {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Pilihan: ");
            String input = scanner.nextLine().trim();
            System.out.println();
            switch (input) {
                case "1":
                    tambahItem(); 
                     break;
                case "2":
                    tambahAnggota(); 
                    break;
                case "3": 
                    pinjamItem(); 
                    break;
                case "4": 
                    kembalikanItem(); 
                    break;
                case "5":
                    lihatStatus(); 
                    break;
                case "6": 
                    lihatLog(); 
                    break;
                case "7": 
                    lihatItemDipinjam(); 
                    break;
                case "8":
                    System.out.println("Terima kasih. Sampai jumpa!");
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
            System.out.println();
        }
    }

    public static void printMenu() {
        System.out.println("=== Sistem Manajemen Perpustakaan ===");
        System.out.println("1. Tambah Item");
        System.out.println("2. Tambah Anggota");
        System.out.println("3. Pinjam Item");
        System.out.println("4. Kembalikan Item");
        System.out.println("5. Lihat Status Perpustakaan");
        System.out.println("6. Lihat Log Aktivitas");
        System.out.println("7. Lihat Item yang Dipinjam Anggota");
        System.out.println("8. Keluar");
    }

    public static void tambahItem() {
        System.out.println("Jenis item:");
        System.out.println("1. Buku");
        System.out.println("2. DVD");
        System.out.print("Pilihan: ");
        String jenis = scanner.nextLine().trim();

        try {
            System.out.print("Judul: ");
            String title = scanner.nextLine().trim();
            System.out.print("ID Item: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            if (jenis.equals("1")) {
                System.out.print("Nama Author: ");
                String author = scanner.nextLine();
                Book book = new Book(title, id, false, author);
                System.out.println(library.addItem(book));
            } else if (jenis.equals("2")) {
                System.out.print("Durasi (menit): ");
                int duration = Integer.parseInt(scanner.nextLine());
                Dvd dvd = new Dvd(title, id, false, duration);
                System.out.println(library.addItem(dvd));
            } else {
                System.out.println("Jenis item tidak valid.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
        }
    }

    public static void tambahAnggota() {
        try {
            System.out.print("Nama Anggota: ");
            String name = scanner.nextLine();
            System.out.print("ID Anggota: ");
            int id = Integer.parseInt(scanner.nextLine());
            Member member = new Member(name, id);
            System.out.println(library.addMember(member));
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
        }
    }

    public static void pinjamItem() {
        try {
            System.out.print("ID Anggota: ");
            int memberId = Integer.parseInt(scanner.nextLine());
            System.out.print("ID Item: ");
            int itemId = Integer.parseInt(scanner.nextLine());
            System.out.print("Lama Peminjaman (hari): ");
            int days = Integer.parseInt(scanner.nextLine());
            System.out.println(library.borrowItem(memberId, itemId, days));
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void kembalikanItem() {
        try {
            System.out.print("ID Anggota: ");
            int memberId = Integer.parseInt(scanner.nextLine());
            System.out.print("ID Item: ");
            int itemId = Integer.parseInt(scanner.nextLine());
            System.out.print("Jumlah Hari Keterlambatan: ");
            int daysLate = Integer.parseInt(scanner.nextLine());
            System.out.println(library.returnItem(memberId, itemId, daysLate));
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void lihatStatus() {
        System.out.println(library.getLibraryStatus());
    }

    public static void lihatLog() {
        System.out.println(library.getAllLogs());
    }

    public static void lihatItemDipinjam() {
        try {
            System.out.print("ID Anggota: ");
            int memberId = Integer.parseInt(scanner.nextLine().trim());
            Member member = library.findMemberById(memberId);
            System.out.println("Item yang dipinjam oleh " + member.name + ":");
            member.getBorrowedItems();
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
