package oleksii.filonov.interview.tasks.string;

/**
 * Anagram is a String with the same chars and the same length,
 * but might be different position of those chars. 
 */
public class AnagramChecker {
    
	private static boolean isAnagram(String a, String b) {
		if(a.length() != b.length()) return false;
		final int size = 26;
        int [] histogram = new int [size];
		String aLower = a.toLowerCase();
		String bLower = b.toLowerCase();
		for(char aChar: aLower.toCharArray()) {
			histogram[aChar - 'a']++;
		}
		for(char bChar: bLower.toCharArray()) {
			if(--histogram[bChar-'a'] < 0) {
				return false;
			}
		}
		return true;
    }
	
	public static void main(String[] args) {
		System.out.println(isAnagram("a", "a"));
		System.out.println(isAnagram("a", "b"));
		System.out.println(isAnagram("CAT", "tca"));
		System.out.println(isAnagram("aaab", "aba"));
	}

}
