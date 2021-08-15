package oleksii.filonov.interview.tasks.datastructures.trees;

import static oleksii.filonov.interview.tasks.datastructures.trees.FindMaxSum.maximumSum;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FindMaxSumTest {

	@Test
	public void findMaxSum() {
		assertEquals(20, maximumSum(new int[] { -1, 0, 1, 2, 0 }, new int[] { -2, 10, 10, -3, 10 }));
		assertEquals(25, maximumSum(new int[] { -1, 0, 1, 4, 0, 2 }, new int[] { 5, 5, 5, 10, 10, -5 }));
	}
}
