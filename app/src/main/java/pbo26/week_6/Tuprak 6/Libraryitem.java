public abstract class Libraryitem {
    String title;
    int item_id;
    boolean isBorrowed;

    public Libraryitem(String title, int item_id, boolean isBorrowed) {
        this.title = title;
        this.item_id = item_id;
        this.isBorrowed = isBorrowed;
    }
    public abstract String getDescription();
    public abstract String borrowItem(int days);
    public abstract double calculateFine(int daysLate);

    public String returnItem() {
        this.isBorrowed = false;
        return title + " dikembalikan";
    }


}