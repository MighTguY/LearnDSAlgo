package io.github.mightguy.algorithms.core.binarytree.traversal;

import io.github.mightguy.algorithms.core.binarytree.BinaryTreeNode;
import java.util.List;

public interface OrderTraversal<T extends Comparable> {

  /**
   * Recursive order traversal
   *
   * @param root     Root Node of the tree
   * @param dataList List which will be populated with the order
   */
  public void traversalByRecursion(BinaryTreeNode<T> root, List<T> dataList);

  /**
   * Traversal in an iteration
   *
   * @param root Root Node of the tree
   * @return List of type T, which containt the ordered values
   */
  public List<T> traversalByIteration(BinaryTreeNode<T> root);
}
