package oleksii.filonov.interview.tasks.datastructures.arrays;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MaxUniqueSequentialSubArrayFinder {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] elements = new int[n];
		for (int i = 0; i < n; i++) {
			elements[i] = in.nextInt();
		}
		in.close();
		System.out.println(findMaximumUniqueSubArray(m, elements));
	}

	public static int findMaximumUniqueSubArray(int m, int[] elements) {
		int max = 0;
		Deque<Integer> deque = new ArrayDeque<>(m);
		Set<Integer> set = new HashSet<>(m);
		for (int i = 0; i < elements.length && max < m; i++) {
			if (set.contains(elements[i])) {
				clearHeadUntilUniqueNumber(deque, set, elements[i]);
			} else {
				addToTheEnd(deque, set, elements[i]);
				if (max < set.size()) {
					max = set.size();
				}
			}
		}
		return max;
	}

	private static void addToTheEnd(Deque<Integer> deque, Set<Integer> set, int element) {
		set.add(element);
		deque.addLast(element);
	}

	private static void clearHeadUntilUniqueNumber(Deque<Integer> deque, Set<Integer> set, int element) {
		Integer first = deque.removeFirst();
		while (first != element) {
			set.remove(first);
			first = deque.removeFirst();
		}
		deque.addLast(first);
	}
	
}
