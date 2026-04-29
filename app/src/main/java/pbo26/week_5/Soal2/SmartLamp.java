package Soal2;

class SmartLamp extends PerangkatElektronik implements KontrolSuara {

    public SmartLamp(String merk, int daya) {
        super(merk, daya);
    }

    @Override
    public void cekFungsi() {
        System.out.println("\nLampu siap digunakan");
    }

    @Override
    public void prosesPerintah(String perintah) {
        if (perintah.equalsIgnoreCase("NYALA")) {
            System.out.println("Lampu berpijar!");
            infoPower();
        }
    }
}
