import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainGudang {

    public static void main(String[] args)
            throws InterruptedException {

        Gudang gudang =
                new Gudang(20);

        ExecutorService pool =
                Executors.newFixedThreadPool(5);

        pool.submit(new Pemasok(gudang));
        pool.submit(new Pemasok(gudang));

        pool.submit(new Kurir(gudang));
        pool.submit(new Kurir(gudang));
        pool.submit(new Kurir(gudang));

        Thread monitor =
                new Thread(new Monitoring(gudang));

        monitor.start();

        Thread.sleep(15000);

        pool.shutdownNow();

        monitor.interrupt();

        pool.awaitTermination(
                3,
                TimeUnit.SECONDS
        );

        System.out.println(
                "\nSistem berhenti dengan aman."
        );
    }
}