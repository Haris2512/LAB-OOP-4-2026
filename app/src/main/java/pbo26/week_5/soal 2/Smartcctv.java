class Smartcctv extends Perangkatelektronik implements Interaksiinternet {

    public Smartcctv(String merk, double dayalistrik) {
        super(merk, dayalistrik);
    }
    @Override
    public void cekfungsi(){
        System.out.println("CCTV berfungsi baik");
    }
    @Override
    public void hubungkanwifi(){
        System.out.println("Mengirim data ke server.....");
    }
    
}
