public abstract class Perangkatelektronik{
    String merk;
    double dayalistrik;

    public Perangkatelektronik(String merk, double dayalistrik) {
        this.merk = merk;
        this.dayalistrik = dayalistrik;
    }

    public abstract void cekfungsi();

    public void infopower(){
        System.out.println("Sedang menyedot daya sebesar "+dayalistrik+ " watt");
    }
}