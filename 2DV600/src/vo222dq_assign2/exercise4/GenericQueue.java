/** 
 * Date: 2021-10-06
 * File Name: GenericQueue.java
 * Author: Viktor Ödman
 */

package vo222dq_assign2.exercise4;

import java.util.Iterator;

/**
 * Represents a Generic Queue
 */
public class GenericQueue<E> implements Queue<E> {
    private int currentSize = 0;
    private Node<E> head = null;
    private Node<E> tail = null;

    /**
     * Creates and return a new GenericIterator
     * @return A new GenericIterator
     */
    @Override
    public Iterator<E> iterator() {
        return new GenericIterator<E>();
    }

    /**
     * Return the current size of the queue
     * @return The current size of the queue
     */
    @Override
    public int size() {
       return currentSize;
    }

    /**
     * Checks if the queue is currently empty
     * @return true if the queue is currently empty else false
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }
    
    /**
     * Adds the passed element to the queue
     * @param element The element to be added
     */
    @Override
    public void enqueue(E element) {
        Node<E> nodeToBeEnqueued = new Node<E>(element, null, null);
        
        if (isEmpty()) {
            head = nodeToBeEnqueued;
            tail = nodeToBeEnqueued;
        } else {
            tail.next = nodeToBeEnqueued;
            nodeToBeEnqueued.prev = tail;
            tail = nodeToBeEnqueued;
        }
        currentSize++; 
    }

    /**
     * Removes and returns the first element
     * @throws IndexOutOfBoundsException if the queue is empty
     * @return The removed element
     */
    @Override
    public E dequeue() throws IndexOutOfBoundsException{
        if (isEmpty()) throw new IndexOutOfBoundsException();
        
        E elementToBeDequeued = first();
        
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        currentSize--;
        return elementToBeDequeued;
    }

    /**
     * Gets the first element in the queue without removing it.
     * @throws IndexOutOfBoundsException If queue is empty
     * @return the first element in the queue
     */
    @Override
    public E first() {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        
        return head.element;
    }

    /**
     * Gets the last element in the queue without removing it.
     * @throws IndexOutOfBoundsException If queue is empty
     * @return the last element in the queue
     */
    @Override
    public E last() throws IndexOutOfBoundsException {
        if (isEmpty()) throw new IndexOutOfBoundsException();

        return tail.element;
    }

    /**
     * Represents a Node which holds an items in the queue.
     */
    private class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;

        /**
         * Creates a new instance of Node
         * @param element The element that the node should store
         * @param next The next element in the queue
         * @param prev The previous element in the queue
         */
        public Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Represents an iterator which can be used to iterate the queue.
     */
    private class GenericIterator<E> implements Iterator<E>{
        private Node<E> current = (Node<E>) head;

        /**
         * Check if it exists another element in the queue
         * @returns True if there is another node in the queue
         */
        @Override
        public boolean hasNext() {
            return isEmpty()==false && current != null;
        }

        /**
         * Returns the element that the next node in the queue stores
         * @throws IndexOutOfBoundsException If the next node does not exist
         * @return The next nodes element.
         */
        @Override
        public E next() throws IndexOutOfBoundsException {
            if (current == null) {
                throw new IndexOutOfBoundsException();
            }
            E currentElement = current.element;
            current = current.next;
            return currentElement;
        }
    }
}
