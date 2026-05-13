class Bangundatar{
    String nama;

    public Bangundatar(String nama){
        this.nama = nama;
    }
    public double hitungluas(){
        return 0;
    }
    public double hitungkeliling(){
        return 0;
    }
}

class Persegi extends Bangundatar {
    double sisi;

    public Persegi(double sisi){
        super("persegi");
        this.sisi = sisi;
    }
    public double hitungluas(){
        return sisi * sisi;
    }
    public double hitungkeliling(){
        return 4 * sisi;
    }
}

class Persegipanjang extends Bangundatar{
    double panjang, lebar;

    public Persegipanjang(double panjang, double lebar) {
        super("persegi_panjang");
        this.panjang = panjang;
        this.lebar = lebar;
    }
    public double hitungluas(){
        return panjang * lebar;
    }
    public double hitungkeliling(){
        return 2 * (panjang + lebar);
    }   
}

class Lingkaran extends Bangundatar{
    double jarijari;

    public Lingkaran(double jarijari) {
        super("lingkaran");
        this.jarijari = jarijari;
    }
    public double hitungluas(){
        return Math.PI * jarijari * jarijari;
    }
    public double hitungkeliling(){
        return 2 * Math.PI * jarijari;
    }
}

class Trapesium extends Bangundatar{
    double sisi1, sisi2, sisi3, sisi4, tinggi;

    public Trapesium(double sisi1, double sisi2, double sisi3, double sisi4, double tinggi) {
        super("trapesium");
        this.sisi1 = sisi1;
        this.sisi2 = sisi2;
        this.sisi3 = sisi3;
        this.sisi4 = sisi4;
        this.tinggi = tinggi;
    }
    public double hitungluas(){
        return (sisi1 + sisi2) * tinggi / 2;
    }
    public double hitungkeliling(){
        return sisi1 + sisi2 + sisi3 + sisi4;
    }
}