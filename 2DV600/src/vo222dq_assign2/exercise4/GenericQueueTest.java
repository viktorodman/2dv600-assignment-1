package vo222dq_assign2.exercise4;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.junit.Test;


public class GenericQueueTest {
    @Test
    public void iterator_hasNext_emptyQueue_ShouldReturnFalse() {
        GenericQueue<Integer> sut = new GenericQueue<Integer>();
        Iterator<Integer> iterator = sut.iterator();

        boolean expected = false;
        boolean actual = iterator.hasNext();

        assertEquals(expected, actual);
    }

    @Test
    public void iterator_hasNext_oneElementInQueue_shouldBeTrueFirstTime() {
        GenericQueue<Integer> sut = new GenericQueue<Integer>();
        sut.enqueue(5);
        Iterator<Integer> iterator = sut.iterator();

        boolean expected = true;
        boolean actual = iterator.hasNext();

        assertEquals(expected, actual);
    }

    @Test
    public void iterator_hasNext_oneElementInQueue_shouldBeFalseAfterCallingNextTwoTimes() {
        GenericQueue<Integer> sut = new GenericQueue<Integer>();
        sut.enqueue(5);
        Iterator<Integer> iterator = sut.iterator();
        iterator.next();
        boolean expected = false;
        boolean actual = iterator.hasNext();

        assertEquals(expected, actual);
    }

    @Test
    public void iterator_next_oneElementInQueue_shouldReturnFirstElement() {
        GenericQueue<Integer> sut = new GenericQueue<Integer>();
        int input = 5;
        sut.enqueue(input);
        Iterator<Integer> iterator = sut.iterator();

        int expected = input;
        int actual = iterator.next();

        assertEquals(expected, actual);
    }

    @Test
    public void iterator_next_shouldThrowExceptionIfCalledMoreTimesThanElementsInQueue() {
        GenericQueue<Integer> sut = new GenericQueue<Integer>();
        int numberOfElementsInQueue = 5;
        
        for (int i = 0; i < numberOfElementsInQueue; i++) {
            sut.enqueue(i);
        }

        Iterator<Integer> iterator = sut.iterator();

        assertThrows(IndexOutOfBoundsException.class, () -> {
            for (int i = 0; i < numberOfElementsInQueue + 1; i++) {
                iterator.next();
            }
        });
    }

    @Test
    public void size_shouldReturnNumberZeroIfNoElementsInQueue() {
        GenericQueue<Integer> sut = new GenericQueue<Integer>();

        int expected = 0;
        int actual = sut.size();

        assertEquals(expected, actual);
    }

    @Test
    public void size_shouldReturnNumberOfElementsInQueue() {
        GenericQueue<Integer> sut = new GenericQueue<Integer>();
        int numberOfElementsToAdd = 5;

        for (int i = 0; i < numberOfElementsToAdd; i++) {
            sut.enqueue(i);
        }

        int expected = numberOfElementsToAdd;
        int actual = sut.size();

        assertEquals(expected, actual);
    }

    @Test
    public void isEmpty_shouldReturnTrueIfNoElementsInQueue() {
        GenericQueue<Integer> sut = new GenericQueue<Integer>();

        boolean expected = true;
        boolean actual = sut.isEmpty();

        assertEquals(expected, actual);
    }

    @Test
    public void isEmpty_shouldReturnFalseElementsInQueue() {
        GenericQueue<Double> sut = new GenericQueue<Double>();

        sut.enqueue(5.1);

        boolean expected = false;
        boolean actual = sut.isEmpty();

        assertEquals(expected, actual);
    }

    @Test
    public void enqueue_genericElement_shouldIncreaseSizeOfQueue() {
        GenericQueue<String> sut = new GenericQueue<String>();
        String input = "element";
        int prevSize = sut.size();
        
        sut.enqueue(input);

        boolean expected = true;
        boolean actual = sut.size() > prevSize;

        assertEquals(expected, actual);
    }

    @Test
    public void enqueue_genericElement_shouldAddElementToEndOfQueue() {
        GenericQueue<Integer> sut = new GenericQueue<Integer>();
        int input = 5;
        
        sut.enqueue(1);
        sut.enqueue(2);
        sut.enqueue(input);

        int expected = input;
        int actual = sut.last();

        assertEquals(expected, actual);
    }

    @Test
    public void enqueue_hugeAmountOfElements_shouldAddElementsToQueue() {
        GenericQueue<Integer> sut = new GenericQueue<Integer>();
        int numberOfElements = 10000000;

        for (int i = 0; i < numberOfElements; i++) {
            sut.enqueue(i);
        }

        int expected = numberOfElements - 1;
        int actual = sut.last();

        assertEquals(expected, actual);
    }

    @Test
    public void dequeue_emptyQueue_shouldThrowException() {
        GenericQueue<Integer> sut = new GenericQueue<Integer>();
        
        assertThrows(IndexOutOfBoundsException.class, () -> sut.dequeue());
    }

    @Test
    public void dequeue_fiveItemQueue_shouldThrowExceptionIfMoreItemsAreDequeuedThanItemsInQueue() {
        GenericQueue<Integer> sut = new GenericQueue<Integer>();
        int numberOfElementsToAdd = 5;

        for (int i = 0; i < numberOfElementsToAdd; i++) {
            sut.enqueue(i);
        }
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            for (int i = 0; i < (numberOfElementsToAdd + 1); i++) {
                sut.dequeue();
            }
        });
    }

    @Test
    public void dequeue_queueWithElements_shouldDecreaseSize() {
        GenericQueue<Integer> sut = new GenericQueue<Integer>();
        int numberOfElementsToAdd = 5;

        for (int i = 0; i < numberOfElementsToAdd; i++) {
            sut.enqueue(i);
        }

        int sizeBeforeDequeue = sut.size();

        sut.dequeue();

        boolean expected = true;
        boolean actual = sizeBeforeDequeue > sut.size();

        
        assertEquals(expected, actual);
    }

    @Test
    public void dequeue_queueWithElements_shouldReturnFirstElementInQueue() {
        GenericQueue<Integer> sut = new GenericQueue<Integer>();
        int numberOfElementsToAdd = 5;
        int firstElementInQueue = 13;


        sut.enqueue(firstElementInQueue);
        for (int i = 0; i < numberOfElementsToAdd; i++) {
            sut.enqueue(i);
        }

        int expected = firstElementInQueue;
        int actual = sut.dequeue();

        
        assertEquals(expected, actual);
    }

    @Test
    public void dequeue_queueWithElements_shouldReturnElementAfterDequeuingAllElements() {
        GenericQueue<Integer> sut = new GenericQueue<Integer>();
        int numberOfElementsToAdd = 5;

        int expected = numberOfElementsToAdd - 1;
        int actual = 0;

        for (int i = 0; i < numberOfElementsToAdd; i++) {
            sut.enqueue(i);
        }

        for (int i = 0; i < numberOfElementsToAdd; i++) {
            actual = sut.dequeue();
        }
        
        assertEquals(expected, actual);
    }

    @Test
    public void dequeue_hugeAmountOfElements_shouldBeAbleToDequeueLargeAmountOfElements() {
        GenericQueue<Integer> sut = new GenericQueue<Integer>();
        int numberOfElements = 10000000;

        for (int i = 0; i < numberOfElements; i++) {
            sut.enqueue(i);
        }
        
        int sizeAfterEnqueuing = sut.size();

        for (int i = 0; i < (numberOfElements / 2); i++) {
            sut.dequeue();
        }

        int expected = (sizeAfterEnqueuing / 2);
        int actual = sut.size();

        assertEquals(expected, actual);
    }

    @Test
    public void first_emptyQueue_shouldThrowException() {
        GenericQueue<Integer> sut = new GenericQueue<Integer>();
    
        assertThrows(IndexOutOfBoundsException.class, () -> sut.first());
    }    

    @Test
    public void first_queueWithElements_shouldReturnFirstElementInQueue() {
        GenericQueue<Integer> sut = new GenericQueue<Integer>();
        int firstElementInQueue = 5;

        sut.enqueue(firstElementInQueue);
        sut.enqueue(1);
        sut.enqueue(2);

        int expected = firstElementInQueue;
        int actual = sut.first();

        assertEquals(expected, actual);
    }

    @Test
    public void first_queueWithElements_shouldNotEffectSizeOfQueue() {
        GenericQueue<Integer> sut = new GenericQueue<Integer>();
        sut.enqueue(5);
        sut.enqueue(1);
        sut.enqueue(2);

        int sizeOfQueue = sut.size();
        sut.first();

        int expected = sizeOfQueue;
        int actual = sut.size();

        assertEquals(expected, actual);
    }    

    @Test
    public void last_emptyQueue_shouldThrowException() {
        GenericQueue<Integer> sut = new GenericQueue<Integer>();
    
        assertThrows(IndexOutOfBoundsException.class, () -> sut.last());
    } 
    
    @Test
    public void last_queueWithElements_shouldReturnLastElementInQueue() {
        GenericQueue<Integer> sut = new GenericQueue<Integer>();
        int lastElementInQueue = 5;

        sut.enqueue(1);
        sut.enqueue(2);
        sut.enqueue(lastElementInQueue);
        
        int expected = lastElementInQueue;
        int actual = sut.last();

        assertEquals(expected, actual);
    }

    @Test
    public void last_queueWithElements_shouldNotEffectSizeOfQueue() {
        GenericQueue<Integer> sut = new GenericQueue<Integer>();
        sut.enqueue(5);
        sut.enqueue(1);
        sut.enqueue(2);

        int sizeOfQueue = sut.size();

        sut.last();

        int expected = sizeOfQueue;
        int actual = sut.size();

        assertEquals(expected, actual);
    }
}
