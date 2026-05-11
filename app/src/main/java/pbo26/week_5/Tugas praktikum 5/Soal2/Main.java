package Soal2;

abstract class PerangkatElektronik {
    String merk;
    int dayaListrik;

    public PerangkatElektronik(String merk, int dayaListrik) {
        this.merk = merk;
        this.dayaListrik = dayaListrik;
    }

    abstract void cekFungsi();

    void infoPower() {
        System.out.println("Perangkat " + merk + " sedang menyedot daya sebesar " + dayaListrik + " Watt.");
    }
}

interface InteraksiInternet {
    void hubungkanWiFi();
}

interface KontrolSuara {
    void prosesPerintah(String perintah);
}


class SmartLamp extends PerangkatElektronik implements KontrolSuara {
    
    public SmartLamp(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    void cekFungsi() {
        System.out.println("Fungsi: Lampu pintar untuk penerangan ruangan.");
    }

    @Override
    public void prosesPerintah(String perintah) {
        if (perintah.equalsIgnoreCase("NYALA")) {
            System.out.println("Lampu berpijar!");
        } else {
            System.out.println("Perintah tidak dikenali.");
        }
    }
}


class SmartCCTV extends PerangkatElektronik implements InteraksiInternet {

    public SmartCCTV(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    void cekFungsi() {
        System.out.println("Fungsi: Kamera pengawas pintar.");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("Mengirim data ke server...");
    }
}


class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara {

    public SmartSpeaker(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    void cekFungsi() {
        System.out.println("Fungsi: Speaker pintar dan asisten virtual.");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("SmartSpeaker berhasil terhubung ke WiFi rumah.");
    }

    @Override
    public void prosesPerintah(String perintah) {
        System.out.println("SmartSpeaker merespon perintah: " + perintah);
    }
}


public class Main {
    public static void main(String[] args) {
        SmartLamp lampu = new SmartLamp("Philips", 12);
        SmartCCTV cctv = new SmartCCTV("Panasonic", 15);
        SmartSpeaker speaker = new SmartSpeaker("Jb", 10);

        System.out.println("===== SmartLamp =====");
        lampu.infoPower();
        lampu.cekFungsi();
        lampu.prosesPerintah("NYALA"); 

        System.out.println("\n===== SmartCCTV =====");
        cctv.infoPower();
        cctv.cekFungsi();
        cctv.hubungkanWiFi(); 

        System.out.println("\n===== SmartSpeaker =====");
        speaker.infoPower();                   
        speaker.cekFungsi();                   
        speaker.hubungkanWiFi();               
        speaker.prosesPerintah("Putar Musik"); 
    }
}
