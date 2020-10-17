package io.github.mightguy.algorithms.trees.traversal;

import io.github.mightguy.algorithms.trees.Node;

import java.util.List;

public class InOrderTraversal<T> implements OrderTraversal<T> {
    /**
     * Root in middle
     * Traversal by recursion
     *
     * @param root
     */
    public void traversalByRecursion(Node<T> root, List<T> dataList) {
        if (root == null) {
            return;
        }
        traversalByRecursion(root.left, dataList);
        dataList.add(root.data);
        traversalByRecursion(root.right, dataList);

    }
}
