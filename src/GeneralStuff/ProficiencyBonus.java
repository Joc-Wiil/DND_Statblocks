package GeneralStuff;

import MonsterStuff.ChallengeRating;

public class ProficiencyBonus {
    /*
     * Created:         05/01/26
     * Last Modified:   05/21/26
     *
     * Is Used by Players and Monsters
     *
     * For Players the ProficiencyBonus is based on Level
     *
     * For Monsters the ProficiencyBonus is based on Challenge Rating
     *
     */

    private int proficiencyBonus;

    public int GetProficiencyBonus() {
        return proficiencyBonus;
    }

    // Set and reset each time the player levels up
    public void SetPlayerProficiencyBonus(int level) {
        if (level >= 17) { proficiencyBonus = 6; }
        else if (level >= 13) { proficiencyBonus = 5; }
        else if (level >= 9) { proficiencyBonus = 4; }
        else if (level >= 5) { proficiencyBonus = 3; }
        else { proficiencyBonus = 2; }
    }

    // Set once per Monster
    public void SetMonsterProficiencyBonus(ChallengeRating cr) {
        switch (cr) {
            // -------------------------- Prof. Bonus of 2
            case CR_Zero, CR_One_Eighth, CR_One_Quarter, CR_One_Half, CR_One, CR_Two, CR_Three, CR_Four: proficiencyBonus = 2; break;
            // -------------------------- Prof. Bonus of 3
            case CR_Five, CR_Six, CR_Seven, CR_Eight: proficiencyBonus = 3; break;
            // -------------------------- Prof. Bonus of 4
            case CR_Nine, CR_Ten, CR_Eleven, CR_Twelve: proficiencyBonus = 4; break;
            // -------------------------- Prof. Bonus of 5
            case CR_Thirteen, CR_Fourteen, CR_Fifteen, CR_Sixteen: proficiencyBonus = 5; break;
            // -------------------------- Prof. Bonus of 6
            case CR_Seventeen, CR_Eighteen, CR_Nineteen, CR_Twenty: proficiencyBonus = 6; break;
            // -------------------------- Prof. Bonus of 7
            case CR_Twenty_One, CR_Twenty_Two, CR_Twenty_Three, CR_Twenty_Four: proficiencyBonus = 7; break;
            // -------------------------- Prof. Bonus of 8
            case CR_Twenty_Five, CR_Twenty_Six, CR_Twenty_Seven, CR_Twenty_Eight: proficiencyBonus = 8; break;
            // -------------------------- Prof. Bonus of 9
            case CR_Twenty_Nine, CR_Thirty: proficiencyBonus = 9; break;
        }
    }

}
