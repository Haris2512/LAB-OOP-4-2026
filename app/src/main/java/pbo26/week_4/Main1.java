import java.util.Scanner;

// ===== SUPERCLASS =====
abstract class Bangun {
    String nama;

    Bangun(String nama) {
        this.nama = nama;
    }

    abstract void hitung();
}

// ===== BANGUN RUANG =====
class Kubus extends Bangun {
    Kubus() {
        super("Kubus");
    }

    void hitung() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan sisi " + this.nama + ": ");
        double s = sc.nextDouble();

        double volume = s * s * s;
        double luas = 6 * s * s;

        System.out.println("Volume " + this.nama + ": " + volume);
        System.out.println("Luas permukaan " + this.nama + ": " + luas);
    }
}

class Balok extends Bangun {
    Balok() {
        super("Balok");
    }

    void hitung() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan panjang: ");
        double p = sc.nextDouble();
        System.out.print("Masukkan lebar: ");
        double l = sc.nextDouble();
        System.out.print("Masukkan tinggi: ");
        double t = sc.nextDouble();

        double volume = p * l * t;
        double luas = 2 * (p*l + p*t + l*t);

        System.out.println("Volume " + this.nama + ": " + volume);
        System.out.println("Luas permukaan " + this.nama + ": " + luas);
    }
}

class Bola extends Bangun {
    Bola() {
        super("Bola");
    }

    void hitung() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jari-jari " + this.nama + ": ");
        double r = sc.nextDouble();

        double volume = (4.0/3.0) * Math.PI * r * r * r;
        double luas = 4 * Math.PI * r * r;

        System.out.println("Volume " + this.nama + ": " + volume);
        System.out.println("Luas permukaan " + this.nama + ": " + luas);
    }
}

class Tabung extends Bangun {
    Tabung() {
        super("Tabung");
    }

    void hitung() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jari-jari " + this.nama + ": ");
        double r = sc.nextDouble();
        System.out.print("Masukkan tinggi " + this.nama + ": ");
        double t = sc.nextDouble();

        double volume = Math.PI * r * r * t;
        double luas = 2 * Math.PI * r * (r + t);

        System.out.println("Volume " + this.nama + ": " + volume);
        System.out.println("Luas permukaan " + this.nama + ": " + luas);
    }
}

// ===== BANGUN DATAR =====
class Persegi extends Bangun {
    Persegi() {
        super("Persegi");
    }

    void hitung() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan sisi " + this.nama + ": ");
        double s = sc.nextDouble();

        double luas = s * s;
        double keliling = 4 * s;

        System.out.println("Luas " + this.nama + ": " + luas);
        System.out.println("Keliling " + this.nama + ": " + keliling);
    }
}

class PersegiPanjang extends Bangun {
    PersegiPanjang() {
        super("Persegi Panjang");
    }

    void hitung() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan panjang: ");
        double p = sc.nextDouble();
        System.out.print("Masukkan lebar: ");
        double l = sc.nextDouble();

        double luas = p * l;
        double keliling = 2 * (p + l);

        System.out.println("Luas " + this.nama + ": " + luas);
        System.out.println("Keliling " + this.nama + ": " + keliling);
    }
}

class Lingkaran extends Bangun {
    Lingkaran() {
        super("Lingkaran");
    }

    void hitung() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jari-jari " + this.nama + ": ");
        double r = sc.nextDouble();

        double luas = Math.PI * r * r;
        double keliling = 2 * Math.PI * r;

        System.out.println("Luas " + this.nama + ": " + luas);
        System.out.println("Keliling " + this.nama + ": " + keliling);
    }
}

class Trapesium extends Bangun {
    Trapesium() {
        super("Trapesium");
    }

    void hitung() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Sisi 1: ");
        double a = sc.nextDouble();
        System.out.print("Sisi 2: ");
        double b = sc.nextDouble();
        System.out.print("Sisi 3: ");
        double c = sc.nextDouble();
        System.out.print("Sisi 4: ");
        double d = sc.nextDouble();
        System.out.print("Tinggi: ");
        double t = sc.nextDouble();

        double luas = 0.5 * (a + b) * t;
        double keliling = a + b + c + d;

        System.out.println("Luas " + this.nama + ": " + luas);
        System.out.println("Keliling " + this.nama + ": " + keliling);
    }
}

// ===== MAIN =====
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\n========= BANGUN RUANG =========");
            System.out.println("1. KUBUS");
            System.out.println("2. BALOK");
            System.out.println("3. BOLA");
            System.out.println("4. TABUNG");

            System.out.println("======= BANGUN DATAR =======");
            System.out.println("5. PERSEGI");
            System.out.println("6. PERSEGI PANJANG");
            System.out.println("7. LINGKARAN");
            System.out.println("8. TRAPESIUM");
            System.out.println("9. KELUAR");

            System.out.print("Pilihan (1-9): ");
            pilih = sc.nextInt();

            Bangun b = null;

            switch (pilih) {
                case 1: b = new Kubus(); break;
                case 2: b = new Balok(); break;
                case 3: b = new Bola(); break;
                case 4: b = new Tabung(); break;
                case 5: b = new Persegi(); break;
                case 6: b = new PersegiPanjang(); break;
                case 7: b = new Lingkaran(); break;
                case 8: b = new Trapesium(); break;
                case 9:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }

            if (b != null) {
                b.hitung();
            }

        } while (pilih != 9);
    }
}