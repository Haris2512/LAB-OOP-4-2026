package Soal2;

import java.util.concurrent.*;

public class Main2 {
    public static void main(String[] args) {

        String[] dokumen = {
                "Dokumen01.txt",
                "Dokumen02.txt",
                "Dokumen03.txt",
                "Dokumen04.txt",
                "Dokumen05.txt",
                "Dokumen06.txt",
                "Dokumen07.txt",
                "Dokumen08.txt",
                "Dokumen09.txt",
                "Dokumen10.txt"
        };

        ExecutorService executor = Executors.newFixedThreadPool(4);

        ConcurrentHashMap<String, Integer> hasilMap = new ConcurrentHashMap<>();

        String[] threadNama = new String[dokumen.length];
        long[] durasiProses = new long[dokumen.length];

        // CountDownLatch untuk memastikan program utama menunggu seluruh proses selesai 
        CountDownLatch latch = new CountDownLatch(dokumen.length);

        DataProcessor processor = new DataProcessor();

        for (int i = 0; i < dokumen.length; i++) {
            int index = i;
            String file = dokumen[i];

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    long mulai = System.currentTimeMillis();

                    // Memproses dokumen 
                    int jumlahKata = processor.process(file);

                    long selesai = System.currentTimeMillis();
                    long durasi = selesai - mulai;

                    // Simpan data ke koleksi
                    hasilMap.put(file, jumlahKata);
                    threadNama[index] = Thread.currentThread().getName();
                    durasiProses[index] = durasi;

                    // proogres real-time mencantumkan jumlah kata
                    System.out.println("[" + threadNama[index] + "] selesai memproses " + file + " (" + jumlahKata + " kata)");

                    latch.countDown();
                }
            });
        }

        try {
            latch.await(); // menunggu sinkronisasi seluruh thread 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n========================================================================");
        System.out.printf("%-15s | %-18s | %-15s | %-10s\n", "Nama Dokumen", "Thread", "Durasi Proses", "Jumlah Kata");
        System.out.println("------------------------------------------------------------------------");

        int totalKata = 0;
        long totalDurasi = 0;

        for (int i = 0; i < dokumen.length; i++) {
            String file = dokumen[i];
            String thread = threadNama[i];
            long durasi = durasiProses[i];
            int jumlah = hasilMap.get(file);

            System.out.printf("%-15s | %-18s | %-12d ms | %-10d\n", file, thread, durasi, jumlah);

            totalKata += jumlah;
            totalDurasi += durasi;
        }

        System.out.println("========================================================================");

        System.out.println("Total Kata Keseluruhan : " + totalKata + " kata");
        System.out.printf("Rata-rata Waktu Proses : %.2f ms \n", (double) totalDurasi / dokumen.length);

        executor.shutdown();
    }
}