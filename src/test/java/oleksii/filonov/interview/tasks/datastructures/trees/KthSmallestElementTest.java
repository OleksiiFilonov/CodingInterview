package oleksii.filonov.interview.tasks.datastructures.trees;

import org.junit.jupiter.api.Test;

import static oleksii.filonov.interview.tasks.datastructures.trees.KthSmallestElement.kthSmallest;
import static oleksii.filonov.interview.tasks.datastructures.trees.TreeUtils.buildLevelOrderTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthSmallestElementTest {

    @Test
    public void testName() {
        //                           5
        //            3                          10
        //     2             4             8           15
        //  1    null   null   null     6     9    null    25
        Node root = buildLevelOrderTree(new Integer[]{0, 5, 3, 10, 2, 4, 8, 15, 1, null, null, null, 6, 9, null, 25});
        assertEquals(1, kthSmallest(root, 1));
        assertEquals(3, kthSmallest(root, 3));
        assertEquals(5, kthSmallest(root, 5));
        assertEquals(8, kthSmallest(root, 7));
    }

}
