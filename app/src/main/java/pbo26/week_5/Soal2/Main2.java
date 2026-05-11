package Soal2;

public class Main2 {
    public static void main(String[] args) {

        SmartLamp lamp = new SmartLamp("Philips", 10);
        lamp.cekFungsi();
        lamp.prosesPerintah("nyalant");


        SmartCCTV cctv = new SmartCCTV("Xiaomi", 15);
        cctv.cekFungsi();
        cctv.hubungkanWiFi();

        SmartSpeaker speaker = new SmartSpeaker("Google", 20);
        speaker.cekFungsi();
        speaker.hubungkanWiFi();
        speaker.prosesPerintah("PLAY MUSIC");
    }
}
