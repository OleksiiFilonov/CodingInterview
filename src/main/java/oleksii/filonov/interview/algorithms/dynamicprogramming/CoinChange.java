package oleksii.filonov.interview.algorithms.dynamicprogramming;

/**
 * https://leetcode.com/problems/coin-change/
 */
public class CoinChange {

    public static final int MAX_VALUE = Integer.MAX_VALUE - 1000;

    public static int coinChangeCycleRecursion(int[] coins, int amount) {
        int result = minChangeRecursiveCycle(coins, amount);
        return result == MAX_VALUE ? -1 : result;
    }

    private static int minChangeRecursiveCycle(int[] coins, int amount) {
        if (amount == 0) return 0;
        int minUsed = MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin >= 0) {
                minUsed = Math.min(minUsed, minChangeRecursiveCycle(coins, amount - coin) + 1);
            }
        }
        return minUsed;
    }

    public static int coinChangeRecursion1(int[] coins, int amount) {
        int result = minChangeRecursive1(coins, 0, amount, 0);
        return result == MAX_VALUE ? -1 : result;
    }

    private static int minChangeRecursive1(int[] coins, int index, int amount, int count) {
        if (index >= coins.length || amount < 0) {
            return MAX_VALUE;
        } else {
            if (amount == 0) return count;
            return Math.min(
                    minChangeRecursive1(coins, index, amount - coins[index], count + 1),
                    minChangeRecursive1(coins, index + 1, amount, count));
        }
    }
}
