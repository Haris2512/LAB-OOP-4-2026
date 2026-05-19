import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class IndexerTask implements Runnable {
    private String namaDokumen;
    private ConcurrentHashMap<String, HasilProses> hasilMap;
    private CountDownLatch latch;
    private DataProcessor processor;

    public IndexerTask(String namaDokumen, ConcurrentHashMap<String, HasilProses> hasilMap, CountDownLatch latch) {
        this.namaDokumen = namaDokumen;
        this.hasilMap = hasilMap;
        this.latch = latch;
        this.processor = new DataProcessor();
    }

    @Override
    public void run() {
        long mulai = System.currentTimeMillis();
        String namaThread = Thread.currentThread().getName();

        try {
            int kata = processor.process(namaDokumen);
            long durasi = System.currentTimeMillis() - mulai;

            // Simpan hasil ke map
            hasilMap.put(namaDokumen, new HasilProses(namaThread, kata, durasi));

            // Tampilkan progres
            System.out.println("[" + namaThread + "] Selesai memproses " + namaDokumen + " (" + kata + " kata).");
        } catch (InterruptedException e) {
            System.out.println(namaDokumen + " gagal diproses.");
        } finally {
            // Pastikan latch dikurangi walau terjadi error
            latch.countDown();
        }
    }
}