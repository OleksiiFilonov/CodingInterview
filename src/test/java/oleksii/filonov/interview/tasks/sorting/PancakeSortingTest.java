package oleksii.filonov.interview.tasks.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PancakeSortingTest {

    @Test
    void testPancakeSort() {
        PancakeSorting sorting = new PancakeSorting();
        Integer[] actual = sorting.pancakeSort(new int[]{3, 2, 4, 1}).toArray(new Integer[]{});
        System.out.println(Arrays.toString(actual));
        assertArrayEquals(new Integer[]{3, 4, 2, 3, 1, 2}, actual);
    }
}