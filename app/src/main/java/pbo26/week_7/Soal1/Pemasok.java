package Soal1;

import java.util.Random;

public class Pemasok implements Runnable {
    Gudang gudang;
    Random random;
    boolean running;

    public Pemasok(Gudang gudang) {
        this.gudang = gudang;
        random = new Random();
        running = true;
    }

    public void stopThread() {
        running = false;
    }

    public void run() {
        while (running) {
            int jumlah = random.nextInt(5) + 1;
            gudang.tambahStok(jumlah);

            try {
                Thread.sleep(random.nextInt(1001) + 1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}