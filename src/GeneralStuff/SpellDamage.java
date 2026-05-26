package GeneralStuff;

public class SpellDamage {
    /*
     * Created:         05/20/26
     * Last Modified:   05/21/26
     *
     *  What does this Script do?
     *
     * This script is managing the damage values of spells.
     *
     * Spell damage is not just the damage but also the healing a spell can do too.
     *
     * Most spells deal half damage on a successful saving throw or missed attack.
     * If it only deals damage on a successful hit or failed saving throw, then increase the damage by 25%
     *
     * Repeat this script for Single Target Spells and Multi Target Spells
     *
     */

    private int[] diceCount = new int[SpellLevels.values().length];
    private int diceValue;
    private int[] damageOutput = new int[SpellLevels.values().length];

    public int GetDamageOutput(SpellLevels spellLevel) { return damageOutput[spellLevel.ordinal()];  }

    public void SetSingleTargetSpellDice(int level) {
        // Cantrips
        SetCantripCount(level);

        // Leveled Spells
        diceCount[SpellLevels.First_1.ordinal()] = 2;
        diceCount[SpellLevels.Second_3.ordinal()] = 3;
        diceCount[SpellLevels.Third_5.ordinal()] = 5;
        diceCount[SpellLevels.Fourth_7.ordinal()] = 6;
        diceCount[SpellLevels.Fifth_9.ordinal()] = 8;
        diceCount[SpellLevels.Sixth_11.ordinal()] = 10;
        diceCount[SpellLevels.Seventh_13.ordinal()] = 11;
        diceCount[SpellLevels.Eighth_15.ordinal()] = 12;
        diceCount[SpellLevels.Ninth_17.ordinal()] = 15;

        // Set Spell Dice Values
        diceValue = 10;
    }

    public void SetMultiTargetSpellDice(int level) {
        // Cantrip
        SetCantripCount(level);

        // Leveled Spells
        diceCount[SpellLevels.First_1.ordinal()] = 2;
        diceCount[SpellLevels.Second_3.ordinal()] = 4;
        diceCount[SpellLevels.Third_5.ordinal()] = 6;
        diceCount[SpellLevels.Fourth_7.ordinal()] = 7;
        diceCount[SpellLevels.Fifth_9.ordinal()] = 8;
        diceCount[SpellLevels.Sixth_11.ordinal()] = 11;
        diceCount[SpellLevels.Seventh_13.ordinal()] = 12;
        diceCount[SpellLevels.Eighth_15.ordinal()] = 13;
        diceCount[SpellLevels.Ninth_17.ordinal()] = 14;

        // Set Spell Dice Value
        diceValue = 6;
    }

    public void CalculateSpellDamage() { for (int sl = 0; sl < SpellLevels.values().length; sl++) { damageOutput[sl] = (diceCount[sl] * diceValue) / 2; } }

    private void SetCantripCount(int level) {
        if (level >= 17) { diceCount[SpellLevels.Cantrip_1.ordinal()] = 4; }
        else if (level >= 11) { diceCount[SpellLevels.Cantrip_1.ordinal()] = 3; }
        else if (level >= 5) { diceCount[SpellLevels.Cantrip_1.ordinal()] = 2; }
        else { diceCount[SpellLevels.Cantrip_1.ordinal()] = 1; }
    }

}
