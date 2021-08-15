package oleksii.filonov.interview.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class InsertionSortTest {

    @Test
    public void iterativeSort() {
        assertArrayEquals(new int[]{3, 5, 8}, InsertionSort.iterativeSort(new int[]{5, 8, 3}));
    }
}