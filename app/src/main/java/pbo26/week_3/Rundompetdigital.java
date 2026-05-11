public class Rundompetdigital {
    public static void main(String[] args) {

        DompetDigital dompet = new DompetDigital("USR001", "123456");
        System.out.println("ID Nasabah: " + dompet.getIdNasabah());
        dompet.setPin("000000", "654321");
        dompet.setPin("123456", "654321");
        dompet.setor(500000);
        dompet.setor(-100000);
        dompet.tarik(100000, "111111");
        dompet.tarik(100000, "654321");
        System.out.println("Saldo akhir: " + dompet.getSaldo());
        System.out.println("Saldo akhir: " + dompet.getSaldo());
        System.out.println(dompet.getIdNasabah());
    }
}