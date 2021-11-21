package oleksii.filonov.interview.tasks.datastructures.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class BinarySearchTreeTraversalTest {

    @Test
    public void inOrderTraversal() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(5);
        List<Integer> actualBSTOrder = binarySearchTree.inOrder();
        assertIterableEquals(List.of(1, 2, 3, 4, 5), actualBSTOrder,
                () -> "actual: " + actualBSTOrder.stream().map(Object::toString).collect(Collectors.joining(",")));
    }
}
