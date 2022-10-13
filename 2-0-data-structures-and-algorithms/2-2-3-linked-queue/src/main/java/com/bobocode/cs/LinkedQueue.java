package com.bobocode.cs;

/**
 * {@link LinkedQueue} implements FIFO {@link Queue}, using singly linked nodes. Nodes are stores in instances of nested
 * class Node. In order to perform operations {@link LinkedQueue#add(Object)} and {@link LinkedQueue#poll()}
 * in a constant time, it keeps to references to the head and tail of the queue.
 * <p><p>
 * <strong>TODO: to get the most out of your learning, <a href="https://www.bobocode.com/learn">visit our website</a></strong>
 * <p>
 *
 * @param <T> a generic parameter
 * @author Taras Boychuk
 * @author Ivan Virchenko
 */
public class LinkedQueue<T> implements Queue<T> {
    Node<T> head;
    Node<T> tail;
    int size;
    /**
     * Adds an element to the end of the queue.
     *
     * @param element the element to add
     */
    public void add(T element) {
        if (head == null) {
            head = tail = new Node<>(element);
        } else {
            tail.next = new Node<>(element);
            tail = tail.next;
        }
        size++;
        //throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Retrieves and removes queue head.
     *
     * @return an element that was retrieved from the head or null if queue is empty
     */
    public T poll() {
        if (head == null) {
            return null;
        }
        T result = head.element;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return result;
        //throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Returns a size of the queue.
     *
     * @return an integer value that is a size of queue
     */
    public int size() {
        return size;
        //throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Checks if the queue is empty.
     *
     * @return {@code true} if the queue is empty, returns {@code false} if it's not
     */
    public boolean isEmpty() {
        return size == 0;
        //throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    private static class Node<T> {
        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
        }
    }
}
