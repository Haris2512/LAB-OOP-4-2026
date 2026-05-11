public class DompetDigital {
   
    private double saldo;            
    private String pin;
    protected String idNasabah; 
    String namaPemilik;   

    
    public DompetDigital(String idNasabah, String nama, String pinAwal) {
        this.idNasabah = idNasabah;
        this.namaPemilik = nama;
        this.pin = pinAwal;
        this.saldo = 0;              
    }

    
    public String getIdNasabah() {                               //GETTER
        return idNasabah;            
    }

    public String getNamaPemilik() {
        return namaPemilik;          
    }

    
    public void ubahPin(String pinLama, String pinBaru) {         // SETTER
        if (this.pin.equals(pinLama)) { 
            if (pinBaru.length() == 6) {
                this.pin = pinBaru;
                catatLog("PIN berhasil diperbarui.");
            } else {
                catatLog("Gagal: PIN baru harus 6 karakter.");
            }
        } else {
            catatLog("Gagal: PIN lama salah.");
        }
    }

    
    public void setorTunai(double jumlah) {
        if (jumlah > 0) {           
            this.saldo += jumlah;
            System.out.println("Setor berhasil: Rp" + jumlah);
        } else {
            catatLog("Setor gagal: Nominal tidak valid.");
        }
    }

    public void tarikTunai(double jumlah, String inputPin) {
       
        if (!this.pin.equals(inputPin)) { //di bandingkan
            catatLog("Tarik gagal: PIN salah.");
        } else if (jumlah > saldo) {
            catatLog("Tarik gagal: Saldo tidak mencukupi.");
        } else {
            this.saldo -= jumlah;
            catatLog("Tarik berhasil: Rp" + jumlah);
        }
    }

    
    private void catatLog(String pesan) { 
        System.out.println("[LOG SISTEM]: " + pesan);
    }

    
    public double getSisaSaldo() {
        return saldo;
    }
}