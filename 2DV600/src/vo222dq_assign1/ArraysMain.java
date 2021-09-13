/** 
 * Date: 2021-09-09
 * File Name: ArraysMain.java
 * Author: Viktor Ödman
 */
package vo222dq_assign1;

/**
 * Class Description: This class is used to demonstrate the Arrays.java class.
 * 
 * @version 1.0
 * @author Viktor Ödman
 */
public class ArraysMain {
    private static int[] unchangedArray = { 1, 2, 3, 4, 5 };
    private static int nNumber = 2;
    private static int newValue = 9;
    private static int oldValue = 3;
    
    private static int[] changedArray = { 1, 2, 3, 4, 3 };
    private static int[] unchangedArrayForSort = { 2,6,1,9,3 };
    private static int[] arrForSubString = { 1, 2, 3, 4, 5, 6 ,7 };
    private static int[] subStringSuccess = { 3, 4, 5 };
    private static int[] subStringFail = { 3, 4, 6 };
    public static void main(String[] args) {
       /*  demoAverage();
        demoMax();
        demoAdn();
        demoReplaceAll();
        demoReverse();
        demoSort();
        demoSubstring();
        demoAbsDif(); */
    }

    /**
     * Demos the average method
     */
    private static void demoAverage() {
        int average = Arrays.average(unchangedArray);
        printIntResults(unchangedArray, average, "The average of the original array");
    }

    /**
     * Demos the max method
     */
    private static void demoMax() {
        int max = Arrays.max(unchangedArray); 
        printIntResults(unchangedArray, max, "The max of the original array");
    }

    /**
     * Demos the demoAdn method
     */
    private static void demoAdn() {
        int[] addN = Arrays.addN(unchangedArray, nNumber);  //Should be changed?
        printArrayResults(unchangedArray, addN, "The original array after adding " 
            + nNumber + " to every value"
        );
    }

    /**
     * Demos the replaceAll method
     */
    private static void demoReplaceAll() {
        System.out.println(
            "Array before replace all: " + 
            java.util.Arrays.toString(changedArray)
        );
        Arrays.replaceAll(changedArray, oldValue, newValue);
        System.out.println(
            "Array after replace all: " + 
            java.util.Arrays.toString(changedArray) + "\n"
        );
    }

    /**
     * Demos the Reverse method
     */
    private static void demoReverse() {
        int[] reverse = Arrays.reverse(unchangedArray);
        printArrayResults(unchangedArray, reverse, "A reversed copy of the original array");
    }

    /**
     * Demos the sort method
     */
    private static void demoSort() {
        int[] sort = Arrays.sort(unchangedArrayForSort);
        printArrayResults(unchangedArrayForSort, sort, "A sorted copy of the original array");
    }

    /**
     * Demos the hasSubString method
     */
    private static void demoSubstring() {
        // Is a substring
        printSubstringResult(
            arrForSubString, 
            subStringSuccess, 
            Arrays.hasSubString(arrForSubString, subStringSuccess), 
            "Should be a substring"
        );
        // Is not a substring
        printSubstringResult(
            arrForSubString, 
            subStringFail, 
            Arrays.hasSubString(arrForSubString, subStringFail), 
            "Should not be a substring"
        );
    }

    /**
     * Demos the absDif method
     */
    private static void demoAbsDif() {
        try {
            // A working version
            int[] absSuccess = Arrays.absDif(unchangedArray, unchangedArrayForSort);
            
            System.out.println(
                "\nArray representation for the difference between first and second array " + "\n" +
                "First Array: " + java.util.Arrays.toString(unchangedArray) + "\n" +
                "Second Array: " + java.util.Arrays.toString(unchangedArrayForSort) + "\n" +
                "Difference Array: " + java.util.Arrays.toString(absSuccess) + "\n"
            );

            // Version that should throw an error
            int[] absWithError = Arrays.absDif(unchangedArray, subStringSuccess);

        } catch (IllegalArgumentException e) {
            System.out.println(
                "Error: " + e.getClass().getName() + "\n" +
                "Message: " + e.getMessage() + "\n"
            );
            demoDoneMessage();
            System.exit(0);
        }
    }

    private static void demoDoneMessage() {
        System.out.println("\n=========== Demo done :) ===========\n");
    }

    private static void printSubstringResult(int[] arr, int[] subString, boolean isSubString, String message) {
        System.out.println(
            "\n" + message + "\n" +
            "Array: " + java.util.Arrays.toString(arr) + "\n" +
            "Sub String: " + java.util.Arrays.toString(subString) + "\n" +
            "isSubString?: " + isSubString + "\n"
        );
    }

    private static void printArrayResults(int[] original, int[] changed, String message) {
        System.out.println(
            "\nResult for : " + message + "\n" +
            "Original Array: " + java.util.Arrays.toString(original) + "\n" +
            "Changed Array: " + java.util.Arrays.toString(changed) + "\n"
        );
    }

    private static void printIntResults(int[] original, int changed, String message) {
        System.out.println(
            "\nResult for : " + message + "\n" +
            "Original Array: " + java.util.Arrays.toString(original) + "\n" +
            "Result: " + changed + "\n"
        );
    }
}
