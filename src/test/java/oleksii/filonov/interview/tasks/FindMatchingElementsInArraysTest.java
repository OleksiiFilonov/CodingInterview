package oleksii.filonov.interview.tasks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FindMatchingElementsInArraysTest {

	private FindMatchingElementsInArrays testInstance = new FindMatchingElementsInArrays();

	@Test
	public void findNumberOfMatchingElementsIfSourceIsSorted() {
		int[] sortedSource = new int[] { 1, 2, 4, 5, 6 };
		int[] destination = new int[] { 8, 0, 1, 6, 7 };
		assertEquals(2,
				testInstance.findNumberOfMatchingElementsWhenSourceSortedWithoutDuplicates(sortedSource, destination));
	}

	@Test
	public void findNumberOfMatchingElements() {
		int[] sortedSource = new int[] { 1, 2, 4, 4, 5, 5, 6 };
		int[] destination = new int[] { 8, 0, 0, 0, 1, 1, 6, 1, 6, 7 };
		assertEquals(2, testInstance.findNumberOfMatchingElements(sortedSource, destination));
	}
}
