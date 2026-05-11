public class Jimat {
    String namaJimat; //atribut
    int kekuatan;

    public Jimat(String namaJimat, int kekuatan) { //construktor 

        this.namaJimat = namaJimat;     //atreibut
        this.kekuatan = kekuatan; 
    }

    public int getKekuatan() {
        return kekuatan;
    }

    public String getNamaJimat() {
        return namaJimat;
    }
}