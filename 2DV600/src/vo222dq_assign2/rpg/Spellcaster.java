/** 
 * Date: 2021-10-06
 * File Name: Spellcaster.java
 * Author: Viktor Ödman
 */
package vo222dq_assign2.rpg;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Spellcaster
 */
public abstract class Spellcaster extends Character {
    private List<Spell> spellBook = new ArrayList<Spell>(); 
    private String[] spellSchools;

    /**
     * Creates a new instance of spellcaster
     * @param name The name of the spellcaster
     * @param level The level of the spellcaster
     * @param attributes The attributes of the spellcaster
     * @param classStats The class stats of the spellcaster
     */
    public Spellcaster(String name, int level, Attributes attributes, ClassStats classStats) {
        super(name, classStats.getClassName(), level, attributes);
        this.spellSchools = classStats.getAvailableActions();
    }

    /**
     * Creates a new instance of spellcaster.
     * Randomizes the level of the character and its attributes.
     * @param name The name of the character
     * @param classStats the class stats of the character
     */
    public Spellcaster(String name, ClassStats classStats) {
        super(name, classStats.getClassName());
        this.spellSchools = classStats.getAvailableActions();
    }
    
    /**
     * Adds a spell to the spellcasters spell book If the spells school is possible for the spellcaster to learn.
     * @param spell The spell to be learned.
     */
    public void learnSpell(Spell spell) {
        if (spellCanBeLearned(spell) && !spellIsAlreadyKnown(spell)) {
            spellBook.add(spell);
        }
    }

    /**
     * Gets the spells that the spellcaster currently knows.
     * @return the spells that the spellcaster currently knows.
     */
    public List<Spell> getKnownSpells() {
        return new ArrayList<Spell>(this.spellBook);
    }

    /**
     * Checks if the passed spell can be learned by the spellcaster.
     * @param spell Spell to be checked
     * @return True if the spell can be learned.
     */
    private boolean spellCanBeLearned(Spell spell) {
        boolean canBeLearned = false;

        for (String school : spellSchools) {
            if (spell.getSchool() == school) {
                canBeLearned = true;
            }
        }

        return canBeLearned;
    }

    /**
     * Checks if the passed spell is already known by the spellcaster
     * @param spell The spell to be checked
     * @return True if the spellcaster already knows the spell
     */
    private boolean spellIsAlreadyKnown(Spell spell) {
        return spellBook.contains(spell);
    }
}
