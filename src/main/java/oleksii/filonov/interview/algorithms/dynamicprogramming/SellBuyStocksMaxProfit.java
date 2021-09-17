package oleksii.filonov.interview.algorithms.dynamicprogramming;

import static java.lang.Math.max;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class SellBuyStocksMaxProfit {

    private int globalMaxProfit;

    /**
     * Find out max profit for selling/buying stocks using recursive decrease and conquer approach
     */
    public int maxProfitRecursive(int[] prices) {
        globalMaxProfit = 0;
        recursion(prices.length - 1, prices);
        return globalMaxProfit;
    }

    private int recursion(int currentIndex, int[] prices) {
        if (currentIndex == 0) {
            return 0;
        }
        int lastMargin = prices[currentIndex] - prices[currentIndex - 1];
        int profit = max(lastMargin, lastMargin + recursion(currentIndex - 1, prices));
        globalMaxProfit = max(globalMaxProfit, profit);
        return profit;
    }

    public int maxProfitDP(int[] prices) {
        int globalMaxProfit = 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int lastMargin = prices[i] - prices[i - 1];
            profit = max(lastMargin, profit + lastMargin);
            globalMaxProfit = max(globalMaxProfit, profit);
        }
        return globalMaxProfit;
    }


}
