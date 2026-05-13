package Soal1;

public class Monitoring extends Thread {
    Gudang gudang;
    boolean running;

    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
        running = true;
    }

    public void stopThread() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            int stok = gudang.stok;
            int kapasitas = gudang.kapasitasMaksimal;

            int persen =
                    (stok * 100) / kapasitas;

            String bar = "";
            for (int i = 1; i <= 10; i++) {
                if (i <= persen / 10) {
                    bar += "#";
                } else {
                    bar += "-";
                }
            }
            System.out.println("Status Gudang: [" + bar + "] " + persen + "%");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}