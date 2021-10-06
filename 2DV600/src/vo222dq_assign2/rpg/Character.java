/** 
 * Date: 2021-10-06
 * File Name: Character.java
 * Author: Viktor Ödman
 */
package vo222dq_assign2.rpg;

import java.util.Random;

/**
 * Represents a game-character
 */
public abstract class Character {
    private final int CHARACTER_MAX_LEVEL = 20;
    private final int CHARACTER_MIN_LEVEL = 1;
    private String name;
    private String className;
    private int level;
    private Attributes attributes;

    /**
     * Creates a new instance of a Character
     * @param name Name of the character
     * @param className The class name of the character 
     * @param level The level of the character.
     * @param attributes The characters attributes.
     */
    public Character(String name, String className, int level, Attributes attributes) {
        this.name = name;
        this.className = className;
        this.setLevel(level);
        this.attributes = attributes;
    }

    /**
     * Creates a new instance of a Character and randomizes the level of the character and its attributes.
     * @param name The characters name 
     * @param className The characters class name
     */
    public Character(String name, String className) {
        this.randomizeLevel();
        this.attributes = new Attributes();
        this.name = name;
        this.className = className;
    }

    /**
     * Sets a random level for the character
     */
    private void randomizeLevel() {
        Random rand = new Random();
        this.setLevel((rand.nextInt(CHARACTER_MAX_LEVEL)) +1);
    }

    /**
     * Returns the primary attribute of the character, which is determined by its class.
     * @return The value of the primary attribute of the character.
     */
    public int getPrimaryAttribute() {
        switch (this.className) {
            case "Mage":
                return this.attributes.getIntelligence();
            case "Cleric":
                return this.attributes.getWisdom();
            case "Warrior":
                return this.attributes.getStrength();
            case "Rouge":
                return this.attributes.getAgility();
            default:
                return -1;
        }
    }

    /**
     * Get the characters attributes
     * @return The characters attributes
     */
    public Attributes getAttributes() {
        return this.attributes;
    }

    /**
     * Gets the characters name
     * @return The characters name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Gets the characters level
     * @return The characters level.
     */
    public int getLevel() {
        return this.level;
    }
    
    /**
     * Gets the characters class name
     * @return
     */
    public String getClassName() {
        return this.className;
    }

    /**
     * Sets the characters level.
     * Throws an exception if the passed level is greater than 20 or less than 1
     * @param level The level to be set
     * @throws IllegalArgumentException if the passed level is greater than 20 or less than 1.
     */
    private void setLevel(int level) {
        if (level < CHARACTER_MIN_LEVEL || level > CHARACTER_MAX_LEVEL) {
            throw new IllegalArgumentException("Character level must be in the range [1-20]");
        }
        this.level = level;
    }

    /**
     * Creates a string representation of the Character
     */
    public String toString() {
        return "Class: " + this.className + "\n" + "Name: " + this.name + "\n" + "Level: " + this.level;
    } 
}
