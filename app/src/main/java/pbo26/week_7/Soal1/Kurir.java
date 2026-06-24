import java.util.Random;

public class Kurir implements Runnable {
    private Gudang gudang;
    private String nama;
    private Random random = new Random();

    public Kurir(Gudang gudang, String nama) {
        this.gudang = gudang;
        this.nama = nama;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int jumlah = random.nextInt(5) + 1; // Acak 1-5 barang
                gudang.ambilStok(jumlah, nama);
                Thread.sleep(random.nextInt(1000) + 2000); // Sleep 2-3 detik
            }
        } catch (InterruptedException e) {
            System.out.println(nama + " selesai bertugas.");
        }
    }
}