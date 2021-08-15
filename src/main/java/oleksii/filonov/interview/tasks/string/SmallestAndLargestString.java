package oleksii.filonov.interview.tasks.string;


public class SmallestAndLargestString {
	
	public static String getSmallestAndLargest(String s, int k) {
		String smallest = "";
		String largest = "";
		smallest = largest = s.substring(0, k);
		for (int i = 1; i <= s.length() - k; i++) {
			String temp = s.substring(i, i + k);
			if (smallest.compareTo(temp) > 0) {
				smallest = temp;
			} else if (largest.compareTo(temp) < 0) {
				largest = temp;
			}
		}
		// Complete the function
		// 'smallest' must be the lexicographically smallest substring of length 'k'
		// 'largest' must be the lexicographically largest substring of length 'k'

		return smallest + "\n" + largest;
	}

	public static void main(String[] args) {
		System.out.println(getSmallestAndLargest("welcometojava", 3));
	}
}
