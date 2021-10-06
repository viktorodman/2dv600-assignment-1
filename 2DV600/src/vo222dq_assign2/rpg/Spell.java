/** 
 * Date: 2021-10-06
 * File Name: Spell.java
 * Author: Viktor Ödman
 */

package vo222dq_assign2.rpg;

/**
 * Represents a Spell
 */
public class Spell {
    private String name;
    private String school;
    
    /**
     * Creates a Spell instance
     * @param name The name of the spell
     * @param school The School of the spell
     */
    public Spell(String name, String school) {
        this.name = name;
        this.school = school;
    }
    
    /**
     * Gets the name of the spell
     * @return The name of the spell
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the school of the spell
     * @return the school of the spell
     */
    public String getSchool() {
        return this.school;
    }
}
