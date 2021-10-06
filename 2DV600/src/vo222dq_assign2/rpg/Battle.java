/** 
 * Date: 2021-10-06
 * File Name: Battle.java
 * Author: Viktor Ödman
 */
package vo222dq_assign2.rpg;

/**
 * Represents a battle between characters
 */
public class Battle {
    
    /**
     * Simulates a battle between characters.
     * @param args
     */
    public static void main(String[] args) {
        Mage mage1 = new Mage(); 
        Mage mage2 = new Mage();

        mage1.learnSpell(new Spell("Arcane Blast", "evocation"));
        mage1.learnSpell(new Spell("Ice Lance", "evocation"));
        mage1.learnSpell(new Spell("Frostbolt", "evocation"));
        mage2.learnSpell(new Spell("Polymorph", "alteration"));
        mage2.learnSpell(new Spell("Flamestrike", "alteration"));
        mage2.learnSpell(new Spell("Arcane Explosion", "alteration"));

        Cleric cleric1 = new Cleric();
        Cleric cleric2 = new Cleric();

        cleric1.learnSpell(new Spell("Mending", "restoration"));
        cleric1.learnSpell(new Spell("Light", "restoration"));
        cleric1.learnSpell(new Spell("Hand of Radiance", "restoration"));
        cleric2.learnSpell(new Spell("Sacred Flame", "divination"));
        cleric2.learnSpell(new Spell("Toll the Dead", "divination"));
        cleric2.learnSpell(new Spell("Decompose", "divination"));
        
        Warrior warrior1 = new Warrior();
        Warrior warrior2 = new Warrior();

        warrior1.learnAbility(new Ability("Thunder Clap", "athletics"));
        warrior1.learnAbility(new Ability("Whirlwind", "athletics"));
        warrior1.learnAbility(new Ability("Charge", "athletics")); 
        warrior2.learnAbility(new Ability("Spell Reflection", "survival"));
        warrior2.learnAbility(new Ability("Shield Wall", "survival"));
        warrior2.learnAbility(new Ability("Victory Rush", "survival")); 

        Rogue rogue1 = new Rogue();
        Rogue rogue2 = new Rogue();
        rogue1.learnAbility(new Ability("Sprint", "acrobatics"));
        rogue1.learnAbility(new Ability("Kick", "acrobatics"));
        rogue1.learnAbility(new Ability("Vanish", "acrobatics"));  
        rogue2.learnAbility(new Ability("Backstab", "stealth"));
        rogue2.learnAbility(new Ability("Cloak of Shadows", "stealth"));
        rogue2.learnAbility(new Ability("Ambush", "stealth"));  
        
        Party party1 = new Party(new Character[]{ mage1, cleric1, warrior1, rogue1 }, "Team 1");
        Party party2 = new Party(new Character[]{ mage2, cleric2, warrior2, rogue2 }, "Team 2");

        singleCombat(mage1, mage2);
        resolve(party1, party2);
    }
    
    /**
     * Starts a battle between to characters.
     * @param firstCombatant the first character
     * @param secondCombatant the second character
     */
    public static void singleCombat(Character firstCombatant, Character secondCombatant) {
        Duel duel = new Duel(firstCombatant, secondCombatant);
        
        Character[] survivors = duel.startDuel();

        System.out.println("----------- Duel -----------\n\n" + firstCombatant.getName() + 
            " vs " + secondCombatant.getName() + "\n"
        );
        if (survivors.length < 2) {
            System.out.println("The winner is: " + survivors[0].getName());
        } else {
            System.out.println("Its a tie between " + survivors[0].getName() + " and " + survivors[1].getName());
        }
    }
    
    /**
     * Creates a battle between two parties.
     * @param party1 The first party
     * @param party2 The seconds party
     */
    public static void resolve(Party party1, Party party2) {
        printStatistics(party1);
        printStatistics(party2);
        Brawl brawl = new Brawl(party1, party2);

        Party[] survivors = brawl.startBrawl();

        if (survivors.length < 2) {
            System.out.println("The winner is: " + survivors[0]);
        } else {
            System.out.println("Its a tie between " + survivors[0] + " and " + survivors[1]);
        }

    }
    
    /**
     * Prints statistic about a party.
     * @param party
     */
    public static void printStatistics(Party party) {
        StringBuilder statisticsBuilder = new StringBuilder("");

        statisticsBuilder.append("----------- Party Statistics -----------\n\n");
        statisticsBuilder.append("Team Name: " + party + "\n\n");
        statisticsBuilder.append("Average level for party: " + party.getAverageLevel() + "\n");
        statisticsBuilder.append("Number of Spells: " + party.getNumberOfSpells() + "\n");
        statisticsBuilder.append("Number of Abilities: " + party.getNumberOfAbilities()  + "\n");
        statisticsBuilder.append("Number of Mage spells: " + party.getNumberOfMageSpells()  + "\n");
        statisticsBuilder.append("Number of Cleric spells: " + party.getNumberOfClericSpells()  + "\n");
        statisticsBuilder.append("Number of Warrior spells: " + party.getNumberOfWarriorAbilities()  + "\n");
        statisticsBuilder.append("Number of Rogue spells: " + party.getNumberRogueAbilities()  + "\n");
        statisticsBuilder.append("----------------------------------------");

        System.out.println(statisticsBuilder);
    }
}
