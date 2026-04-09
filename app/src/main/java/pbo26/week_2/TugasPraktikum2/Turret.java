public class Turret {
    String namaTurret;
    int hp;
    int damage;

    public Turret() {
        this.namaTurret = "Outer turret";
        this.hp = 100;
        this.damage = 50;
    }

    public Turret(String namaTurret,int hp, int damage) {
        this.namaTurret = namaTurret;
        this.hp = hp;
        this.damage = damage;
    }

    public void serangHero(Hero hero) {
        System.out.println(namaTurret + " menyerang " + hero.namaHero);
        hero.hp -= damage;
    }

    public void statusTurret() {
        System.out.println("\n---------- STATUS TURRET ----------\n");
        System.out.println("Turret: " + namaTurret + " || Hp: " + hp + " || Damage total: " + damage);
    }  
}