public class Hero {
    String namaHero;
    int hp;
    int damage;
    Skill skill;

    public Hero() {
        this.namaHero = "Layla";
        this.hp = 100;
        this.damage = 30;
        this.skill = new Skill();
    }

    public Hero(String namaHero, int hp, int damage, Skill skill) {
        this.namaHero = namaHero;
        this.hp = hp;
        this.damage = damage;
        this.skill = skill;
    }

    public void serangHero(Hero musuh) {
        System.out.println("");
        System.out.println(namaHero + " menyerang " + musuh.namaHero);
        System.out.println("");
        musuh.hp -= damage;
    }

    public void serangTurret(Turret musuh) {
        System.out.println("");
        System.out.println(namaHero + " menyerang " + musuh.namaTurret);
        System.out.println("");
        musuh.hp -= damage;
    }

    public void gunakanSkill(Hero musuh) {
        int totalDamage = damage + skill.gunakanSkill();
        System.out.println(namaHero + " menggunakan " + skill.namaSkill + " ke " + musuh.namaHero);
        System.out.println("");
        musuh.hp -= totalDamage;
    }

    public void statusHero() {
        System.out.println("\n---------- STATUS HERO ----------\n");
        System.out.println("Hero: " + namaHero + " || Hp: " + hp + " || Damage total: " + (skill.damageSkill + damage));
    }
}