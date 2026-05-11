public class Run {
    public static void main(String[] args) {
        Tempat t1 = new Tempat("semak semak", 5);
        Tempat t2 = new Tempat("rumah", 8);

        Pemain p1 = new Pemain("asep", 0, t1);
        Pemain p2 = new Pemain("udin", 0, t2);
    

        p1.sembunyi();
        p2.sembunyi();
        
        System.out.println("\n mulai mencari\n");
        p1.cari(p2);
        System.out.println("\n mulai mencari\n");
        p2.cari(p1);
    }
}
