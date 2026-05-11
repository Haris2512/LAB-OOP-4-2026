public class Skill {
    String namaSkill;
    int damageSkill;

    public Skill() {
        this.namaSkill = "Skill 1";
        this.damageSkill = 50; 
    }

    public Skill(String namaSkill, int damageSkill) {
        this.namaSkill = namaSkill;
        this.damageSkill = damageSkill;
    }

    public int gunakanSkill() {
        return damageSkill;
    }
}
