import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed()) {
            throw new IllegalStateException("Item " + item.getTitle() + " tidak tersedia (sudah dipinjam).");
        }
        
        item.setBorrowed(true);
        borrowedItems.add(item);
        return "Item " + item.getTitle() + " berhasil dipinjam selama " + days + " hari";
    }

    public String returnItem(LibraryItem item, int daysLate) {
        item.returnItem();
        borrowedItems.remove(item);
        double fine = item.calculateFine(daysLate);

        String fineFormatted = formatRupiah(fine);
        return "Item " + item.getTitle() + " berhasil dikembalikan dengan denda: Rp " + fineFormatted;
    }

    private String formatRupiah(double amount) {
        long val = (long) amount;
        String s = Long.toString(val);
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (count > 0 && count % 3 == 0) result.insert(0, '.');
            result.insert(0, s.charAt(i));
            count++;
        }
        return result.toString();
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam");
            return;
        }
        int idWidth = 6;
        int titleWidth = 20;
        String separator = "+" + "-".repeat(idWidth) + "+" + "-".repeat(titleWidth) + "+";
        System.out.println(separator);
        System.out.printf("| %-" + (idWidth - 2) + "s | %-" + (titleWidth - 2) + "s |%n", "ID", "Judul");
        System.out.println(separator);
        for (LibraryItem item : borrowedItems) {
            System.out.printf("| %-" + (idWidth - 2) + "s | %-" + (titleWidth - 2) + "s |%n",
                    item.getItemId(), item.getTitle());
        }
        System.out.println(separator);
    }

    public String getName() { return name; }
    public int getMemberId() { return memberId; }
    public List<LibraryItem> getBorrowedItemsList() { return borrowedItems; }
}
