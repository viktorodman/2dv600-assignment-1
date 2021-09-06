/** 
 * Date: 2021-09-06
 * File Name: TextProcessor.java
 * Author: Viktor Ödman
 */

package vo222dq_assign1;

import java.util.Scanner;

/**
 * Class Description: This class is used to make changes to a user provided sentence.
 * The changes are done to the sentence are:
 * 1. Every alphabetic letter in the sentence are changed with the letter following it in the alphabet(a-y)(z becomes a)
 * 2. Capitalizing every vowel
 * 
 * @version 1.0
 * @author Viktor Ödman
 */
public class TextProcessor {
    /**
     * Calls the internal methods to take a user provided sentence and make the needed changes.
     *  
     */
    public void processSentence() {
        String userSentence = readUserSentence();
        String transformedSentence =  transformSentence(userSentence);

        presentResult(transformedSentence);
    }

    /**
     * Presents the result of the transomed sentence
     * @param transformedSentence The transformed sentence.
     */
    private void presentResult(String transformedSentence) {
        System.out.print("After Processing: " + transformedSentence);
    }

    /**
     * Takes the originial sentence makes changes and returns the transformed sentence.
     * @param originalSentence The user provided sentence.
     * @return The transformed sentence.
     */
    private String transformSentence(String originalSentence) {
        String newSentence = "";

        for (int i = 0; i < originalSentence.length(); i++) {
            char currentChar = originalSentence.charAt(i);

            if (isAlphabeticalCharacter(currentChar)) {
                char replacedChar = replaceCharacter(currentChar);

                if (charIsVowel(replacedChar)) {
                    replacedChar = Character.toUpperCase(replacedChar);
                }

                newSentence += replacedChar;
            } else {
                newSentence += currentChar;
            }
        }

        return newSentence;
    }

    /**
     * Checks if the passed character is a vowel.
     * @param charToCheck The character to be checked.
     * @return True if the passed character is a vowel, otherwise false.
     */
    private boolean charIsVowel(char charToCheck) {
        return ("aeiou").indexOf(Character.toLowerCase(charToCheck)) != -1;
    }

    /**
     * Takes an character from the alphabet and returns the next character in the alphabet.
     * If the character is a "z" or "Z" an "a" or "A" will be returned.
     * 
     * 
     * @param charToBeReplaced A character in the alphabet.
     * @return The next character in the alphabet
     */
    private Character replaceCharacter(char charToBeReplaced) {
        int charCode = (int)charToBeReplaced;

        if (charCode == 90 || charCode == 122) {
            return (char)(charCode - 25);
        }

        return (char)(charCode + 1);
    }

    /**
     * Checks if the passed character is alphabetical.
     * The function is basically an abstraction of the Character.isAplhabetical function.
     * @param characterToBeChecked The character to be checked.
     * @return True if the character is aplhabetical, otherwise false
     */
    private boolean isAlphabeticalCharacter(char characterToBeChecked) {
        return Character.isAlphabetic((int)(characterToBeChecked));
    }

    /**
     * Prompts the user to enter a sentence. 
     * @return Returns the user provided sentence.
     */
    private String readUserSentence() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type a line of text: ");
        String userSentence = scanner.nextLine();
        scanner.close();
        return userSentence;
    } 
}
