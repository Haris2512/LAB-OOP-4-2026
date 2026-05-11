class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara {

    public SmartSpeaker(String merk, int daya) {
        super(merk, daya);
    }

    @Override
    public void cekFungsi() {
        System.out.println("Speaker pintar aktif");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("Speaker terhubung ke WiFi");
    }

    @Override
    public void prosesPerintah(String perintah) {
        System.out.println("Menjalankan perintah: " + perintah);
    }
}