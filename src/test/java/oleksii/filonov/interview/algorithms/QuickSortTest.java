package oleksii.filonov.interview.algorithms;

import static oleksii.filonov.interview.algorithms.QuickSort.sort;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class QuickSortTest {

	@Test
	public void sortArraysWithUniqueNumbers() {
		assertArrayEquals(new int[] { 1, 2 }, sort(new int[] { 1, 2 }));
		assertArrayEquals(sort(new int[] { 2, 1 }), (new int[] { 1, 2 }));
		assertArrayEquals(sort(new int[] { 4, 5, 1, 8, 3, 2 }), (new int[] { 1, 2, 3, 4, 5, 8 }));
		assertArrayEquals(sort(new int[] { 4, 5, 1, 8, 10, 7, 3, 2 }), (new int[] { 1, 2, 3, 4, 5, 7, 8, 10 }));
		assertArrayEquals(sort(new int[] { 15, 999, 18, 4, 5, 333, 1, 8, 3, 22 }),
				(new int[] { 1, 3, 4, 5, 8, 15, 18, 22, 333, 999 }));
	}

	@Test
	public void sortArrayWithRepeatedNumbers() {
		assertArrayEquals(sort(new int[] { 5, 3, 88, 7, 1, 2, 1, 5, 12, 1, 3, 12 }),
				(new int[] { 1, 1, 1, 2, 3, 3, 5, 5, 7, 12, 12, 88 }));
	}

}
