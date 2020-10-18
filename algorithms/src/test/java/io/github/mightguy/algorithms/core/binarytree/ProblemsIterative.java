package io.github.mightguy.algorithms.core.binarytree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.Queue;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
public class ProblemsIterative {

  BinaryTree<Integer> binaryTree = new IterativeBinaryTree<>();

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
    if (root == null) {
      return Integer.MIN_VALUE;
    }
    int max = Integer.MIN_VALUE;
    Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      BinaryTreeNode<Integer> temp = queue.poll();
      if (temp.data > max) {
        max = temp.data;
      }

      if (temp.left != null) {
        queue.offer(temp.left);
      }
      if (temp.right != null) {
        queue.offer(temp.right);
      }
    }
    return max;
  }

  @Test
  public void testMaximumOfTree() {
    assertEquals(6, maximumInBinaryTree(binaryTree.root));
  }


}
