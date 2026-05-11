import java.util.Scanner;

public class dompetDigital {
    Scanner inputan = new Scanner(System.in);
    protected String namaNasabah;
    protected int noRek;
    private int pin;
    private int saldo;


    public dompetDigital(String namaNasabah, int noRek, int pin) {
        this.namaNasabah = namaNasabah;
        this.noRek = noRek;
        this.pin = pin;
    }

    public void getInfoNasabah() {
        System.out.println("----- INFO NASABAH -----");
        System.out.println("Nama Nasabah    : " + this.namaNasabah);
        System.out.println("Nomor Rekening  : " + this.noRek);
    }

    public void getInfoSaldo() {
        System.out.println("Total saldo anda: " + this.saldo);
    }

    public void setPin(int newPin) {
        System.out.print("Masukkan pin lama anda: ");
        int pinLama = inputan.nextInt();
        boolean validation = true;

        if (pinLama != this.pin) {
            validation = false;
            System.out.println("Anda salah memasukkan pin lama!");
        }

        String validationNewPin = String.valueOf(newPin);

        if (validationNewPin.length() != 6) {
            validation = false;
            System.out.println("Anda salah memasukkan pin lama!");
        }

        if (validation) {
            this.pin = newPin;
            System.out.println("Pin berhasil diubah");
        }
    }
    
    public void setorTunai(int uang) {
        System.out.print("Masukkan pin anda: ");
        int validationSetor = inputan.nextInt();

        if (validationSetor != this.pin) {
            System.out.println("Anda salah memasukkan pin!");
        }

        else {
            if (uang <= 0){
                System.out.println("Input tidak valid!");
            }
            else {
                this.saldo += uang;
                System.out.println("Setor tunai berhasil, total saldo anda sekarang: " + this.saldo);
            }   
        }
    }

    public void tarikTunai(int sambarang) {
        System.out.print("Masukkan pin anda: ");
        int validationTarik = inputan.nextInt();

        if (validationTarik != this.pin) {
            System.out.println("Anda salah memasukkan pin!");
        }
        else {
            if (sambarang <= 0){
                System.out.println("Input tidak valid!");
            }
            else {
                this.saldo -= sambarang;
                System.out.println("Tarik tunai berhasil, total saldo anda sekarang: " + this.saldo);
            }   
        }
    }
}