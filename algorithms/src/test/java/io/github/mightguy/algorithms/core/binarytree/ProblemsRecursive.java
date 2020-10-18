package io.github.mightguy.algorithms.core.binarytree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
public class ProblemsRecursive {

  BinaryTree<Integer> binaryTree = new RecursiveBinaryTree<>();

  @BeforeEach
  public void init() {
    binaryTree.deleteTree();
    binaryTree.add(new BinaryTreeNode<>(0));
    binaryTree.add(new BinaryTreeNode<>(1));
    binaryTree.add(new BinaryTreeNode<>(2));
    binaryTree.add(new BinaryTreeNode<>(3));
    binaryTree.add(new BinaryTreeNode<>(4));
    binaryTree.add(new BinaryTreeNode<>(5));
    binaryTree.add(new BinaryTreeNode<>(6));
    log.info("@BeforeEach - Deleted old and New Binary Tree is Created ");
  }

  public int maximumInBinaryTree(BinaryTreeNode<Integer> root) {
    int maxValue = Integer.MIN_VALUE;
    if (root != null) {
      int leftMax = maximumInBinaryTree(root.left);
      int rightMax = maximumInBinaryTree(root.right);
      if (leftMax > rightMax) {
        maxValue = leftMax;
      } else {
        maxValue = rightMax;
      }
      if (maxValue < root.data) {
        maxValue = root.data;
      }
    }
    return maxValue;
  }

  @Test
  public void testMaximumOfTree() {
    assertEquals(6, maximumInBinaryTree(binaryTree.root));
  }
}
