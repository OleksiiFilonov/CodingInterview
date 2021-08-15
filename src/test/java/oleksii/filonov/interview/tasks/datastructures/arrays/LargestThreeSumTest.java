package oleksii.filonov.interview.tasks.datastructures.arrays;

import org.junit.jupiter.api.Test;

import static oleksii.filonov.interview.tasks.datastructures.arrays.LargestThreeSum.calculateThreeSum;
import static org.junit.jupiter.api.Assertions.*;

class LargestThreeSumTest {

    @Test
    void checkForInputArgument() {
        assertThrows(RuntimeException.class, () -> calculateThreeSum(new int[0]));
    }

    @Test
    void calculateMaxSum() {
        assertEquals(6, calculateThreeSum(new int[]{1, 2, 3}));
        assertEquals(9, calculateThreeSum(new int[]{1, 2, 3, 4}));
        assertEquals(9, calculateThreeSum(new int[]{4, 3, 2, 1}));
        assertEquals(6, calculateThreeSum(new int[]{2, 2, 2, 2}));
        assertEquals(300, calculateThreeSum(new int[]{50, -1, 3, 5, 50, -100, 3, 5, 17, 200, -200}));
    }

}