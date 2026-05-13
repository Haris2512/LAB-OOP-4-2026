public class Main {
    public static void main(String[] args) {
        Jimat jimatKuat = new Jimat("Jimat 5G", 20);
        Jimat jimatBiasa = new Jimat("Jimat 4G", 15);

        DukunDigital dukun1 = new DukunDigital("Aidil", 80, jimatKuat);
        DukunDigital dukun2 = new DukunDigital("Raikhan", 80, jimatBiasa);

        dukun1.ritual();
        dukun1.ganggu(dukun2);
        dukun2.ritual();
    }
}