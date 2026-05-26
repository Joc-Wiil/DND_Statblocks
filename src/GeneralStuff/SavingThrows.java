package GeneralStuff;

public class SavingThrows {
    /*
     * Created:         05/02/26
     * Last Modified:   05/21/26
     *
     * Saving Throws use Ability Types, Ability Mods, and Proficiency Bonus
     *
     * For Players Prof. Bonus is based on Class
     *
     * For Monsters Prof. Bonus is based on ??
     *
     */

    private int[] savingThrowsBase = new int[6];
    private int[] savingThrowsProfBonus = new int[6];
    private int[] savingThrowsMagicBoons = new int[6];

    public int GetSavingThrowsBase(int a) { return savingThrowsBase[a]; }

    public int GetSavingThrowsProfBonus(int a) { return savingThrowsProfBonus[a]; }

    public void SetSavingThrows(int a, int mod, int profBonus) {
        savingThrowsBase[a] = mod;
        savingThrowsProfBonus[a] = mod + profBonus;
    }

    public void SetSavingThrowsMagicBoons(int a, int mod) {
        savingThrowsMagicBoons[a] += mod;
    }

    public int GetSavingThrowsBasePlusMagicBoon(int a) {
        return savingThrowsBase[a] + savingThrowsMagicBoons[a];
    }

    public int GetSavingThrowsProfBonusPlusMagicBoon(int a) {
        return savingThrowsProfBonus[a] + savingThrowsMagicBoons[a];
    }
}
