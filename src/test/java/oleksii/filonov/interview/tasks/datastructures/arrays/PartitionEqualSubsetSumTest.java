package oleksii.filonov.interview.tasks.datastructures.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PartitionEqualSubsetSumTest {

    @Test
    public void testIsPossible() {
        PartitionEqualSubsetSum test = new PartitionEqualSubsetSum();
        assertTrue(test.canPartition(new int[]{1, 2, 3, 3, 4, 5}));
        assertTrue(test.canPartition(new int[]{1, 5, 11, 5}));
        assertFalse(test.canPartition(new int[]{1, 2, 3, 5}));
    }
}