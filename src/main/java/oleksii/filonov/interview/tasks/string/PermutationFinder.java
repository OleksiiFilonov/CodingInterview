package oleksii.filonov.interview.tasks.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Find all permutations of s - small in string b - big,
 * e.g. s=aabc, b=abacbbaadcabbacbabcatoabcaaabciaabibaac
 */
public class PermutationFinder {

	private static String [] generatePermutations(String initial) {
		Set<String> set = new HashSet<>();
		return set.toArray(new String [] {});
	}
}
