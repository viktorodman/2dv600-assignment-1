/** 
 * Date: 2021-10-06
 * File Name: IdentifyWordsMain.java
 * Author: Viktor Ödman
 */
package vo222dq_assign2.exercise_5;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents a Class for demonstrating exercise 5
 */
public class IdentifyWordsMain {
    private final static String TEXT_FILE_NAME = "HistoryOfProgramming.txt";
    private final static String WRITE_FILE_NAME = "words.txt";

    /**
     * Demonstrates Task 5.1 in exercise 5
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ArrayList<String> linesFromFile = FileIO.readLinesFromFile(TEXT_FILE_NAME);
        ArrayList<String> filteredLines = createWordSequenceList(linesFromFile);


        FileIO.writeToFile(filteredLines, WRITE_FILE_NAME);
    }

    /**
     * Takes the lines read from the HistoryOfPRogramming file
     * and removes number and special characters.
     * @param originalList The lines from the original file
     * @return A list with modified lines
     */
    public static ArrayList<String> createWordSequenceList(ArrayList<String> originalList) {
        ArrayList<String> filteredLines = new ArrayList<String>();
        
        for (String line : originalList) {
            String tempString = "";
            for (int i = 0; i < line.length(); i++) {
                char currentChar = line.charAt(i);
                if (!Character.isAlphabetic(currentChar)) {
                    if (currentChar == '-' || Character.isSpaceChar(currentChar)) {
                        tempString += " ";
                    } else {
                        tempString += "";
                    }
                } else {
                    tempString += currentChar;
                }
            }

            filteredLines.add(tempString.replaceAll("[ ]+", " ").replaceAll(" s ", " "));
        }
       return filteredLines;
    }

    
}
