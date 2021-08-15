package oleksii.filonov.interview.tasks.string;

/**
 * https://www.hackerrank.com/challenges/special-palindrome-again/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 * aabaa, aa, aaa, aaaa - are special palindromes abcdcba, abccba - are
 * palindromes but not special
 */
public class SpecialPalindromeCounter {

	// Complete the substrCount function below.
public static long substrCount(int length, String s) {
	long counter = 0;
	for (int i = 0; i < length; i++) {
		// if the current symbol is in the middle of palindrome, e.g. aba
		int offset = 1;
		while (i - offset >= 0 && i + offset < length && s.charAt(i - offset) == s.charAt(i - 1)
				&& s.charAt(i + offset) == s.charAt(i - 1)) {
			counter++;
			offset++;
		}
		// if this is repeatable characters aa
		int repeats = 0;
		while (i + 1 < length && s.charAt(i) == s.charAt(i + 1)) {
			repeats++;
			i++;
		}
		counter += repeats * (repeats + 1) / 2;
	}
	return counter + length;
}
}
