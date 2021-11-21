package oleksii.filonov.interview.tasks.datastructures.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTreeLookupTest {
    /*
                  5
             4       8
           1      7   12
             3
     */
    @Test
    public void hasPathSum() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(4);
        bst.insert(8);
        bst.insert(1);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        assertTrue(bst.hasPathSum(13));
        assertTrue(bst.hasPathSum(25));
        assertFalse(bst.hasPathSum(9));
        assertFalse(bst.hasPathSum(18));
    }
}
