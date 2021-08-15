package oleksii.filonov.interview.tasks;

import java.util.List;
import java.util.Arrays;

/**
 * For a given array of integers, find the 3rd maximum distance between 2 points
 * (i and j) that have higher values ​​than any element between them.
 */
public class ThirdFatherstDistanceBetweenElementsFinder {

	public static Integer thirdFarthestDistance(List<Integer> arr, Integer x) {
		Integer[] distances = new Integer[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			distances[i] = Math.abs(arr.get(i) - x);
		}
		Integer[] distanceIndexes = Arrays.copyOf(distances, arr.size());
		System.out.println("Unsorted distances: " + Arrays.toString(distances));
		Arrays.sort(distances);
		System.out.println("Sorted distances: " + Arrays.toString(distances));
		for (int i = 0; i < arr.size(); i++) {
			if (distances[2] == distanceIndexes[i]) {
				return arr.get(i);
			}
		}
		throw new IllegalStateException("No elements find");
	}
}