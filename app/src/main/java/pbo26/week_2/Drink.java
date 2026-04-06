// CLASS UTAMA
class Drink {
    String namaMinuman;
    int harga;
    Topping topping; // atribut objek

    // Constructor default
    Drink() {
        namaMinuman = "Default Drink";
        harga = 0;
        topping = new Topping("None");
    }

    // Constructor dengan parameter
    Drink(String namaMinuman, int harga, Topping topping) {
        this.namaMinuman = namaMinuman;
        this.harga = harga;
        this.topping = topping;
    }

    // Method 1 (behavior)
    void tampilkanInfo() {
        System.out.println("Minuman: " + namaMinuman);
        System.out.println("Harga: " + harga);
        topping.tampilkanTopping();
        System.out.println();
    }

    // Method 2 (INTERAKSI ANTAR OBJEK)
    void tukarTopping(Drink minumanLain) {
        Topping sementara = this.topping;
        this.topping = minumanLain.topping;
        minumanLain.topping = sementara;

        System.out.println("Topping berhasil ditukar!");
    }