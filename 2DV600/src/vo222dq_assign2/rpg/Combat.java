/** 
 * Date: 2021-10-06
 * File Name: Combat.java
 * Author: Viktor Ödman
 */

package vo222dq_assign2.rpg;

/**
 * Represents a Combat interaction.
 */
public abstract class Combat {

    /**
     * Checks if the first two  booleans in the passed array are true or not.
     * @param competitors An array of booleans, if both are true than both teams survived.
     * @return The result of the competition. True if both teams survived.
     */
    public boolean bothCompetitorsSurvived(boolean[] competitors) {
        return competitors[0] && competitors[1];
    }

    /**
     * Checks if the passed amount of survivors are more than two.
     * If it is the method returns false, else it returns true.
     * @param numOfSurvivors Number of survivors.
     * @return False if passed value is greater than 2 else True
     */
    public boolean challengeHasWinner(int numOfSurvivors) {
        return numOfSurvivors < 2;
    }

    /**
     * Compares two stats.
     * @param stat1 First stat
     * @param stat2 Second stat
     * @return an array containing [true, true] if the stats where equal | [true, false] if stat1 is greater than stat2 etc..
     */
    public boolean[] compareStats(int stat1, int stat2) {
        if (notEqual(stat1, stat2)) {
            return stat1 > stat2 ? 
                new boolean[]{ true, false }:
                new boolean[] { false, true };
        } else {
            return new boolean[] { true, true };
        }
    }

    /**
     * Return true if the passed values are not equal, else false
     * @param first first value
     * @param second second value
     * @return true if the passed values are not equal, else false
     */
    private static boolean notEqual (int first, int second) {
        return first != second;
    }
}
