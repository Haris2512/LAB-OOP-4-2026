package no1;

public class DompetDigital {
    String userId; 
    protected String nama;
    private double saldo;
    private String pin;

    public DompetDigital(String userId, String nama, String pin) { 
        this.nama = nama;
        this.pin = pin;
        this.saldo = 0;
        this.userId = userId;
    }
    // getter untuk data aman
    public String getUserId() {
        return userId;
    }

    public String getNama() {
        return nama;
    }

    public double getSaldo() {
        return saldo;
    }

    // pakai setter untuk ubah pin, tapi tidak boleh pakai get
    public void setPin(String pinLama, String pinBaru) {
        if (!pin.equals(pinLama)) {
            System.out.println("PIN lama salah!\n");
        } else if (pinBaru.length() != 6) {
            System.out.println("PIN harus 6 digit!");
        } else {
            pin = pinBaru;
            System.out.println("PIN berhasil diubah");
            log("Ubah PIN");
        }
    }

    // method transaksi 1 (setor + validasi jumlah)
    public void setor(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("Jumlah tidak valid!");
            log("Setor gagal");
        } else {
            saldo += jumlah;
            System.out.println("Setor berhasil");
            log("Setor " + jumlah);
        }
    }

    // method transaksi 2 (tarik + validasi PIN + validasi saldo)
    public void tarik(String inputPin, double jumlah) {
        if (!pin.equals(inputPin)) {
            System.out.println("PIN salah!");
            log("Tarik gagal (PIN salah)");
        } else if (jumlah > saldo) {
            System.out.println("Saldo tidak cukup!");
            log("Tarik gagal (saldo kurang)");
        } else {
            saldo -= jumlah;
            System.out.println("Tarik berhasil");
            log("Tarik " + jumlah);
        }
    }

    // method internal private untuk log aktivitas
    private void log(String pesan) {
        System.out.println("LOG: " + pesan + "\n");
    }
}