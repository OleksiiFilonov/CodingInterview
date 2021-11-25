package oleksii.filonov.interview.tasks.datastructures.trees;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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

    private String printCollection(Collection<Integer> actualBSTOrder) {
        return "actual: " + actualBSTOrder.stream().map(Object::toString).collect(Collectors.joining(","));
    }

    /**
     * 4
     * 2        5
     * 1    3
     *
     * @return binary  tree
     */
    private BinarySearchTree createBST() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(5);
        return binarySearchTree;
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

    @Test
    public void mirror() {
        BinarySearchTree bst = createBST();
        List<Integer> inOrderBefore = bst.inOrder();
        assertIterableEquals(List.of(1, 2, 3, 4, 5), inOrderBefore, () -> printCollection(inOrderBefore));
        bst.mirror();
        List<Integer> inOrderAfterMirror = bst.inOrder();
        assertIterableEquals(List.of(5, 4, 3, 2, 1), inOrderAfterMirror, () -> printCollection(inOrderAfterMirror));
    }
}
