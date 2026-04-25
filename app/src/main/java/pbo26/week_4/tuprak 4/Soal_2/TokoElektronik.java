package Soal_2;


class Produk {
    String merek;
    String nomorSeri;
    double harga;

    Produk(String merek, String nomorSeri, double harga) {
        this.merek = merek;
        this.nomorSeri = nomorSeri;
        this.harga = harga;
    }

    void tampilkan() {
        System.out.println("Merek: " + merek);
        System.out.println("No Seri: " + nomorSeri);
        System.out.println("Harga: " + harga);
    }
}


class Smartphone extends Produk {
    String layar;
    int storage;

    Smartphone(String merek, String nomorSeri, double harga, String layar, int storage) {
        super(merek, nomorSeri, harga);
        this.layar = layar;
        this.storage = storage;
    }

    void tampilkan() {
        super.tampilkan();
        System.out.println("Layar: " + layar);
        System.out.println("Storage: " + storage + "GB");
    }
}


class Laptop extends Produk {
    String ram;

    Laptop(String merek, String nomorSeri, double harga, String ram) {
        super(merek, nomorSeri, harga);
        this.ram = ram;
    }

    void tampilkan() {
        super.tampilkan();
        System.out.println("RAM: " + ram);
    }
}


class Kamera extends Produk {
    int megapixel;

    Kamera(String merek, String nomorSeri, double harga, int megapixel) {
        super(merek, nomorSeri, harga);
        this.megapixel = megapixel;
    }

    void tampilkan() {
        super.tampilkan();
        System.out.println("MP: " + megapixel);
    }
}


