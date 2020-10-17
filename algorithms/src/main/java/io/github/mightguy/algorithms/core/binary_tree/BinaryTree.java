package io.github.mightguy.algorithms.core.binary_tree;

import io.github.mightguy.algorithms.core.binary_tree.traversal.OrderTraversalFactory;
import io.github.mightguy.algorithms.core.binary_tree.traversal.TraversalType;

import java.util.List;

public abstract class BinaryTree<T> {
    protected BinaryTreeNode<T> root;
    protected final OrderTraversalFactory<T> orderTraversalFactory;

    public BinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
        this.orderTraversalFactory = OrderTraversalFactory.getInstance();
    }

    public BinaryTree() {
        this.root = null;
        this.orderTraversalFactory = OrderTraversalFactory.getInstance();
    }


    /**
     * Pre order Traversal i.e Root -> Left -> Right
     *
     * @return List {@link List} of elements of type T
     */
    public List<T> preOrderTraversal() {
        return fetchOrderTraversalList(TraversalType.PREORDER);
    }

    /**
     * IN order Traversal i.e Left -> Root -> Right
     *
     * @return List {@link List} of elements of type T
     */
    public List<T> inOrderTraversal() {
        return fetchOrderTraversalList(TraversalType.INORDER);
    }

    /**
     * Post order Traversal i.e Left -> Right -> Root
     *
     * @return List {@link List} of elements of type T
     */
    public List<T> postOrderTraversal() {
        return fetchOrderTraversalList(TraversalType.POSTORDER);
    }

    public boolean deleteTree() {
        root = null;
        return true;
    }

    abstract protected List<T> fetchOrderTraversalList(TraversalType traversalType);

    /**
     * Adding a node to the binary tree
     *
     * @param node {@link BinaryTreeNode} to insert
     */
    abstract public void add(BinaryTreeNode<T> node);

}
