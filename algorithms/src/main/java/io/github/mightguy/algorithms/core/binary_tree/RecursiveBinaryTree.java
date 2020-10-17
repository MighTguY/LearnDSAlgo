package io.github.mightguy.algorithms.core.binary_tree;

import io.github.mightguy.algorithms.core.binary_tree.traversal.TraversalType;

import java.util.ArrayList;
import java.util.List;

public class RecursiveBinaryTree<T> extends BinaryTree<T> {

    public RecursiveBinaryTree(BinaryTreeNode<T> root) {
        super(root);
    }

    public RecursiveBinaryTree() {
        super();
    }


    /**
     * Adding a node recursively to the Same Level as other leaves else add it to the left most
     *
     * @param node {@link BinaryTreeNode} to insert
     */
    public void add(BinaryTreeNode<T> node) {

    }

    protected List<T> fetchOrderTraversalList(TraversalType traversalType) {
        List<T> orderedList = new ArrayList<T>();
        orderTraversalFactory.getTraversal(traversalType).traversalByRecursion(root, orderedList);
        return orderedList;
    }

}
