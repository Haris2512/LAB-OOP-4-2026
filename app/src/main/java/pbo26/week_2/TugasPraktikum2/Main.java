public class Main {
    public static void main(String[] args) {

        Skill skill1 = new Skill("skill 1", 50);
        Skill skill2 = new Skill("skill 2", 70);
        Skill skill3 = new Skill("ultimate ",90);
        
        Hero hero1 = new Hero("Alucard", 200, 40, skill1);
        Hero hero2 = new Hero("Miya", 150, 30, skill1);

        Turret turret1 = new Turret("inhibitor turret", 250, 100);
        Turret turret2 = new Turret("base turret", 500, 150);

        // hero1.serangHero(hero2);
        // hero2.serangHero(hero1);

        hero1.serangTurret(turret1);

        hero1.gunakanSkill(hero2);
        hero2.gunakanSkill(hero1);

        hero1.statusHero();
        hero2.statusHero();

        turret1.statusTurret();
    }
}
