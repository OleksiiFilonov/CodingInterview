package oleksii.filonov.interview.tasks.datastructures.trees;

import org.junit.jupiter.api.Test;

import static oleksii.filonov.interview.tasks.datastructures.trees.TreeUtils.buildLevelOrderTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberGoodLeafNodesPairsTest {

    private NumberGoodLeafNodesPairs testInstance = new NumberGoodLeafNodesPairs();

    @Test
    public void testCountPairsDistance_3() {
        Node root = buildLevelOrderTree(new Integer[]{0, 1, 2, 3, null, 4});
        assertEquals(1, testInstance.countPairs(root, 3));
    }

    @Test
    public void testCountPairsDistance_3_moreComplex() {
        Node root = buildLevelOrderTree(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7});
        assertEquals(2, testInstance.countPairs(root, 3));
    }

    @Test
    public void testCountPairsDistance_3_theOnlyPair() {
        Node root = buildLevelOrderTree(new Integer[]{0, 7, 1, 4, 6, null, 5, 3, null, null, null, null, null, 2});
        assertEquals(1, testInstance.countPairs(root, 3));
    }

    @Test
    public void testCountPairsDistance_one_root() {
        Node root = buildLevelOrderTree(new Integer[]{0, 100});
        assertEquals(0, testInstance.countPairs(root, 1));
    }

    @Test
    public void testCountPairsDistance_2() {
        Node root = buildLevelOrderTree(new Integer[]{0, 1, 1, 1});
        assertEquals(1, testInstance.countPairs(root, 2));
    }
}