package PlayerStuff;

import GeneralStuff.*;

public class CharacterSheet {
    /*
     * Created:         05/03/26
     * Last Modified:   05/21/26
     *
     * What is this Script trying to do?
     *
     * This Script Centralizes the components of the Character Sheet,
     * and collects the statistics of each component that has a numeric value,
     * then converting into monster statistics (if it can be converted).
     *
     */

    // Tool Constructors
    private PlayerClassFeaturesManager cfm = new PlayerClassFeaturesManager();

    // Character Data Constructors
    private PlayerLevel playerLevel = new PlayerLevel();
    private AbilityScores abilityScores = new AbilityScores();
    private ProficiencyBonus profBonus = new ProficiencyBonus();
    private SavingThrows savingthrows = new SavingThrows();
    private Skills skills = new Skills();
    private Initiative initiative = new Initiative();
    private ItemMagicMod magicMod = new ItemMagicMod();
    private ArmorClass armorClass = new ArmorClass();
    private HitPoints hitPoints = new HitPoints();
    private AccuracyAndDC accuracyAndDC = new AccuracyAndDC();
    private AttacksPerAction attacksPerAction = new AttacksPerAction();
    private WeaponDamage weaponDamage = new WeaponDamage();
    private SpellDamage singleTargetSpellDamage = new SpellDamage();
    private SpellDamage multiTargetSpellDamage = new SpellDamage();
    private SpellSlots spellSlots = new SpellSlots();

    public void RunCharacter(PlayerClasses[] build) {
        // Step 1: Set Character Build
        RunCharacterBuild(build);

        // Step 2: Set Ability Scores Origins
        RunCharacterAbilityScoreOrigins();

        // Step 3: Start Loop
        //PlayerClasses[] levelsAndTheirCLasses = playerLevel.GetClassesOfLevels();
        for (int l = 1; l < 21; l++) {
            // Step 18: Set/Update Ability Scores (Mortal and Magic)
            RunCharacterAbilityScoreUpdate();

            // Step 4: Set/Update Proficiency Bonus
            RunCharacterProficiencyBonus(l);

            // Step 5: Set/Update Saving Throws
            RunCharacterSavingThrows();

            // Step 6: Set/Update Skills
            RunCharacterSkills();

            // Step 7: Set/Update Initiative
            RunCharacterInitiative();

            // Step 8 Set/Update Item Magic Mod
            RunCharacterItemMagicMod(l);

            // Step 9: Set/Update Armor Class
            RunCharacterArmorClass();

            // Step 10: Set/Update Hit Points
            RunCharacterHitPoints(l);

            // Step 11: Set/Update Accuracy and DC
            RunCharacterAccuracyAndDC(l);

            // Step 12: Set/Update Attacks Per Action
            RunCharacterAttacksPerAction();

            // Step 13: Set/Update Weapon Damage
            RunCharacterWeaponDamage();

            // Step 14: Set/Update Spell Damage
            RunCharacterSpellDamage(l);

            // Step 15: Spell Slots
            RunCharacterSpellSlots(l);



            // Step 16: Set/Update Movement Speeds
            // Step 17: Set/Update Melee/Spell Range
        }

    }

    // Step 1: Generate Character Build
    private void RunCharacterBuild(PlayerClasses[] build) {
        playerLevel.SetCharacterBuild(build);
        playerLevel.SetCurrentLevelOfClass(playerLevel.GetOriginClass());
    }

    // Step 2: Generate Ability Scores Origins and Origin Mods
    private void RunCharacterAbilityScoreOrigins() {
        abilityScores.SetAbilityScoreOrigin();

        for(int a = 0; a < 6; a++) {
            abilityScores.SetAbilityMod(a);
        }
    }

    // Step 4: Set/Update Proficiency Bonus
    private void RunCharacterProficiencyBonus(int level) {
        profBonus.SetPlayerProficiencyBonus(level);
    }

    // Step 5: Set/Update Saving Throws
    private void RunCharacterSavingThrows() {
        for(int a = 0; a < 6; a++) {
            savingthrows.SetSavingThrows(a, abilityScores.GetAbilityMod(a), profBonus.GetProficiencyBonus());
        }
    }

    // Step 6: Set/Update Skills
    private void RunCharacterSkills() {
        for(int a = 0; a < 6; a++) {
            skills.SetSkills(a, abilityScores.GetAbilityMod(a), profBonus.GetProficiencyBonus());
        }
    }

    // Step 7: Set/Update Initiative
    private void RunCharacterInitiative() {
        for(int a = 0; a < 6; a++) {
            initiative.SetInitiativeNormal(a, abilityScores.GetAbilityMod(a));
        }
    }

    // Step 8 Set/Update Item Magic Mod
    private void RunCharacterItemMagicMod(int level) {
        magicMod.SetMagicMod(level);
    }

    // Step 9: Set/Update Armor Class
    private void RunCharacterArmorClass() {
        // Set Armorless and Mage Armor
        for(int a = 0; a < 6; a++) {
            armorClass.SetArmorlessAndMageArmor(a, abilityScores.GetAbilityMod(a));
        }

        // Set Light, Medium, and Heavy Armor
        for(int t = 0; t < 4; t++) {
            for(int a = 0; a < 6; a++) {
                armorClass.SetArmorLightMediumHeavy(t, a, abilityScores.GetAbilityMod(a), false);
            }
        }

        // Set Unarmored Defense
        for(int a1 = 0; a1 < 6; a1++){
            for(int a2 = 0; a2 < 6; a2++) {
                armorClass.SetUnarmoredDefense(a1, a2, abilityScores.GetAbilityMod(a1), abilityScores.GetAbilityMod(a2));
            }
        }

        // Set Shield
        armorClass.SetShield();

    }

    // Step 10: Set/Update Hit Points
    private void RunCharacterHitPoints(int level) {
        hitPoints.SetHitPointsPlayer(level, false);
    }

    // Step 11: Set/Update Accuracy and DC
    private void RunCharacterAccuracyAndDC(int level) {
        for(int a = 0; a < 6; a++){
            accuracyAndDC.SetAccuracyOrigin(a, abilityScores.GetAbilityMod(a), profBonus.GetProficiencyBonus());
            accuracyAndDC.SetDC_Origin(a, abilityScores.GetAbilityMod(a), profBonus.GetProficiencyBonus());
        }
    }

    // Step 12: Set/Update Attacks Per Action
    private void RunCharacterAttacksPerAction() {
        // Find the largest attack feature of each class
        PlayerClassFeatures temp;
        PlayerClassFeatures highestAttackFeature = PlayerClassFeatures.Attack_Action;
        for (PlayerClasses pc : PlayerClasses.values()) {
            temp = cfm.FindAttackFeature(playerLevel.GetCurrentLevelOfClass(pc), pc);
            if (temp == PlayerClassFeatures.Three_Extra_Attacks) { highestAttackFeature = PlayerClassFeatures.Three_Extra_Attacks; break; }
            if (temp == PlayerClassFeatures.Two_Extra_Attacks) { highestAttackFeature = PlayerClassFeatures.Two_Extra_Attacks; break; }
            if (temp == PlayerClassFeatures.Extra_Attack) { highestAttackFeature = PlayerClassFeatures.Extra_Attack; break; }
        }

        attacksPerAction.SetAttacks(highestAttackFeature);
    }

    // Step 13: Set/Update Weapon Damage
    private void RunCharacterWeaponDamage() {
        weaponDamage.SetWeaponsDice();
        weaponDamage.CalculateWeaponDamage();
    }

    // Step 14: Set/Update Spell Damage
    private void RunCharacterSpellDamage(int level) {
        // Single Target Spell Damage
        singleTargetSpellDamage.SetSingleTargetSpellDice(level);
        singleTargetSpellDamage.CalculateSpellDamage();

        // Multi Target Spell Damage
        multiTargetSpellDamage.SetMultiTargetSpellDice(level);
        multiTargetSpellDamage.CalculateSpellDamage();
    }

    // Step 15: Spell Slots
    private void RunCharacterSpellSlots(int level) {
        int spellCasterLevel = spellSlots.FindCasterLevel(playerLevel.GetCharacterBuild(), level, false);
        int pactCasterLevel = spellSlots.FindCasterLevel(playerLevel.GetCharacterBuild(), level, true);

        spellSlots.SetSpellSlots(spellCasterLevel);
        spellSlots.SetPactSlots(pactCasterLevel);
    }

    // Step 18: Set/Update Ability Scores (Mortal and Magic)
    private void RunCharacterAbilityScoreUpdate() {

    }

}
