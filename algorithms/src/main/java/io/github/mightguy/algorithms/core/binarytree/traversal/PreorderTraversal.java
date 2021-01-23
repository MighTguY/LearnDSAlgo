package io.github.mightguy.algorithms.core.binarytree.traversal;

import io.github.mightguy.algorithms.core.binarytree.commons.BinaryTreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Preorder when the Root is first
 *
 * @param <T>
 */
public class PreorderTraversal<T extends Comparable> implements OrderTraversal<T> {

  @Override
  public void traversalByRecursion(BinaryTreeNode<T> root, List<T> dataList) {
    if (root == null) {
      return;
    }
    dataList.add(root.data);
    traversalByRecursion(root.left, dataList);
    traversalByRecursion(root.right, dataList);
  }

  @Override
  public List<T> traversalByIteration(BinaryTreeNode<T> root) {
    if (root == null) {
      return Collections.emptyList();
    }
    Stack<BinaryTreeNode<T>> stack = new Stack<>();
    List<T> orderedList = new ArrayList<>();
    stack.push(root);
    while (!stack.empty()) {
      BinaryTreeNode<T> node = stack.pop();
      orderedList.add(node.data);
      if (node.right != null) {
        stack.push(node.right);
      }
      if (node.left != null) {
        stack.push(node.left);
      }
    }
    return orderedList;
  }
}
