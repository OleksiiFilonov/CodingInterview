package oleksii.filonov.interview.algorithms.dynamicprogramming;

/**
 * https://leetcode.com/problems/decode-ways/
 */
public class WaysToDecode {

    public int numDecodings(String s) {
        return recursion(0, s);
    }

    private int recursion(int index, String s) {
        if (index == s.length())
            return 1;
        if (s.charAt(index) == '0')
            return 0;

        int counter = recursion(index + 1, s);

        if ((index < s.length() - 1) && Integer.parseInt(s.substring(index, index + 2)) < 27)
            counter += recursion(index + 2, s);

        return counter;
    }

    public int dp(String s) {
        int length = s.length();
        if (length == 1)
            return firstCharWays(s);
        int[] dp = new int[length + 1];
        dp[0] = 1;
        dp[1] = firstCharWays(s);
        for (int i = 2; i <= length; i++) {
            if (s.charAt(i - 1) != '0')
                dp[i] += dp[i - 1];
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigits >= 10 && twoDigits <= 27) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[length];
    }

    private int firstCharWays(String s) {
        return (s.charAt(0) == '0') ? 0 : 1;
    }
}
