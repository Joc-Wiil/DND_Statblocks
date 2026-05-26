package GeneralStuff;

import PlayerStuff.PlayerClassFeatures;
import PlayerStuff.PlayerClasses;

public class SpellSlots {
    /*
     * Created:         05/20/26
     * Last Modified:   05/21/26
     *
     * What does this Script do?
     *
     * This script tracks the spell slots of a character.
     *
     * Full Casters get all 9 leveled spell slots.
     * Half Caster stop at 5th level spell slots.
     *
     * Warlocks are unique version of a Full Caster,
     * Warlocks are not spellcasters but Pact Magic Casters:
     * Warlocks have 1 Spell Slot at level 1,
     * 2 Spell Slots at level 2,
     * 3 Spell Slots at level 11,
     * and 4 Spell Slots at level 17.
     *
     * Then starting at 11th level,
     * Warlocks gain a single spell slot for each level starting at 6th,
     * 7th at level 13, 8th at level 15, climbing to 9th at 17th level,
     * and each with a limited spell pool.
     *
     */

    // Full Caster and Half Casters
    private int[] spellSlots = new int[SpellLevels.values().length];

    // Pact Magic Caster
    private int pactSlots;
    private SpellLevels pactLevel;
    private int[] mysticArcanum = new int[4];

    public int GetSpellSlots(int casterLevel, SpellLevels spellLevel, PlayerClassFeatures playerClassFeatures) {
        switch (spellLevel) {
            case Cantrip_1, First_1: return spellSlots[spellLevel.ordinal()];
            case Second_3: if (casterLevel >= 3) return spellSlots[spellLevel.ordinal()];
            case Third_5: if (casterLevel >= 5) return spellSlots[spellLevel.ordinal()];
            case Fourth_7: if (casterLevel >= 7) return spellSlots[spellLevel.ordinal()];
            case Fifth_9: if (casterLevel >= 9) return spellSlots[spellLevel.ordinal()];
            case Sixth_11: if (casterLevel >= 11) return spellSlots[spellLevel.ordinal()];
            case Seventh_13: if (casterLevel >= 13) return spellSlots[spellLevel.ordinal()];
            case Eighth_15: if (casterLevel >= 15) return spellSlots[spellLevel.ordinal()];
            case Ninth_17: if (casterLevel >= 17) return spellSlots[spellLevel.ordinal()];
            default: return 0;
        }
    }

    public void SetSpellSlots(int casterLevel) {
        // Cantrips
        spellSlots[SpellLevels.Cantrip_1.ordinal()] = 99999;

        // First Level Spells
        if (casterLevel >= 3) { spellSlots[SpellLevels.First_1.ordinal()] = 4; }
        else if (casterLevel == 2) { spellSlots[SpellLevels.First_1.ordinal()] = 3; }
        else { spellSlots[SpellLevels.First_1.ordinal()] = 2; }

        // Second Level Spells
        if (casterLevel >= 4) { spellSlots[SpellLevels.Second_3.ordinal()] = 3; }
        else if (casterLevel == 3) { spellSlots[SpellLevels.Second_3.ordinal()] = 2; }

        // Third Level Spells
        if (casterLevel >= 6) { spellSlots[SpellLevels.Third_5.ordinal()] = 3; }
        else if (casterLevel == 5) { spellSlots[SpellLevels.Third_5.ordinal()] = 2; }

        // Fourth Level Spells
        if (casterLevel >= 9) { spellSlots[SpellLevels.Fourth_7.ordinal()] = 3; }
        else if (casterLevel == 8) { spellSlots[SpellLevels.Fourth_7.ordinal()] = 2; }
        else if (casterLevel == 7) { spellSlots[SpellLevels.Fourth_7.ordinal()] = 1; }

        // Fifth Level Spells
        if (casterLevel >= 18) { spellSlots[SpellLevels.Fifth_9.ordinal()] = 3; }
        else if (casterLevel >= 10) { spellSlots[SpellLevels.Fifth_9.ordinal()] = 2; }
        else if (casterLevel == 9) { spellSlots[SpellLevels.Fifth_9.ordinal()] = 1; }

        // Sixth Level Spells
        if (casterLevel >= 19) { spellSlots[SpellLevels.Sixth_11.ordinal()] = 2; }
        else if (casterLevel >= 11) { spellSlots[SpellLevels.Sixth_11.ordinal()] = 1; }

        // Seventh Level Spells
        if (casterLevel >= 20) { spellSlots[SpellLevels.Seventh_13.ordinal()] = 2; }
        else if (casterLevel >= 13) { spellSlots[SpellLevels.Seventh_13.ordinal()] = 1; }

        // Eighth Level Spells
        if (casterLevel >= 15) { spellSlots[SpellLevels.Eighth_15.ordinal()] = 1; }

        // Second Level Spells
        if (casterLevel >= 17) { spellSlots[SpellLevels.Ninth_17.ordinal()] = 1; }
    }

    public int GetPactSlots() { return pactSlots; }

    public SpellLevels GetPactLevel() { return pactLevel; }

    public int GetMysticArcanum(int arcanumLevel) { return mysticArcanum[arcanumLevel]; }

    public void SetPactSlots(int casterLevel) {
        // Cantrips
        spellSlots[SpellLevels.Cantrip_1.ordinal()] = 99999;

        // Pact Slots
        if (casterLevel >= 17) { pactSlots = 4; }
        else if (casterLevel >= 11) { pactSlots = 3; }
        else if (casterLevel >= 2) { pactSlots = 2; }
        else { pactSlots = 1; }

        // Pact Level
        if (casterLevel >= 9) { pactLevel = SpellLevels.Fifth_9; }
        else if (casterLevel >= 7) { pactLevel = SpellLevels.Fourth_7; }
        else if (casterLevel >= 5) { pactLevel = SpellLevels.Third_5; }
        else if (casterLevel >= 3) { pactLevel = SpellLevels.Second_3; }
        else { pactLevel = SpellLevels.First_1; }

        // Mystic Arcanum
        if (casterLevel >= 17) { mysticArcanum[3] = 1; }
        if (casterLevel >= 15) { mysticArcanum[2] = 1; }
        if (casterLevel >= 13) { mysticArcanum[1] = 1; }
        if (casterLevel >= 11) { mysticArcanum[0] = 1; }

    }

    public int FindCasterLevel(PlayerClasses[] build, int currentLevel, boolean isPact) {
        int fullCasterLevels = 0;
        int halfCasterLevels = 0;
        int pactCasterLevels = 0;
        int loopTracker = 0;

        for (PlayerClasses pc : build) {
            switch (pc) {
                case Artificer, Paladin, Ranger: halfCasterLevels += 1; break;
                case Bard, Cleric, Druid, Sorcerer, Wizard: fullCasterLevels += 1; break;
                case Warlock: pactCasterLevels += 1; break;
                default: break;
            }
            loopTracker += 1;
            if (loopTracker == currentLevel) { break; }
        }

        // Set Half Caster Level (Rounded Up)
        halfCasterLevels = (int)Math.ceil((double)halfCasterLevels / 2);

        // Return Pact Magic Level or Spellcaster Level
        if (isPact) { return pactCasterLevels; }
        else { return fullCasterLevels + halfCasterLevels; }
    }
}
