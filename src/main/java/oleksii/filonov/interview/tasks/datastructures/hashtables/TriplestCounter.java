package oleksii.filonov.interview.tasks.datastructures.hashtables;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/count-triplets-1
 */
public class TriplestCounter {

	// Complete the countTriplets function below.
	public static long countTriplets(List<Long> arr, long r) {
		Map<Long, Long> v2 = new HashMap<>();
		Map<Long, Long> v3 = new HashMap<>();
		Long count = 0L;

		for (Long key : arr) {
			//System.out.println("element: " + key);
			count += v3.getOrDefault(key, 0L);
			if (v2.containsKey(key)) {
				v3.put(key * r, v3.getOrDefault(key * r, 0L) + v2.get(key));
			}
			
			v2.merge(key * r, 1L, Long::sum);
			//System.out.println("v2 map:");
			//print(v2);
			//System.out.println("v3 map:");
			//print(v3);
			//System.out.println("Count: " + count);
		}
		return count;
	}

	public static long countTriplets1(List<Long> arr, long r) {
		Map<Long, Long> t2 = new HashMap<>();
		Map<Long, Long> t3 = new HashMap<>();
		long result = 0L;

		for (Long a : arr) {
			result += t3.getOrDefault(a, 0L);
			if (t2.containsKey(a)) {
				t3.put(a * r, t3.getOrDefault(a * r, 0L) + t2.get(a));
			}
			t2.put(a * r, t2.getOrDefault(a * r, 0L) + 1);
		}
		return result;
	}

	private static void print(Map<Long, Long> map) {
		for (Map.Entry<Long, Long> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "->" + entry.getValue());
		}

	}

}
