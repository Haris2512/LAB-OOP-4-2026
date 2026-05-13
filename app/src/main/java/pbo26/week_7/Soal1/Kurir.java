package Soal1;

import java.util.Random;

public class Kurir implements Runnable {
    Gudang gudang;
    Random random;
    boolean running;

    public Kurir(Gudang gudang) {
        this.gudang = gudang;
        random = new Random();
        running = true;
    }

    public void stopThread() {
        running = false;
    }

    public void run() {
        while (running) {
            int jumlah = random.nextInt(4) + 1;
            gudang.ambilStok(jumlah);

            try {
                Thread.sleep(random.nextInt(1001) + 2000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}