class Smartphone extends Produk{
    double screensize;
    int storagecapacity;

    public Smartphone(String brand, int seriesnumber, double price, double screensize, int storagecapacity) {
        super(brand, seriesnumber, price);
        this.screensize = screensize;
        this.storagecapacity = storagecapacity;
    }
    public void displayinfo(){
        System.out.println("Produk : smartphone");
        System.out.println("Ukuran layar : "+ screensize + " inci");
        System.out.println("Kapasitas penyimpanan : "+ storagecapacity + " gb");
    }
    
}
