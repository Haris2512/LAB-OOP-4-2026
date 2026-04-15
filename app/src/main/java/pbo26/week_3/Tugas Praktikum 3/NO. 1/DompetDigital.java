class DompetDigital {

    // ===== ATRIBUT =====
    private double saldo;        // data rahasia
    private String pin;          // data rahasia

    protected String idNasabah;  // bisa dipakai turunan

    String namaAplikasi = "E-WalletKu"; // default (package)

    // ===== CONSTRUCTOR =====
    public DompetDigital(String idNasabah, String pin) {
        this.idNasabah = idNasabah;
        this.pin = pin;
        this.saldo = 0; // saldo otomatis 0
    }

    // ===== GETTER (yang aman saja) =====
    public String getIdNasabah() {
        return idNasabah;
    }

    public double getSaldo() {
        return saldo;
    }

    // ===== SETTER (ubah PIN dengan validasi) =====
    public void ubahPin(String pinLama, String pinBaru) {
        if (!this.pin.equals(pinLama)) {
            System.out.println("❌ PIN lama salah!");
            logTransaksi("Gagal ubah PIN");
        } else if (pinBaru.length() != 6) {
            System.out.println("❌ PIN baru harus 6 digit!");
            logTransaksi("Gagal ubah PIN");
        } else {
            this.pin = pinBaru;
            System.out.println("✅ PIN berhasil diubah!");
            logTransaksi("Berhasil ubah PIN");
        }
    }

    // ===== SETOR TUNAI =====
    public void setor(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("❌ Nominal tidak valid!");
            logTransaksi("Gagal setor");
        } else {
            saldo += jumlah;
            System.out.println("✅ Berhasil setor: " + jumlah);
            logTransaksi("Setor berhasil");
        }
    }

    // ===== TARIK TUNAI =====
    public void tarik(double jumlah, String pinInput) {
        if (!this.pin.equals(pinInput)) {
            System.out.println("❌ PIN salah!");
            logTransaksi("Gagal tarik (PIN salah)");
        } else if (jumlah > saldo) {
            System.out.println("❌ Saldo tidak cukup!");
            logTransaksi("Gagal tarik (saldo kurang)");
        } else {
            saldo -= jumlah;
            System.out.println("✅ Berhasil tarik: " + jumlah);
            logTransaksi("Tarik berhasil");
        }
    }

    // ===== METHOD INTERNAL (PRIVATE) =====
    private void logTransaksi(String pesan) {
        System.out.println("[LOG]: " + pesan);
    }
}