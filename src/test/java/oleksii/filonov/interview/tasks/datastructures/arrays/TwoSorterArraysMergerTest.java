package oleksii.filonov.interview.tasks.datastructures.arrays;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSorterArraysMergerTest {

    @Test
    public void merge() {
        assertArrayEquals(new int[]{1, 3, 4, 5, 6, 7, 9}, TwoSorterArraysMerger.merge(new int[]{1, 5, 6, 9, 0, 0, 0}, new int[]{3, 4, 7}));
        assertArrayEquals(new int[]{1, 1}, TwoSorterArraysMerger.merge(new int[]{1, 0}, new int[]{1}));
        assertArrayEquals(new int[]{1, 2}, TwoSorterArraysMerger.merge(new int[]{1, 0}, new int[]{2}));
        assertArrayEquals(new int[]{1, 2}, TwoSorterArraysMerger.merge(new int[]{2, 0}, new int[]{1}));
        assertArrayEquals(new int[]{1, 2}, TwoSorterArraysMerger.merge(new int[]{1, 2}, new int[]{}));
    }

}