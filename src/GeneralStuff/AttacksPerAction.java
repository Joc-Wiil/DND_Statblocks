package GeneralStuff;

import PlayerStuff.PlayerClassFeatures;

public class AttacksPerAction {
    /*
     * Created:         05/12/26
     * Last Modified:   05/21/26
     *
     * What is this Script trying to do?
     *
     * This Script tracks which class gets extra attacks and at what level
     *
     */

    private int attacks;

    private int GetAttacks() { return attacks; }

    public void SetAttacks(PlayerClassFeatures classFeat) {
        switch (classFeat) {
            case Extra_Attack: attacks = 2; break;
            case Two_Extra_Attacks: attacks = 3; break;
            case Three_Extra_Attacks: attacks = 4; break;
            default: attacks = 1; break;
        }
    }
}
