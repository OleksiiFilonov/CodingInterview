package oleksii.filonov.interview.tasks.datastructures.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
