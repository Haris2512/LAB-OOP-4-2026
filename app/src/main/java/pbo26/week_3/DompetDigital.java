public class DompetDigital {

    private String pin;          
    private double saldo;        

    protected String idNasabah; 
    String statusAkun;           

    public DompetDigital(String idNasabah, String pin) {
        this.idNasabah = idNasabah;
        this.pin = pin;
        this.saldo = 0; 
        this.statusAkun = "Aktif";
    }

    public String getIdNasabah() {
        return idNasabah;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setPin(String pinLama, String pinBaru) {
        if (!this.pin.equals(pinLama)) {
            System.out.println("PIN lama salah!");
        } else if (pinBaru.length() != 6) {
            System.out.println("PIN baru harus 6 karakter!");
        } else {
            this.pin = pinBaru;
            System.out.println("PIN berhasil diubah!");
        }
    }

    public void setor(double jumlah) {
        if (jumlah <= 0) {
            logTransaksi("Setor gagal: nominal tidak valid");
            System.out.println("Nominal tidak boleh negatif atau nol!");
        } else {
            saldo += jumlah;
            logTransaksi("Setor berhasil: +" + jumlah);
            System.out.println("Setor berhasil!");
        }
    }

    public void tarik(double jumlah, String inputPin) {
        if (!this.pin.equals(inputPin)) {
            logTransaksi("Tarik gagal: PIN salah");
            System.out.println("PIN salah!");
        } else if (jumlah <= 0) {
            logTransaksi("Tarik gagal: nominal tidak valid");
            System.out.println("Nominal tidak valid!");
        } else if (saldo < jumlah) {
            logTransaksi("Tarik gagal: saldo tidak cukup");
            System.out.println("Saldo tidak cukup!");
        } else {
            saldo -= jumlah;
            logTransaksi("Tarik berhasil: -" + jumlah);
            System.out.println("Tarik tunai berhasil!");
        }
    }

    
    private void logTransaksi(String pesan) {
        System.out.println("[LOG] " + pesan);
    }
}