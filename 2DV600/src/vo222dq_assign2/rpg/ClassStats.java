/** 
 * Date: 2021-10-06
 * File Name: ClassStats.java
 * Author: Viktor Ödman
 */
package vo222dq_assign2.rpg;

/**
 * Represents a characters 
 * available actions // Proficiencies for Warrior and rogue and Schools for mage and cleric
 * and className.
 */
public class ClassStats {
    private String[] availableActions;
    private String className;
    
    /**
     * Creates a new instance of ClassStats
     * @param availableActions
     * @param className
     */
    public ClassStats(String[] availableActions, String className) {
       this.availableActions = availableActions;
       this.className = className;
    }
    
    /**
     * Gets the class name
     * @return The class name
     */
    public String getClassName() {
        return className;
    }

    /**
     * Gets the available actions
     * @return The available actions 
     */
    public String[] getAvailableActions() {
        return availableActions;
    }
}
