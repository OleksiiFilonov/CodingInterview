package oleksii.filonov.interview.tasks.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/subsets/
 * Input: nums = [1,2,3] Output: [ [3],
 * [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 */
public class Subsets {

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		backtracking(result, new ArrayList<>(), nums, 0);
		return result;
	}

	private static void backtracking(List<List<Integer>> result, List<Integer> steps, int[] nums, int start) {
		result.add(new ArrayList<>(steps));
		for (int i = start; i < nums.length; i++) {
			steps.add(nums[i]);
			backtracking(result, steps, nums, i + 1);
			steps.remove(steps.size() - 1);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> lists = Subsets.subsets(IntStream.of(1, 2, 3).toArray());
		for (List<Integer> inner : lists) {
			System.out.println(Arrays.toString(inner.toArray()));
		}
	}
}
