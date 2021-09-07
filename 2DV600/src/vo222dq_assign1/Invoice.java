/** 
 * Date: 2021-09-07
 * File Name: Invoice.java
 * Author: Viktor Ödman
 */
package vo222dq_assign1;

/**
 * Class Description: This class represents an invoice for a product.
 * 
 * @version 1.0
 * @author Viktor Ödman
 */
public class Invoice {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double price;

    /**
     * Creates a new instance of Invoice
     * @param partNumber The products part number
     * @param partDescription The products part description
     * @param quantity The amount of products
     * @param price The price for one unit
     */
    public Invoice(String partNumber, String partDescription, int quantity, double price) {
        this.setPartNumber(partNumber);
        this.setPartDescription(partDescription);
        this.setQuantity(quantity);
        this.setPrice(price);
    }

    /**
     * Calculates the price for the amount of products in the invoice.
     * @return The total price for the invoice.
     */
    public double getInvoiceAmount() {
        return this.price * (double)this.quantity;
    }

    /**
     * Get the price of one unit.
     * @return The price of one unit.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price for one unit of the product
     * If given a negative value, the price will be set to 0.0
     * @param price The price that the product will be set to.
     */
    public void setPrice(double price) {
        if (price < 0) {
            this.price = 0.0;
        } else {
            this.price = price;
        }
    }

    /**
     * Get the amount of products in the invoice
     * @return The amount of products in the invoice
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the amount of products for the invoice
     * If given a negative value, the quantity will be set to 0
     * @param quantity The amount of products for the invoice.
     */
    public void setQuantity(int quantity) {
        if (quantity < 0) {
            this.quantity = 0;
        } else {
            this.quantity = quantity;
        }
    }

    /**
     * Gets the product part description.
     * @return The product part description.
     */
    public String getPartDescription() {
        return partDescription;
    }

    /**
     * Sets the part description of the product
     * @param partDescription The part description.
     */
    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    /**
     * Gets the part number of the product.
     * @return The part number of the product.
     */
    public String getPartNumber() {
        return partNumber;
    }

    /**
     * Sets the part number for the product
     * @param partNumber The part number for the product.
     */
    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }
}
