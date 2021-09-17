package oleksii.filonov.interview.algorithms.dynamicprogramming;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumSumSubarrayFinderTest {

    private MaximumSumSubarrayFinder finder = new MaximumSumSubarrayFinder();

    @Test
    public void maxSum() {
        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, finder.findMaxSubArrayRecursively(input));
        assertEquals(6, finder.findMaxSubArrayDP(input));
    }
}