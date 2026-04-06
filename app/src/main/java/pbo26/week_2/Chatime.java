public class Chatime {
    public static void main(String[] args) {

        // Object 1
        Drink d1 = new Drink("Milk Tea", 10000, new Topping("Pearl"));

        // Object 2
        Drink d2 = new Drink("Green Tea", 12000, new Topping("Grass Jelly"));

        d1.tampilkanInfo();
        d2.tampilkanInfo();

        System.out.println("\n=== Tukar Topping ===");
        d1.tukarTopping(d2);

        d1.tampilkanInfo();
        d2.tampilkanInfo();
    }
}
