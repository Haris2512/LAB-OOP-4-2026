package Tuprak4.bangun;

class BangunRuang {
    double volume() {
        return 0;
    }

    double luasPermukaan() {
        return 0;
    }
}

class Kubus extends BangunRuang {
    double sisi;

    Kubus(double sisi) {
        this.sisi = sisi;
    }

    @Override
    double volume() {
        return sisi * sisi * sisi;
    }

    @Override
    double luasPermukaan() {
        return 6 * sisi * sisi;
    }
}

class Balok extends BangunRuang {
    double panjang;
    double lebar;
    double tinggi;

    Balok(double panjang, double lebar, double tinggi) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }

    @Override
    double volume() {
        return panjang * lebar * tinggi;
    }

    @Override
    double luasPermukaan() {
        return 2 * ((panjang * lebar) + (panjang * tinggi) + (lebar * tinggi));
    }
}

class Tabung extends BangunRuang {
    double jariJari;
    double tinggi;

    Tabung(double jariJari, double tinggi) {
        this.jariJari = jariJari;
        this.tinggi = tinggi;
    }

    @Override
    double volume() {
        return Math.PI * jariJari * jariJari * tinggi;
    }

    @Override
    double luasPermukaan() {
        return 2 * Math.PI * jariJari * (jariJari + tinggi);
    }
}

class Bola extends BangunRuang {
    double jariJari;

    Bola(double jariJari) {
        this.jariJari = jariJari;
    }

    @Override
    double volume() {
        return 4.0 / 3.0 * Math.PI * jariJari * jariJari * jariJari;
    }

    @Override
    double luasPermukaan() {
        return 4 * Math.PI * jariJari * jariJari;
    }
}