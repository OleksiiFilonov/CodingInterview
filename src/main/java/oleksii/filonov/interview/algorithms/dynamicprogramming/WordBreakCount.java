package oleksii.filonov.interview.algorithms.dynamicprogramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Similar to
 * https://leetcode.com/problems/word-break/
 * https://leetcode.com/problems/word-break-ii/
 */
public class WordBreakCount {

    public int wordBreakCountRecursion(List<String> dictionary, String txt) {
        return recursion(0, txt, new HashSet<>(dictionary));
    }

    private int recursion(int start, String txt, Set<String> set) {
        //one changing parameter - 1 dimensional array from start = 0, so dp[0, txt.length()], length txt.length() + 1
        //size of the array will be txt.length() + 1
        //dp should go other direction than recursion start is decreasing
        //dp[0] - should be returned
        if (start == txt.length())
            return 1;
        int result = 0;
        for (int end = start + 1; end <= txt.length(); end++) {
            String prefix = txt.substring(start, end);
            if (set.contains(prefix)) {
                result += recursion(end, txt, set);
            }
        }
        return result;
    }

    public int wordBreakCountDP(List<String> dictionary, String txt) {
        Set<String> set = new HashSet<>(dictionary);
        int length = txt.length();
        int[] dp = new int[length + 1];
        dp[length] = 1;
        for (int start = length; start >= 0; start--) {
            for (int end = start + 1; end <= length; end++) {
                String prefix = txt.substring(start, end);
                if (set.contains(prefix))
                    dp[start] += dp[end];
            }
        }
        return dp[0];
    }
}
