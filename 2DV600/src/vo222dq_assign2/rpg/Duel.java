/** 
 * Date: 2021-10-06
 * File Name: Duel.java
 * Author: Viktor Ödman
 */

package vo222dq_assign2.rpg;

/**
 * Represents a Duel between two characters. 
 */
public class Duel extends Combat{
    private Character firstCombatant;
    private Character secondCombatant;
    private Character[] duelSurvivors;

    /**
     * Creates an instance of Duel
     * @param firstCombatant The first duelist.
     * @param secondCombatant The second duelist.
     */
    public Duel(Character firstCombatant, Character secondCombatant) {
        this.firstCombatant = firstCombatant;
        this.secondCombatant = secondCombatant;
        this.duelSurvivors = new Character[]{firstCombatant, secondCombatant};
    }

    /**
     * Starts a new duel
     * @return The survivors of the duel
     */
    public Character[] startDuel() {
        startLevelChallenge();

        if (challengeHasWinner(duelSurvivors.length)) return duelSurvivors;
    
        startPrimaryAttributeChallenge();

        if (challengeHasWinner(duelSurvivors.length)) return duelSurvivors;

        startMostKnownActionsChallenge();

        return duelSurvivors;
    }

    /**
     * The two duelist compares in terms of level.
    */
    private void startLevelChallenge() {
        boolean[] challengeResult = this.compareStats(this.firstCombatant.getLevel(), this.secondCombatant.getLevel());
        evaluateChallengeResults(challengeResult);
    }

    /**
     * The two duelist compares in terms of primary attributes.
    */
    private void startPrimaryAttributeChallenge() {
        boolean[] challengeResult = this.compareStats(this.firstCombatant.getPrimaryAttribute(), this.secondCombatant.getPrimaryAttribute());
        evaluateChallengeResults(challengeResult);
    }

    /**
     * The two duelist compares in terms of number of known actions(spells or Abilities).
    */
    private void startMostKnownActionsChallenge() {
        Party tempParty1 = new Party(new Character[]{firstCombatant}, "tempname");
        Party tempParty2 = new Party(new Character[]{secondCombatant}, "tempname");

        boolean[] challengeResult = this.compareStats(tempParty1.getNumberOfActions(), tempParty2.getNumberOfActions());

        evaluateChallengeResults(challengeResult);
    }

    /**
     * Determines which team/teams that survived the challenge
     * @param challengeResult The results of a challenge
     */
    private void evaluateChallengeResults(boolean[] challengeResult) {
        if (!bothCompetitorsSurvived(challengeResult)) {
            this.duelSurvivors = challengeResult[0] 
                ? new Character[]{ firstCombatant } 
                : new Character[]{ secondCombatant };
        }
    }
}
