import java.util.List;

public class Book extends Libraryitem {
    String author;
    

    public Book(String title, int item_id, boolean isBorrowed, String author) {
        super(title, item_id, isBorrowed);
        this.author = author;
    }

    @Override
    public String getDescription() {
        return "Buku: " + title + " oleh " + author + ", ID: " + item_id;
    }

    @Override
    public String borrowItem(int days) {
        if (isBorrowed) {
            throw new IllegalArgumentException("Item sudah dipinjam dan belum dikembalikan.");
        }
        if (days > 14) {
            throw new IllegalArgumentException("Buku hanya dapat dipinjam maksimal " + 14 + " hari.");
        }
        isBorrowed = true;
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 10000;
    }

    public void printBooks(List<Book> books) {
        System.out.println("+------+----------------------+----------------------+");
        System.out.printf("| %-4s | %-20s | %-20s |%n", "ID", "Judul", "Author");
        System.out.println("+------+----------------------+----------------------+");
        for (Book b : books) {
            System.out.printf("| %-4d | %-20s | %-20s |%n", b.item_id, b.title, b.author);
        }
        System.out.println("+------+----------------------+----------------------+");
    }
}