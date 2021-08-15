package oleksii.filonov.interview.algorithms.dynamicprogramming;

/**
 * Cut the rope at least once so the product will be maximum
 * Example: Length of the rope is 4.
 * All ways it can be cut into parts: 1+3, 1+1+2, 1+1+1+1, 2+2, 2+1+1.
 * Among these, 2+2 cut makes for the greatest product: 2*2=4.
 */
public class RopeCuttingWithMaxProduct {

    public long maxProductFromCutPieces(int n) {
        return dp(n);
    }

    public long dp(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j >= 1; j--) {
                long max = Math.max((long) j * (i - j), j * dp[i - j]);
                dp[i] = Math.max(max, dp[i]);
            }
        }
        return dp[n];
    }

    public long recursion(int n) {
        if (n < 2)
            return n;
        long max = 0;
        for (int i = n; i >= 1; i--) {
            max = Math.max(max, Math.max((long) i * (n - i), i * recursion(n - i)));
        }
        return max;
    }
}
