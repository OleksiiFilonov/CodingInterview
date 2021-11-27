package oleksii.filonov.interview.tasks.datastructures.trees;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static oleksii.filonov.interview.tasks.datastructures.trees.BSTTestHelper.createBST;
import static oleksii.filonov.interview.tasks.datastructures.trees.BSTTestHelper.printCollection;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTreeTraversalTest {

    @Test
    public void inOrderTraversal() {
        BinarySearchTree binarySearchTree = createBST();
        List<Integer> actualBSTOrder = binarySearchTree.inOrder();
        assertIterableEquals(List.of(1, 2, 3, 4, 5), actualBSTOrder,
                () -> printCollection(actualBSTOrder));
    }

    @Test
    public void postOrderTraversal() {
        BinarySearchTree binarySearchTree = createBST();
        List<Integer> actualBSTOrder = binarySearchTree.postOrder();
        assertIterableEquals(List.of(1, 3, 2, 5, 4), actualBSTOrder,
                () -> printCollection(actualBSTOrder));
    }

    @Test
    public void preOrderTraversal() {
        BinarySearchTree binarySearchTree = createBST();
        List<Integer> actualBSTOrder = binarySearchTree.preOrder();
        assertIterableEquals(List.of(4, 2, 1, 3, 5), actualBSTOrder,
                () -> printCollection(actualBSTOrder));
    }

    @Test
    public void printPath() {
        BinarySearchTree bst = createBST();
        bst.insert(6);
        List<List<Integer>> paths = bst.printPath();
        assertTrue(paths.stream().anyMatch(path -> path.equals(List.of(4, 2, 1))));
        assertTrue(paths.stream().anyMatch(path -> path.equals(List.of(4, 2, 3))));
        assertFalse(paths.stream().anyMatch(path -> path.equals(List.of(4, 5))));
        assertTrue(paths.stream().anyMatch(path -> path.equals(List.of(4, 5, 6))));
        assertFalse(paths.stream().anyMatch(path -> path.equals(List.of(4, 2))));
        assertFalse(paths.stream().anyMatch(path -> path.equals(List.of(4, 3))));
    }


}
