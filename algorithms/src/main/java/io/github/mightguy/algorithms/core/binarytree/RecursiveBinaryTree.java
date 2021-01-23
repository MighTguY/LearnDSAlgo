package io.github.mightguy.algorithms.core.binarytree;

import io.github.mightguy.algorithms.core.binarytree.commons.TraversalType;
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
    root = insert(root, node);
  }

  private BinaryTreeNode<T> insert(BinaryTreeNode<T> root, BinaryTreeNode<T> node) {
    if (root == null) {
      return node;
    }
    if (root.rchildCount == root.lchildCount) {
      root.left = insert(root.left, node);
      root.lchildCount += 1;
    } else if (root.rchildCount < root.lchildCount) {
      if (isPBT(root.lchildCount)) {
        root.right = insert(root.right, node);
        root.rchildCount += 1;
      } else {
        root.left = insert(root.left, node);
        root.lchildCount += 1;
      }
    }
    return root;
  }

  private boolean isPBT(int count) {
    count = count + 1;
    while (count % 2 == 0) {
      count = count / 2;
    }
    if (count == 1) {
      return true;
    } else {
      return false;
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

  @Override
  public int height() {
    return height(root);
  }

  private int height(BinaryTreeNode<T> root) {
    if (root == null) {
      return 0;
    }
    int leftDepth = root.left == null ? 0 : height(root.left);
    int rightDepth = root.right == null ? 0 : height(root.right);
    return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
  }

}
