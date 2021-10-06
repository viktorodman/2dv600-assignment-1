/** 
 * Date: 2021-10-06
 * File Name: Attribute.java
 * Author: Viktor Ödman
 */
package vo222dq_assign2.rpg;

/**
 * Class Description: Represents the attributes of a character
 * 
 * @version 1.0
 * @author Viktor Ödman
 */
public class Attributes {
    private final String ATTRIBUTE_MESSAGE = "Attributes must be in the range [1-10]";
    private final int ATTRIBUTE_MAX_VALUE = 10;
    private final int ATTRIBUTE_MIN_VALUE = 1;
    private int strength;
    private int agility;
    private int intelligence;
    private int wisdom;
    
    /**
     * Creates a new instance of Attributes
     * @param strength The strength attribute of a character
     * @param agility The agility attribute of a character
     * @param intelligence The intelligence attribute of a character
     * @param wisdom The wisdom attribute of a character
     */
    public Attributes(int strength, int agility, int intelligence, int wisdom) {
        this.setStrength(strength);
        this.setAgility(agility);
        this.setIntelligence(intelligence);
        this.setWisdom(wisdom);
    }

    /**
     * Creates a new instance of Attributes with random values set to the different attributes.
     */
    public Attributes() {
        this.setRandomAttributes();
    }

    /**
     * Sets random values to the different attributes of a character.
     */
    private void setRandomAttributes() {
        int randomIntegers[] = new int[4];

        for (int i = 0; i < randomIntegers.length; i++) {
            randomIntegers[i] = (int) ((Math.random() * ((ATTRIBUTE_MAX_VALUE + 1) - ATTRIBUTE_MIN_VALUE)) + ATTRIBUTE_MIN_VALUE);
        }

        this.setAgility(randomIntegers[0]);
        this.setIntelligence(randomIntegers[1]);
        this.setStrength(randomIntegers[2]);
        this.setWisdom(randomIntegers[3]);
    }

    /**
     * Gets the wisdom attribute
     * @return The value of the wisdom attribute
     */
    public int getWisdom() {
        return wisdom;
    }

    /**
     * Sets the wisdom attribute.
     * The value to be set must be between 1 and 10.
     * 
     * @param wisdom Set the wisdom attribute
     * @throws IllegalArgumentException If the passed value is less than 1 over greater than 10
     */
    private void setWisdom(int wisdom) {
        if (wisdom < ATTRIBUTE_MIN_VALUE || wisdom > ATTRIBUTE_MAX_VALUE) {
            throw new IllegalArgumentException(ATTRIBUTE_MESSAGE);
        }

        this.wisdom = wisdom;
    }

     /**
     * Gets the intelligence attribute
     * @return The value of the intelligence attribute
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * Sets the intelligence attribute.
     * The value to be set must be between 1 and 10.
     * 
     * @param intelligence Set the intelligence attribute
     * @throws IllegalArgumentException If the passed value is less than 1 over greater than 10
     */
    private void setIntelligence(int intelligence) {
        if (intelligence < ATTRIBUTE_MIN_VALUE || intelligence > ATTRIBUTE_MAX_VALUE) {
            throw new IllegalArgumentException(ATTRIBUTE_MESSAGE);
        }

        this.intelligence = intelligence;
    }

    /**
     * Gets the agility attribute
     * @return The value of the agility attribute
     */
    public int getAgility() {
        return agility;
    }

    /**
     * Sets the agility attribute.
     * The value to be set must be between 1 and 10.
     * 
     * @param agility Set the agility attribute
     * @throws IllegalArgumentException If the passed value is less than 1 over greater than 10
     */
    private void setAgility(int agility) {
        if (agility < ATTRIBUTE_MIN_VALUE || agility > ATTRIBUTE_MAX_VALUE) {
            throw new IllegalArgumentException(ATTRIBUTE_MESSAGE);
        }
        this.agility = agility;
    }

    /**
     * Gets the strength attribute
     * @return The value of the strength attribute
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Sets the strength attribute.
     * The value to be set must be between 1 and 10.
     * 
     * @param strength Set the strength attribute
     * @throws IllegalArgumentException If the passed value is less than 1 over greater than 10
     */
    private void setStrength(int strength) {
        if (strength < ATTRIBUTE_MIN_VALUE || strength > ATTRIBUTE_MAX_VALUE) {
            throw new IllegalArgumentException(ATTRIBUTE_MESSAGE);
        }
        this.strength = strength;
    }
}

