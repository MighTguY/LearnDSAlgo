package io.github.mightguy.algorithms.core.binary_tree.traversal;

import java.util.HashMap;
import java.util.Map;

public class OrderTraversalFactory<T> {

    public static OrderTraversalFactory instance = null;
    Map<TraversalType, OrderTraversal> traversals = new HashMap<TraversalType, OrderTraversal>();

    public static OrderTraversalFactory getInstance() {
        if (instance == null) {
            instance = new OrderTraversalFactory();
        }
        return instance;
    }

    private OrderTraversalFactory() {
        traversals.put(TraversalType.INORDER, new InOrderTraversal<T>());
        traversals.put(TraversalType.POSTORDER, new PostOrderTraversal());
        traversals.put(TraversalType.PREORDER, new PreorderTraversal());
    }

    public OrderTraversal<T> getTraversal(TraversalType traversalType) {
        OrderTraversal<T> orderTraversal = traversals.get(traversalType);
        if (orderTraversal == null) {
            throw new RuntimeException("No such traversal found " + traversalType);
        }
        return orderTraversal;
    }
}
