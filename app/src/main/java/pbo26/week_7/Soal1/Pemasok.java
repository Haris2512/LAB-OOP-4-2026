import java.util.Random;

public class Pemasok implements Runnable {
    private Gudang gudang;
    private String nama;
    private Random random = new Random();

    public Pemasok(Gudang gudang, String nama) {
        this.gudang = gudang;
        this.nama = nama;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int jumlah = random.nextInt(5) + 1; // Acak 1-5 barang
                gudang.tambahStok(jumlah, nama);
                Thread.sleep(random.nextInt(1000) + 1000); // Sleep 1-2 detik
            }
        } catch (InterruptedException e) {
            System.out.println(nama + " berhenti bekerja.");
        }
    }
}