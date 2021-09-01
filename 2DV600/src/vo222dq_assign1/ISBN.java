package vo222dq_assign1;

import java.util.Scanner;

public class ISBN {
    private final int ISBN_CHECKSUM = 10; 

    public void calculateISBNNumber() {
        String userISBNNumbers = getUserISBNNumbers();
        String ISBNChecksum = getLastISBNNumber(userISBNNumbers);
        
        System.out.println("Your ISBN number is: " + userISBNNumbers + ISBNChecksum);
    }

    private String getLastISBNNumber(String userISBNNumbers) {
        String[] ISBNArray = userISBNNumbers.split("");
        
        int sum = 0;

        for(int i = 0; i < ISBNArray.length; i++) {
            sum += Integer.parseInt(ISBNArray[i]) * (i+1);
        }

        int remainder = sum % 11;

        return remainder == ISBN_CHECKSUM ? "X": String.valueOf(remainder);
    }

    private String getUserISBNNumbers() {
        int userInput = promptUserInput();

        return formatISBNNumber(userInput);
    }

    private int promptUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first 9 ISBN-numbers: ");
        return scanner.nextInt();
    }

    private String formatISBNNumber(int ISBNnumber) {
        return String.format("%09d", ISBNnumber);
    }
}
