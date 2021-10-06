/** 
 * Date: 2021-10-06
 * File Name: Brawl.java
 * Author: Viktor Ödman
 */

package vo222dq_assign2.rpg;

/**
 * Represents a combat situation between two parties.
 */
public class Brawl extends Combat {
    private Party party1;
    private Party party2;
    private Party[] brawlSurvivors;

    /**
     * Create a new instance of brawl.
     * @param party1 The first party
     * @param party2 The second party
     */
    public Brawl(Party party1, Party party2) {
        this.party1 = party1;
        this.party2 = party2;
        this.brawlSurvivors = new Party[]{ party1, party2 };
    }
    
    /**
     * Starts a brawl between the two parties.
     * 
     * @return The surviving party/parties of the brawl.
     */
    public Party[] startBrawl() {
        startPartySizeChallenge();

        if (challengeHasWinner(brawlSurvivors.length)) return this.brawlSurvivors;
        
        startPartyLevelChallenge();
        
        if (challengeHasWinner(brawlSurvivors.length)) return this.brawlSurvivors; 

        startPrimaryAttributeChallenge();
        

        return this.brawlSurvivors;

    }

    /**
     * The two teams compares in terms of number of characters in the party.
     */
    private void startPartySizeChallenge() {
        boolean[] challengeResult = this.compareStats(this.party1.getPartySize(), this.party2.getPartySize());
        evaluateChallengeResults(challengeResult);
    }

    /**
     * The two teams compares in terms of average level of characters in the party.
    */
    private void startPartyLevelChallenge() {
        boolean[] challengeResult = this.compareStats(this.party1.getAverageLevel(), this.party2.getAverageLevel());
        evaluateChallengeResults(challengeResult);
    }

    /**
     * The two teams compares in terms of the sum of the individual characters primary attributes.
    */
    private void startPrimaryAttributeChallenge() {
        boolean[] challengeResult = this.compareStats(this.party1.getSumOfPrimaryAttributes(), this.party2.getSumOfPrimaryAttributes());
        evaluateChallengeResults(challengeResult);
    }

    /**
     * Determines which team/teams that survived the challenge
     * @param challengeResult The results of a challenge
     */
    private void evaluateChallengeResults(boolean[] challengeResult) {
        if (!bothCompetitorsSurvived(challengeResult)) {
            this.brawlSurvivors = challengeResult[0] 
                ? new Party[]{ party1 } 
                : new Party[]{ party2 };
        }
    }
}
