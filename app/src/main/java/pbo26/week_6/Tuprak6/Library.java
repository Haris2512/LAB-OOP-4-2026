import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library {
    private List<LibraryItem> items;
    private List<Member> members;
    private LibraryLogger logger;

    public Library() {
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
        this.logger = new LibraryLogger();
    }

    public String addItem(LibraryItem item) {
        items.add(item);
        return item.getTitle() + " berhasil ditambahkan";
    }

    public String addMember(Member member) {
        members.add(member);
        return "Anggota " + member.getName() + " berhasil ditambahkan";
    }

    public LibraryItem findItemById(int itemId) {
        for (LibraryItem item : items) {
            if (item.getItemId() == itemId) return item;
        }
        throw new NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan.");
    }

    public Member findMemberById(int memberId) {
        for (Member m : members) {
            if (m.getMemberId() == memberId) return m;
        }
        throw new NoSuchElementException("Anggota dengan ID " + memberId + " tidak ditemukan.");
    }

    public String borrowItem(int memberId, int itemId, int days) {
        Member member = findMemberById(memberId);
        LibraryItem item = findItemById(itemId);
        String result = member.borrow(item, days);

        String timestamp = logger.getNowTimestamp();
        logger.logBorrow(timestamp, item.getTitle(), member.getName());

        return result;
    }

    public String returnItem(int memberId, int itemId, int daysLate) {
        Member member = findMemberById(memberId);
        LibraryItem item = findItemById(itemId);
        String result = member.returnItem(item, daysLate);

        String returnTime = logger.getNowTimestamp();
        logger.logReturn(item.getTitle(), returnTime);

        return result;
    }

    public String getLibraryStatus() {
        if (items.isEmpty()) {
            return "Tidak ada item di perpustakaan.";
        }

        int idWidth = 6;
        int titleWidth = 30;
        int statusWidth = 12;
        String sep = "+" + "-".repeat(idWidth) + "+" + "-".repeat(titleWidth) + "+" + "-".repeat(statusWidth) + "+";

        StringBuilder sb = new StringBuilder();
        sb.append(sep).append("\n");
        sb.append(String.format("| %-" + (idWidth - 2) + "s | %-" + (titleWidth - 2) + "s | %-" + (statusWidth - 2) + "s |%n",
                "ID", "Judul", "Status"));
        sb.append(sep).append("\n");

        for (LibraryItem item : items) {
            String status = item.isBorrowed() ? "Dipinjam" : "Tersedia";
            sb.append(String.format("| %-" + (idWidth - 2) + "s | %-" + (titleWidth - 2) + "s | %-" + (statusWidth - 2) + "s |%n",
                    item.getItemId(), item.getTitle(), status));
        }
        sb.append(sep);
        return sb.toString();
    }

    public String getAllLogs() {
        return logger.getLogs();
    }

    public List<LibraryItem> getItems() { return items; }
    public List<Member> getMembers() { return members; }
}
