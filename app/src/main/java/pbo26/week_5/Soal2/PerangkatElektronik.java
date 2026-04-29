abstract class PerangkatElektronik {
    protected String merk;
    protected int dayaListrik;

    public PerangkatElektronik(String merk, int dayaListrik) {
        this.merk = merk;
        this.dayaListrik = dayaListrik;
    }

    public void infoPower() {
        System.out.println("Daya: " + dayaListrik + " Watt");
    }

    public abstract void cekFungsi();
}