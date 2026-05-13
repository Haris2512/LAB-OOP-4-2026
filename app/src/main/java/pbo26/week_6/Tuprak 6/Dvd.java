public class Dvd extends Libraryitem {
    int duration;
    

    public Dvd(String title, int item_id, boolean isBorrowed, int duration) {
        super(title, item_id, isBorrowed);
        this.duration = duration;
    }

    @Override
    public String getDescription() {
        return "DVD: " + title + ", durasi " + duration + " menit, ID: " + item_id;
    }

    @Override
    public String borrowItem(int days) {
        if (isBorrowed) {
            throw new IllegalArgumentException("Item sudah dipinjam dan belum dikembalikan.");
        }
        if (days > 7) {
            throw new IllegalArgumentException("DVD hanya dapat dipinjam maksimal " + 7 + " hari.");
        }
        isBorrowed = true;
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 25000;
    }
}
