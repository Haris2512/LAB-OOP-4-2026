

public class Main {
    public static void main(String[] args) {
        SmartLamp Lamp = new SmartLamp("Philips", 10);
        Lamp.CekFungsi();
        Lamp.ProsesPrintah("NYALA");
        Lamp.InfoPower();
        SmartCCTV Cctv = new SmartCCTV("Xiomi", 20);
        Cctv.CekFungsi();
        Cctv.HubungkanWifi();
        Cctv.InfoPower();
        SmartSpeaker Speaker = new SmartSpeaker("Apple", 20);
        Speaker.CekFungsi();
        Speaker.HubungkanWifi();
        Speaker.ProsesPrintah("Putar musik");
        Speaker.InfoPower();

    }
}