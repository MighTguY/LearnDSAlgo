package io.github.mightguy.algorithms.core.binary_tree;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class IterativeBinaryTreeTest {

    IterativeBinaryTree<Integer> binaryTree = new IterativeBinaryTree<>();

    @BeforeEach
    void init() {
        binaryTree.deleteTree();
        binaryTree.add(new BinaryTreeNode<>(1));
        binaryTree.add(new BinaryTreeNode<>(2));
        binaryTree.add(new BinaryTreeNode<>(3));
        binaryTree.add(new BinaryTreeNode<>(4));
        binaryTree.add(new BinaryTreeNode<>(5));
        binaryTree.add(new BinaryTreeNode<>(6));
        log.info("@BeforeEach - Deleted old and New Binary Tree is Created ");
    }

    @Test
    void lambdaExpressions() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        assertTrue(numbers.stream()
                .mapToInt(i -> i)
                .sum() > 5, "Sum should be greater than 5");
    }

    @Test
    public void testPreOrderTraversal() {
        assertEquals(Arrays.asList(0, 1, 3, 4, 2, 5, 6), binaryTree.preOrderTraversal());
    }

    @Test
    public void testInOrderTraversal() {
        assertEquals(Arrays.asList(3, 1, 4, 0, 5, 2, 6), binaryTree.preOrderTraversal());
    }

    @Test
    public void testPostOrder() {
        assertEquals(Arrays.asList(3, 4, 1, 5, 6, 2, 0), binaryTree.preOrderTraversal());
    }

    @Test
    public void testAdd() {

    }

    @Test
    public void testDelete() {

    }
}