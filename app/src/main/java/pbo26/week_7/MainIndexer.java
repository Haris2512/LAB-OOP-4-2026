import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainIndexer {

    public static void main(String[] args)
            throws InterruptedException {

        ExecutorService executor =
                Executors.newFixedThreadPool(4);

        ConcurrentHashMap<String, Integer> hasilMap =
                new ConcurrentHashMap<>();

        List<HasilDokumen> hasilList =
                Collections.synchronizedList(
                        new ArrayList<>()
                );

        String[] dokumen = {
                "Dokumen_A.txt",
                "Dokumen_B.txt",
                "Dokumen_C.txt",
                "Dokumen_D.txt",
                "Dokumen_E.txt",
                "Dokumen_F.txt",
                "Dokumen_G.txt",
                "Dokumen_H.txt",
                "Dokumen_I.txt",
                "Dokumen_J.txt"
        };

        CountDownLatch latch =
                new CountDownLatch(dokumen.length);

        DataProcessor processor =
                new DataProcessor();

        for (String doc : dokumen) {

            executor.execute(() -> {

                try {

                    long start =
                            System.currentTimeMillis();

                    int jumlahKata =
                            processor.process(doc);

                    long end =
                            System.currentTimeMillis();

                    long durasi =
                            end - start;

                    hasilMap.put(
                            doc,
                            jumlahKata
                    );

                    String namaThread =
                            Thread.currentThread()
                                    .getName();

                    hasilList.add(
                            new HasilDokumen(
                                    doc,
                                    namaThread,
                                    jumlahKata,
                                    durasi
                            )
                    );

                    System.out.println(
                            "[" + namaThread + "] "
                                    + "Selesai memproses "
                                    + doc
                                    + " ("
                                    + jumlahKata
                                    + " kata)"
                    );

                } catch (InterruptedException e) {

                    Thread.currentThread()
                            .interrupt();

                } finally {

                    latch.countDown();
                }
            });
        }

        latch.await();

        executor.shutdown();

        System.out.println(
                "\n===== HASIL AKHIR ====="
        );

        int totalKata = 0;

        long totalDurasi = 0;

        System.out.printf(
                "%-20s %-20s %-15s %-15s\n",
                "Dokumen",
                "Thread",
                "Jumlah Kata",
                "Durasi(ms)"
        );

        for (HasilDokumen h : hasilList) {

            System.out.printf(
                    "%-20s %-20s %-15d %-15d\n",
                    h.namaDokumen,
                    h.namaThread,
                    h.jumlahKata,
                    h.durasi
            );

            totalKata += h.jumlahKata;

            totalDurasi += h.durasi;
        }

        double rataRata =
                (double) totalDurasi
                        / hasilList.size();

        System.out.println(
                "\nTotal Kata Keseluruhan : "
                        + totalKata
        );

        System.out.println(
                "Rata-rata Waktu Proses : "
                        + rataRata
                        + " ms"
        );
    }
}