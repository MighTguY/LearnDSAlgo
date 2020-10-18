package io.github.mightguy.algorithms.core.binarytree.traversal;

import io.github.mightguy.algorithms.core.binarytree.BinaryTreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Inorder Traversal, when root is in the middle
 *
 * @param <T>
 */
public class InOrderTraversal<T extends Comparable> implements OrderTraversal<T> {

  @Override
  public void traversalByRecursion(BinaryTreeNode<T> root, List<T> dataList) {
    if (root == null) {
      return;
    }
    traversalByRecursion(root.left, dataList);
    dataList.add(root.data);
    traversalByRecursion(root.right, dataList);
  }

  @Override
  public List<T> traversalByIteration(BinaryTreeNode<T> root) {
    if (root == null) {
      return Collections.emptyList();
    }
    Stack<BinaryTreeNode<T>> stack = new Stack<>();
    BinaryTreeNode<T> curr = root;
    List<T> result = new ArrayList<>();
    boolean done = false;

    while (!done) {
      if (curr != null) {
        stack.push(curr);
        curr = curr.left;
      } else {
        if (stack.isEmpty()) {
          done = true;
        } else {
          curr = stack.pop();
          result.add(curr.data);
          curr = curr.right;
        }
      }
    }
    return result;
  }
}
