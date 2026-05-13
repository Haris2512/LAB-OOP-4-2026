class Karyawankontrak extends Karyawan{
    int upahperhari;

    public Karyawankontrak(String nama, String idkaryawan, int upahperhari) {
        super(nama, idkaryawan);
        this.upahperhari = upahperhari;
    }

    @Override
    public double hitunggaji(){
        int total = upahperhari * jumlahkehadiran;
        if (jumlahkehadiran > 20){
           total += 500000;
        }
        return total;
    }
}