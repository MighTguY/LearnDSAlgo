package io.github.mightguy.algorithms.trees.traversal;

import io.github.mightguy.algorithms.trees.Node;

import java.util.List;

public interface OrderTraversal<T> {

    /**
     * Recursive order traversal
     *
     * @param root
     */
    public void traversalByRecursion(Node<T> root, List<T> dataList);
}
