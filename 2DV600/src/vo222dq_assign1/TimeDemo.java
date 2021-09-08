/** 
 * Date: 2021-09-08
 * File Name: TimeDemo.java
 * Author: Viktor Ödman
 */

package vo222dq_assign1;

import java.util.Scanner;

/**
 * Class Description: This class is used to test the Time.java class.
 * 
 * @version 1.0
 * @author Viktor Ödman
 */
public class TimeDemo {
    /**
     * Starts the testing of the Time.java class
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /**
         * Prompts the user to enter a number in seconds which will be used to create 
         * a new Timer instance(timeA). Will also add 1 second to the clock and print its current time
         * 10 times
         */
        Time timeA = new Time(readUserInput(scanner));
        runClock(timeA, 10);

        /**
         * Prompts the user to enter 3 numbers (Hours, minutes, seconds) which will be used to create 
         * a new Timer instance(timeB). Will also add 1 second to the clock and print its current time
         * 10 times
         */
        int[] hoursMinutesSeconds = {0,0,0};

        for (int i = 0; i < 3; i++) {
            hoursMinutesSeconds[i] = readUserInput(scanner);
        }

        Time timeB = new Time(hoursMinutesSeconds[0], hoursMinutesSeconds[1], hoursMinutesSeconds[2]);

        runClock(timeB, 10);

        // Adds the time of timeA and timeB and shows the sum of the time of the clocks.
        System.out.println("timeA added with timeB: " + timeA.addTime(timeB) + "\n");

        /**
         * Creates timeC, by calling timeA's "subtractTime" method and passing the timeB 
         * instance as an argument. The timeC instance time will be the difference between
         * timeA and timeB.
         */
        Time timeC = timeA.subtractTime(timeB);

        System.out.println("Difference between timeA and timeB: " + timeC);

        scanner.close();
    }

    /**
     * Will take the passed Time instance and run the "tick" method and print the
     * current time the passed amount of times.
     * @param time A Time instance
     * @param times How many times the tick() method and printing the current time should happen.
     */
    public static void runClock(Time time, int times) {
        System.out.println("\n========= Running Clock " + times + " times =========\n");
        for (int i = 0; i < times; i++) {
            time.tick();
            System.out.println(time);
        }
        System.out.println("\n========= END =========\n");
    } 

    /**
     * Prompts the user to enter a number
     * @param scanner A Scanner instance used to read inputs from the user.
     * @return The number the user entered.
     */
    public static int readUserInput(Scanner scanner) {
        System.out.print("Enter a number: ");
        int userNumber = scanner.nextInt();
        return userNumber;
    }
}
