package Soal2;

public class Laptop extends Produk {
    private int ram;
    private String prosesor;

    public Laptop(String brand, int nomorSeri, double harga, int ram, String prosesor) {
        super(brand, nomorSeri, harga);
        this.ram = ram;
        this.prosesor = prosesor;
    }

    public void Info() {
        super.Info();
        System.out.println("RAM         : " + ram + " GB");
        System.out.println("Processor   : " + prosesor);
    }
}