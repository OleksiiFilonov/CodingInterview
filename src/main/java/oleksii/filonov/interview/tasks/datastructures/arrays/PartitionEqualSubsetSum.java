package oleksii.filonov.interview.tasks.datastructures.arrays;

/**
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences/
 */
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = calculateSum(nums);
        if (sum % 2 == 1)
            return false;
        int target = sum / 2;
        boolean[] dpSum = new boolean[target + 1];
        dpSum[0] = true;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dpSum[i] |= dpSum[i - num];
                if (dpSum[target])
                    return true;
            }
        }
        return dpSum[target];
    }

    private int calculateSum(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        return sum;
    }
}
