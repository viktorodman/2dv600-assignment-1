/** 
 * Date: 2021-09-01
 * File Name: ArmstrongNumber.java
 * Author: Viktor Ödman
 */

package vo222dq_assign1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class Description: This class is used to calculate the 
 * Armstrong numbers between a set range of numbers.
 * 
 * @version 1.0
 * @author Viktor Ödman
 */
public class ArmstrongNumber {
    /**
     * An instance of a scanner, used to read values from the user.  
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Calculates the armstrong numbers in the range of numbers that the user decides.
     * Will keep running until the user decides to stop.
     */
    public void calculateArmstrongNumbers() {
        do {
            int startNumber = promptUserInput("Enter the starting number of the range :");
            int endNumber = promptUserInput("Enter the ending number of the range :");
            List<Integer> armstrongNumbers = getArmstrongNumbersInRange(startNumber, endNumber);

            presentResults(armstrongNumbers);
        } while(userWantsToContiue());
    }

    /**
     * Prompts the user and asks if the user wants to continiue running the app.
     * Will return true if the user enters Y and will otherwise return false.
     * @return True if the user enters Y and will otherwise return false.
     */
    private boolean userWantsToContiue() {
        System.out.print("Do you want to repeat? (Y/N): ");
        String userChoice = scanner.nextLine();
        System.out.println(userChoice);        
        return userChoice.equals("Y");
    }

    /**
     * Presents the passed armstrong numbers
     * @param armstrongNumbers A list of integers.
     */
    private void presentResults(List<Integer> armstrongNumbers) {
        System.out.println("\nThe Armstrong numbers between the given range are :");
        for (Integer integer : armstrongNumbers) {
            System.out.println(integer);
        }
    }

    /**
     * Checks for armstrong numbers in the passed range of numbers.
     * 
     * @param startNumber The starting number in the range of numbers.
     * @param endNumber The end number in the range of numbers.
     * @return Returns a list of integers containing the found armstrong numbers. 
     */
    private List<Integer> getArmstrongNumbersInRange(int startNumber, int endNumber) {
        List<Integer> armStrongNumbers = new ArrayList<Integer>();

        for(int i = startNumber; i <= endNumber; i++) {
            if(isAnArmstrongNumber(i)){
                armStrongNumbers.add(i);
            }
        }

        return armStrongNumbers;
    }

    /**
     * Checks if the passed number is an "Armstrong number". 
     * 
     * @param number The number to be checked.
     * @return Return true if the passed number is a "Armstrong number".
     */
    private boolean isAnArmstrongNumber(int number) {
        int sum = 0;
        String[] numberAsStringArray = numberToStringArray(number);

        for (String string : numberAsStringArray) {
            sum += Math.pow(Integer.parseInt(string), numberAsStringArray.length); 
        }

        return sum == number ? true : false;
    }

    /**
     * Creates a String Array representation of the passed integer.
     * @param number The number that will be converted to an String Array.
     * @return A String Array representation of the passed integer.
     */
    private String[] numberToStringArray(Integer number) {
        return number.toString().split("");
    }

    /**
     * Prints the passed message and prompts the user to enter a integer.
     * @param message A message that will be presented in the console.
     * @return The integer that the user entered.
     */
    private int promptUserInput(String message) {
        System.out.print(message);
        int userInput = scanner.nextInt();
        scanner.nextLine();
        return userInput;
    }
}
