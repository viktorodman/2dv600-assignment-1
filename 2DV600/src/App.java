/** 
 * Date: 2021-09-01
 * File Name: App.java
 * Author: Viktor Ödman
 */

import vo222dq_assign1.Anagram;
import vo222dq_assign1.ArmstrongNumber;
import vo222dq_assign1.Codestrip;
import vo222dq_assign1.ISBN;
import vo222dq_assign1.InvoiceTest;
import vo222dq_assign1.Point;
import vo222dq_assign1.SquareRoot;
import vo222dq_assign1.TextProcessor;
/**
 * Starting point of the application.
 */
public class App {
    public static void main(String[] args) throws Exception {
        //demoISBN(); // Uncomment to demo ISBN
        //demoArmstrongNumber(); // Uncomment to demo Armstrong Number
        //demoSquareRoot(); // Uncomment to demo SquareRoot
        //demoTextProcessor(); // Uncomment to demo TextProcessor
        //demoAnagram(); // Uncomment to demo Anagram
        //demoCodestrip(); // Uncomment to demo Codestrip
        //demoPoint(); // Uncomment to demo Point
        //demoInvoice(); // Uncomment to demo Invoice

        //To demo the Time class, run The timeDemo main method.
        //To demo the Arrays class, run the ArraysMain main method.
    }

    private static void demoISBN() {
        ISBN isbn = new ISBN();
        isbn.calculateISBNNumber();
    }

    private static void demoArmstrongNumber() {
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();
        armstrongNumber.calculateArmstrongNumbers();
    }

    private static void demoSquareRoot() {
        SquareRoot squareRoot = new SquareRoot();
        squareRoot.estimateSquareRoot();
    }
    
    private static void demoTextProcessor() {
        TextProcessor textProcessor = new TextProcessor();
        textProcessor.processSentence();
    }
    
    private static void demoAnagram() {
        Anagram anagram = new Anagram();
        anagram.checkForAnagrams();
    }
    
    private static void demoCodestrip() {
        Codestrip codestrip = new Codestrip();
        codestrip.stripCode();
    }

    private static void demoPoint() {
        Point p1 = new Point();
        Point p2 = new Point(3,4);

        System.out.println(p1.toString()); // ==> (0,0)
        System.out.println(p2.toString()); // ==> (3,4)

        if (p1.isEqualTo(p2)) // False!
            System.out.println("The two points are equal");
        
        double dist = p1.distanceTo(p2);

        System.out.println("Point Distance: "+dist);
        
        p2.move(5,-2); // ==> (8,2)
        p1.moveToXY(8,2); // ==> (8,2)

       

        if (p1.isEqualTo(p2)) // True!
            System.out.println("The two points are equal");
    }

    private static void demoInvoice() {
        InvoiceTest invoiceTest = new InvoiceTest();
        invoiceTest.testInvoice();
    }


    
}
