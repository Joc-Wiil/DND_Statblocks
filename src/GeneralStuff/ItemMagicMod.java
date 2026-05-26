package GeneralStuff;

public class ItemMagicMod {
    /*
     * Created:         05/11/26
     * Last Modified:   05/21/26
     *
     * What does this Script do?
     *
     * This script deals with the item magic modifier used in armor and weapons
     *
     */

    private int magicMod;

    public int GetMagicMod() { return magicMod; }

    public void SetMagicMod(int level) {
        if (level > 18) { magicMod = 4; }
        else if (level > 14) { magicMod = 3; }
        else if (level > 8) { magicMod = 2; }
        else if (level > 2 ) { magicMod = 1; }
        else { magicMod = 0; }
    }

}
