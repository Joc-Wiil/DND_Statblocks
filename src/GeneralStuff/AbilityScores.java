package GeneralStuff;

public class AbilityScores {
    /*
     * Created:         05/01/26
     * Last Modified:   05/21/26
     *
     * An Ability Score has a Type, a Score, and a Modifier.
     *
     * The Type determines the Score and the Score determines the Modifier.
     *
     */

    private int[] abilityScoreOrigin = new int[6];
    private int[] abilityScoreMortal = new int[6];
    private int[] abilityScoreMagicBoons = new int[6];
    private int[] abilityScoreMagicBanes = new int[6];
    private int[] abilityMod = new int[6];

    public int GetTotalAbilityScore(int a) {
        return abilityScoreOrigin[a] + abilityScoreMortal[a] + abilityScoreMagicBoons[a] + abilityScoreMagicBanes[a];
    }

    public int GetAbilityScoreOrigin(int a) {
        return abilityScoreOrigin[a];
    }

    public void SetAbilityScoreOrigin() {
        abilityScoreOrigin[0] = 16;
        abilityScoreOrigin[1] = 16;
        abilityScoreOrigin[2] = 13;
        abilityScoreOrigin[3] = 12;
        abilityScoreOrigin[4] = 10;
        abilityScoreOrigin[5] = 8;
    }

    public int GetAbilityScoreMortal(int a) {
        return abilityScoreOrigin[a] + abilityScoreMortal[a];
    }

    public boolean SetAbilityScoreMortal(int a, int scoreMod) {
        int check = abilityScoreOrigin[a] + abilityScoreMortal[a] + scoreMod;
        // if (Max Mortal Ability Score)
        if (check > 20) { return false; }
        // else
        abilityScoreMortal[a] += scoreMod;
        return true;
    }

    public int GetAbilityScoreMagicBoons(int a) {
        return abilityScoreOrigin[a] + abilityScoreMortal[a] + abilityScoreMagicBoons[a];
    }

    public boolean SetAbilityScoreMagicBoons(int a, int scoreMod) {
        int check = abilityScoreOrigin[a] + abilityScoreMortal[a] + abilityScoreMagicBoons[a] + scoreMod;
        // if (Max Ability Score)
        if (check > 30) { return false; }
        // else
        abilityScoreMagicBoons[a] += scoreMod;
        return true;
    }

    public int GetAbilityScoreMagicBanes(int a) {
        return abilityScoreMagicBanes[a];
    }

    public boolean SetAbilityScoreMagicBanes(int a, int scoreMod) {
        int check = abilityScoreMagicBanes[a] + scoreMod;
        // if (Character Dies)
        if (check == 0) {
            AbilityScoreEqualsZero();
            return false;
        }
        // else
        abilityScoreMagicBanes[a] += scoreMod;
        return true;
    }

    public int GetAbilityMod(int a) {
        return abilityMod[a];
    }

    public void SetAbilityMod(int a) {
        int score = abilityScoreOrigin[a] + abilityScoreMortal[a] + abilityScoreMagicBoons[a] + abilityScoreMagicBanes[a];
        abilityMod[a] = ChangeAbilityModifier(score);
    }

    // Calls a Method in HitPoints that kills the Character
    private void AbilityScoreEqualsZero() {
        // Put code here
    }

    // Change the Ability Modifier
    private int ChangeAbilityModifier(int score) {
        int mod = 0;
        switch(score){
            case 1: mod = -5; break;
            case 2, 3: mod = -4; break;
            case 4, 5: mod = -3; break;
            case 6, 7: mod = -2; break;
            case 8, 9: mod = -1; break;
            case 10, 11: mod = 0; break;
            case 12, 13: mod = 1; break;
            case 14, 15: mod = 2; break;
            case 16, 17: mod = 3; break;
            case 18, 19: mod = 4; break;
            case 20: mod = 5; break;
            // ------------------------ Max Mortal Ability Score (Above)
            case 21: mod = 5; break;
            case 22, 23: mod = 6; break;
            case 24, 25: mod = 7; break;
            case 26, 27: mod = 8; break;
            case 28, 29: mod = 9; break;
            case 30: mod = 10; break;
            // ------------------------ Max Ability Score (Above)
            default: mod = 0;
        }
        return mod;
    }

}
