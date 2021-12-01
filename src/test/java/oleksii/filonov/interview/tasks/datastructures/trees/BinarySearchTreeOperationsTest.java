package oleksii.filonov.interview.tasks.datastructures.trees;

import org.junit.jupiter.api.Test;

import java.util.List;

import static oleksii.filonov.interview.tasks.datastructures.trees.BSTTestHelper.createBST;
import static oleksii.filonov.interview.tasks.datastructures.trees.BSTTestHelper.printCollection;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class BinarySearchTreeOperationsTest {

    @Test
    public void checkSize() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        assertEquals(2, binarySearchTree.size());
        binarySearchTree.insert(3);
        assertEquals(3, binarySearchTree.size());
        binarySearchTree.insert(4);
        assertEquals(4, binarySearchTree.size());
    }

    @Test
    public void checkMaxDepth() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        assertEquals(0, binarySearchTree.maxDepth());
        binarySearchTree.insert(2);
        assertEquals(1, binarySearchTree.maxDepth());
        binarySearchTree.insert(1);
        assertEquals(2, binarySearchTree.maxDepth());
        binarySearchTree.insert(3);
        assertEquals(2, binarySearchTree.maxDepth());
        binarySearchTree.insert(4);
        assertEquals(3, binarySearchTree.maxDepth());
    }

    @Test
    public void checkMinValue() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        assertThrows(IllegalStateException.class, binarySearchTree::minValue);
        binarySearchTree.insert(2);
        assertEquals(2, binarySearchTree.minValue());
        binarySearchTree.insert(1);
        assertEquals(1, binarySearchTree.minValue());
        binarySearchTree.insert(3);
        assertEquals(1, binarySearchTree.minValue());
        binarySearchTree.insert(0);
        assertEquals(0, binarySearchTree.minValue());
    }

    @Test
    public void mirror() {
        BinarySearchTree bst = createBST();
        List<Integer> inOrderBefore = bst.inOrder();
        assertIterableEquals(List.of(1, 2, 3, 4, 5), inOrderBefore, () -> printCollection(inOrderBefore));
        bst.mirror();
        List<Integer> inOrderAfterMirror = bst.inOrder();
        assertIterableEquals(List.of(5, 4, 3, 2, 1), inOrderAfterMirror, () -> printCollection(inOrderAfterMirror));
    }

    @Test
    public void doubleTree() {
        BinarySearchTree bst = createBST();
        bst.doubleTree();
        List<Integer> inOrderBefore = bst.inOrder();
        assertIterableEquals(List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5), inOrderBefore, () -> printCollection(inOrderBefore));
    }

    @Test
    public void sameTree() {
        BinarySearchTree bst1 = createBST();
        BinarySearchTree bst2 = createBST();
        assertEquals(bst1, bst2);
        bst2.insert(99);
        assertNotEquals(bst1, bst2);
    }

    @Test
    public void countTrees() {
        assertEquals(1, BinarySearchTree.countTrees(0));
        assertEquals(1, BinarySearchTree.countTrees(1));
        assertEquals(2, BinarySearchTree.countTrees(2));
        assertEquals(5, BinarySearchTree.countTrees(3));
        assertEquals(14, BinarySearchTree.countTrees(4));
    }
}
