package oleksii.filonov.interview.algorithms.dynamicprogramming;

import static java.lang.Math.max;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSumSubarrayFinder {

    private long maxSum;

    /**
     * lazy manager approach to find max sub array:
     * 1. Ask subordinates to give max contiguous sub array sum
     * 2. Manager will add current index to sum or use just current index value -> what will lead to max sum
     * 3. Pass result to his manager up level
     */
    public int findMaxSubArrayRecursively(int[] nums) {
        maxSum = nums[0];
        recursion(0, nums);
        return (int) maxSum;
    }

    private long recursion(int curIndex, int[] nums) {
        if (curIndex == nums.length) {
            return Integer.MIN_VALUE;
        }

        int curValue = nums[curIndex];
        long sum = max(curValue, curValue + recursion(curIndex + 1, nums));
        maxSum = max(sum, maxSum);
        return sum;
    }

    public int findMaxSubArrayDP(int[] nums) {
        //[-2, 1, -3, 4, -1, 2, 1, -5, 4];
        int maxSum = nums[0];
        int contiguousSum = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            int current = nums[i];
            contiguousSum = max(contiguousSum + current, current);
            maxSum = max(maxSum, contiguousSum);
        }
        return maxSum;
    }

}
