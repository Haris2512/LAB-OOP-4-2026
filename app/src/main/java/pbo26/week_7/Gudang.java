public class Gudang {

    private int stok;
    private final int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal) {
        this.kapasitasMaksimal = kapasitasMaksimal;
        this.stok = 0;
    }

    public synchronized void tambahStok(int jumlah)
            throws InterruptedException {

        while (stok + jumlah > kapasitasMaksimal) {

            System.out.println(
                    Thread.currentThread().getName()
                            + " menunggu (gudang penuh)"
            );

            wait();
        }

        stok += jumlah;

        System.out.println(
                Thread.currentThread().getName()
                        + " menambah stok: "
                        + jumlah
                        + " | Total: "
                        + stok
        );

        notifyAll();
    }

    public synchronized void ambilStok(int jumlah)
            throws InterruptedException {

        while (stok - jumlah < 0) {

            System.out.println(
                    Thread.currentThread().getName()
                            + " menunggu (stok kosong)"
            );

            wait();
        }

        stok -= jumlah;

        System.out.println(
                Thread.currentThread().getName()
                        + " mengambil stok: "
                        + jumlah
                        + " | Sisa: "
                        + stok
        );

        notifyAll();
    }

    public synchronized int getStok() {
        return stok;
    }

    public int getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }
}