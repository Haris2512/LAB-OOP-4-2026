import java.util.Scanner;

class Smartlamp extends Perangkatelektronik implements Kontrolsuara{
    Scanner x = new Scanner(System.in);
    public Smartlamp(String merk, double dayalistrik) {
        super(merk, dayalistrik);
    }

    @Override
    public void cekfungsi(){
        System.out.println("Lampu berfungsi dengan baik");
    }
    @Override
    public void prosesperintah(String perintah){
        System.out.print("Mau di nyalakan/dimatikan? (NYALA/MATI):");
        perintah = x.nextLine();
        if (perintah.equalsIgnoreCase("NYALA")){
            System.out.println("Lampu menyala");
            infopower();
        }else if (perintah.equalsIgnoreCase("MATI")){
            System.out.println("Lampu mati");
        }else{
            System.out.println("Perintah tidak valid");
        }
    }
}
