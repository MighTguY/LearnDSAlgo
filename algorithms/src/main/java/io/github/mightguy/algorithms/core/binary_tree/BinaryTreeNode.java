package io.github.mightguy.algorithms.core.binary_tree;

/**
 * Generic Node of a binary Tree.
 * Every Binary Tree Node has 3 things to hold,
 * 1. Data of Type T
 * 2. Reference of the Right Child
 * 3. Reference of the Left Child
 * @param <T> Generic Node where T is the Class type
 */
public class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}
