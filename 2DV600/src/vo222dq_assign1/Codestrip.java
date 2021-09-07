/** 
 * Date: 2021-09-07
 * File Name: Codestrip.java
 * Author: Viktor Ödman
 */
package vo222dq_assign1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class Description: This class is used to strip code files from
 * comments and blank lines, and also to count how many lines/comments that
 * were removed.
 * 
 * @version 1.0
 * @author Viktor Ödman
 */
public class Codestrip {
     /**
     * The file name of the code file.
     */
    private final String FILE_NAME = "ExampleClass.java";

    /**
     * Initializes the stripping of the code.
     */
    public void stripCode() {
        try {
            BufferedReader bufferedReader = readFile();
            calculateResultsFromFile(bufferedReader);
            bufferedReader.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * Counts the number of lines of code, comment and blank lines.
     * Also prints the code file without comments and blank lines
     * @param bufferedReader Used to read the next line in the file.
     * @throws IOException Throws an IOexception is code fails to read.
     */
    private void calculateResultsFromFile(BufferedReader bufferedReader) throws IOException{
        int linesOfCode = 0;
        int blankLines = 0;
        int comments = 0;
        boolean commentHasStarted = false;
        String newString = "";
        String lineFromFile = "";

        lineFromFile = bufferedReader.readLine();

        while (lineFromFile != null) {
            String trimmedLine = lineFromFile.trim();

            if (isBlankLine(trimmedLine)) {
                blankLines++;
            } else if(commentHasStarted) {
                if (isEndOfComment(trimmedLine)) {
                    comments++;
                    commentHasStarted = false;
                }
            } else if(isSingleLineComment(trimmedLine)) {
                comments++;
            } else if(isMultiLineComment(trimmedLine)) {
                commentHasStarted = true;
            } else {
                newString+=lineFromFile + "\n";
                linesOfCode++;
            }
            
            lineFromFile = bufferedReader.readLine();
        }
        printResults(linesOfCode, blankLines, comments, newString);
    }

    /**
     * Reads a file and return the bufferReader.
     * @return A BufferReader used to read the file,
     * @throws IOException Throws an IOexception is code fails to read.
     */
    private BufferedReader readFile() throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            return bufferedReader;
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Prints the result of number of lines, blank lines and comments. Also presents the stripped
     * version of the code file.
     * @param lines Number of lines of code.
     * @param blankLines Number of blank lines.
     * @param comments Number of comments.
     * @param codeSnippet The stripped code.
     */
    private void printResults(int lines, int blankLines, int comments, String codeSnippet) {
        System.out.println(
            "Stripped code\n" + 
            codeSnippet + "\n" +
            "Number of actual lines of code: " + lines + "\n" + 
            "Number of blank lines removed: " + blankLines + "\n" + 
            "Number of comments removed: " + comments
        );
    }

    /**
     * Checks if the passed line is blank.
     * @param lineToBeChecked The line that will be checked.
     * @return True if the line is blank,
     */
    private boolean isBlankLine(String lineToBeChecked) {
        return lineToBeChecked.isEmpty();
    }

    /**
     * Check if the line is an end of a comment
     * @param lineToBeChecked The line that will be checked.
     * @return True if the line is an end of a comment
     */
    private boolean isEndOfComment(String lineToBeChecked) {
        return lineToBeChecked.startsWith("*/");
    }

    /**
     * Checks if the line is a single line comment.
     * @param lineToBeChecked The line that will be checked.
     * @return True if line is a single line comment.
     */
    private boolean isSingleLineComment(String lineToBeChecked) {
        return lineToBeChecked.startsWith("//");
    } 

    /**
     * Checks if the line is a multiline comment.
     * @param line The line that will be checked.
     * @return True if the line is a multiline comment
     */
    private boolean isMultiLineComment(String line) {
        return line.startsWith("/*");
    } 

}
