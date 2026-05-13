class Camera extends Produk{
    int resolution;
    String lenstype;

    public Camera(String brand, int seriesnumber, double price, int resolution, String lenstype) {
        super(brand, seriesnumber, price);
        this.resolution = resolution;
        this.lenstype = lenstype;
    }
    public void displayinfo(){
        System.out.println("Produk : camera");
        System.out.println("Resolusi : "+ resolution);
        System.out.println("Tipe lensa : "+ lenstype);
    }
}