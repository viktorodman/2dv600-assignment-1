/** 
 * Date: 2021-10-06
 * File Name: Rogue.java
 * Author: Viktor Ödman
 */

package vo222dq_assign2.rpg;

/**
 * Represents a Rogue character
 */
public class Rogue extends SwordWielder {
    private final static String[] rogueNames = { "Lennart Laglydig", "Sa gott", "Mattias Rulljeff", "Runar rag" };
    private final static ClassStats classStats = new ClassStats(new String[]{"acrobatics", "stealth"},  "Rogue");

    /**
     * Creates a new Rogue instance.
     * @param name The name of the Rogue
     * @param level The level of the Rogue
     * @param attributes The attributes of the Rogue
     */
    public Rogue(String name, int level, Attributes attributes) {
        super(name, classStats.getClassName(), level, attributes, classStats);
    }

    /**
     * Creates a new Rogue instance.
     * The characters level, attributes and name will be randomized.
     */
    public Rogue() {
        super(NameGenerator.selectRandomNameFromList(rogueNames), classStats);
    }
}
