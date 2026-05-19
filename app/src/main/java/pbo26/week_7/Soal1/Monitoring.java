public class Monitoring implements Runnable {
    private Gudang gudang;

    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int stok = gudang.getStok();
                int kapasitas = gudang.getKapasitasMaksimal();
                double persentase = (double) stok / kapasitas * 100;

                int jumlahHash = (int) (persentase / 10);
                StringBuilder visual = new StringBuilder("[");
                for (int i = 0; i < 10; i++) {
                    if (i < jumlahHash) visual.append("#");
                    else visual.append("-");
                }
                visual.append("]");

                System.out.printf("Status Gudang: %s %.0f%%\n", visual.toString(), persentase);
                Thread.sleep(1000); // Muncul setiap 1 detik
            }
        } catch (InterruptedException e) {
            System.out.println("Monitoring dihentikan.");
        }
    }
}