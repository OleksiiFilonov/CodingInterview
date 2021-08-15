package oleksii.filonov.interview.tasks.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static oleksii.filonov.interview.tasks.string.NextSmallestPalindrome.findNextPalindrome;


class NextSmallestPalindromeTest {

    @Test
    void testFindNextPalindrome() {
        assertEquals(1001, findNextPalindrome(999));
        assertEquals(6789876, findNextPalindrome(6789123));
        assertEquals(678876, findNextPalindrome(678123));
        assertEquals(5555, findNextPalindrome(5522));
        assertEquals(636, findNextPalindrome(631));
        assertEquals(12421, findNextPalindrome(12345));
        assertEquals(5665, findNextPalindrome(5566));
        assertEquals(23632, findNextPalindrome(23545));
        assertEquals(1331, findNextPalindrome(1221));
        assertEquals(1331, findNextPalindrome(1234));
        assertEquals(94_188_088_149L, findNextPalindrome(94_187_978_322L));
        assertEquals(1235321, findNextPalindrome(1234628));
        assertEquals(404, findNextPalindrome(397));
        assertEquals(131, findNextPalindrome(123));
        assertEquals(4554, findNextPalindrome(4512));
        assertEquals(2002, findNextPalindrome(1997));
        assertEquals(141, findNextPalindrome(139));
        assertEquals(129921, findNextPalindrome(128965));
        assertEquals(130031, findNextPalindrome(129965));

    }
}