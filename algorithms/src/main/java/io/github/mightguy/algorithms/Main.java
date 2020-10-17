package io.github.mightguy.algorithms;

import io.github.mightguy.algorithms.trees.BinaryTree;
import io.github.mightguy.algorithms.trees.Node;

public class Main {


    /**
     * Binary Tree Traversal
     * 0
     * 1   2
     * 3 4 5 6
     * <p>
     * Pre -> 0134256
     * Post -> 3415620
     * Inorder -> 3140526
     */
    public void binaryTreeTraversal() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>(new Node<>(0));
        binaryTree.add(new Node<>(1));
        binaryTree.add(new Node<>(2));
        binaryTree.add(new Node<>(3));
        binaryTree.add(new Node<>(4));
        binaryTree.add(new Node<>(5));
        binaryTree.add(new Node<>(6));

        System.out.println(binaryTree.preOrderTraversal());
        System.out.println(binaryTree.postOrderTraversal());
        System.out.println(binaryTree.inOrderTraversal());
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.binaryTreeTraversal();
    }
}
