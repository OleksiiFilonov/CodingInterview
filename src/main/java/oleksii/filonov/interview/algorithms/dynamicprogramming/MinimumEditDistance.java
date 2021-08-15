package oleksii.filonov.interview.algorithms.dynamicprogramming;

import static java.lang.Math.min;

/**
 * https://leetcode.com/problems/edit-distance/
 */
public class MinimumEditDistance {

    public int dp(String word1, String word2) {
        //System.out.printf("%s:%s%n%s:%s%n", word1, word1.length(), word2, word2.length());
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= l2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int replace = dp[i - 1][j - 1];
                    int insert = dp[i - 1][j];
                    int delete = dp[i][j - 1];
                    dp[i][j] = 1 + min(replace, min(insert, delete));
                }
            }
        }
        //Arrays.stream(dp).forEach(row -> System.out.println(Arrays.toString(row)));
        return dp[l1][l2];
    }

    public int recursion(String word1, String word2) {
        return recursion(word1, 0, word2, 0);
    }

    /**
     * O (n^3)
     */
    private int recursion(String word1, int i1, String word2, int i2) {
        if (i1 == word1.length() || i2 == word2.length()) {
            return (word1.length() - i1) + (word2.length() - i2);
        }
        if (word1.charAt(i1) == word2.charAt(i2)) {
            return recursion(word1, i1 + 1, word2, i2 + 1);
        } else {
            int insert = recursion(word1, i1 + 1, word2, i2);
            int replace = recursion(word1, i1 + 1, word2, i2 + 1);
            int delete = recursion(word1, i1, word2, i2 + 1);
            return min(insert, min(replace, delete)) + 1;
        }
    }
}
