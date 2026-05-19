import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainSoal1 {
    public static void main(String[] args) {
        Gudang gudang = new Gudang(50); // Kapasitas 50 barang

        // 2 thread Pemasok + 3 thread Kurir = 5 thread pool
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Thread monitor = new Thread(new Monitoring(gudang));
        
        monitor.start();

        // Jalankan pemasok
        executor.execute(new Pemasok(gudang, "Pemasok-1"));
        executor.execute(new Pemasok(gudang, "Pemasok-2"));

        // Jalankan kurir
        executor.execute(new Kurir(gudang, "Kurir-1"));
        executor.execute(new Kurir(gudang, "Kurir-2"));
        executor.execute(new Kurir(gudang, "Kurir-3"));

        try {
            Thread.sleep(15000); // Biarkan sistem berjalan 15 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n--- Waktu Habis, Menghentikan Sistem ---");
        executor.shutdownNow(); // Paksa berhenti agar thread yang sleep langsung ke interrupt
        monitor.interrupt();

        try {
            executor.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Program selesai dengan aman.");
    }
}