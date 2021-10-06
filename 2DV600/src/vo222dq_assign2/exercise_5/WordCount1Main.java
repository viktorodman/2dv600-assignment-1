/** 
 * Date: 2021-10-06
 * File Name: WordCount1Main.java
 * Author: Viktor Ödman
 */

package vo222dq_assign2.exercise_5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Represents the demonstration of Task 5.3 in exercise 5
 */
public class WordCount1Main {
    private final static String FILE_NAME = "words.txt";

    /**
     * Demonstrates Task 5.3
     */
    public static void main(String[] args) {
        try {
            ArrayList<String> linesFromFile = FileIO.readLinesFromFile(FILE_NAME);

            HashSet<Word> wordHashSet = new HashSet<Word>();
            TreeSet<Word> wordTreeSet = new TreeSet<Word>();

            for (String line : linesFromFile) {
                String[] splitLine = line.split(" ");

                for (String word : splitLine) {
                    Word myWord = new Word(word);
                    wordHashSet.add(myWord);
                    wordTreeSet.add(myWord);
                }
            }

            System.out.println(wordHashSet.size());
            System.out.println(wordTreeSet.size());

            for (Word word : wordTreeSet) {
                System.out.println(word);
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.err.println(e);
        }
    }
    
}
