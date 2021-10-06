/** 
 * Date: 2021-10-06
 * File Name: SwordWielder.java
 * Author: Viktor Ödman
 */

package vo222dq_assign2.rpg;

import java.util.ArrayList;

/**
 * Represents a Sword wielding character
 */
public abstract class SwordWielder extends Character {
    private ArrayList<Ability> knownAbilities = new ArrayList<Ability>();
    private String[] proficiencies;

    /**
     * Creates a new instance of Sword wielder
     * @param name The name of the Sword wielder
     * @param level The level of the Sword wielder
     * @param attributes The attributes of the Sword wielder
     * @param classStats The class stats of the Sword wielder
     */
    public SwordWielder(String name, String className, int level, Attributes attributes, ClassStats classStats) {
        super(name, className, level, attributes);
        this.proficiencies = classStats.getAvailableActions();
    }

    /**
     * Creates a new instance of sword wielder.
     * Randomizes the level of the character and its attributes.
     * @param name The name of the character
     * @param classStats the class stats of the character
     */
    public SwordWielder(String name, ClassStats classStats) {
        super(name, classStats.getClassName());
        this.proficiencies = classStats.getAvailableActions();
    }

    /**
     * Adds a ability to the list of known abilities If the ability is possible for the sword wielder to learn.
     * @param ability The ability to be learned.
     */
    public void learnAbility(Ability ability) {
        if (abilityCanBeLearned(ability) && !AbilityIsAlreadyKnown(ability)) {
            knownAbilities.add(ability);
        }
    }

    /**
     * Gets the abilities already known by the sword wielder
     * @return the abilities already known by the sword wielder
     */
    public ArrayList<Ability> getKnownAbilities() {
        return new ArrayList<>(knownAbilities);
    }

    /**
     * Checks of the passed ability can be learned by the sword wielder
     * @param ability The ability to be checked
     * @return True if the ability can be learned, else false
     */
    private boolean abilityCanBeLearned(Ability ability) {
        boolean canBeLearned = false;

        for (String proficiency : proficiencies) {
            if (ability.getProficiency() == proficiency) {
                canBeLearned = true;
            }
        }

        return canBeLearned; 
    }

    /**
     * Check if the passed ability is already known by the sword wielder.
     * @param ability The ability to be checked.
     * @return True if the ability is already known by the Sword wielder, else false
     */
    private boolean AbilityIsAlreadyKnown(Ability ability) {
        return knownAbilities.contains(ability);
    }
}
