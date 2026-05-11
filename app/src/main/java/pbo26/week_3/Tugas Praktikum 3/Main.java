public class Main {
    public static void main(String[] args) {
        dompetDigital dompet1 = new dompetDigital("Aren" , 12345678, 258036);

        dompet1.getInfoNasabah();
        // dompet1.setPin(123456);

        dompet1.setorTunai(25000);

        dompet1.tarikTunai(30000);
    }
}
