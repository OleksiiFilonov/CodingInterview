package oleksii.filonov.interview.tasks.screening;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TargetSumTest {

    private TargetSum targetSum = new TargetSum();

    @Test
    public void testZero() {
        assertTrue(targetSum.ifSumPossible(new int[]{1, 0}, 0));
        assertTrue(targetSum.ifSumPossible(new int[] {1, 10, 1, -10}, 0));
        assertFalse(targetSum.ifSumPossible(new int[] {}, 0));
        assertFalse(targetSum.ifSumPossible(new int[] {1, 2, 3}, 0));
    }

    @Test
    public void testSum() {
        assertTrue(targetSum.ifSumPossible(new int[] {1, 2, 3, 4}, 10));
        assertTrue(targetSum.ifSumPossible(new int[] {1, -10, -5}, -15));
        assertFalse(targetSum.ifSumPossible(new int[] {1, 4, 5}, 7));
        assertFalse(targetSum.ifSumPossible(new int[] {1, -2, 3}, 15));
    }
}