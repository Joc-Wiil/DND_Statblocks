package GeneralStuff;

public class AccuracyAndDC {
    /*
     * Created:         05/12/26
     * Last Modified:   05/21/26
     *
     * What is this Script trying to do?
     *
     * This Script takes the Ability Mod, Prof. Bonus, and Magic Mod
     * and outputs the Accuracy and DC of a weapon, spell or feature
     *
     */

    private int[] accuracyOrigin = new int[6];
    private int[] DC_Origin = new int[6];

    public int GetAccuracyOrigin(int ability) { return accuracyOrigin[ability]; }

    public int GetDC_Origin(int ability) { return DC_Origin[ability]; }

    public void SetAccuracyOrigin(int ability, int abilityMod, int profBonus) { accuracyOrigin[ability] = abilityMod + profBonus; }

    public void SetDC_Origin(int ability, int abilityMod, int profBonus) { DC_Origin[ability] = 8 + abilityMod + profBonus; }

}
