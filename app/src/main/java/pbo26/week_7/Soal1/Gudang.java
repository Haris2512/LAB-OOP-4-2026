public class Gudang {
    private int stok = 0;
    private int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal) {
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    public synchronized void tambahStok(int jumlah, String namaThread) throws InterruptedException {
        while (stok + jumlah > kapasitasMaksimal) {
            wait();
        }
        stok += jumlah;
        System.out.println(namaThread + " menambah " + jumlah + " barang. Stok sekarang: " + stok);
        notifyAll();
    }

    public synchronized void ambilStok(int jumlah, String namaThread) throws InterruptedException {
        while (stok < jumlah) {
            wait();
        }
        stok -= jumlah;
        System.out.println(namaThread + " mengambil " + jumlah + " barang. Stok sekarang: " + stok);
        notifyAll();
    }

    public synchronized int getStok() {
        return stok;
    }

    public int getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }
}