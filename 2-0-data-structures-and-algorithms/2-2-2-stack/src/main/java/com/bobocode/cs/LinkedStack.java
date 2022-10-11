package com.bobocode.cs;

import com.bobocode.cs.exception.EmptyStackException;

/**
 * {@link LinkedStack} is a stack implementation that is based on singly linked generic nodes.
 * A node is implemented as inner static class {@link Node<T>}.
 * <p><p>
 * <strong>TODO: to get the most out of your learning, <a href="https://www.bobocode.com/learn">visit our website</a></strong>
 * <p>
 *
 * @param <T> generic type parameter
 * @author Taras Boychuk
 * @author Serhii Hryhus
 */
public class LinkedStack<T> implements Stack<T> {
    private int size;
    private Node<T> head;

    public LinkedStack() {
        //size = 0;
       // head = null;
    };

    /**
     * This method creates a stack of provided elements
     *
     * @param elements elements to add
     * @param <T>      generic type
     * @return a new stack of elements that were passed as method parameters
     */
    public static <T> LinkedStack<T> of(T... elements) {
        LinkedStack<T> stack = new LinkedStack<>();
        for (T element : elements) {
            stack.push(element);
        }
        return stack;
        //throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * The method pushes an element onto the top of this stack. This has exactly the same effect as:
     * addElement(item)
     *
     * @param element elements to add
     */
    @Override
    public void push(T element) {
        if (element == null) {
            throw new NullPointerException("Element can't be null.");
        }
        Node<T> node = new Node<>(element);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
        // throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * This method removes the object at the top of this stack
     * and returns that object as the value of this function.
     *
     * @return The object at the top of this stack
     * @throws EmptyStackException - if this stack is empty
     */
    @Override
    public T pop() {
        if (head == null) {
            throw new EmptyStackException();
        }
        T element = head.value;
        head = head.next;
        size--;
        return element;
        // throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Returns the number of elements in the stack
     *
     * @return number of elements
     */
    @Override
    public int size() {
        return size;
        //throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Checks if a stack is empty
     *
     * @return {@code true} if a stack is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
        //throw new ExerciseNotCompletedException(); // todo: implement this method;
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

}
