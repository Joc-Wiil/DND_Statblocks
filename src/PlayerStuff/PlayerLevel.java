package PlayerStuff;

public class PlayerLevel {
    /*
     * Created:         05/01/26
     * Last Modified:   05/21/26
     *
     * What is this Script trying to do?
     *
     * This Script is acting like a Blueprint of the Character Build
     * Taking the Origin Class, the number of Levels in each Class and the Character level of when the Class Level increases
     */

    /*
     * A Character starts at Level 1 as it's Origin Class, and stops at Level 20
     * A Character's Level is based on the combined Levels of all their Classes
     * A Character can have 1 or more Classes
     *
     * The Character Level affects the Proficiency Bonus
     */

    private PlayerClasses[] characterBuild = new PlayerClasses[20];
    private int[] currentLevelOfCLass = new int[PlayerClasses.values().length];

    public PlayerClasses GetOriginClass() {
        return characterBuild[0];
    }

    public PlayerClasses[] GetCharacterBuild() {
        return characterBuild;
    }

    public void SetCharacterBuild(PlayerClasses[] build) {
        // Set Character Build
        characterBuild = build;
    }

    public int GetCurrentLevelOfClass(PlayerClasses pc) { return currentLevelOfCLass[pc.ordinal()]; }

    public void SetCurrentLevelOfClass(PlayerClasses pc) { currentLevelOfCLass[pc.ordinal()] += 1; }


}
