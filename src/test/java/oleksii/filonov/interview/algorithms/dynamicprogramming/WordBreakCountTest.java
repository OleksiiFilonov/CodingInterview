package oleksii.filonov.interview.algorithms.dynamicprogramming;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordBreakCountTest {

    private static final List<String> A_USE_CASE = List.of("a", "aa", "aaa", "aaaa", "aaaaa");
    private static final List<String> AB_USE_CASE = List.of("ab", "aab", "aaab", "aaaab", "aaaaab");
    private WordBreakCount target = new WordBreakCount();

    @Test
    public void recursion() {
        assertEquals(16, target.wordBreakCountRecursion(A_USE_CASE, "aaaaa"));
        assertEquals(1, target.wordBreakCountRecursion(AB_USE_CASE, "aaaaab"));
    }

    @Test
    public void dp() {
        assertEquals(16, target.wordBreakCountDP(A_USE_CASE, "aaaaa"));
        assertEquals(1, target.wordBreakCountDP(AB_USE_CASE, "aaaaab"));
    }

}