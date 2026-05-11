class Laptop extends Produk{
    int ramsize;
    String processortype;

    public Laptop(String brand, int seriesnumber, double price, int ramsize, String processortype) {
        super(brand, seriesnumber, price);
        this.ramsize = ramsize;
        this.processortype = processortype;
    }
    public void displayinfo(){
        System.out.println("Produk : laptop");
        System.out.println("Ukuran ram : "+ ramsize + "gb");
        System.out.println("Tipe prosesor : "+ processortype);
    }
    
}