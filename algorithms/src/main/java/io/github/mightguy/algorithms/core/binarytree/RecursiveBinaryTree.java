package io.github.mightguy.algorithms.core.binarytree;

import io.github.mightguy.algorithms.core.binarytree.traversal.TraversalType;
import java.util.ArrayList;
import java.util.List;

public class RecursiveBinaryTree<T extends Comparable> extends BinaryTree<T> {

  public RecursiveBinaryTree(BinaryTreeNode<T> root) {
    super(root);
  }

  public RecursiveBinaryTree() {
    super();
  }

  /**
   * Adding a node recursively to the Same Level as other leaves else add it to the left most
   *
   * @param node {@link BinaryTreeNode} to insert
   */
  @Override
  public void add(BinaryTreeNode<T> node) {
    if (root == null) {
      root = node;
      return;
    }
    addWithHelper(root, node);
  }

  private void addWithHelper(BinaryTreeNode<T> root, BinaryTreeNode<T> node) {
    if (root.data.compareTo(node.data) > 0) {
      if (root.left == null) {
        root.left = node;
      } else {
        addWithHelper(root.right, node);
      }
    } else {
      if (root.right == null) {
        root.right = node;
      } else {
        addWithHelper(root.right, node);
      }
    }
  }

  @Override
  protected List<T> fetchOrderTraversalList(TraversalType traversalType) {
    List<T> orderedList = new ArrayList<T>();
    orderTraversalFactory.getTraversal(traversalType).traversalByRecursion(root, orderedList);
    return orderedList;
  }

  @Override
  public boolean contains(T data) {

    return findRecursive(root, data);
  }

  private boolean findRecursive(BinaryTreeNode<T> root, T data) {
    if (root == null) {
      return false;
    }
    if (root.data.compareTo(data) == 0) {
      return true;
    }
    return findRecursive(root.left, data) || findRecursive(root.right, data);
  }

  @Override
  public int size() {
    return size(root);
  }

  private int size(BinaryTreeNode<T> root) {
    int leftTreeSize = root.left == null ? 0 : size(root.left);
    int rightTreeSize = root.right == null ? 0 : size(root.right);
    return 1 + leftTreeSize + rightTreeSize;
  }
}
