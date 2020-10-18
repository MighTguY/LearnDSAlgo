package io.github.mightguy.algorithms.core.binarytree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
class IterativeBinaryTreeTest {

  IterativeBinaryTree<Integer> binaryTree = new IterativeBinaryTree<>();

  @BeforeEach
  void init() {
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


  @Test
  public void testPreOrderTraversal() {
    assertEquals(Arrays.asList(0, 1, 3, 4, 2, 5, 6), binaryTree.preOrderTraversal());
  }

  @Test
  public void testInOrderTraversal() {
    assertEquals(Arrays.asList(3, 1, 4, 0, 5, 2, 6), binaryTree.inOrderTraversal());
  }

  @Test
  public void testPostOrder() {
    assertEquals(Arrays.asList(3, 4, 1, 5, 6, 2, 0), binaryTree.postOrderTraversal());
  }


  @Test
  public void testLevelOrder() {
    assertEquals(Arrays.asList(0, 1, 2, 3, 4, 5, 6), binaryTree.levelOrderTraversal());
  }


  @Test
  public void testAdd() {
    binaryTree.add(new BinaryTreeNode<>(11));
    assertTrue(binaryTree.inOrderTraversal().contains(11));
  }

  @Test
  public void testFind() {
    assertTrue(binaryTree.contains(5));
    assertTrue(binaryTree.contains(1));
    assertTrue(binaryTree.contains(4));
    assertTrue(binaryTree.contains(0));
    assertFalse(binaryTree.contains(-1));
  }

  @Test
  public void testSize() {
    assertEquals(7, binaryTree.size());
  }

}