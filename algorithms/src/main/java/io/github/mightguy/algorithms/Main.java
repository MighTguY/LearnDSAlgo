package io.github.mightguy.algorithms;

import io.github.mightguy.algorithms.core.binarytree.BinaryTree;
import io.github.mightguy.algorithms.core.binarytree.commons.BinaryTreeNode;
import io.github.mightguy.algorithms.core.binarytree.IterativeBinaryTree;

public class Main {

  /**
   * Binary Tree Traversal 0 1   2 3 4 5 6
   * <p>
   * Pre -> 0134256 Post -> 3415620 Inorder -> 3140526
   */
  public void binaryTreeTraversal() {
    BinaryTree<Integer> binaryTree = new IterativeBinaryTree<>(new BinaryTreeNode<>(0));
    binaryTree.add(new BinaryTreeNode<>(1));
    binaryTree.add(new BinaryTreeNode<>(2));
    binaryTree.add(new BinaryTreeNode<>(3));
    binaryTree.add(new BinaryTreeNode<>(4));
    binaryTree.add(new BinaryTreeNode<>(5));
    binaryTree.add(new BinaryTreeNode<>(6));

    System.out.println(binaryTree.preOrderTraversal());
    System.out.println(binaryTree.postOrderTraversal());
    System.out.println(binaryTree.inOrderTraversal());
  }

  public static void main(String[] args) {
    Main main = new Main();
    main.binaryTreeTraversal();
  }
}
