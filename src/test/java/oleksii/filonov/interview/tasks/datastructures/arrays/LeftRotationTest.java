package oleksii.filonov.interview.tasks.datastructures.arrays;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LeftRotationTest {

	@Test
	public void testLeftRotationInitialEven() {
		int[] initial = new int[] { 41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51 };
		int[] expectedRotated = new int[] { 77, 97, 58, 1, 86, 58, 26, 10, 86, 51, 41, 73, 89, 7, 10, 1, 59, 58, 84,
				77 };
		int[] rotatedLeft = LeftRotation.rotLeft(initial, 10);
		//System.out.println(Arrays.toString(rotatedLeft));
		assertArrayEquals(expectedRotated, rotatedLeft);
	}

	@Test
	public void testLeftRotationInitialOdd() {
		int[] initial = new int[] { 1, 2, 3, 4, 5 };
		int[] expectedRotated = new int[] { 5, 1, 2, 3, 4 };
		int[] rotatedLeft = LeftRotation.rotLeft(initial, 4);
		//System.out.println(Arrays.toString(rotatedLeft));
		assertArrayEquals(expectedRotated, rotatedLeft);
	}

}
