public class Main {
    public static void main(String[] args) {
        
        DompetDigital dompet = new DompetDigital("FT-99", "Aidil", "123456");
        
        System.out.println("ID Nasabah: " + dompet.getIdNasabah());
        System.out.println("Pemilik: " + dompet.namaPemilik);
        
        System.out.println("\nUji Ubah PIN (Salah PIN Lama):");
        dompet.ubahPin("000000", "111111");
        
        System.out.println("\nUji Ubah PIN (Data Benar):");
        dompet.ubahPin("123456", "654321");
        
        System.out.println("\nSetor Tunai (Valid):");
        dompet.setorTunai(200000);
    
        System.out.println("\nSetor Tunai (Negatif):");
        dompet.setorTunai(-50000);
        
        System.out.println("\nTarik Tunai (PIN Salah):");
        dompet.tarikTunai(50000, "123456");
        
        System.out.println("\nTarik Tunai (PIN Benar):");
        dompet.tarikTunai(75000, "654321");

        System.out.println("\nSisa Saldo Akhir: Rp" + dompet.getSisaSaldo());
    }
}