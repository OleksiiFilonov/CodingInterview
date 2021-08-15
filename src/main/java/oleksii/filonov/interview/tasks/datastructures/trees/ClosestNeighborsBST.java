package oleksii.filonov.interview.tasks.datastructures.trees;

import java.util.Arrays;

import static oleksii.filonov.interview.tasks.datastructures.trees.TreeUtils.buildLevelOrderTree;

/**
 * //                           5
 * //            3                          10
 * //     2             4             8           15
 * //  1    null   null   null     6     9    null    25
 * Task - given a value find min closest to this value and max closest to this value
 * In the given tree above for 5 closest neighbors would be 4 and 6
 * for 1 the min would be - 1, max - 2
 * for 0 - min will be null, max - 1
 * for 25: min - 15, max - 25 (itself)
 * for 14 (not present in the tree) - min 10, max - 15;
 * for 999, min - 25, max - null;
 */
public class ClosestNeighborsBST {

    public static Integer[] findNeighbors(int value, Node root) {
        return new Integer[]{findNextLesser(value, root), findNextGreater(value, root)};
    }

    private static Integer findNextGreater(int value, Node root) {
        if (root == null) return null;
        if (root.value > value) {
            Integer result = findNextGreater(value, root.left);
            return result == null || result <= value ? root.value : result;
        } else {
            Integer result = findNextGreater(value, root.right);
            return result == null || result <= value ? root.value : result;
        }
    }

    private static Integer findNextLesser(int value, Node root) {
        if (root == null) return null;
        if (root.value >= value) {
            Integer result = findNextLesser(value, root.left);
            return result == null || result >= value ? root.value : result;
        } else {
            Integer result = findNextLesser(value, root.right);
            return result == null || result >= value ? root.value : result;
        }
    }

    public static void main(String[] args) {
        Node root = buildLevelOrderTree(
                new Integer[]{0, 5, 3, 10, 2, 4, 8, 15, 1, null, null, null, 6, 9, null, 25});
        assertArrayEquals(new Integer[]{4, 6}, findNeighbors(5, root));
        assertArrayEquals(new Integer[]{1, 3}, findNeighbors(2, root));
        assertArrayEquals(new Integer[]{3, 5}, findNeighbors(4, root));
        assertArrayEquals(new Integer[]{10, 25}, findNeighbors(15, root));
        assertArrayEquals(new Integer[]{8, 10}, findNeighbors(9, root));
        assertArrayEquals(new Integer[]{10, 15}, findNeighbors(14, root));
        assertArrayEquals(new Integer[]{1, 2}, findNeighbors(1, root));
    }

    private static boolean assertArrayEquals(Object [] expected, Object [] actual) {
        if (expected.length != actual.length) {
            System.out.println(String.format(
                    "Arrays are different sizes, expected: %s, actual: %s", expected.length, actual.length));
            return false;
        }
        for (int i = 0; i < expected.length; i++) {
            if (!expected[i].equals(actual[i])) {
                System.out.println(String.format(
                        "Element at index %s doesn't match, expected: %s, actual %s",
                        i, expected[i], actual[i]));
                return false;
            }
        }
        System.out.println(String.format(
                "expected: %s matches with actual: %s",
                Arrays.toString(expected), Arrays.toString(actual)));
        return true;
    }
}
