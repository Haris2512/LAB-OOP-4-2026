import java.util.Scanner;
public class Run {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int pilihan;
        System.out.println("============ Bangun Ruang =============");
        System.out.println("1.Kubus");
        System.out.println("2.Balok");
        System.out.println("3.Bola");
        System.out.println("4.Tabung");
        System.out.println("=========== Bangun Datar ==============");
        System.out.println("5.Persegi");
        System.out.println("6.Persegi Panjang");
        System.out.println("7.Lingkaran");
        System.out.println("8.Trapesium");
        System.out.print("Masukkan Pilihan : ");
        pilihan = x.nextInt();

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan sisi = ");
                Kubus k = new Kubus(x.nextDouble());
                System.out.println("Luas Permukaan : "+ k.hitungluaspermukaan());
                System.out.println("Volume : "+ k.hitungvolume());
                break;
            case 2:
                System.out.print("Masukkan panjang = "); double panjang = x.nextDouble();
                System.out.print("Masukkan lebar = "); double lebar = x.nextDouble();
                System.out.print("Masukkan tinggi = "); double tinggi = x.nextDouble();
                Balok b = new Balok(panjang, lebar, tinggi);
                System.out.println("Luas Permukaan : "+ b.hitungluaspermukaan());
                System.out.println("Volume : "+ b.hitungvolume());
                break;
            case 3:
                System.out.print("Masukkan Jari Jari = ");
                Bola bl = new Bola(x.nextDouble());
                System.out.println("Luas Permukaan : "+ bl.hitungluaspermukaan());
                System.out.println("Volume : "+ bl.hitungvolume());
                break;
            case 4:
                System.out.print("Masukkan Jari Jari = "); double jarijari = x.nextDouble();
                System.out.print("Masukkan Tinggi = "); double tinggi1 = x.nextDouble();
                Tabung tb = new Tabung(jarijari, tinggi1);
                System.out.println("Luas Permukaan : "+ tb.hitungluaspermukaan());
                System.out.println("Volume : "+ tb.hitungvolume());
                break;
            case 5:
                System.out.print("Masukkan Sisi = ");
                Persegi pr = new Persegi(x.nextDouble());
                System.out.println("Luas : "+ pr.hitungluas());
                System.out.println("Keliling : "+ pr.hitungkeliling());
                break;
            case 6:
                System.out.print("Masukkan Panjang = "); double panjang1 = x.nextDouble(); 
                System.out.print("Masukkan Lebar = "); double lebar1 = x.nextDouble(); 
                Persegipanjang prp = new Persegipanjang(panjang1, lebar1);
                System.out.println("Luas : "+ prp.hitungluas());
                System.out.println("Keliling : "+ prp.hitungkeliling());
                break;
            case 7:
                System.out.print("Masukkan Jari Jari = ");
                Lingkaran lk = new Lingkaran(x.nextDouble());
                System.out.println("Luas : "+ lk.hitungluas());
                System.out.println("Keliling :"+ lk.hitungkeliling());
                break;
            case 8:
                System.out.print("Masukkan Sisi 1 = "); double sisi1 = x.nextDouble();
                System.out.print("Masukkan Sisi 2 = "); double sisi2 = x.nextDouble();
                System.out.print("Masukkan Sisi 3 = "); double sisi3 = x.nextDouble();
                System.out.print("Masukkan Sisi 4 = "); double sisi4 = x.nextDouble();
                System.out.print("Masukkan Tinggi = "); double tinggi2 = x.nextDouble();
                Trapesium trp = new Trapesium(sisi1, sisi2, sisi3, sisi4, tinggi2);
                System.out.println("Luas : "+ trp.hitungluas());
                System.out.println("Keliling : "+ trp.hitungkeliling());
                break;
            default:
                break;
        }
    }
}