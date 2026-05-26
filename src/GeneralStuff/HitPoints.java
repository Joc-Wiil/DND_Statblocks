package GeneralStuff;

public class HitPoints {
    /*
     * Created:         05/12/26
     * Last Modified:   05/21/26
     *
     * What is this Script trying to do?
     *
     * This Script takes each hit dice (d6, d8, d10 and d12 for players and monsters, and d4 and d20 for monsters)
     * and calculates their hit points per level
     *
     */

    private int[] diceValues = new int[6];

    private int[] hitPointsPlayer = new int[4];

    private int[] hitPointsMonster = new int[6];

    public int GetHitPointsPlayer(int dice) { return hitPointsPlayer[dice]; }

    public int GetHitPointsMonster(int dice) { return hitPointsMonster[dice]; }

    public void SetHitPointsPlayer(int level, boolean hasToughFeat) {
        SetDice();

        if (level == 1) {
            SetHitPointsPlayerRepeat(true, hasToughFeat);
        } else {
            SetHitPointsPlayerRepeat(false, hasToughFeat);
        }
    }

    private void SetHitPointsPlayerRepeat(boolean isLevelOne, boolean hasToughFeat) {
        int tough = 0;
        if (hasToughFeat) tough = 2;

        for(int d = 0; d < 4; d++) {
            // if level = to 1 then Hit Points for that level is = to Max
            if (isLevelOne) {
                hitPointsPlayer[d] = diceValues[d+1] + tough;
            } else {
                hitPointsPlayer[d] += (diceValues[d+1] / 2) + tough;
            }
        }
    }

    private void SetDice() {
        diceValues[0] = 4;
        diceValues[1] = 6;
        diceValues[2] = 8;
        diceValues[3] = 10;
        diceValues[4] = 12;
        diceValues[5] = 20;
    }
}
