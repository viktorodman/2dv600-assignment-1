package vo222dq_assign1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArmstrongNumber {
    
    public void calculateArmstrongNumbers() {
        /* do {

        } */
        int startNumber = promptUserInput("Enter the starting number of the range :");
        int endNumber = promptUserInput("Enter the ending number of the range :");

        List<Integer> armstrongNumbers = getArmstrongNumbersInRange(startNumber, endNumber);

        presentResults(armstrongNumbers);
    }


    private void presentResults(List<Integer> armstrongNumbers) {
        System.out.println("\nThe Armstrong numbers between the given range are :");
        for (Integer integer : armstrongNumbers) {
            System.out.println(integer);
        }
    }


    private List<Integer> getArmstrongNumbersInRange(int startNumber, int endNumber) {
        List<Integer> armStrongNumbers = new ArrayList<Integer>();

        for(int i = startNumber; i <= endNumber; i++) {
            String[] numberToArray = numberToStringArray(i);
            if(isArmstrongNumber(numberToArray, i)){
                armStrongNumbers.add(i);
            }
        }

        return armStrongNumbers;
    }

    private boolean isArmstrongNumber(String[] numberArray, int number) {
        int sum = 0;

        for (String string : numberArray) {
            sum += Math.pow(Integer.parseInt(string), numberArray.length); 
        }

        return sum == number ? true : false;
    }

    private String[] numberToStringArray(Integer number) {
        return number.toString().split("");
    }

    private int promptUserInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextInt();
    }
}
