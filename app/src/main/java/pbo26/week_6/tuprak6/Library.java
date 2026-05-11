package tuprak6;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library {
    List<LibraryItem> items;
    List<Member> members;
    LibraryLogger logger;

    public Library () {
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
        this.logger = new LibraryLogger();
    }

    public String addItem (LibraryItem item) {
        this.items.add(item);
        this.logger.logActivity(item.title + " berhasil ditambahkan");
        return item.title + " berhasil ditambahkan";
    }

    public void addMember(Member member) {
    this.members.add(member);
    // tambah log aktivitas buat daftar anggota baru
    this.logger.logActivity("Anggota baru terdaftar: " + member.name);
}

    public LibraryItem findItemById (int itemId) {
        for (LibraryItem item : items) {
            if (item.itemId == itemId) {
                return item;
            }
        }
        // lempar exception kalau tidak ketemu
        throw new NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan");
    }

    // kasi masuk ini ke class Library
    public Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.memberId.equals(memberId)) {
                return member;
            }
        }
        // klo tidak ketemu
        throw new java.util.NoSuchElementException("Anggota dengan ID " + memberId + " tidak ditemukan.");
    }


    public String getLibraryStatus() {
    if (items.isEmpty()) {
        return "Perpustakaan kosong.";
    }

    String status = "+-------+----------------------+-----------+\n";
    status += "|  ID   |        Judul         |  Status   |\n";
    status += "+-------+----------------------+-----------+\n";

    // loop daftar item
    for (LibraryItem item : items) {
        String ketersediaan;
        
        // cek status pinjam untuk tentukan teks yang ditampilkan
        if (item.isBorrowed) {
            ketersediaan = "Dipinjam";
        } else {
            ketersediaan = "Tersedia";
        }


        status += String.format("| %-6d | %-21s | %-10s|\n", 
                  item.itemId, item.title, ketersediaan);
    }

    status += "+-------+----------------------+-----------+";
    
    return status;
}

    public String getAllLogs () {
        return this.logger.getLogs();
    }
}
