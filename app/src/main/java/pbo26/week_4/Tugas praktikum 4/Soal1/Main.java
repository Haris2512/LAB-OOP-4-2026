package Soal1;
import java.util.Scanner;
import Soal1.BangunDatar.*;
import Soal1.BangunRuang.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char ulang;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Persegi");
            System.out.println("2. Kubus");
            System.out.println("3. Persegi Panjang");
            System.out.println("4. Balok");
            System.out.println("5. Lingkaran");
            System.out.println("6. Tabung");
            System.out.println("7. Bola");
            System.out.print("Pilihan: ");
            int pilih = input.nextInt();

            switch (pilih) {
                case 1:
                    System.out.print("Masukkan sisi: ");
                    double s = input.nextDouble();
                    Persegi p = new Persegi(s);
                    System.out.println("Luas = " + p.luas());
                    System.out.println("Keliling = " + p.keliling());
                    break;
                    
                case 2:
                    System.out.print("Masukkan sisi: ");
                    s = input.nextDouble();
                    Kubus k = new Kubus(s);
                    System.out.println("Luas Permukaan = " + k.luasPermukaan());
                    System.out.println("Volume = " + k.volume());
                    break;
                    
                case 3:
                    System.out.print("Masukkan panjang: ");
                    double pj = input.nextDouble();
                    System.out.print("Masukkan lebar: ");
                    double lb = input.nextDouble();
                    PersegiPanjang pp = new PersegiPanjang(pj, lb);
                    System.out.println("Luas = " + pp.luas());
                    System.out.println("Keliling = " + pp.keliling());
                    break;
                        
                case 4:
                    System.out.print("Masukkan panjang: ");
                    pj = input.nextDouble();
                    System.out.print("Masukkan lebar: ");
                    lb = input.nextDouble();
                    System.out.print("Masukkan tinggi: ");
                    double t = input.nextDouble();
                    Balok b = new Balok(pj, lb, t);
                    System.out.println("Luas Permukaan = " + b.luasPermukaan());
                    System.out.println("Volume = " + b.volume());
                    break;
                
                case 5:
                    System.out.print("Masukkan jari-jari: ");
                    double r = input.nextDouble();
                    Lingkaran l = new Lingkaran(r);
                    System.out.println("Luas = " + l.luas());
                    System.out.println("Keliling = " + l.keliling());
                    break;
                    
                case 6:
                    System.out.print("Masukkan jari-jari: ");
                    r = input.nextDouble();
                    System.out.print("Masukkan tinggi: ");
                    t = input.nextDouble();
                    Tabung tb = new Tabung(r, t);
                    System.out.println("Luas Permukaan = " + tb.luasPermukaan());
                    System.out.println("Volume = " + tb.volume());
                    break;
                
                case 7:
                    System.out.print("Masukkan jari-jari: ");
                    r = input.nextDouble();
                    Bola bo = new Bola(r);
                    System.out.println("Luas Permukaan = " + bo.luasPermukaan());
                    System.out.println("Volume = " + bo.volume());
                    break;
                    
                    default:
                        System.out.println("Pilihan tidak tersedia.");
                    }
                    
                    System.out.print("\nIngin memilih lagi? (y/n): ");
                    ulang = input.next().charAt(0);
                    
                    if (ulang != 'y' && ulang != 'Y' && ulang != 'n' && ulang != 'N') {
                        System.out.println("Input salah.");

                    }

        } while (ulang == 'y' || ulang == 'Y');    

        System.out.println("Program selesai.");
        input.close();  
    }
}