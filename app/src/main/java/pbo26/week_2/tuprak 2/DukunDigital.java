public class DukunDigital {                  //Dukun Digital Penangkal Sinyal Buruk
    String nama;
    int kekuatanSinyal;
    Jimat jimat;

    // construktor                         
    public DukunDigital() {
        this.nama = "Dukun Pemula";
        this.kekuatanSinyal = 0;           
        this.jimat = new Jimat("Jimat WiFi", 0);
    }

    // construktor
    public DukunDigital(String nama, int kekuatanSinyal, Jimat jimat) { 
        this.nama = nama;
        this.kekuatanSinyal = kekuatanSinyal; //atribute/para
        this.jimat = jimat; 
    }

    
    public void ritual() {
        kekuatanSinyal += jimat.getKekuatan();
        System.out.println("Sinyal awal " + nama + ": 80");
        System.out.println(nama + " melakukan ritual dengan " + jimat.getNamaJimat());
        System.out.println("Kekuatan sinyal sekarang: " + kekuatanSinyal);
    }                                                                                       
                                                                                                
    // method interaksi antar objek
    public void ganggu(DukunDigital teman) {
        System.out.println("Sinyal awal " + nama + ": 80");
        System.out.println(nama + " mengganggu sinyal " + teman.nama);
        teman.kekuatanSinyal -= jimat.getKekuatan();
        System.out.println("Sinyal " + teman.nama + " sekarang: " + teman.kekuatanSinyal);
    }
}