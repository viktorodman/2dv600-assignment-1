package vo222dq_assign1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Codestrip {
    private final String FILE_NAME = "ExampleClass.java";
    public void stripCode() {
        try {
            readFile();
        } catch (Exception e) {
            //TODO: handle exception
            System.err.println(e);
        }
    }

    private boolean isSingleLineComment(String line) {
        return line.startsWith("//");
    } 

    private boolean isMultiLineComment(String line) {
        return line.startsWith("/*");
    } 
    
    private boolean isJavadocComment(String line) {
        return line.startsWith("/**");
    } 

    private void readFile() throws IOException {
        try {
            int lines = 0;
            int blankLines = 0;
            int comments = 0;

            boolean commentHasStarted = false;

            FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String newString = "";
            String lineFromFile = "";
            lineFromFile = bufferedReader.readLine();

            while (lineFromFile != null) {
                String trimmedLine = lineFromFile.trim();
                if (trimmedLine.isEmpty()) {
                    // Do empty stuff
                    blankLines++;
                } else if(commentHasStarted) {
                    // Do something
                    if (isEndOfComment(trimmedLine)) {
                        // Do something
                        comments++;
                        commentHasStarted = false;
                    }
                } else if(isSingleLineComment(trimmedLine)) {
                    comments++;
                } else if(isMultiLineComment(trimmedLine)) {
                    commentHasStarted = true;
                } else if(isJavadocComment(trimmedLine)) {
                    commentHasStarted = true;
                } else {
                    newString+=lineFromFile + "\n";
                    lines++;
                }
                
                lineFromFile = bufferedReader.readLine();
            }
            printResults(lines, blankLines, comments, newString);

            bufferedReader.close();
        } catch (FileNotFoundException e) {
            //TODO: handle exception
            System.err.println("File Not Found");
            e.printStackTrace();
        }
    }

    private void printResults(int lines, int blankLines, int comments, String codeSnippet) {
        System.out.println(
            "Stripped code\n" + 
            codeSnippet + "\n" +
            "Number of actual lines of code: " + lines + "\n" + 
            "Number of blank lines removed: " + blankLines + "\n" + 
            "Number of comments removed: " + comments
        );
    }

    private boolean isEndOfComment(String trimmedLine) {
        return trimmedLine.startsWith("*/");
    }

    private boolean isCommentFinnished(String trimmedLine) {
        return trimmedLine.startsWith("*/") || trimmedLine.startsWith("//");
    }

}
