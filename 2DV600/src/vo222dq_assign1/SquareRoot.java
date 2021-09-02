/** 
 * Date: 2021-09-01
 * File Name: SquareRoot.java
 * Author: Viktor Ödman
 */
package vo222dq_assign1;

import java.util.Scanner;

/**
 * Class Description: This class is used to estimate the square root of a given number.
 * 
 * @version 1.0
 * @author Viktor Ödman
 */
public class SquareRoot {
    private double prevGuess = 0;

    /**
     * Starts the Square Root estimations of the provided number.
     *  
     */
    public void startEstimation() {
        double number = promptUserInput();
        double initialGuess = number / 2d;
        double finalGuess = squareRootEstimation(initialGuess, number);

        String formattedGuess = String.format("%.2f", finalGuess);
        System.out.println("\nThe estimated sqare root of " + number + " is " + formattedGuess);
    }

    /***
     * Makes an attempt to estimate the square root of a given number.
     * Will run recursively until the passed guess is within 1% of the previous guess.  
     * 
     * @param guess An attempt of guessing the number 
     * @param number The number that the square root will be guessed
     * @return The estimated square root guess.
     */
    private double squareRootEstimation(double guess, double number) {
        prevGuess = guess;
        double r = number / guess;
        guess = (guess+r)/2;

        if (shouldContinueEstimating(guess, prevGuess)) {
            System.out.println("Current guess: " + guess);
            return squareRootEstimation(guess, number);
        }
        System.out.println("Current guess: " + guess);
        return guess;
    }

    /***
     * Checks if the passed guesses are within 1% of each other.
     * 
     * @param newGuess One of the guesses that will be checked.
     * @param prevGuess One of the guesses that will be checked.
     * @return Returns true if the passed guesses are within 1% of each other.
     */
    private boolean shouldContinueEstimating(double newGuess, double prevGuess) {
        double difference = newGuess - prevGuess;
        double percentage = (difference/prevGuess) * 100;

        if(percentage >= 1 || percentage <= -1) {
            return true;
        } 
        
        return false;
    }

    /**
     * Prompts the user to enter the number to check for the square root.
     * @return The number that the user entered.
     */
    private int promptUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This program estimate square roots.");
        System.out.print("Enter an integer to estimate the square root of: ");
        return scanner.nextInt();
    }
}
