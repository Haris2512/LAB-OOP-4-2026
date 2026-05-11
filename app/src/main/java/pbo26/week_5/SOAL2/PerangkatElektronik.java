

abstract class PerangkatElektronik {
    protected String merk;
    protected int DayaListrik;

    public PerangkatElektronik(String merk, int DayaListrik) {
        this.merk = merk;
        this.DayaListrik = DayaListrik;

    }
    
    public void InfoPower(){
        System.out.println("Menggunakan daya sebesar " + DayaListrik + " Watt");
    }

    public abstract void CekFungsi();
    
}

interface InteraksiInternet {
    void HubungkanWifi();

}

interface KontrolSuara {
    void ProsesPrintah(String Printah);

    
}

class SmartLamp extends PerangkatElektronik implements KontrolSuara{
    public SmartLamp (String mrek, int DayaListrik){
        super(mrek, DayaListrik);
 
    }

    @Override
    public void CekFungsi(){
        System.out.println("Lampu pintar siap di gunakan"); 

    }

    @Override
    public void ProsesPrintah(String Printah){
        if (Printah.equalsIgnoreCase("NYAKA")){
            System.out.println("Lampu berpijar!");
        }
    }
}

class SmartCCTV extends PerangkatElektronik implements InteraksiInternet{
    public SmartCCTV(String merk, int DayaListrik){
        super(merk, DayaListrik);
    }

    @Override
    public void CekFungsi(){
        System.out.println("CCTV aktif memantau");

    }
    @Override
    public void HubungkanWifi(){
        System.out.println("Mengirim data ke server...");
    }

}

class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara{

    public SmartSpeaker(String merk, int DayaListrik){
        super(merk, DayaListrik);
    }
    @Override
    public void CekFungsi(){
        System.out.println("ini berfungsi");
    }
    @Override
    public void HubungkanWifi(){
        System.out.println("Speaker terhubung ke WIFI");
    }
    @Override
    public void ProsesPrintah(String Printah){
        System.out.println("Memproses perintah "+ Printah);
    }
}
