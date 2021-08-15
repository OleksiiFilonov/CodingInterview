package oleksii.filonov.interview.tasks.datastructures.trees;


import org.junit.jupiter.api.Test;

import static oleksii.filonov.interview.tasks.datastructures.trees.ClosestNeighborsBST.findNeighbors;
import static oleksii.filonov.interview.tasks.datastructures.trees.TreeUtils.buildLevelOrderTree;
import static org.junit.jupiter.api.Assertions.*;

public class ClosestNeighborsBSTTest {

    @Test
    public void testFindNeighbors() {
        //                           5
        //            3                          10
        //     2             4             8           15
        //  1    null   null   null     6     9    null    25
        Node root = buildLevelOrderTree(
                new Integer[]{0, 5, 3, 10, 2, 4, 8, 15, 1, null, null, null, 6, 9, null, 25});
        assertArrayEquals(new Integer[]{4, 6}, findNeighbors(5, root));
        assertArrayEquals(new Integer[]{1, 3}, findNeighbors(2, root));
        assertArrayEquals(new Integer[]{3, 5}, findNeighbors(4, root));
        assertArrayEquals(new Integer[]{10, 25}, findNeighbors(15, root));
        assertArrayEquals(new Integer[]{8, 10}, findNeighbors(9, root));
        assertArrayEquals(new Integer[]{10, 15}, findNeighbors(14, root));
    }

    public void whenTargetIsTheMostLeftLeaf() {
        Node root = buildLevelOrderTree(
                new Integer[]{0, 5, 3, 10, 2, 4, 8, 15, 1, null, null, null, 6, 9, null, 25});
        assertArrayEquals(new Integer[]{1, 2}, findNeighbors(1, root));
    }
}