package GeneralStuff;

public class WeaponDamage {
    /*
     * Created:         05/15/26
     * Last Modified:   05/21/26
     *
     * What does this Script do?
     *
     * This script calculates the damage of the weapon dice.
     *
     * The needed variables are the number of dice,
     * The value of those dice,
     * and the output.
     *
     * The damage dice of Weapons:
     * 1d4
     * 1d6
     * 2d6
     * 1d8
     * 1d10
     * 1d12
     *
     * Also, a rule for magic items is that the largest dice value becomes the value for the magic weapon dice.
     */

    private int[] diceCount = new int[2];
    private int[] diceValue = new int[6];
    private int[] damageOutput = new int[6];

    public int GetDamageOutput(int diceValue) { return damageOutput[diceValue]; }

    public void SetWeaponsDice() {
        // Set Dice Count
        diceCount[0] = 1;
        diceCount[1] = 2;

        // Set Dice Values
        diceValue[0] = 4;
        diceValue[1] = 6;
        diceValue[2] = 6;
        diceValue[3] = 8;
        diceValue[4] = 10;
        diceValue[5] = 12;
    }

    public void CalculateWeaponDamage() {
        for (int dc = 0; dc < 2; dc++) {
            for (int dv = 0; dv < 5; dv++) {
                if (dc == 0) { damageOutput[dv] = ((diceCount[dc] * diceValue[dv]) / 2) + 1; }
                if (dc == 1) { damageOutput[2] = ((diceCount[dc] * diceValue[2]) / 2) + 1; break; }
            }
        }
    }

}