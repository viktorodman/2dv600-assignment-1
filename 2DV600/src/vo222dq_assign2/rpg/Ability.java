/** 
 * Date: 2021-10-06
 * File Name: Ability.java
 * Author: Viktor Ödman
 */

package vo222dq_assign2.rpg;

/**
 * Class Description: Represents an ability for a character
 * 
 * @version 1.0
 * @author Viktor Ödman
 */
public class Ability {
    private String name;
    private String proficiency;

    /**
     * Creates a new instance of an Ability
     * @param name An abilities name
     * @param proficiency An abilities proficiency
     */
    public Ability(String name, String proficiency) {
        this.name = name;
        this.proficiency = proficiency;
    }

    /**
     * Gets the name of the ability
     * @return The abilities name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the proficiency of the ability
     * @return The proficiency of the ability
     */
    public String getProficiency() {
        return this.proficiency;
    }    
}
