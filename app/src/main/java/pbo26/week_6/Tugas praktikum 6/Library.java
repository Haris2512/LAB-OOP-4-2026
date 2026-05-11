import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library {
    private List<LibraryItem> items = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private LibraryLogger logger = new LibraryLogger();

    public String addItem(LibraryItem item) {
        items.add(item);
        return item.title + " berhasil ditambahkan";
    }

    public void addMember(Member member) {
        members.add(member);
        System.out.println("Anggota " + member.getName() + " berhasil ditambahkan.");
    }

    public LibraryItem findItemById(int itemId) {
        for (LibraryItem item : items) {
            if (item.itemId == itemId) {
                return item;
            }
        }
        throw new NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan.");
    }

    public Member findMemberById(String memberId) {
        for (Member m : members) {
            if (m.getMemberId().equals(memberId)) return m;
        }
        return null;
    }

    public void getLibraryStatus() {
        if (items.isEmpty()) {
            System.out.println("Perpustakaan kosong.");
            return;
        }
        System.out.println("+---------+---------------------------+------------+");
        System.out.printf("| %-7s | %-25s | %-10s |\n", "ID", "Judul", "Status");
        System.out.println("+---------+---------------------------+------------+");
        for (LibraryItem item : items) {
            String status = item.isBorrowed ? "Dipinjam" : "Tersedia";
            System.out.printf("| %-7d | %-25s | %-10s |\n", item.itemId, item.title, status);
        }
        System.out.println("+---------+---------------------------+------------+");
    }

    public String getAllLogs() {
        return logger.getLogs();
    }

    public LibraryLogger getLogger() {
        return logger;
    }
}