package Soal1;

public class Gudang {
    int stok;
    int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal) {
        this.kapasitasMaksimal = kapasitasMaksimal;
        stok = 0;
    }

    public synchronized void tambahStok(int jumlah) {
        while (stok + jumlah > kapasitasMaksimal) {
            try {
                System.out.println("Gudang penuh, pemasok menunggu...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        stok += jumlah;
        System.out.println("Tambah " + jumlah + " | stok = " + stok);

        notifyAll();
    }

    public synchronized void ambilStok(int jumlah) {
        while (stok < jumlah) {
            try {
                System.out.println("Stok tidak cukup, kurir menunggu...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        stok -= jumlah;
        System.out.println("Ambil " + jumlah + " | stok = " + stok);

        notifyAll();
    }

}