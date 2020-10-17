package io.github.mightguy.algorithms.trees;

import io.github.mightguy.algorithms.trees.traversal.OrderTraversalFactory;
import io.github.mightguy.algorithms.trees.traversal.TraversalType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree<T> {
    private Node<T> root;
    private final OrderTraversalFactory<T> orderTraversalFactory;

    public BinaryTree(Node<T> root) {
        this.root = root;
        this.orderTraversalFactory = OrderTraversalFactory.getInstance();
    }

    public BinaryTree() {
        this.root = null;
        this.orderTraversalFactory = OrderTraversalFactory.getInstance();
    }

    /**
     * Adding a node to the Same Level as other leaves else add it to the left most
     *
     * @param node {@link Node} to insert
     */
    public void add(Node<T> node) {
        if (root == null) {
            root = node;
            return;
        }
        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> temp = queue.peek();
            queue.remove();
            if (temp.left == null) {
                temp.left = node;
                break;
            } else {
                queue.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = node;
                break;
            } else {
                queue.add(temp.right);
            }
        }
    }

    public List<T> preOrderTraversal() {
        return fetchOrderTraversalList(TraversalType.PREORDER);
    }

    public List<T> inOrderTraversal() {
        return fetchOrderTraversalList(TraversalType.INORDER);
    }

    public List<T> postOrderTraversal() {
        return fetchOrderTraversalList(TraversalType.POSTORDER);
    }

    private List<T> fetchOrderTraversalList(TraversalType traversalType) {
        List<T> orderedList = new ArrayList<T>();
        orderTraversalFactory.getTraversal(traversalType).traversalByRecursion(root, orderedList);
        return orderedList;
    }

}
