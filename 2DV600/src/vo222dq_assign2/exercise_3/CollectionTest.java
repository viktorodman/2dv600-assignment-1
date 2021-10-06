/** 
 * Date: 2021-10-06
 * File Name: CollectionTest.java
 * Author: Viktor Ödman
 */

package vo222dq_assign2.exercise_3;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import vo222dq_assign2.two_dv600.ArrayIntList;
import vo222dq_assign2.two_dv600.ArrayIntStack;

/**
 * Represents a testing class for the Classes ArrayIntStack and ArrayIntList
 * 
 * The method names are constructed as following
 * 
 * methodBeingTested_input_expectedResult()
 * example: push_newInteger_sizeOfArrayShouldHaveIncreased()
 */
public class CollectionTest {
    // ArrayIntStack TESTS
    @Test
    public void push_newInteger_sizeOfArrayShouldHaveIncreased() {
        ArrayIntStack sut = new ArrayIntStack();
        
        int input = 5;
        int previousSize = sut.size();
        
        sut.push(input);

        boolean expected = true;
        boolean actual = sut.size() > previousSize;

        assertEquals(expected, actual);
    }

    @Test
    public void push_newInteger_addedIntegerShouldBeLastInList() {
        ArrayIntStack sut = new ArrayIntStack();

        int input = 5;
        
        sut.push(1);
        sut.push(input);

        int expected = input;
        int actual = sut.peek();

        assertEquals(expected, actual);
    }

    @Test
    public void pop_shouldThrowExceptionIfListIsEmpty() {
        ArrayIntStack sut = new ArrayIntStack();
        assertThrows(IndexOutOfBoundsException.class, () -> sut.pop());
    }

    @Test
    public void pop_shouldDecreaseSizeOfArray() {
        ArrayIntStack sut = new ArrayIntStack();
        
        sut.push(1);
        sut.push(2);
        
        int previousSize = sut.size();
        
        sut.pop();
        
        boolean expected = true;
        boolean actual = sut.size() < previousSize;

        assertEquals(expected, actual);
    }

    @Test
    public void pop_shouldReturnTheRemovedValue() {
        ArrayIntStack sut = new ArrayIntStack();
        int input = 5;

        sut.push(1);
        sut.push(input);
        
        int expected = input;
        int actual = sut.pop();

        assertEquals(expected, actual);
    }

    @Test
    public void peek_shouldThrowExceptionIfListIsEmpty() {
        ArrayIntStack sut = new ArrayIntStack();
        assertThrows(IndexOutOfBoundsException.class, () -> sut.peek());
    }

    @Test
    public void peek_shouldNotEffectListSize() {
        ArrayIntStack sut = new ArrayIntStack();
        
        sut.push(1);
        sut.push(2);
        
        int previousSize = sut.size();
        
        sut.peek();
        
        boolean expected = true;
        boolean actual = sut.size() == previousSize;

        assertEquals(expected, actual);
    }

    @Test
    public void peek_shouldReturnLastIntegerInList() {
        ArrayIntStack sut = new ArrayIntStack();
        int input = 4;
        sut.push(1);
        sut.push(input);
        
        int previousSize = sut.size();
        
        int expected = input;
        int actual = sut.peek();

        assertEquals(expected, actual);
    }

    // ArrayIntList TESTS

    @Test
    public void add_newInteger_sizeOfArrayShouldIncrease() {
        ArrayIntList sut = new ArrayIntList();
        int previousSize = sut.size();
        
        sut.add(5);

        boolean expected = true;
        boolean actual = sut.size() > previousSize;

        assertEquals(expected, actual);
    }

    @Test
    public void add_newInteger_addedIntegerShouldBeLastInList() {
        ArrayIntList sut = new ArrayIntList();

        int input = 5;
        
        sut.add(1);
        sut.add(input);

        int expected = input;
        int actual = sut.get(sut.size() - 1);

        assertEquals(expected, actual);
    }

    @Test
    public void addAt_newInteger_invalidIndex_ShouldThrowException() {
        ArrayIntList sut = new ArrayIntList();

        sut.add(1);
        sut.add(2);
        sut.add(3);

        assertThrows(IndexOutOfBoundsException.class, () -> sut.addAt(4,3));
    }

    @Test
    public void addAt_newInteger_validIndex_addedIntegerShouldBeAtPassedIndex() {
        ArrayIntList sut = new ArrayIntList();

        int integerToBeAdded = 5;
        int index = 2;
        
        sut.add(1);
        sut.add(2);
        sut.add(3);

        sut.addAt(integerToBeAdded, index);

        boolean expected = true;
        boolean actual = sut.get(index) == integerToBeAdded;

        assertEquals(expected, actual);
    }

    @Test
    public void addAt_newInteger_validIndex_addedIntegerShouldIncreaseSizeOfArray() {
        ArrayIntList sut = new ArrayIntList();
        
        sut.add(1);
        sut.add(2);
        sut.add(3);

        int previousSize = sut.size();
        
        sut.addAt(5, 2);

        boolean expected = true;
        boolean actual = sut.size() > previousSize;

        assertEquals(expected, actual);
    }

    @Test
    public void remove_invalidIndex_ShouldThrowException() {
        ArrayIntList sut = new ArrayIntList();

        sut.add(1);
        sut.add(2);
        sut.add(3);

        assertThrows(IndexOutOfBoundsException.class, () -> sut.remove(3));
    }

    @Test
    public void remove_validIndex_removeShouldDecreaseSizeOfList() {
        ArrayIntList sut = new ArrayIntList();
        
        sut.add(1);
        sut.add(2);
        sut.add(3);

        int previousSize = sut.size();
        
        sut.remove(1);

        boolean expected = true;
        boolean actual = sut.size() < previousSize;

        assertEquals(expected, actual);
    }

    @Test
    public void get_invalidIndex_ShouldThrowException() {
        ArrayIntList sut = new ArrayIntList();

        sut.add(1);
        sut.add(2);
        sut.add(3);

        assertThrows(IndexOutOfBoundsException.class, () -> sut.get(3));
    }

    @Test
    public void get_validIndex_ShouldReturnValueAtIndex() {
        ArrayIntList sut = new ArrayIntList();
        int valueAtIndex = 4;
        int index = 2;
        sut.add(1);
        sut.add(2);
        sut.add(3);
        sut.addAt(valueAtIndex, index);

        int expected = valueAtIndex;
        int actual = sut.get(index);

        assertEquals(expected, actual);
    }

    @Test
    public void indexOf_nonExistingValue_ShouldReturnMinusOne() {
        ArrayIntList sut = new ArrayIntList();
        int input = 4;

        sut.add(1);
        sut.add(2);
        sut.add(3);

        int expected = -1;
        int actual = sut.indexOf(input);

        assertEquals(expected, actual);
    }

    @Test
    public void indexOf_existingValue_ShouldIndexOfValue() {
        ArrayIntList sut = new ArrayIntList();
        int input = 9;

        sut.add(5);
        sut.add(9);
        sut.add(1);

        int expected = 1;
        int actual = sut.indexOf(input);

        assertEquals(expected, actual);
    }
}
