package no1;

public class Main {
    public static void main(String[] args) {
        DompetDigital dompet1 = new DompetDigital("1010101010", "Hanni Pham", "261123" );

        System.out.println("User ID: " + dompet1.getUserId());
        System.out.println("Nama: " + dompet1.getNama());

        dompet1.setPin("000000", "654321");

        dompet1.setPin("261123", "100604");

        dompet1.setor(50000);

        dompet1.setor(-100);

        dompet1.tarik("123456", 10000);

        dompet1.tarik("654321", 10000);

        System.out.println("Saldo akhir: " + dompet1.getSaldo());
    }
}