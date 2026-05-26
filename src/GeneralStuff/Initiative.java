package GeneralStuff;

public class Initiative {
    /*
     * Created:         05/11/26
     * Last Modified:   05/21/26
     *
     * Initiative for players and monsters
     *
     */

    private int[] initiative = new int[6];

    public int GetInitiative(int a) { return initiative[a]; }

    public void SetInitiativeNormal(int a, int mod) {
        initiative[a] = mod;
    }
}
