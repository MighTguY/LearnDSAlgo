package io.github.mightguy.algorithms.core.binarytree;

import io.github.mightguy.algorithms.core.binarytree.traversal.OrderTraversalFactory;
import io.github.mightguy.algorithms.core.binarytree.traversal.TraversalType;
import java.util.List;

public abstract class BinaryTree<T extends Comparable> {

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

  public List<T> levelOrderTraversal() {
    return fetchOrderTraversalList(TraversalType.LEVELORDER);
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

  /**
   * Check if the element exist in the tree
   *
   * @param data
   * @return
   */
  abstract public boolean contains(T data);

  abstract public int size();
}
