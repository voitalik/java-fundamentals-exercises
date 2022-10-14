package com.bobocode.cs;


import com.bobocode.util.ExerciseNotCompletedException;

import java.util.NoSuchElementException;

/**
 * {@link LinkedList} is a list implementation that is based on singly linked generic nodes. A node is implemented as
 * inner static class {@link Node<T>}.
 * <p><p>
 * <strong>TODO: to get the most out of your learning, <a href="https://www.bobocode.com/learn">visit our website</a></strong>
 * <p>
 *
 * @param <T> generic type parameter
 * @author Taras Boychuk
 * @author Serhii Hryhus
 */
public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    /**
     * This method creates a list of provided elements
     *
     * @param elements elements to add
     * @param <T>      generic type
     * @return a new list of elements the were passed as method parameters
     */
    public static <T> LinkedList<T> of(T... elements) {
        LinkedList<T> list = new LinkedList<>();
        for (T element : elements) {
            list.add(element);
        }
        return list;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param element element to add
     */
    @Override
    public void add(T element) {
        Node<T> node = new Node<>(element);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
        //throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Adds a new element to the specific position in the list. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an index of new element
     * @param element element to add
     */
    @Override
    public void add(int index, T element) {
        if (index == size) {
            add(element);
            return;
        }
        checkIndexBounds(index);
        Node<T> node = new Node<>(element);
        if (index == 0) {
            node.next = head;
            head = node;
        } else {
            Node<T> current = getNode(index - 1);
            node.next = current.next;
            current.next = node;
        }
        size++;
    }

    private Node<T> getNode(int index) {
        Node<T> current = head;
        for (int i = 1; i <= index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * Changes the value of an list element at specific position. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an position of element to change
     * @param element a new element value
     */
    @Override
    public void set(int index, T element) {
        if (head == null || index == size) {
            throw new IndexOutOfBoundsException();
        }
        checkIndexBounds(index);
        Node<T> current = getNode(index);
        current.element = element;
    }

    /**
     * Retrieves an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     * @return an element value
     */
    @Override
    public T get(int index) {
        if (head == null || index == size) {
            throw new IndexOutOfBoundsException();
        }
        checkIndexBounds(index);
        Node<T> current = getNode(index);
        return current.element;
        //throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Returns the first element of the list. Operation is performed in constant time O(1)
     *
     * @return the first element of the list
     * @throws java.util.NoSuchElementException if list is empty
     */
    @Override
    public T getFirst() {
        if (head == null)
            throw new NoSuchElementException("Index out of bound.");
        return head.element;
        //throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Returns the last element of the list. Operation is performed in constant time O(1)
     *
     * @return the last element of the list
     * @throws java.util.NoSuchElementException if list is empty
     */
    @Override
    public T getLast() {
        if (tail == null)
            throw new NoSuchElementException("Index out of bound.");
        return tail.element;
        //throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Removes an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     * @return deleted element
     */
    @Override
    public T remove(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException("Index out of bound.");
        }
        checkIndexBounds(index);
        T result;
        if (index == 0) {
            result = head.element;
            head = head.next;
        } else {
            Node<T> current = getNode(index - 1);
            result = current.next.element;
            current.next = current.next.next;
        }
        size--;
        return result;
    }


    /**
     * Checks if a specific exists in he list
     *
     * @return {@code true} if element exist, {@code false} otherwise
     */
    @Override
    public boolean contains(T element) {
        Node<T> current = head;
        for (int i = 1; i < size; i++) {
            if (current.element.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
        //throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Checks if a list is empty
     *
     * @return {@code true} if list is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
        //throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Returns the number of elements in the list
     *
     * @return number of elements
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all list elements
     */
    @Override
    public void clear() {
        head = tail = null;
        size = 0;
        //throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    private void checkIndexBounds(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index out of bound.");
    }

    private static class Node<T> {
        T element;
        Node<T> next;

        Node(T element) {
            this.element = element;
        }
    }
}
