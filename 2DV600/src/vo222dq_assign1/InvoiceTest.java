/** 
 * Date: 2021-09-07
 * File Name: InvoiceTest.java
 * Author: Viktor Ödman
 */
package vo222dq_assign1;

/**
 * Class Description: This class is used to test the Invoice.java class
 * 
 * @version 1.0
 * @author Viktor Ödman
 */
public class InvoiceTest {
    
    /**
     * Runs all the tests
     */
    public void testInvoice() {
        negativeQuantityShouldBeCorrected();
        negativePriceShouldBeCorrected();
        getInvoiceAmountShouldMultiplieQuantityAndPrice();
        setPartNumberEqualToGet();
        setPartDescriptionEqualToGet();
        setPositiveQuantityEqualToGet();
        setPositivePriceEqualToGet();
    }
    /**
     * Test if the getter and setter for positive numbers for quantity works correctly
     */
    private void setPositiveQuantityEqualToGet() {
        int testedQuantity = 5;
        Invoice sut = new Invoice("1177", "A Positive Peter", 3, 3.50);
        sut.setQuantity(testedQuantity);
        int actual = sut.getQuantity();

        System.out.println("After using setQuantity with a positive number, getQuantity should return the set value");
        presentTestResult(
            Integer.toString(testedQuantity), 
            Integer.toString(testedQuantity), 
            Integer.toString(actual), 
            actual == testedQuantity
        );
    }

    /**
     * Test if the getter and setter for positive numbers for Price works correctly
     */
    private void setPositivePriceEqualToGet() {
        double testedPrice = 5.33;
        Invoice sut = new Invoice("1177", "A Positive Peter", 3, 3.50);
        sut.setPrice(testedPrice);
        double actual = sut.getPrice();

        System.out.println("After using setPrice with a positive number, getPrice should return the set value");
        presentTestResult(
            Double.toString(testedPrice), 
            Double.toString(testedPrice), 
            Double.toString(actual), 
            actual == testedPrice
        );
    }

    /**
     * Test if the getter and setter for partDescription works correctly
     */
    private void setPartDescriptionEqualToGet() {
        String testedPartDescription = "A negative nancy:(";
        Invoice sut = new Invoice("1177", "A Positive Peter", 3, 3.50);
        sut.setPartDescription(testedPartDescription);
        String actual = sut.getPartDescription();

        System.out.println("After using setPartDescription, getPartDescription should return the set value");
        presentTestResult(
            testedPartDescription, 
            testedPartDescription, 
            actual, 
            actual == testedPartDescription  
        );
    }

    /**
     * Test if the getter and setter for partNumber works correctly
     */
    private void setPartNumberEqualToGet() {
        String testedPartNumber = "1337";
        Invoice sut = new Invoice("1177", "A negative nancy:(", 3, 3.50);
        sut.setPartNumber(testedPartNumber);
        String actual = sut.getPartNumber();

        System.out.println("After using setPartNumber, getPartNumber should return the set value");
        presentTestResult(
            testedPartNumber, 
            testedPartNumber, 
            actual, 
            actual == testedPartNumber  
        );
    }

    /**
     * Test if the getInvoiceAmount method works correctly
     */
    private void getInvoiceAmountShouldMultiplieQuantityAndPrice() {
        int quantity = 3;
        double price = 3.50;
        Invoice sut = new Invoice("1177", "A Positive Peter", quantity, price);

        double expectedResult = quantity*price;
        double actualResult = sut.getInvoiceAmount();

        System.out.println("getInvoiceAmount() should multiplie price with quantity");
        
        presentTestResult(
            quantity + "*" + price, 
            Double.toString(expectedResult), 
            Double.toString(actualResult), 
            actualResult == expectedResult
        );


    }

    /**
     * Test if the quantity setter changes the quantity value to 0 if given a negative value.
     */
    private void negativeQuantityShouldBeCorrected() {
        int testedQuantity = -1;
        int expectedQuantity = 0;
        Invoice sut = new Invoice("1178", "A negative nancy:(" , testedQuantity , 1);
        int actualQuantity = sut.getQuantity();

        System.out.println("Invoice with negative quantity should be corrected to 0");

        presentTestResult(
            Integer.toString(testedQuantity), 
            Integer.toString(expectedQuantity), 
            Integer.toString(actualQuantity), 
            actualQuantity == expectedQuantity
        );
    }

     /**
     * Test if the price setter changes the price value to 0.0 if given a negative value.
     */
    private void negativePriceShouldBeCorrected() {
        double testedPrice = -3.14159265;
        double expectedPrice = 0.0;
        Invoice sut = new Invoice("1178", "A negative nancy:(" , 1 , testedPrice);
        double actualPrice = sut.getPrice();

        System.out.println("Invoice with negative price should be corrected to 0.0");

        presentTestResult(
            Double.toString(testedPrice), 
            Double.toString(expectedPrice), 
            Double.toString(actualPrice), 
            actualPrice == expectedPrice
        );
    }
    
    /**
     * Presents the result of a test
     * 
     * @param testedValue The value that was used in the test.
     * @param expectedValue The expected outcome of the test.
     * @param actualValue The actual outcome of the test.
     * @param didPass If the test did pass or not.
     */
    private void presentTestResult(String testedValue, String expectedValue, String actualValue, boolean didPass) {
        String result = 
        "Tested value: " + testedValue + 
        "\nExpected value: " + expectedValue +
        "\nActual value: " + actualValue +
        "\nTest " + (didPass ? "Passed" : "Failed");

        System.out.println("\n" + result + "\n");
    }
}
