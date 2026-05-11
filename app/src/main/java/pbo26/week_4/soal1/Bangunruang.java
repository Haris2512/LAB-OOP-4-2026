class Bangunruang {
    String nama;

    public Bangunruang(String nama){
        this.nama = nama;
    }
    public double hitungluaspermukaan(){
        return 0;
    }
    public double hitungvolume(){
        return 0;
    }
}

class Kubus extends Bangunruang{
    double sisi;

    public Kubus(double sisi){
        super("kubus");
        this.sisi = sisi;
    }
    public double hitungluaspermukaan(){
        return 6 * sisi * sisi;
    }
    public double hitungvolume(){
        return sisi * sisi * sisi;
    }
}

class Balok extends Bangunruang{
    double panjang, lebar, tinggi;

    public Balok(double panjang, double lebar, double tinggi) {
        super("balok");
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }
    public double hitungluaspermukaan(){
         return 2 * ((panjang * lebar)+(panjang * tinggi)+(lebar * tinggi));
    }
    public double hitungvolume(){
        return panjang * lebar * tinggi;
    }
    
}

class Bola extends Bangunruang{
    double jarijari;

    public Bola(double jarijari) {
        super("bola");
        this.jarijari = jarijari;
    }
    public double hitungluaspermukaan(){
        return 4 * Math.PI * jarijari * jarijari;
    }
    public double hitungvolume(){
        return (4.0 / 3.0) * Math.PI * Math.pow(jarijari, 3);
    }

}
class Tabung extends Bangunruang{
    double jarijari,tinggi;

    public Tabung(double jarijari, double tinggi) {
        super("tabung");
        this.jarijari = jarijari;
        this.tinggi = tinggi;
    }
    public double hitungluaspermukaan(){
        return 2 * Math.PI * jarijari * (jarijari + tinggi);
    }
    public double hitungvolume(){
        return Math.PI * jarijari * jarijari * jarijari * tinggi;
    }
    
}