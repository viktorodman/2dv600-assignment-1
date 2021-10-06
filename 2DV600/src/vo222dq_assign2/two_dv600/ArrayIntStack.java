/** 
 * Date: 2021-10-06
 * File Name: ArrayIntStack.java
 * Author: Viktor Ödman
 */

package vo222dq_assign2.two_dv600;

import java.util.Iterator;

/**
 * Represents an Array int stack
 */
public class ArrayIntStack extends AbstractIntCollection implements IntStack {
    
    /** 
     * Adds the passed integer to the top of the stack
     * @param n The integer to be added
    */
    @Override
    public void push(int n) {
        if (size() == values.length) resize();
        values[size()] = n;
        size++;
    }


    /**
     * Removes and returns the integer at the top of the stack
     * @throws IndexOutOfBoundsException if the list is empty.
     * @return The removed integer
     */
    @Override
    public int pop() throws IndexOutOfBoundsException {
        if (isEmpty()) throw new IndexOutOfBoundsException();

        Iterator<Integer> intIterator = iterator();
        int counter = 0;
        int poppedValue = 0;

        while (intIterator.hasNext()) {
            int currentValue = intIterator.next();
            if (counter == size() -1) {
                poppedValue = currentValue;
                values[counter] = 0;
            }
            counter++;
        }

        size--;

        return poppedValue;

       /* Probably not the solution that you wanted us to do  
       int poppedValue = values[size - 1]; 
        values[size() -1] = 0;
        return poppedValue */
    }

    /**
     * Returns the value of the integer at the top of the stack without removing it.
     */
    @Override
    public int peek() throws IndexOutOfBoundsException {
        if (isEmpty()) throw new IndexOutOfBoundsException();

        Iterator<Integer> intIterator = iterator();
        int counter = 0;
        int peekedValue = 0;

        while (intIterator.hasNext()) {
            int currentValue = intIterator.next();
            if (counter == size() -1) {
                peekedValue = currentValue;
            }
            counter++;
        }

        return peekedValue;

        /* Probably not the solution that you wanted us to do  
        int poppedValue = values[size - 1]; 
        return poppedValue */   
    }
}
