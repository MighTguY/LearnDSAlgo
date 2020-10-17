package io.github.mightguy.algorithms.core.binary_tree.traversal;


import io.github.mightguy.algorithms.core.binary_tree.BinaryTreeNode;

import java.util.List;

/**
 * PostOrder when the Root is in the end
 *
 * @param <T>
 */
public class PostOrderTraversal<T> implements OrderTraversal<T> {

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
        return null;
    }
}
