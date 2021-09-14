/** 
 * Date: 2021-09-09
 * File Name: Arrays.java
 * Author: Viktor Ödman
 */
package vo222dq_assign1;

/**
 * Class Description: This class is represents Static methods to manipulate an Integer array.
 * 
 * @version 1.0
 * @author Viktor Ödman
 */
public class Arrays {
    
    /**
     * Calculates and returns the average of the passed array.
     * @param arr An array of integers.
     * @return The average of the passed array
     */
    public static int average(int[] arr) {
        int sum = 0;

        for (int i : arr) {
            sum += i;
        }

        return sum / arr.length;
    }

    /**
     * Calculates the highest integer in the passed array
     * @param arr An array of integers.
     * @return The highest value in the passed array.
     */
    public static int max(int[] arr) {
        int maxNum = 0;

        for (int i : arr) {
            maxNum = i > maxNum ? i : maxNum;
        }

        return maxNum;
    }

    /**
     * Adds the passed integer "n" to every  position of the passed array.
     * This will affect the passed array.
     * 
     * @param arr An array of integers.
     * @param n The number to add to every element.
     * @return The passed array but with every changed values.
     */
    public static int[] addN(int[] arr, int n) {        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + n;   
        }

        return arr;
    }

    /**
     * Creates a new array, that is a reverse copy of the passed array.
     * @param arr An array of integers.
     * @return A reverse copy of the passed array.
     */
    public static int[] reverse(int[] arr) {
        int[] newArr = new int[arr.length];
        int x = 0;
        for (int i = arr.length; i > 0; i--) {
            newArr[x] = arr[i - 1];
            x++;
        }

        return newArr;
    }

    /**
     * Replaces all the occurences of the int "old" in the arr array
     * with the int nw. 
     * 
     * Will affect the passed array 
     * @param arr The array to be changed.
     * @param old The value to be changed.
     * @param nw The new value.
     */
    public static void replaceAll(int[] arr, int old, int nw) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == old) {
                arr[i] = nw;
            }
        }
    }

    /**
     * Creates a sorted copy of the passed array.
     * Will sort the values in an ascending order.
     * @param arr An array of integers.
     * @return A sorted copy of the passed array.
     */
    public static int[] sort(int[] arr) {
        int[] arrClone = arr.clone();

        int tempSwap = 0;

        for (int i = 0; i < arrClone.length; i++) {
           for (int j = i + 1; j < arrClone.length; j++) {
                if (arrClone[i] > arrClone[j]) {
                    tempSwap = arrClone[i];
                    arrClone[i] = arrClone[j];
                    arrClone[j] = tempSwap;
                }
           }
        }
        return arrClone;
   }

   /**
    * Checks if the passed array "sub" is a substring of the passed array "arr".
    * @param arr An array of integers.
    * @param sub The "substring" array of integers.
    * @return True if the "sub" array if a substring of the "arr" array.
    */
    public static boolean hasSubString(int[] arr, int[] sub) {
        boolean isSub = false;
       /**
        * Creates segements of arr which are the same length as sub
        * and checks if the segment is equal to the sub. 
        * Breaks if more segments are not possible
        * 
        * Example [1,2,3,4,5]
        * The segments are [1,2,3][2,3,4][3,4,5]
        * 
        */
        for (int i = 0; i < arr.length; i++) {
            int[] segmentArr = new int[sub.length];
            if((i + sub.length) > arr.length) {
                break;
            }
            for (int j = 0; j < sub.length; j++) {

                segmentArr[j] = arr[i+j];
            }

            if(arraysIsEqual(segmentArr, sub)) {
                isSub = true;
            }
        }
        
        return isSub;
    }

    /**
     * Creates an array that consist of the difference of the each position of "arr1" and "arr2" 
     * The passed arrays will have to be of the same length, otherwise an error will be thrown.
     * @param arr1 An array of integers.
     * @param arr2 An array of integers.
     * @throws IllegalArgumentException If the arrays are not of the same length. 
     * @return An array consisting of the difference between the passed arrays.
     */
    public static int[] absDif(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new IllegalArgumentException("Both arrays  must be of the same length");
        }
 
        int[] newArr = new int[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] > arr2[i]) {
                newArr[i] = arr1[i] - arr2[i];
            } else {
                newArr[i] = arr2[i] - arr1[i];
            }
        }

        return newArr;
    }

    private static boolean arraysIsEqual(int[] arr1, int[] arr2) {
        boolean isEqual = true;

        if(arr1.length != arr2.length) {
            isEqual = false;
        }

        for (int i = 0; i < arr2.length; i++) {
            if (arr1[i] != arr2[i]) {
                isEqual = false;
            }
        }

        return isEqual;
    }

    public static String arrayToString(int[] arr) {
        StringBuilder sBuilder = new StringBuilder("[");
        String separator = ", ";
        for (int i = 0; i < arr.length; i++) {
            sBuilder.append(arr[i]);
            if (i < arr.length - 1) {
                sBuilder.append(separator);
            }
        }
        sBuilder.append("]");

        return sBuilder.toString();
    }
}
