/** 
 * Date: 2021-10-06
 * File Name: NameGenerator.java
 * Author: Viktor Ödman
 */

package vo222dq_assign2.rpg;

import java.util.Random;

/**
 * Represents a nameGenerator
 */
public class NameGenerator {

    /**
     * Selects a random name from a list of names
     * @param listOfNames A list of names
     * @return a random name from the passed list.
     */
    public static String selectRandomNameFromList(String[] listOfNames) {
        Random rand = new Random();
        int position = rand.nextInt(listOfNames.length);
        return listOfNames[position];
    }
}
