package oleksii.filonov.interview.tasks;

import java.util.Arrays;

/**
 * Given a string of names, separated by some delimiter.
 * Print the names in the reverse order
 */
public class NamesReversal {
	
	public String reverse(String initial, String delimiter) {
		return Arrays.stream(initial.split(delimiter)).reduce((a, b) -> b + delimiter + a).orElse("");
	}
	
	
	public static void main(String[] args) {
		String [] strings = "string1\nstring2".split("\\n");
		System.out.println(Arrays.toString(strings));
	}

}
