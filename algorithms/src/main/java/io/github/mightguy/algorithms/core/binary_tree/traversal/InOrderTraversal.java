package io.github.mightguy.algorithms.core.binary_tree.traversal;

import io.github.mightguy.algorithms.core.binary_tree.BinaryTreeNode;

import java.util.List;

/**
 * Inorder Traversal, when root is in the middle
 * @param <T>
 */
public class InOrderTraversal<T> implements OrderTraversal<T> {

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
        return null;
    }
}
