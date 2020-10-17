package io.github.mightguy.algorithms.trees.traversal;

import io.github.mightguy.algorithms.trees.Node;

import java.util.List;

public class PreorderTraversal<T> implements OrderTraversal<T> {

    /**
     * Root in beginning
     * Traversal by recursion
     *
     * @param root
     */
    public void traversalByRecursion(Node<T> root, List<T> dataList) {
        if (root == null) {
            return;
        }
        dataList.add(root.data);
        traversalByRecursion(root.left, dataList);
        traversalByRecursion(root.right, dataList);
    }
}
