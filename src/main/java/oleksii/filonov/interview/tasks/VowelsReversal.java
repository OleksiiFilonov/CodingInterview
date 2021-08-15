package oleksii.filonov.interview.tasks;

/**
 * change vowels in the word, e.g. apple -> eppla, something -> simethong,
 * consequence -> censequenco, disease -> desaesi
 */
public class VowelsReversal {

	public static void main(String[] args) {
		if (args.length > 0 && !args[0].isEmpty())
			System.out.println(reverseVowels(args[0]));
		else
			System.out.println("Input argument is empty");
	}

	public static String reverseVowels(String original) {
		char[] reverse = original.toCharArray();
		int left = 0, right = original.length() - 1;
		while (left < right) {
			while (left < right && !isVowel(reverse[left])) {
				left++;
			}
			while (left < right && !isVowel(reverse[right])) {
				right--;
			}
			if (left < right) {
				swap(reverse, left, right);
				left++;
				right--;
			}
		}
		return new String(reverse);
	}

	private static void swap(char[] characters, int first, int last) {
		char temp = characters[first];
		characters[first] = characters[last];
		characters[last] = temp;
	}

	private static boolean isVowel(char c) {
		return (c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u');
	}

}
