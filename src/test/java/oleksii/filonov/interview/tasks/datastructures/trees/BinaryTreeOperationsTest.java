package oleksii.filonov.interview.tasks.datastructures.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BinaryTreeOperationsTest {

    @Test
    public void checkSize() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(2);
        binaryTree.insert(1);
        assertEquals(2, binaryTree.size());
        binaryTree.insert(3);
        assertEquals(3, binaryTree.size());
        binaryTree.insert(4);
        assertEquals(4, binaryTree.size());
    }

    @Test
    public void checkMaxDepth() {
        BinaryTree binaryTree = new BinaryTree();
        assertEquals(0, binaryTree.maxDepth());
        binaryTree.insert(2);
        assertEquals(1, binaryTree.maxDepth());
        binaryTree.insert(1);
        assertEquals(2, binaryTree.maxDepth());
        binaryTree.insert(3);
        assertEquals(2, binaryTree.maxDepth());
        binaryTree.insert(4);
        assertEquals(3, binaryTree.maxDepth());
    }

    @Test
    public void checkMinValue() {
        BinaryTree binaryTree = new BinaryTree();
        assertThrows(IllegalStateException.class, binaryTree::minValue);
        binaryTree.insert(2);
        assertEquals(2, binaryTree.minValue());
        binaryTree.insert(1);
        assertEquals(1, binaryTree.minValue());
        binaryTree.insert(3);
        assertEquals(1, binaryTree.minValue());
        binaryTree.insert(0);
        assertEquals(0, binaryTree.minValue());
    }
}
