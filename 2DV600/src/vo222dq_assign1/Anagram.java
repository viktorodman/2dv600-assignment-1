/** 
 * Date: 2021-09-06
 * File Name: Anagram.java
 * Author: Viktor Ödman
 */

package vo222dq_assign1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class Description: This class is used to ask the user for a word
 * and check for anagrams of the word in a wordlist
 * 
 * @version 1.0
 * @author Viktor Ödman
 */
public class Anagram {
    /**
     * The file name of the wordlist.
     */
    private final String FILE_NAME = "wordlist";

    /**
     * Prompts the user to enter a word and checks for anagrams of the word 
     * in a wordlist.
     */
    public void checkForAnagrams() {
        try {
            String userInput = promptUserInput();
            List<String> anagramList = checkAnagramForWord(userInput);

            presentResults(anagramList);
        } catch (IOException e) {
            System.err.println("IO Exception");
            e.printStackTrace();
        }
        
    }

    /**
     * Presents the found anagrams
     * 
     * @param anagramList A list of the found anagrams
     */
    private void presentResults(List<String> anagramList) {
        String presentationString = "";
        for (int i = 0; i < anagramList.size(); i++) {
            presentationString += anagramList.get(i);
            if (i < anagramList.size() - 1) {
                presentationString += ", ";
            }
        }
        System.out.print(presentationString);
    }

    /**
     * Reads the file line by line and checks if the passed word is an anagram of the
     * current line in the file.
     * 
     * @param userWord The word that will be used to check for anagrams.
     * @return A list of the found anagrams
     * @throws IOException Throws IOException if failure of reading the file.
     */
    private List<String> checkAnagramForWord(String userWord) throws IOException {
        try {
            List<String> anagramsFound = new ArrayList<String>();
            FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String wordFromFile = "";
            wordFromFile = bufferedReader.readLine();

            while (wordFromFile != null) {
                if(wordsAreSameLength(userWord, wordFromFile) && wordIsAnagram(userWord, wordFromFile)) {
                    anagramsFound.add(wordFromFile);
                }
                wordFromFile = bufferedReader.readLine();
            }

            bufferedReader.close();
            return anagramsFound;
        } catch (FileNotFoundException e) {
            //TODO: handle exception
            System.err.println("File Not Found");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Checks if the two passed words are of the same length
     * This is used to rule out if the users word and the currently read line are anagrams.
     * Since words must be of the same lenght in order to be an anagram.
     * 
     * @param firstWord One of the words.
     * @param secondWord One of the words.
     * @return True if the words are of the same length
     */
    private boolean wordsAreSameLength(String firstWord, String secondWord) {
        return firstWord.length() == secondWord.length();
    }

    /**
     * Check if the first passed string is an anagram of the second passed word
     * @param userWord One of the words.
     * @param wordToBeChecked One of the words.
     * @return True if the passed words are anagrams.
     */
    private boolean wordIsAnagram(String userWord, String wordToBeChecked) {
        boolean isAnagram = true;

        for (int i = 0; i < wordToBeChecked.length(); i++) {
            if (wordToBeChecked.indexOf(userWord.charAt(i)) == -1) {
                isAnagram = false;
            }
        }

        return isAnagram;
    }

    /**
     * Prompts the user to enter a word.
     * @return The word that the user entered.
     */
    private String promptUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String userSentence = scanner.next();
        scanner.close();
        return userSentence;
    }
}
