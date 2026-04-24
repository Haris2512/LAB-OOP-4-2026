package Soal2;

public class Camera extends Produk {
    private int resolusi;
    private String tipeLensa;

    public Camera(String brand, int nomorSeri, double harga, int resolusi, String tipeLensa) {
        super(brand, nomorSeri, harga);
        this.resolusi = resolusi;
        this.tipeLensa = tipeLensa;
    }

    public void Info() {
        super.Info();
        System.out.println("Resolusi    : " + resolusi + " MP");
        System.out.println("Tipe Lensa  : " + tipeLensa);
    }
}