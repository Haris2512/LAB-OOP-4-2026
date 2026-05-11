package tuprak6;

import java.util.ArrayList;
import java.util.List;


public class Member {
    String name;
    String memberId;
    List <LibraryItem> borrowedItems;

    public Member (String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow (LibraryItem item, int days) {
        if (item.isBorrowed) {
            throw new IllegalStateException ("Item " + item.title + " telah dipinjam orang lain");
        }

        item.borrowItem (days);

        this.borrowedItems.add (item);

        return "Item " + item.title + " berhasil dipinjam selama " + days + " hari oleh " + this.name;  
    }

    public String returnItem (LibraryItem item, int daysLate) {
        // memanggil item.returnItem() untuk set status isBorrowed jadi false
        item.returnItem();
        this.borrowedItems.remove(item);
        
        double denda = item.calculateFine(daysLate);

        return "Item " + item.title + " berhasil dikembalikan oleh " + this.name + " dengan denda: Rp. " + denda;
    }

    public void getBorrowedItems() {
        if (this.borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam");
        } else {
            System.out.println("+-------+-----------+");
            System.out.println("|  ID   |   Judul   |");
            System.out.println("+-------+-----------+");
        
            for (LibraryItem item : borrowedItems) {
                // %-5d artinya angka ID dikasih jarak 5 spasi ke kanan
                System.out.printf("|  %-5d |  %-9s |\n", item.itemId, item.title);
            }
            
            System.out.println("+-------+-----------+");
        }
    }

    }
