package io.github.mightguy.algorithms.core.binarytree.traversal;

import io.github.mightguy.algorithms.core.binarytree.commons.BinaryTreeNode;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1. Visit the root \n 2. While traversing Level i, keep all elements of level i+1 in queue \n 3.
 * Go to the next level and visit all the nodes \n 4. repeat until all levels are completed \n
 *
 * @param <T>
 */
public class LevelOrderTraversal<T extends Comparable> implements OrderTraversal<T> {

  @Override
  public void traversalByRecursion(BinaryTreeNode<T> root, List<T> dataList) {
    throw new UnsupportedOperationException("Level order by recursion is not supported");
  }

  @Override
  public List<T> traversalByIteration(BinaryTreeNode<T> root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<T> res = new LinkedList<>();
    List<T> curr = new LinkedList<>();
    Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
    queue.offer(root);
    queue.offer(null);
    while (!queue.isEmpty()) {
      BinaryTreeNode<T> temp = queue.poll();
      if (temp == null) {
        res.addAll(curr);
        curr.clear();
        if (!queue.isEmpty()) {
          queue.offer(null);
        }
        continue;
      }
      curr.add(temp.data);
      if (temp.left != null) {
        queue.offer(temp.left);
      }
      if (temp.right != null) {
        queue.offer(temp.right);
      }
    }
    return res;
  }
}
