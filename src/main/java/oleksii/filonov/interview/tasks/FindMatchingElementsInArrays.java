package oleksii.filonov.interview.tasks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Find number of matching elements in 2 arrays
 *
 */
public class FindMatchingElementsInArrays {

	public long findNumberOfMatchingElementsWhenSourceSortedWithoutDuplicates(int[] source, int[] destination) {
		return Arrays.stream(destination).filter(i -> Arrays.binarySearch(source, i) > -1).count();
	}

	public int findNumberOfMatchingElements(int[] source, int[] destination) {
		Set<Integer> sourceSet = new HashSet<>();
		Arrays.stream(source).forEach(i -> sourceSet.add(i));
		Set<Integer> destinationSet = new HashSet<>();
		Arrays.stream(destination).forEach(i -> destinationSet.add(i));
		sourceSet.retainAll(destinationSet);
		return sourceSet.size();
	}

}
