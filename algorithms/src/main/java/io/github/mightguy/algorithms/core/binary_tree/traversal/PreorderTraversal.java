package io.github.mightguy.algorithms.core.binary_tree.traversal;

import io.github.mightguy.algorithms.core.binary_tree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Preorder when the Root is first
 *
 * @param <T>
 */
public class PreorderTraversal<T> implements OrderTraversal<T> {

    /**
     * Root in beginning
     * Traversal by recursion
     *
     * @param root
     */
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
        List<BinaryTreeNode<T>> orderedList = new ArrayList<>();
        stack.push(root);
        while (!stack.empty()) {
            BinaryTreeNode<T> node = stack.pop();
            orderedList.add(node);
            if (node.left != null) {
                stack.push(node.left);
            } else if (node.right != null) {
                stack.push(node.right);
            }
        }
        return null;
    }
}
