import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library {
    List<Libraryitem> items;
    List<Member> members;
    LibraryLogger logger;

    public Library() {
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
        this.logger = new LibraryLogger();
    }

    public String addItem(Libraryitem item) {
        items.add(item);
        return item.title + " berhasil ditambahkan";
    }

    public String addMember(Member member) {
        members.add(member);
        return "Anggota " + member.name + " berhasil ditambahkan";
    }

    public Libraryitem findItemById(int itemId) {
        for (Libraryitem item : items) {
            if (item.item_id == itemId) return item;
        }
        throw new NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan.");
    }

    public Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.memberId == memberId) return member;
        }
        throw new NoSuchElementException("Anggota dengan ID " + memberId + " tidak ditemukan.");
    }

    public String borrowItem(int memberId, int itemId, int days) {
        Member member = findMemberById(memberId);
        Libraryitem item = findItemById(itemId);
        String result = member.borrow(item, days);
        logger.logActivity("BORROW:" + item.title + ":" + member.name);
        return result;
    }

    public String returnItem(int memberId, int itemId, int daysLate) {
        Member member = findMemberById(memberId);
        Libraryitem item = findItemById(itemId);
        String result = member.returnItem(item, daysLate);
        logger.logActivity("RETURN:" + item.title + ":" + member.name);
        return result;
    }

    public String getLibraryStatus() {
        if (items.isEmpty()) return "Tidak ada item di perpustakaan.";

        int wId = "ID".length();
        int wTitle = "Judul".length();
        int wStatus = "Status".length();

        for (Libraryitem item : items) {
            wId = Math.max(wId, String.valueOf(item.item_id).length());
            wTitle = Math.max(wTitle, item.title.length());
        }

        String border = "+" + "-".repeat(wId + 2) + "+" + "-".repeat(wTitle + 2) + "+" + "-".repeat(wStatus + 2) + "+";
        String fmt = "| %-" + wId + "s | %-" + wTitle + "s | %-" + wStatus + "s |%n";

        StringBuilder sb = new StringBuilder();
        sb.append(border).append("\n");
        sb.append(String.format(fmt, "ID", "Judul", "Status"));
        sb.append(border).append("\n");
        for (Libraryitem item : items) {
            String status = item.isBorrowed ? "Dipinjam" : "Tersedia";
            sb.append(String.format(fmt, item.item_id, item.title, status));
        }
        sb.append(border);
        return sb.toString();
    }

    public String getAllLogs() {
        return logger.getLogs();
    }

    public List<Libraryitem> getItems() {
        return items; 
    }
    public List<Member> getMembers() { 
        return members; 
    }
}