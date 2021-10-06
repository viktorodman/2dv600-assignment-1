/** 
 * Date: 2021-10-06
 * File Name: ArrayIntList.java
 * Author: Viktor Ödman
 */

package vo222dq_assign2.two_dv600;

import java.util.Iterator;

/**
 * Represents an Array int list
 */
public class ArrayIntList extends AbstractIntCollection implements IntList {
    
    /** 
     * Adds the passed integer to the list
     * @param n The integer to be added
    */
    @Override
    public void add(int n) {
        checkAvailableSpace();

        values[size()] = n;
        size += 1;
    }

    /**
     * Adds the passed integer to the passed index
     * @param n The integer to be added
     * @param index The index where the integer should be added
     * @throws IndexOutOfBoundsException if the index does not exists in the list
     */
    @Override
    public void addAt(int n, int index) throws IndexOutOfBoundsException {
        if (!checkIndex(index, size())) throw new IndexOutOfBoundsException();

        checkAvailableSpace();

        Iterator<Integer> intIterator = iterator();
        int temp = 0;
        int counter = 0;
        size += 1;

        while (intIterator.hasNext()) {
            int currentValue = intIterator.next();
            if(counter == index) {
                values[counter] = n;
            } else if (counter > index) {
                values[counter] = temp;
            } 
            temp = currentValue;               
            counter++;
        }
    }

    /**
     * Removes the integer at the passed index position
     * @param index The position that should be removed
     * @throws IndexOutOfBoundsException if the index does not exists in the list
     */
    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        if (!checkIndex(index, size())) throw new IndexOutOfBoundsException();

        Iterator<Integer> intIterator = iterator();
        size -=1;
        int counter = 0;

        while (intIterator.hasNext()) {
            int currentValue = intIterator.next();
            values[counter] = counter >= index ? values[counter +1] : currentValue;
            counter++;
        }
    }

     /**
     * Gets the integer at the passed index position
     * @param index The position of the integer that should be returned
     * @throws IndexOutOfBoundsException if the index does not exists in the list
     * @return The integer at the passed index
     */
    @Override
    public int get(int index) throws IndexOutOfBoundsException {
        if (!checkIndex(index, size())) throw new IndexOutOfBoundsException();

        int localIterator = 0;
        Iterator<Integer> intIterator = iterator();
        int correctValue = 0;

        while (intIterator.hasNext()) {
            int currentValue = intIterator.next();

            if (localIterator == index) {
                correctValue = currentValue;
                break;
            }
            localIterator++;
        }
        return correctValue;
        /* return values[index]; This is probably not allowed :) */
    }

    /**
     * Gets the index of the first occurrence of the passed integer
     * @param n The integer to be checked
     * @return The index position of the first occurrence of the passed integer or -1 if the integer does not exist in the list
     */
    @Override
    public int indexOf(int n) {
        int index = -1;
        int currentIndex = 0;
        Iterator<Integer> intIterator = iterator();

        while (intIterator.hasNext()) {
            int currentInteger = intIterator.next();

            if (currentInteger == n) {
                return currentIndex;
            }
            currentIndex++;
        }

        return index;
    }

    /**
     * Check if the internal array should be resized and resizes the internal list if it should
     */
    private void checkAvailableSpace() {
        if (size() == values.length) {
            resize();
        }
    }

}
