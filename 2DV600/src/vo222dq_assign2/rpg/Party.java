/** 
 * Date: 2021-10-06
 * File Name: Party.java
 * Author: Viktor Ödman
 */

package vo222dq_assign2.rpg;

/**
 * Represents a Party of characters
 */
public class Party {
    private Character[] partyMembers;
    private String teamName;

    /**
     * Creates a new instance of party.
     * @param partyMembers 
     * @param teamName 
     */
    public Party(Character[] partyMembers, String teamName) {
        this.partyMembers = partyMembers;
        this.teamName = teamName;
    }

    /**
     * Gets the average level of the party.
     * @return the average level of the party
     */
    public int getAverageLevel() {
        int averageLevel = 0; 

        for (Character partyMember : partyMembers) {
            averageLevel += partyMember.getLevel();
        }

        return averageLevel;
    }

    /**
     * Gets the size of the party
     * @return the size of the party
     */
    public int getPartySize() {
        return this.partyMembers.length;
    }

    /**
     * Returns the sum of the parties primary attributes 
     * 
     * @return The sum of the parties primary attributes
     */
    public int getSumOfPrimaryAttributes() {
        int sumOfPrimaryAttributes = 0;

        for (Character partyMember : partyMembers) {
            sumOfPrimaryAttributes += partyMember.getPrimaryAttribute();
        }

        return sumOfPrimaryAttributes;
    }

    /**
     * Returns the number of actions available for the party
     * @return the number of actions available for the party
     */
    public int getNumberOfActions() {
        return (this.getNumberOfAbilities() + this.getNumberOfSpells());
    }

    /**
     * Return the number of spells available for the party
     * @return The number of spells available for the party
     */
    public int getNumberOfSpells() {
        int numOfSpells = 0;

        for (Character partyMember : partyMembers) {
            if (partyMember instanceof Spellcaster) {
                Spellcaster tempSpellcaster = (Spellcaster) partyMember;
                numOfSpells += tempSpellcaster.getKnownSpells().size();
            }
        }

        return numOfSpells;
    }

    /**
     * Returns the number of abilities in the party.
     * @return the number of abilities in the party.
     */
    public int getNumberOfAbilities() {
        int numOfAbilities = 0;

        for (Character partyMember : partyMembers) {
            if (partyMember instanceof SwordWielder) {
                SwordWielder tempSwordWielder = (SwordWielder) partyMember;
                numOfAbilities += tempSwordWielder.getKnownAbilities().size();
            }
        }

        return numOfAbilities;
    }

    /**
     * Returns the numbers of cleric spells in the party
     * @return The numbers of cleric spells in the party 
     */
    public int getNumberOfClericSpells() {
        int numOfClericSpells = 0;

        for (Character partyMember : partyMembers) {
            if (partyMember instanceof Cleric) {
                Cleric tempCleric = (Cleric) partyMember;
                numOfClericSpells += tempCleric.getKnownSpells().size();
            }
        }

        return numOfClericSpells;
    }

    /**
     * Returns the numbers of mage spells in the party
     * @return The numbers of mage spells in the party 
     */
    public int getNumberOfMageSpells() {
        int numOfMageSpells = 0;

        for (Character partyMember : partyMembers) {
            if (partyMember instanceof Mage) {
                Mage tempMage = (Mage) partyMember;
                numOfMageSpells += tempMage.getKnownSpells().size();
            }
        }

        return numOfMageSpells;
    }

    /**
     * Returns the numbers of warrior abilities in the party
     * @return The numbers of warrior abilities in the party 
     */
    public int getNumberOfWarriorAbilities() {
        int numOfWarriorAbilities = 0;

        for (Character partyMember : partyMembers) {
            if (partyMember instanceof Warrior) {
                Warrior tempWarrior = (Warrior) partyMember;
                numOfWarriorAbilities += tempWarrior.getKnownAbilities().size();
            }
        }

        return numOfWarriorAbilities;
    }

    /**
     * Returns the numbers of rogue abilities in the party
     * @return The numbers of rogue abilities in the party 
     */
    public int getNumberRogueAbilities() {
        int numOfRogueAbilities = 0;

        for (Character partyMember : partyMembers) {
            if (partyMember instanceof Rogue) {
                Rogue tempRogue = (Rogue) partyMember;
                numOfRogueAbilities += tempRogue.getKnownAbilities().size();
            }
        }

        return numOfRogueAbilities;
    }

    /**
     * Creates a string representation of the party. 
     */
    public String toString() {
        return this.teamName;
    }
}
