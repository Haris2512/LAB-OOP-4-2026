import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        int choice = 0; // Deklarasi variabel untuk menyimpan pilihan menu

        do {
            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");
            
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Membersihkan buffer (newline character)

                switch (choice) {
                    case 1:
                        System.out.print("Tipe Item (1. Buku, 2. DVD): ");
                        int type = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("ID Item: ");
                        int itemId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Judul: ");
                        String title = scanner.nextLine();

                        if (type == 1) {
                            System.out.print("Penulis: ");
                            String author = scanner.nextLine();
                            System.out.println(library.addItem(new Book(title, itemId, author)));
                        } else if (type == 2) {
                            System.out.print("Durasi (menit): ");
                            int duration = scanner.nextInt();
                            System.out.println(library.addItem(new DVD(title, itemId, duration)));
                        } else {
                             System.out.println("Tipe item tidak valid.");
                        }
                        break;

                    case 2:
                        System.out.print("ID Anggota: ");
                        String memberId = scanner.nextLine();
                        System.out.print("Nama Anggota: ");
                        String name = scanner.nextLine();
                        library.addMember(new Member(name, memberId));
                        break;

                    case 3:
                        System.out.print("ID Anggota: ");
                        String mIdBorrow = scanner.nextLine();
                        Member mBorrow = library.findMemberById(mIdBorrow);
                        if (mBorrow == null) {
                            System.out.println("Anggota tidak ditemukan.");
                            break;
                        }
                        System.out.print("ID Item: ");
                        int iIdBorrow = scanner.nextInt();
                        System.out.print("Lama pinjam (hari): ");
                        int days = scanner.nextInt();
                        
                        LibraryItem itemBorrow = library.findItemById(iIdBorrow);
                        String result = mBorrow.borrow(itemBorrow, days);
                        System.out.println(result);
                        
                        String typeStr = itemBorrow instanceof Book ? "Buku" : "DVD";
                        library.getLogger().logActivity(typeStr + " " + itemBorrow.title + " dipinjam oleh " + mBorrow.getName());
                        break;

                    case 4:
                        System.out.print("ID Anggota: ");
                        String mIdReturn = scanner.nextLine();
                        Member mReturn = library.findMemberById(mIdReturn);
                        if (mReturn == null) {
                            System.out.println("Anggota tidak ditemukan.");
                            break;
                        }
                        System.out.print("ID Item yang dikembalikan: ");
                        int iIdReturn = scanner.nextInt();
                        System.out.print("Jumlah hari keterlambatan (0 jika tidak telat): ");
                        int daysLate = scanner.nextInt();
                        
                        LibraryItem itemReturn = library.findItemById(iIdReturn);
                        System.out.println(mReturn.returnItem(itemReturn, daysLate));
                        
                        String typeStrRet = itemReturn instanceof Book ? "Buku" : "DVD";
                        library.getLogger().logActivity(typeStrRet + " " + itemReturn.title + " dikembalikan oleh " + mReturn.getName());
                        break;

                    case 5:
                        library.getLibraryStatus();
                        break;

                    case 6:
                        System.out.println("\n--- Log Aktivitas ---");
                        System.out.print(library.getAllLogs());
                        break;

                    case 7:
                        System.out.print("ID Anggota: ");
                        String mIdCheck = scanner.nextLine();
                        Member mCheck = library.findMemberById(mIdCheck);
                        if (mCheck != null) {
                            System.out.println("Item yang dipinjam oleh " + mCheck.getName() + ":");
                            mCheck.getBorrowedItems();
                        } else {
                            System.out.println("Anggota tidak ditemukan.");
                        }
                        break;

                    case 8:
                        System.out.println("Terima kasih telah menggunakan sistem!");
                        break;

                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan input.");
            }
            
        } while (choice != 8);
        scanner.close();
    }
}