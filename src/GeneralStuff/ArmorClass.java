package GeneralStuff;

public class ArmorClass {
    /*
     * Created:         05/11/26
     * Last Modified:   05/21/26
     *
     * What does this Script do?
     *
     * This script calculates the armor class of each armor type
     *
     * Armorless: 10 + Dex Mod
     *
     * Light Armor:
     * 1) 11 + Dex Mod + Armor Item Magic Mod
     * 2) 12 + Dex Mod + Armor Item Magic Mod
     *
     * Medium Armor:
     * 1) 12 + Dex Mod (Limit 2 or 3 with Medium Armor Feat) + Armor Item Magic Mod
     * 2) 13 + Dex Mod (Limit 2 or 3 with Medium Armor Feat) + Armor Item Magic Mod
     * 3) 14 + Dex Mod (Limit 2 or 3 with Medium Armor Feat) + Armor Item Magic Mod
     * 4) 15 + Dex Mod (Limit 2 or 3 with Medium Armor Feat) + Armor Item Magic Mod
     *
     * Heavy Armor:
     * 14 + Armor Magic Mod
     * 16 + Armor Magic Mod
     * 17 + Armor Magic Mod
     * 18 + Armor Magic Mod
     *
     * Unarmored Defense:
     * 10 + Dex Mod + Other Mod (Charisma for Rogue or Bard Subclass, Wisdom for Monk, Constitution for Barbarian)
     *
     * Shield: 2 + Armor Item Magic Mod
     *
     */

    private int[] armorless = new int[6];
    private int[][] lightArmor = new int[2][6];
    private int[][] mediumArmor = new int[4][6];
    private int[] heavyArmor = new int[4];
    private int[] mageArmor = new int[6];
    private int[][] unarmoredDefense = new int[6][6];
    private int shield;

    public int GetArmorLess(int ability) { return armorless[ability]; }

    public int GetLightArmor(int armorType, int ability) { return lightArmor[armorType][ability]; }

    public int GetMediumArmor(int armorType, int ability) { return mediumArmor[armorType][ability]; }

    public int GetHeavyArmor(int armorType) { return heavyArmor[armorType]; }

    public  int GetMageArmor(int ability) { return mageArmor[ability]; }

    public int GetUnarmoredDefense(int ability1, int ability2) { return unarmoredDefense[ability1][ability2]; }

    public int GetShield() { return shield; }

    public void SetArmorlessAndMageArmor(int ability, int abilityMod) {
        armorless[ability] = 10 + abilityMod;
        mageArmor[ability] = 13 + abilityMod;
    }

    public void SetArmorLightMediumHeavy(int armorType, int ability, int abilityMod, boolean hasMediumArmorFeat) {
        int mediumMod = 0;
        if (hasMediumArmorFeat && abilityMod > 3) { mediumMod = 3; }
        else if (!hasMediumArmorFeat && abilityMod > 2) { mediumMod = 2; }
        else { mediumMod = abilityMod; }

        switch(armorType) {
            case 0:
                lightArmor[armorType][ability] = 11 + abilityMod;
                mediumArmor[armorType][ability] = 12 + mediumMod;
                heavyArmor[armorType] = 14;
                break;
            case 1:
                lightArmor[armorType][ability] = 12 + abilityMod;
                mediumArmor[armorType][ability] = 13 + mediumMod;
                heavyArmor[armorType] = 16;
                break;
            case 2:
                mediumArmor[armorType][ability] = 14 + mediumMod ;
                heavyArmor[armorType] = 17;
                break;
            case 3:
                mediumArmor[armorType][ability] = 15 + mediumMod ;
                heavyArmor[armorType] = 18;
                break;
        }
    }

    public void SetUnarmoredDefense(int ability1, int ability2, int abilityMod1, int abilityMod2) {
        unarmoredDefense[ability1][ability2] = 10 + abilityMod1 + abilityMod2;
    }

    public void SetShield() {
        shield = 2;
    }
}
