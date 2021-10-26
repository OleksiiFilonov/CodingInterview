package oleksii.filonov.interview.tasks.datastructures.arrays;

/**
 * https://leetcode.com/discuss/interview-question/1321204/efficient-harvest-faang-oa-question-2021
 */
public class EfficientHarvest {

    public static long maxProfit(int k, int[] profit) {
        int window = 0;
        int n = profit.length;
        int half = n / 2;
        for (int i = 0; i < k; i++) {
            window += profit[i] + profit[i + half];
        }
        int max = window;
        for (int i = 0; i < half; i++) {
            window += profit[i+k] + profit[(i + k + half) % n] - profit[i] - profit[i + half];
            max = Math.max(max, window);
        }
        return max;
    }
}
