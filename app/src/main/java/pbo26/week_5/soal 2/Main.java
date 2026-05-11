public class Main {
    public static void main(String[] args) {
        Smartlamp sl = new Smartlamp("Panasonic", 40);
        Smartcctv sc = new Smartcctv("LG", 35);
        Smartspeaker ss = new Smartspeaker("Robot", 27);

        System.out.println("=================================================");
        ss.cekfungsi();
        ss.hubungkanwifi();
        ss.prosesperintah(null);
        //ss.infopower();
        System.out.println("=================================================");
        sl.cekfungsi();
        //sl.hubungkanwifi();
        sl.prosesperintah("Nyala");
        //sl.infopower();
        System.out.println("=================================================");
        sc.cekfungsi();
        sc.hubungkanwifi();
        //sc.prosesperintah("Mati");
        sc.infopower();
        System.out.println("=================================================");
    }
}
