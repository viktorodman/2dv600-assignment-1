/** 
 * Date: 2021-10-06
 * File Name: Mage.java
 * Author: Viktor Ödman
 */

package vo222dq_assign2.rpg;

/**
 * Represents a Mage character
 */
public class Mage extends Spellcaster {
    private final static String[] mageNames = { "Cheezard", "Sam Salabam", "Parry Hotter", "Pokus Hokus" };
    private final static ClassStats classStats = new ClassStats(new String[]{"evocation", "alteration"},  "Mage");
    
    /**
     * Creates a new Mage instance.
     * @param name The name of the Mage
     * @param level The level of the Mage
     * @param attributes The attributes of the Mage
     */
    public Mage(String name, int level, Attributes attributes) {
        super(name, level, attributes, classStats);
    }

     /**
     * Creates a new Mage instance.
     * The characters level, attributes and name will be randomized.
     */
    public Mage() {
        super(NameGenerator.selectRandomNameFromList(mageNames), classStats);
    }
}
