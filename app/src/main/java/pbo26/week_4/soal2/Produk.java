class Produk{
    String brand;
    int seriesnumber;
    double price;

    public Produk(String brand, int seriesnumber, double price) {
        this.brand = brand;
        this.seriesnumber = seriesnumber;
        this.price = price;
    }
    public void displayinfo(){
        System.out.println("Merek : "+ brand);
        System.out.println("Nomor Seri : "+ seriesnumber);
        System.out.println("Harga : "+ price);
    }

}