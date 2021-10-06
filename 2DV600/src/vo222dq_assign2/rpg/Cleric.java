/** 
 * Date: 2021-10-06
 * File Name: Cleric.java
 * Author: Viktor Ödman
 */

package vo222dq_assign2.rpg;

/**
 * Represents a Cleric character
 */
public class Cleric extends Spellcaster {
    private final static String[] clericNames = { "Classe cleric", "Generic cleric name", "Amen ramen", "Dr mugg" };
    private final static ClassStats classStats = new ClassStats(new String[]{"restoration", "divination"},  "Cleric");
       
    /**
     * Creates a new Cleric instance.
     * @param name The name of the cleric
     * @param level The level of the cleric
     * @param attributes The attributes of the cleric
     */
    public Cleric(String name, int level, Attributes attributes) {
        super(name, level, attributes, classStats);
    }

    /**
     * Creates a new Cleric instance.
     * The characters level, attributes and name will be randomized.
     */
    public Cleric() {
        super(NameGenerator.selectRandomNameFromList(clericNames), classStats);
    }
}
