package com.bobobode.cs;

/**
 * Class {@link Node} is a very simple data structure that consists of an element itself and the reference to the next
 * node. An element can have any value since it's a generic. A reference to the next node allows to link {@link Node}
 * objects and build more comprehensive data structures on top of those liked nodes.
 *
 * @param <T> a generic type T
 * @author Taras Boychuk
 */
public class Node<T> {
    T item;
    Node<T> next;

    public Node(T item) {
        this.item = item;
        this.next = null;
    }

    public Node(T item, Node<T> next) {
        this.item = item;
        this.next = next;
    }
}
