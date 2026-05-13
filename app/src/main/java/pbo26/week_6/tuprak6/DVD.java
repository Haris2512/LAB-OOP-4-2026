package tuprak6;

public class DVD extends LibraryItem{
    int duration;

    public DVD (String title, int itemId, int duration) {
        super(title, itemId);
        this.duration = duration;
    }

    @Override
    public String getDescription() {
        return "DVD: " + this.title + ", Durasi " + this.duration + " menit, ID: " + this.itemId;
    }


    @Override
    public String borrowItem(int days) {
        if (days > 7) {
            throw new IllegalArgumentException("Peminjaman DVD maksimal 7 hari");
        }

        if (this.isBorrowed == true) {
            throw new IllegalArgumentException("Item telah dipinjam dan belum dikembalikan.");
        }

        this.isBorrowed = true;
        return "Item " + this.title + " berhasil dipinjam selama " + days + " hari";
    }


    @Override
    public double calculateFine (int daysLate) {
        return daysLate * 25000;
    } 
    
}
