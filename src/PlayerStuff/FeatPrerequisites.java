package PlayerStuff;

public enum FeatPrerequisites {
    /*
     * Created:         05/21/26
     * Last Modified:   05/21/26
     *
     * The Prerequisites needed to access a feat
     *
     */

    // Origin or Empty array slot
    None,

    // Levels
    Level_4_Plus,
    Level_19_Plus,

    // Ability Scores
    Strength_13_Plus,
    Dexterity_13_Plus,
    Constitution_13_Plus,
    Intelligence_13_Plus,
    Wisdom_13_Plus,
    Charisma_13_Plus,
    StrengthOrDexterity_13_Plus,
    DexterityOrConstitution_13_Plus,
    IntelligenceOrWisdom_13_Plus,
    WisdomOrCharisma_13_Plus,
    IntelligenceWisdomOrCharisma_13_Plus,


    // Class Features
    Spellcasting,
    SpellCastingOrPact_Magic,
    Fighting_Style,

    // Armor/Shield Training
    Shield_Training,
    Light_Armor_Training,
    Medium_Armor_Training,
    Heavy_Armor_Training,

}
