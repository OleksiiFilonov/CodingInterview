package oleksii.filonov.interview.tasks.datastructures.trees;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

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

    private BinarySearchTree createBST() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(5);
        return binarySearchTree;
    }

}
