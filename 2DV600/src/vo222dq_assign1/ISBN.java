/** 
 * Date: 2021-09-01
 * File Name: ISBN.java
 * Author: Viktor Ödman
 */
package vo222dq_assign1;

import java.util.Scanner;

/**
 * Class Description: This class represents an ISBN number generator
 * 
 * @version 1.0
 * @author Viktor Ödman
 */
public class ISBN {

    /** 
     * Prompts the user to enter 9 out of the 10 digits in an ISBN-10 number,
     * and calculates and presents the 10th digit. 
     * 
     */
    public void calculateISBNNumber() {
        int userISBNNumbers = promptUserInput();
        String formattedISBNNumbers = formatISBNNumber(userISBNNumbers);
        String lastISBNNumber = getISBNChecksum(formattedISBNNumbers);

        
        System.out.println("Your ISBN number is: " + userISBNNumbers + lastISBNNumber);
    }
    /** 
     * Calculates the 10nth digit(the checksum) of the ISBN number.
     * 
     * @param userISBNNumbers The 9 first numbers of an ISBN-10 number.
     * @return The 10nth number/character of an ISBN-10 number.
     */
    private String getISBNChecksum(String userISBNNumbers) {
        int sum = 0;

        for(int i = 0; i < userISBNNumbers.length(); i++) {
            sum += Character.getNumericValue(userISBNNumbers.charAt(i)) * (i+1);
        }

        return sum % 11 == 10 ? "X": String.valueOf(sum % 11);
    }

    /** 
     * Prompts the user to enter the first 9 numbers of an ISBN-10 number.
     * 
     * @return The numbers that the user entered.
     */
    private int promptUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first 9 ISBN-numbers: ");
        int userInput = scanner.nextInt();
        scanner.close();
        return userInput;
    }

    /**
     * Converts a number to a string and adds leading 0's until the string contains 9 digits.
     *  
     * @param ISBNnumber An number containing up to 9 digits
     * @return The converted string
     */
    private String formatISBNNumber(int ISBNnumber) {
        return String.format("%09d", ISBNnumber);
    }
}
