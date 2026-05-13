package Tuprak4.bangun;

class BangunDatar {
    double luas() {
        return 0;
    }

    double keliling() {
        return 0;
    }
}

class Persegi extends BangunDatar {
    double sisi;

    Persegi(double sisi) {
        this.sisi = sisi;
    }

    @Override
    double luas() {
        return sisi * sisi;
    }

    @Override  
    double keliling() {
        return 4 * sisi;
    }
}

class PersegiPanjang extends BangunDatar {
    double panjang;
    double lebar;

    PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    @Override
    double luas() {
        return panjang * lebar;
    }

    @Override
    double keliling() {
        return 2 * (panjang + lebar);
    }
}

class Lingkaran extends BangunDatar {
    double jariJari;

    Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    @Override
    double luas() {
        return 3.14 * jariJari * jariJari;
    }

    @Override
    double keliling() {
        return 2 * Math.PI * jariJari;
    }
}

class Trapesium extends BangunDatar {
    double sisiSejajar1;
    double sisiSejajar2;
    double sisiMiring1;
    double sisiMiring2;
    double tinggi;

    Trapesium(double sisiSejajar1, double sisiSejajar2,
              double sisiMiring1, double sisiMiring2,
              double tinggi) {

        this.sisiSejajar1 = sisiSejajar1;
        this.sisiSejajar2 = sisiSejajar2;
        this.sisiMiring1 = sisiMiring1;
        this.sisiMiring2 = sisiMiring2;
        this.tinggi = tinggi;
    }

    @Override
    double luas() {
        return 0.5 * (sisiSejajar1 + sisiSejajar2) * tinggi;
    }

    @Override
    double keliling() {
        return sisiSejajar1 + sisiSejajar2 + sisiMiring1 + sisiMiring2;
    }
}