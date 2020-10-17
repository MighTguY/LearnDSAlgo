package io.github.mightguy.algorithms.trees;

/**
 * Generic Node of a binary Tree.
 * Every Binary Tree Node has 3 things to hold,
 * 1. Data of Type T
 * 2. Reference of the Right Child
 * 3. Reference of the Left Child
 * @param <T> Generic Node where T is the Class type
 */
public class Node<T> {
    public T data;
    public Node left;
    public Node right;

    public Node(T data) {
        this.data = data;
    }
}
