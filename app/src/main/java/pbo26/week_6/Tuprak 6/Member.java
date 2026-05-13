import java.util.ArrayList;
import java.util.List;

public class Member {
    String name;
    int memberId;
    List<Libraryitem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(Libraryitem item, int days) {
        if (item.isBorrowed) {
            throw new IllegalStateException("Item " + item.title + " tidak tersedia (sedang dipinjam).");
        }
        item.borrowItem(days);
        borrowedItems.add(item);
        return "Item " + item.title + " berhasil dipinjam selama " + days + " hari";
    }

    public String returnItem(Libraryitem item, int daysLate) {
        item.returnItem();
        borrowedItems.remove(item);
        double fine = item.calculateFine(daysLate);
        return String.format("Item %s berhasil dikembalikan dengan denda: Rp %,.0f", item.title, fine);
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam");
            return;
        }
        System.out.println("+------+------------------------------+");
        System.out.printf("| %-4s | %-28s |%n", "ID", "Judul");
        System.out.println("+------+------------------------------+");
        for (Libraryitem item : borrowedItems) {
            System.out.printf("| %-4d | %-28s |%n", item.item_id, item.title);
        }
        System.out.println("+------+------------------------------+");
    }
}