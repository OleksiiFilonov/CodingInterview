package oleksii.filonov.interview.algorithms;

import static oleksii.filonov.interview.algorithms.MergeSort.sortIteratively;
import static oleksii.filonov.interview.algorithms.MergeSort.sortRecursively;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class MergeSortTest {

    @Test
    public void testMergeSortRecursion() {
        assertArrayEquals(new int[]{1, 2, 3, 5}, sortRecursively(new int[]{5, 2, 3, 1}));
        assertArrayEquals(new int[]{1, 1, 2, 2, 3}, sortRecursively(new int[]{2, 1, 3, 1, 2}));
        assertArrayEquals(new int[]{1, 3, 5, 6, 7}, sortRecursively(new int[]{7, 5, 1, 3, 6}));
        assertArrayEquals(new int[]{-5, -2, 3}, sortRecursively(new int[]{-2, 3, -5}));
    }

    @Test
    public void testMergeSortIteration() {
        assertArrayEquals(new int[]{1, 2, 3, 5}, sortIteratively(new int[]{5, 2, 3, 1}));
        assertArrayEquals(new int[]{1, 1, 2, 2, 3}, sortIteratively(new int[]{2, 1, 3, 1, 2}));
        assertArrayEquals(new int[]{1, 3, 5, 6, 7}, sortIteratively(new int[]{7, 5, 1, 3, 6}));
        assertArrayEquals(new int[]{-5, -2, 3}, sortIteratively(new int[]{-2, 3, -5}));
    }
}
