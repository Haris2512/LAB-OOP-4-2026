public class Pemain {
    String namaPemain;
    int skor;
    Tempat tempatSembunyi;

    public Pemain(Object s2){
        this.namaPemain = "abdul";
        this.skor = 0;
        this.tempatSembunyi = new Tempat();
    }

    public Pemain(String np, int s, Tempat ts){
        this.namaPemain = np;
        this.skor = s;
        this.tempatSembunyi = ts;
    }

    public void sembunyi(){
        System.out.println(namaPemain + " bersembunyi di " + tempatSembunyi.namaTempat);
    }
    public void cari(Pemain target){
        System.out.println(namaPemain + " mencari " + target.namaPemain);

        if(this.tempatSembunyi.tingkatKeamanan > target.tempatSembunyi.tingkatKeamanan){
            System.out.println("di temukan");
            this.skor +=5;
            System.out.println("skor bertambah = "+ this.skor);
        } else {
            System.out.println("tidak di temukan");
            this.skor -=1;
            System.out.println("skor berkurang = "+ this.skor);
        }
        
    }   
}
