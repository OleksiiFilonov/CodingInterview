package oleksii.filonov.interview.tasks.datastructures.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMinValueInRotatedArrayTest {

    @Test
    void testFindMin() {
        FindMinValueInRotatedArray solution = new FindMinValueInRotatedArray();
        assertEquals(3, solution.findMin(new int[]{6, 7, 8, 9, 3, 4, 5}));
        assertEquals(3, solution.findMin(new int[]{6, 7, 8, 9, 10, 11, 3, 4, 5}));
        assertEquals(1, solution.findMin(new int[]{6, 7, 8, 9, 1, 2, 3, 4, 5}));
        assertEquals(99, solution.findMin(new int[]{99}));
        assertEquals(1, solution.findMin(new int[]{1, 2, 3}));
        assertEquals(1, solution.findMin(new int[]{2, 1}));
    }
}