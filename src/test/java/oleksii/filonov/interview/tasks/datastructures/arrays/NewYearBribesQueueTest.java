package oleksii.filonov.interview.tasks.datastructures.arrays;

import static oleksii.filonov.interview.tasks.datastructures.arrays.ArrayScanner.readArray;
import static oleksii.filonov.interview.tasks.datastructures.arrays.NewYearBribesQueue.minimumBribes;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NewYearBribesQueueTest {

	@Test
	public void simpleTests() {
		assertEquals(3, NewYearBribesQueue.minimumBribes(new int[] { 2, 1, 5, 3, 4 }));
		assertEquals(-1, NewYearBribesQueue.minimumBribes(new int[] { 2, 5, 1, 3, 4 }));
		assertEquals(-1, NewYearBribesQueue.minimumBribes(new int[] { 5, 1, 2, 3, 7, 8, 6, 4 }));
		assertEquals(7, NewYearBribesQueue.minimumBribes(new int[] { 1, 2, 5, 3, 7, 8, 6, 4 }));
		assertEquals(4, minimumBribes(new int[] { 1, 2, 5, 3, 4, 7, 8, 6 }));
		assertEquals(4, minimumBribes(new int[] { 1, 2, 5, 3, 4, 7, 8, 6 }));
		assertEquals(10, minimumBribes(new int[] { 1, 4, 5, 2, 7, 6, 9, 8, 3 }));
	}

	@Test
	public void largeInput() {
		assertEquals(966, minimumBribes(readArray("NewYearBribesQueueTestCaseInput02.txt")));
	}

	@Test
	public void largeInput91() {
		assertEquals(119847, minimumBribes(readArray("NewYearBribesQueueTestCaseInput09_01.txt")));
	}

	@Test
	public void largeInput92() {
		assertEquals(-1, minimumBribes(readArray("NewYearBribesQueueTestCaseInput09_02.txt")));
	}

	@Test
	public void largeInput93() {
		assertEquals(-1, minimumBribes(readArray("NewYearBribesQueueTestCaseInput09_03.txt")));
	}

	@Test
	public void largeInput94() {
		assertEquals(-1, minimumBribes(readArray("NewYearBribesQueueTestCaseInput09_04.txt")));
	}

	@Test
	public void largeInput95() {
		assertEquals(119971, minimumBribes(readArray("NewYearBribesQueueTestCaseInput09_05.txt")));
	}

}
