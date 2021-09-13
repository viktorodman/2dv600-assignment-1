/** 
 * Date: 2021-09-08
 * File Name: Time.java
 * Author: Viktor Ödman
 */

package vo222dq_assign1;

/**
 * Class Description: This class is represents Time or a simple clock.
 * 
 * @version 1.0
 * @author Viktor Ödman
 */
public class Time {
    private final int SECONDS_IN_A_DAY = 86400;
    private final int SECONDS_IN_A_HOUR = 3600;
    private final int SECONDS_IN_A_MINUTE = 60;

    private int hours;
    private int minutes;
    private int seconds;
    
    /**
     * Creates an instance of Time with seconds minutes and hours set to 0
     */
    public Time() {
        this.setSeconds(0);
        this.setMinutes(0);
        this.setHours(0);
    }

    /**
     * Creates an instance of clock where hours minutes and seconds are set to the passed arguments.
     * @param hours The hours as an integer
     * @param minutes The minu as an integer
     * @param seconds The hours as an integer
     */
    public Time(int hours, int minutes, int seconds) {
        this.setHours(hours);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
    }

    /**
     * Creates an instance of Time with the hours minutes and seconds 
     * set to the passed amount of seconds. So seconds will be converted to hours, minutes and seconds.
     * @param timeInSeconds The time of the Time object in seconds.
     */
    public Time(int timeInSeconds) {
        this.setClock(timeInSeconds);
    }

    /**
     * Takes an Time object and calculates the time difference 
     * between the calling object and the passed object. 
     * A new Time object will be returned with the time difference as the initialize value of the object.
     * @param t2 A Time object
     * @return A Time object with its time set to the difference between the passed and the calling object.
     */
    public Time subtractTime(Time t2) {
        int secondsFromThisObject = this.totalTimeInSeconds(this.hours, this.minutes, this.seconds);
        int secondsFromPassedObject = this.totalTimeInSeconds(t2.getHours(), t2.getMinutes(), t2.getSeconds());

        int differenceInSeconds = Math.abs(secondsFromThisObject - secondsFromPassedObject);

        return new Time(differenceInSeconds);
    }

    /**
     * Add the time from the calling object with the passed object. 
     * A new object will be returned with the total time set as its initial time.
     * @param t2 A Time object.
     * @return A Time object set to the sum of the calling and the passed Time object.
     */
    public Time addTime(Time t2) {
        int secondsFromThisObject = this.totalTimeInSeconds(this.hours, this.minutes, this.seconds);
        int secondsFromPassedObject = this.totalTimeInSeconds(t2.getHours(), t2.getMinutes(), t2.getSeconds());

        return new Time(secondsFromThisObject + secondsFromPassedObject);
    }

    /**
     * Adds a second to the current time.
     */
    public void tick() {
        this.setClock(this.totalTimeInSeconds(this.hours, this.minutes, this.seconds) + 1);
    }

    /**
     * Removes one second from the current time.
     */
    public void tickDown() {
        this.setClock(this.totalTimeInSeconds(this.hours, this.minutes, this.seconds) - 1);
    }

    /**
     * Returns the seconds
     * @return Returns the seconds
     */
    public int getSeconds() {
        return seconds;
    }
    
    /**
     * Returns the minutes
     * @return Returns the minutes
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Returns the hours
     * @return Returns the hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * Sets the clock to the passed amount of seconds.
     * The time will change its hours, minutes and seconds accordingly to the passed amount of seconds
     * @param timeInSeconds Time in seconds
     */
    public void setClock(int timeInSeconds) {
        if (timeInSeconds >= SECONDS_IN_A_DAY) {
            setClock(timeInSeconds - SECONDS_IN_A_DAY);
        } else {
            int totalHours = timeInSeconds / SECONDS_IN_A_HOUR;
            int seconds = timeInSeconds - (totalHours * SECONDS_IN_A_HOUR);
            int minutes = seconds / SECONDS_IN_A_MINUTE;
    
            this.setHours(totalHours);
            this.setMinutes(minutes);
            this.setSeconds(seconds - (minutes * SECONDS_IN_A_MINUTE));
        }
    }

    /**
     * Sets the seconds.
     * Will throw an "IllegalArgumentException" if passed seconds are
     * less than 0 or greater than 59
     * @param seconds time in seconds.
     * @throws IllegalArgumentException if passed seconds are less than 0 or greater than 59
     */
    public void setSeconds(int seconds) {
        if (seconds < 0 || seconds > 59) {
            throw new IllegalArgumentException(
                "Seconds must be between 0 and 59. Passed value: " + Integer.toString(seconds)
            );
        } 

        this.seconds = seconds;
    }

    /**
     * Sets the minutes.
     * Will throw an "IllegalArgumentException" if passed minutes are
     * less than 0 or greater than 59
     * @param minutes time in minutes.
     * @throws IllegalArgumentException if passed minutes are less than 0 or greater than 59
     */
    public void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException(
                "Minutes must be between 0 and 59. Passed value: " + Integer.toString(minutes)
            );
        } 
        this.minutes = minutes;
    }
    
    /**
     * Sets the hours.
     * Will throw an "IllegalArgumentException" if passed hours are
     * less than 0 or greater than 23
     * @param hours time in hours.
     * @throws IllegalArgumentException if passed hours are less than 0 or greater than 23
     */
    public void setHours(int hours) {
        if (hours < 0 || hours > 23) {
            throw new IllegalArgumentException(
                "Hours must be between 0 and 23. Passed value: " + Integer.toString(hours)
            );
        } 
        this.hours = hours;
    }

    /**
     * Creates a string representation of the current time
     */
    public String toString() {
        String hours = numberToTwoDigitString(this.hours);
        String minutes = numberToTwoDigitString(this.minutes);
        String seconds = numberToTwoDigitString(this.seconds);

        return hours + ":" + minutes + ":" + seconds;
    }

    /**
     * Converts the passed int to a String and also adds a 0 in front of the new string
     * if the int does not consist of two numbers.
     * @param number The number to be converted
     * @return The passed number in string format and a 0 in front of the new string
     * if the int does not consist of two numbers.
     */
    private String numberToTwoDigitString(int number) {
        return String.format("%02d", number);
    }

    /**
     * Converts the passed time in hours, minutes and seconds into seconds
     * @param hours hours
     * @param minutes minutes
     * @param seconds seconds
     * @return the passed time in hours, minutes and seconds, in seconds.
     */
    private int totalTimeInSeconds(int hours, int minutes, int seconds) {
        return (hours * SECONDS_IN_A_HOUR) + (minutes * SECONDS_IN_A_MINUTE) + seconds;
    }
}
