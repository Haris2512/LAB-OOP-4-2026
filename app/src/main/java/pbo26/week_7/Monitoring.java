public class Monitoring implements Runnable {

    private final Gudang gudang;

    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {

        try {

            while (true) {

                int kapasitas =
                        gudang.getKapasitasMaksimal();

                int isi =
                        gudang.getStok();

                int persen =
                        (isi * 100) / kapasitas;

                int filledBars =
                        persen / 10;

                int emptyBars =
                        10 - filledBars;

                StringBuilder bar =
                        new StringBuilder("[");

                for (int i = 0; i < filledBars; i++) {
                    bar.append("#");
                }

                for (int i = 0; i < emptyBars; i++) {
                    bar.append("-");
                }

                bar.append("] ")
                        .append(persen)
                        .append("%");

                System.out.println(
                        "Status Gudang: " + bar
                );

                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }
    }
}