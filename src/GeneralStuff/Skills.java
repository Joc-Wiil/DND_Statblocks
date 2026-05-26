package GeneralStuff;

public class Skills {
    /*
     * Created:         05/02/26
     * Last Modified:   05/21/26
     *
     * Skills use Ability Types, Ability Mods, and Proficiency Bonus
     *
     * For Players Prof. Bonus is based on Choice
     *
     * For Monsters Prof. Bonus is based on ??
     *
     */

    private int[] skillsBase = new int[6];
    private int[] skillsProfBonus = new int[6];
    private int[] skillsExpertise = new int[6];
    private int[] skillsMagicBoons = new int[6];

    public int GetSkillsBase(int a) { return skillsBase[a]; }

    public int GetSkillsProfBonus(int a) { return skillsProfBonus[a]; }

    public int GetSkillsExpertise(int a) { return skillsExpertise[a]; }

    public void SetSkills(int a, int mod, int profBonus) {
        skillsBase[a] = mod;
        skillsProfBonus[a] = mod + profBonus;
        skillsExpertise[a] = mod + (profBonus * 2);
    }

    public int GetSkillsMagicBoons(int a) { return skillsMagicBoons[a]; }

    public void SetSkillsMagicBoons(int a, int mod) {
        skillsMagicBoons[a] = mod;
    }

    

}
