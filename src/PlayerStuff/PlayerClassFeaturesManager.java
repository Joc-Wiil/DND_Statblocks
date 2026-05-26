package PlayerStuff;

public class PlayerClassFeaturesManager {
    /*
     * Created:         05/11/26
     * Last Modified:   05/21/26
     *
     * What is this Script trying to do?
     *
     * This script is a manager for the base features of each Character Class
     * This takes in the Class and Level
     * and outputs the relevant feature for the method that needs it
     */

    public boolean FindClassFeature(int level, PlayerClasses pc, PlayerClassFeatures cf) {
        return switch (pc) {
            case Artificer -> GetArtificerClassFeatures(level, cf);
            case Barbarian -> GetBarbarianClassFeatures(level, cf);
            case Bard -> GetBardClassFeatures(level, cf);
            case Cleric -> GetClericClassFeatures(level, cf);
            case Druid -> GetDruidClassFeatures(level, cf);
            case Fighter -> GetFighterClassFeatures(level, cf);
            case Monk -> GetMonkClassFeatures(level, cf);
            case Paladin -> GetPaladinClassFeatures(level, cf);
            case Ranger -> GetRangerClassFeatures(level, cf);
            case Rogue -> GetRogueClassFeatures(level, cf);
            case Sorcerer -> GetSorcererClassFeatures(level, cf);
            case Warlock -> GetWarlockClassFeatures(level, cf);
            case Wizard -> GetWizardClassFeatures(level, cf);
            default -> false;
        };
    }

    // Find the highest leveled class with extra attack within the character build
    public PlayerClassFeatures FindAttackFeature(int currentLevelOfClass, PlayerClasses pc) {
        if (currentLevelOfClass == 20 && pc == PlayerClasses.Fighter) { return PlayerClassFeatures.Three_Extra_Attacks; }
        if (currentLevelOfClass >= 11 && pc == PlayerClasses.Fighter) { return PlayerClassFeatures.Two_Extra_Attacks; }
        if (currentLevelOfClass >= 5) {
            return switch (pc) {
                case Barbarian, Fighter, Monk, Paladin, Ranger -> PlayerClassFeatures.Extra_Attack;
                case Artificer, Bard, Cleric, Druid, Rogue, Sorcerer, Warlock, Wizard -> PlayerClassFeatures.Attack_Action;
            };
        }
        return PlayerClassFeatures.Attack_Action;
    }

    private boolean GetArtificerClassFeatures(int level, PlayerClassFeatures desiredFeature) {
        switch (desiredFeature) {
            // Level 1
            case Spellcasting, Tinkers_Magic, Half_Caster: return true;
            // Level 2
            case Replicate_Magic_Item:
                if(level >= 2) { return true; }
            // Level 6
            case Magic_Item_Tinker:
                if(level >= 6) { return true; }
            // Level 7
            case Flash_of_Genius:
                if(level >= 7) { return true; }
            // Level 10
            case Magic_Item_Adept:
                if(level >= 10) { return true; }
            // Level 11
            case Spell_Storing_Item:
                if(level >= 11) { return true; }
            // Level 14
            case Advanced_Artifice:
                if(level >= 14) { return true; }
            // Level 18
            case Magic_Item_Master:
                if(level >= 18) { return true; }
            // Level 20
            case Soul_of_Artifice:
                if(level == 20) { return true; }
            default: return false;
        }
    }

    private boolean GetBarbarianClassFeatures(int level, PlayerClassFeatures desiredFeature) {
        switch (desiredFeature) {
            // Level 1
            case Rage, Unarmored_Defense: return true;
            // Level 2
            case Danger_Sense, Reckless_Attack:
                if(level >= 2) { return true; }
            // Level 3
            case Primal_Knowledge:
                if(level >= 3) { return true; }
            // Level 5
            case Extra_Attack, Fast_Movement:
                if(level >= 5) { return true; }
            // Level 7
            case Feral_Instinct, Instinctive_Pounce:
                if(level >= 7) { return true; }
            // Level 9
            case Brutal_Strike:
                if(level >= 9) { return true; }
            // Level 11
            case Relentless_Rage:
                if(level >= 11) { return true; }
            // Level 14
            case Improved_Brutal_Strike:
                if(level >= 14) { return true; }
            // Level 15
            case Persistent_Rage:
                if(level >= 15) { return true; }
            // Level 17
            case Improved_Brutal_Strike2:
                if(level >= 17) { return true; }
            // Level 18
            case Indomitable_Might:
                if(level >= 18) { return true; }
            // Level 20
            case Primal_Champion:
                if(level == 20) { return true; }
            default: return false;
        }
    }

    private boolean GetBardClassFeatures(int level, PlayerClassFeatures desiredFeature) {
        switch (desiredFeature) {
            // Level 1
            case Bardic_Inspiration, Spellcasting, Full_Caster: return true;
            // Level 2
            case Expertise, Jack_of_All_Trades:
                if(level >= 2) { return true; }
                // Level 5
            case Font_of_Inspiration:
                if(level >= 5) { return true; }
                // Level 7
            case Countercharm:
                if(level >= 7) { return true; }
                // Level 9
            case Expertise2:
                if(level >= 9) { return true; }
                // Level 10
            case Magical_Secrets:
                if(level >= 10) { return true; }
                // Level 18
            case Superior_Inspiration:
                if(level >= 18) { return true; }
                // Level 20
            case Words_of_Creation:
                if(level == 20) { return true; }
            default: return false;
        }
    }

    private boolean GetClericClassFeatures(int level, PlayerClassFeatures desiredFeature) {
        switch (desiredFeature) {
            // Level 1
            case Spellcasting, Divine_Order, Full_Caster: return true;
            // Level 2
            case Channel_Divinity:
                if(level >= 2) { return true; }
                // Level 5
            case Sear_Undead:
                if(level >= 5) { return true; }
                // Level 7
            case Blessed_Strikes:
                if(level >= 7) { return true; }
                // Level 10
            case Divine_Intervention:
                if(level >= 10) { return true; }
                // Level 14
            case Improved_Blessed_Strikes:
                if(level >= 14) { return true; }
                // Level 20
            case Greater_Divine_Intervention:
                if(level == 20) { return true; }
            default: return false;
        }
    }

    private boolean GetDruidClassFeatures(int level, PlayerClassFeatures desiredFeature) {
        switch (desiredFeature) {
            // Level 1
            case Spellcasting, Druidic, Primal_Order, Full_Caster: return true;
            // Level 2
            case Wild_Shape, Wild_Companion:
                if(level >= 2) { return true; }
                // Level 5
            case Wild_Resurgence:
                if(level >= 5) { return true; }
                // Level 7
            case Elemental_Fury:
                if(level >= 7) { return true; }
                // Level 15
            case Improved_Elemental_Fury:
                if(level >= 15) { return true; }
                // Level 18
            case Beast_Spells:
                if(level >= 18) { return true; }
                // Level 20
            case Archdruid:
                if(level == 20) { return true; }
            default: return false;
        }
    }

    private boolean GetFighterClassFeatures(int level, PlayerClassFeatures desiredFeature) {
        switch (desiredFeature) {
            // Level 1
            case Fighting_Style, Second_Wind: return true;
            // Level 2
            case Action_Surge_One_Use, Tactical_Mind:
                if(level >= 2) { return true; }
            // Level 5
            case Extra_Attack, Tactical_Shift:
                if(level >= 5) { return true; }
            // Level 9
            case Indomitable_One_Use, Tactical_Master:
                if(level >= 9) { return true; }
            // Level 11
            case Two_Extra_Attacks:
                if(level >= 11) { return true; }
            // Level 13
            case Indomitable_Two_Use, Studied_Attacks:
                if(level >= 13) { return true; }
            // Level 17
            case Action_Surge_Two_Uses, Indomitable_Three_Use:
                if(level >= 17) { return true; }
            // Level 20
            case Three_Extra_Attacks:
                if(level == 20) { return true; }
            default: return false;
        }
    }

    private boolean GetMonkClassFeatures(int level, PlayerClassFeatures desiredFeature) {
        switch (desiredFeature) {
            // Level 1
            case Martial_Arts, Unarmored_Defense: return true;
            // Level 2
            case Monks_Focus, Unarmored_Movement, Uncanny_Metabolism:
                if(level >= 2) { return true; }
            // Level 3
            case Deflect_Attacks:
                if(level >= 3) { return true; }
            // Level 4
            case Slow_Fall:
                if(level >= 4) { return true; }
            // Level 5
            case Extra_Attack, Stunning_Strike:
                if(level >= 5) { return true; }
            // Level 6
            case Empowered_Strike:
                if(level >= 6) { return true; }
            // Level 7
            case Evasion:
                if(level >= 7) { return true; }
            // Level 9
            case Acrobatic_Movement:
                if(level >= 9) { return true; }
            // Level 10
            case Heightened_Focus, Self_Restoration:
                if(level >= 10) { return true; }
            // Level 13
            case Deflect_Energy:
                if(level >= 13) { return true; }
            // Level 14
            case Disciplined_Survivor:
                if(level >= 14) { return true; }
            // Level 15
            case Perfect_Focus:
                if(level >= 15) { return true; }
            // Level 18
            case Superior_Defense:
                if(level >= 18) { return true; }
            // Level 20
            case Body_and_Mind:
                if(level == 20) { return true; }
            default: return false;
        }
    }

    private boolean GetPaladinClassFeatures(int level, PlayerClassFeatures desiredFeature) {
        switch (desiredFeature) {
            // Level 1
            case Lay_on_Hands, Spellcasting, Half_Caster: return true;
            // Level 2
            case Fighting_Style, Paladins_Smite:
                if(level >= 2) { return true; }
            // Level 3
            case Channel_Divinity:
                if(level >= 3) { return true; }
            // Level 5
            case Extra_Attack, Faithful_Steed:
                if(level >= 5) { return true; }
            // Level 6
            case Aura_of_Protection:
                if(level >= 6) { return true; }
            // Level 9
            case Abjure_Foes:
                if(level >= 9) { return true; }
            // Level 10
            case Aura_of_Courage:
                if(level >= 10) { return true; }
            // Level 11
            case Radiant_Strikes:
                if(level >= 11) { return true; }
            // Level 14
            case Restoring_Touch:
                if(level >= 14) { return true; }
            // Level 18
            case Aura_of_Expansion:
                if(level >= 18) { return true; }
            default: return false;
        }
    }

    private boolean GetRangerClassFeatures(int level, PlayerClassFeatures desiredFeature) {
        switch (desiredFeature) {
            // Level 1
            case Spellcasting, Favored_Enemy, Half_Caster: return true;
            // Level 2
            case Deft_Explorer, Fighting_Style:
                if(level >= 2) { return true; }
            // Level 5
            case Extra_Attack:
                if(level >= 5) { return true; }
            // Level 6
            case Roving:
                if(level >= 6) { return true; }
            // Level 9
            case Expertise:
                if(level >= 9) { return true; }
            // Level 10
            case Tireless:
                if(level >= 10) { return true; }
            // Level 13
            case Relentless_Hunter:
                if(level >= 13) { return true; }
            // Level 14
            case Natures_Veil:
                if(level >= 14) { return true; }
            // Level 17
            case Precise_Hunter:
                if(level >= 17) { return true; }
            // Level 18
            case Feral_Senses:
                if(level >= 18) { return true; }
            // Level 20
            case Foe_Slayer:
                if(level == 20) { return true; }
            default: return false;
        }
    }

    private boolean GetRogueClassFeatures(int level, PlayerClassFeatures desiredFeature) {
        switch (desiredFeature) {
            // Level 1
            case Expertise, Sneak_Attack, Thieves_Cant: return true;
            // Level 2
            case Cunning_Action:
                if(level >= 2) { return true; }
            // Level 3
            case Steady_Aim:
                if(level >= 3) { return true; }
            // Level 5
            case Cunning_Strike, Uncanny_Dodge:
                if(level >= 5) { return true; }
            // Level 5
            case Expertise2:
                if(level >= 5) { return true; }
            // Level 7
            case Evasion, Reliable_Talent:
                if(level >= 7) { return true; }
            // Level 11
            case Improved_Cunning_Strike:
                if(level >= 11) { return true; }
            // Level 14
            case Devious_Strike:
                if(level >= 14) { return true; }
            // Level 15
            case Slippery_Mind:
                if(level >= 15) { return true; }
            // Level 18
            case Elusive:
                if(level >= 18) { return true; }
            // Level 20
            case Stroke_of_Luck:
                if(level == 20) { return true; }
            default: return false;
        }
    }

    private boolean GetSorcererClassFeatures(int level, PlayerClassFeatures desiredFeature) {
        switch (desiredFeature) {
            // Level 1
            case Spellcasting, Innate_Sorcery, Full_Caster: return true;
            // Level 2
            case Font_of_Magic, Metamagic:
                if(level >= 2) { return true; }
            // Level 5
            case Sorcerous_Restoration:
                if(level >= 5) { return true; }
            // Level 7
            case Sorcery_Incarnate:
                if(level >= 7) { return true; }
            // Level 10
            case Metamagic2:
                if(level >= 10) { return true; }
            // Level 17
            case Metamagic3:
                if(level >= 17) { return true; }
            // Level 20
            case Arcane_Apotheosis:
                if(level == 20) { return true; }
            default: return false;
        }
    }

    private boolean GetWarlockClassFeatures(int level, PlayerClassFeatures desiredFeature) {
        switch (desiredFeature) {
            // Level 1
            case Eldritch_Invocations, Pact_Magic: return true;
            // Level 2
            case Magical_Cunning:
                if(level >= 2) { return true; }
            // Level 9
            case Contract_Patron:
                if(level >= 9) { return true; }
            // Level 11
            case Mystic_Arcanum:
                if(level >= 11) { return true; }
             // Level 13
            case Mystic_Arcanum2:
                if(level >= 13) { return true; }
            // Level 15
            case Mystic_Arcanum3:
                if(level >= 15) { return true; }
            // Level 17
            case Mystic_Arcanum4:
                if(level >= 17) { return true; }
            // Level 20
            case Eldritch_Master:
                if(level == 20) { return true; }
            default: return false;
        }
    }

    private boolean GetWizardClassFeatures(int level, PlayerClassFeatures desiredFeature) {
        switch (desiredFeature) {
            // Level 1
            case Spellcasting, Ritual_Adept, Arcane_Recovery, Full_Caster: return true;
            // Level 2
            case Scholar:
                if(level >= 2) { return true; }
            // Level 5
            case Memorize_Spell:
                if(level >= 5) { return true; }
            // Level 18
            case Spell_Mastery:
                if(level >= 18) { return true; }
            // Level 20
            case Signature_Spells:
                if(level == 20) { return true; }
            default: return false;
        }
    }
}
