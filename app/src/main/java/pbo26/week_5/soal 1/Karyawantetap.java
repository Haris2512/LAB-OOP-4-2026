class Karyawantetap extends Karyawan{
    int gajipokok;
    int tunjanganmakan;

    public Karyawantetap(String nama, String idkaryawan, int gajipokok, int tunjanganmakan) {
        super(nama, idkaryawan);
        this.gajipokok = gajipokok;
        this.tunjanganmakan = tunjanganmakan;
    }
    @Override 
    public double hitunggaji(){
        return gajipokok + (tunjanganmakan * jumlahkehadiran);
    }
    
    public double hitunggaji(double bonuskinerja){
        return hitunggaji() + bonuskinerja;
    }
} 