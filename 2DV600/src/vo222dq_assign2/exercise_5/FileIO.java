/** 
 * Date: 2021-10-06
 * File Name: FileIO.java
 * Author: Viktor Ödman
 */
package vo222dq_assign2.exercise_5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Represents a File reader and writer
 */
public class FileIO {
    
    /**
     * Reads the file with the passed filename and return an arrayList containing all the lines of the file
     * 
     * @param fileName The file to be read
     * @return A list with all the lines in the file
     * @throws IOException 
     */
    public static ArrayList<String> readLinesFromFile(String fileName) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            ArrayList<String> lines = new ArrayList<String>();
            
            String lineFromFile = "";
            lineFromFile = bufferedReader.readLine();
            int test = 0;
            while (lineFromFile != null) {
                lines.add(lineFromFile);
                lineFromFile = bufferedReader.readLine();
            }
            System.out.println(test); 
            
            bufferedReader.close();

            return lines;
        } catch (FileNotFoundException e) {
            //TODO: handle exception
            System.err.println("File Not Found");
            e.printStackTrace();
            return null;
        }
    }


    /**
     * Writes the lines of text passed in the list of lines to the files with the passed filename
     * 
     * @param fileName The file to be written to
     * @return A list with all the lines to be written
     * @throws IOException 
     */
    public static void writeToFile(ArrayList<String> linesToWrite, String filename) {
        try {
            File file = new File(filename);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            for (String ml : linesToWrite) {
                bufferedWriter.write(ml);
                bufferedWriter.write("\n");
            }

            bufferedWriter.close();
            fileWriter.close();

        } catch (Exception e) {
            System.err.println("ye");
            System.err.println(e);
        }
    }
}
