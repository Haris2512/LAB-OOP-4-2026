import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainSoal2 {
    public static void main(String[] args) {
        int totalDokumen = 10;
        ExecutorService executor = Executors.newFixedThreadPool(4); // 4 thread tetap
        ConcurrentHashMap<String, HasilProses> mapHasil = new ConcurrentHashMap<>();
        CountDownLatch latch = new CountDownLatch(totalDokumen);

        System.out.println("Memulai Mesin Pencari...\n");

        for (int i = 1; i <= totalDokumen; i++) {
            String namaFile = "Dokumen_" + i + ".txt";
            executor.execute(new IndexerTask(namaFile, mapHasil, latch));
        }

        try {
            // Tunggu semua thread memanggil latch.countDown()
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();

        // Cetak output akhir
        System.out.println("\n--- Klasemen Hasil ---");
        System.out.printf("%-15s | %-15s | %-15s | %-10s\n", "Nama Dokumen", "Thread", "Durasi (ms)", "Jumlah Kata");
        System.out.println("----------------------------------------------------------------------");

        int totalKata = 0;
        long totalWaktu = 0;

        for (String file : mapHasil.keySet()) {
            HasilProses hasil = mapHasil.get(file);
            System.out.printf("%-15s | %-15s | %-15d | %-10d\n", file, hasil.threadName, hasil.durasiMs, hasil.jumlahKata);
            
            totalKata += hasil.jumlahKata;
            totalWaktu += hasil.durasiMs;
        }

        double rataRata = (double) totalWaktu / totalDokumen;

        System.out.println("----------------------------------------------------------------------");
        System.out.println("Total Kata Keseluruhan : " + totalKata + " kata");
        System.out.printf("Rata-rata Waktu Proses : %.2f ms\n", rataRata);
    }
}