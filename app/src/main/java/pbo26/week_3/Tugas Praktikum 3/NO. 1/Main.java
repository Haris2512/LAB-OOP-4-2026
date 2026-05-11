public class Main {
    public static void main(String[] args) {

        // BUAT OBJEK
        DompetDigital dompet = new DompetDigital("USER123", "123456");

        // TAMPILKAN DATA
        System.out.println("ID Nasabah: " + dompet.getIdNasabah());

        // UBAH PIN
        dompet.ubahPin("000000", "654321"); // salah
        dompet.ubahPin("123456", "654321"); // benar

        // SETOR
        dompet.setor(100000);

        // TARIK
        dompet.tarik(50000, "654321");

        // CEK SALDO
        System.out.println("Saldo sekarang: " + dompet.getSaldo());
    }
}