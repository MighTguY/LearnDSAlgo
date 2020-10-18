package io.github.mightguy.algorithms.core.binarytree;

import io.github.mightguy.algorithms.core.binarytree.traversal.TraversalType;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IterativeBinaryTree<T extends Comparable> extends BinaryTree<T> {

  public IterativeBinaryTree(BinaryTreeNode<T> root) {
    super(root);
  }

  public IterativeBinaryTree() {
    super();
  }

  /**
   * Adding a node to the Same Level as other leaves else add it to the left most
   *
   * @param node {@link BinaryTreeNode} to insert
   */
  public void add(BinaryTreeNode<T> node) {
    if (root == null) {
      root = node;
      return;
    }
    Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      BinaryTreeNode<T> temp = queue.peek();
      queue.remove();
      if (temp.left == null) {
        temp.left = node;
        break;
      } else {
        queue.add(temp.left);
      }

      if (temp.right == null) {
        temp.right = node;
        break;
      } else {
        queue.add(temp.right);
      }
    }
  }

  @Override
  protected List<T> fetchOrderTraversalList(TraversalType traversalType) {
    return orderTraversalFactory.getTraversal(traversalType).traversalByIteration(root);
  }

  @Override
  public boolean contains(T data) {
    if (root == null) {
      return false;
    }
    Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      BinaryTreeNode<T> temp = queue.poll();
      if (temp.data.compareTo(data) == 0) {
        return true;
      }
      if (temp.left != null) {
        queue.offer(temp.left);
      }
      if (temp.right != null) {
        queue.offer(temp.right);
      }
    }
    return false;
  }

  @Override
  public int size() {
    if (root == null) {
      return 0;
    }
    int count = 0;
    Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      BinaryTreeNode<T> temp = queue.poll();
      count++;
      if (temp.left != null) {
        queue.offer(temp.left);
      }
      if (temp.right != null) {
        queue.offer(temp.right);
      }
    }
    return count;
  }
}
