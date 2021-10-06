/** 
 * Date: 2021-10-06
 * File Name: Warrior.java
 * Author: Viktor Ödman
 */
package vo222dq_assign2.rpg;

/**
 * Represents a Warrior character
 */
public class Warrior extends SwordWielder {
    private final static String[] warriorNames = { "Bert the fjert", "Olands Odygligen", "Ox Hagen", "Emil brakmakare" };
    private final static ClassStats classStats = new ClassStats(new String[]{"athletics", "survival"},  "Warrior");

    /**
     * Creates a new Warrior instance.
     * @param name The name of the Warrior
     * @param level The level of the Warrior
     * @param attributes The attributes of the Warrior
     */
    public Warrior(String name, int level, Attributes attributes) {
        super(name, classStats.getClassName(), level, attributes, classStats);
    }

    /**
     * Creates a new Warrior instance.
     * The characters level, attributes and name will be randomized.
     */
    public Warrior() {
        super(NameGenerator.selectRandomNameFromList(warriorNames), classStats);
    }
}
