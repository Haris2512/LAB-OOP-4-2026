package Soal1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main1 {
    public static void main(String[] args) {

        Gudang gudang = new Gudang(20);

        Pemasok pemasok1 = new Pemasok(gudang);
        Pemasok pemasok2 = new Pemasok(gudang);

        Kurir kurir1 = new Kurir(gudang);
        Kurir kurir2 = new Kurir(gudang);
        Kurir kurir3 = new Kurir(gudang);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.execute(pemasok1);
        executor.execute(pemasok2);
        executor.execute(kurir1);
        executor.execute(kurir2);
        executor.execute(kurir3);

        Monitoring monitor = new Monitoring(gudang);

        monitor.start();

        try {
            Thread.sleep(15000);

            pemasok1.stopThread();
            pemasok2.stopThread();

            kurir1.stopThread();
            kurir2.stopThread();
            kurir3.stopThread();

            monitor.stopThread();

            executor.shutdown();

            executor.awaitTermination(
                    5,
                    TimeUnit.SECONDS
            );

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Program selesai");
    }
}