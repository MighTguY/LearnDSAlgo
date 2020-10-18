package io.github.mightguy.algorithms.core.binarytree.traversal;


import io.github.mightguy.algorithms.core.binarytree.BinaryTreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * PostOrder when the Root is in the end
 *
 * @param <T>
 */
public class PostOrderTraversal<T extends Comparable> implements OrderTraversal<T> {

  @Override
  public void traversalByRecursion(BinaryTreeNode<T> root, List<T> dataList) {
    if (root == null) {
      return;
    }
    traversalByRecursion(root.left, dataList);
    traversalByRecursion(root.right, dataList);
    dataList.add(root.data);
  }

  @Override
  public List<T> traversalByIteration(BinaryTreeNode<T> root) {
    if (root == null) {
      return Collections.emptyList();
    }
    Stack<BinaryTreeNode<T>> stack = new Stack<>();
    stack.push(root);
    BinaryTreeNode<T> prev = null;
    List<T> result = new ArrayList<>();

    while (!stack.isEmpty()) {
      BinaryTreeNode<T> curr = stack.peek();
      if (prev == null || prev.left == curr || prev.right == curr) {
        if (curr.left != null) {
          stack.push(curr.left);
        } else if (curr.right != null) {
          stack.push(curr.right);
        }
      } else if (curr.left == prev) {
        if (curr.right != null) {
          stack.push(curr.right);
        }
      } else {
        result.add(curr.data);
        stack.pop();
      }
      prev = curr;
    }
    return result;
  }
}
