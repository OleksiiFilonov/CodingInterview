package oleksii.filonov.interview.tasks.datastructures.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class GreaterTreeConverterTest {

    @Test
    public void convert() {
        BinarySearchTree bst = createBST();

        GreaterTreeConverter.convert(bst);

        assertIterableEquals(List.of(36, 36, 35, 33, 30, 26, 21, 15, 8), bst.inOrder());
    }

    private BinarySearchTree createBST() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(4);
        bst.insert(1);
        bst.insert(6);
        bst.insert(2);
        bst.insert(0);
        bst.insert(5);
        bst.insert(7);
        bst.insert(3);
        bst.insert(8);
        assertIterableEquals(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8), bst.inOrder());
        return bst;
    }
}