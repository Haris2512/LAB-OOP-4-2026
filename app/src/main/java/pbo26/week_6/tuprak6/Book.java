package tuprak6;

public class Book extends LibraryItem {
    String author;

    public Book(String title, int itemId, String author) {
        super(title, itemId);
        this.author = author;
    }

    @Override
    public String getDescription() {
        return "Buku: " + this.title + " oleh " + this.author + ", ID: " + this.itemId;
    }

    @Override
    public String borrowItem(int days) {
        if (days > 14) {
            throw new IllegalArgumentException("Peminjaman buku maksimal 14 hari");
        }

        if (this.isBorrowed == true) {
            throw new IllegalArgumentException("Item telah dipinjam dan belum dikembalikan.");
        }
        
        this.isBorrowed = true;
        return "Item " + this.title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 10000;
    }

}
