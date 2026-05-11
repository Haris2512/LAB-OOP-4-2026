import java.util.Scanner;
class Smartspeaker extends Perangkatelektronik implements Interaksiinternet,Kontrolsuara {
    Scanner x = new Scanner (System.in);
    public Smartspeaker(String merk, double dayalistrik) {
        super(merk, dayalistrik);
    }
    
    @Override
    public void cekfungsi(){
        System.out.println("Speaker berfungsi baik");
    }

    @Override
    public void hubungkanwifi(){
        System.out.println("Menghubungkan....");
    }

    @Override
    public void prosesperintah(String perintah){
        System.out.print("Mau dihidupkan/dimatikan? (HIDUP/MATI): ");
        perintah = x.nextLine();
        if (perintah.equalsIgnoreCase("HIDUP")){
            System.out.println("Speaker hidup");
            infopower();
        }else if (perintah.equalsIgnoreCase("MATI")){
            System.out.println("Speaker mati");
        }else{
            System.out.println("Perintah tidak valid");
        }
    }
}
