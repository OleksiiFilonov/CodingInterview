package oleksii.filonov.interview.tasks.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Return first String with the maximum number of repeated characters
 */
public class HighestRepeatedString {

    public static void main(String[] args) {
        HighestRepeatedString highestRepeatedString = new HighestRepeatedString();
        System.out.println("1:'" + highestRepeatedString.highest_repeated("It is really simple and accurate!") + "'- should return 'really', because it is first with 2 characters");
        System.out.println("2:'" + highestRepeatedString.highest_repeated("It is really simple and accurate! ccc") + "'- should return 'ccc', because it has max numbers of repeating characters");
        System.out.println("3:'" + highestRepeatedString.highest_repeated("a b c d") + "'- should return nothing, there is no word with repeating characters in the word");
    }

    //O(n) - time complexity, n - number of characters in the initial String
    //O(n) - space complexity, but could be optimized up to O(1) extra space complexity
    public String highest_repeated(String str) {
        if(str == null || str.length() == 0)
            return "";

        String [] words = str.split("\\s");
        int greatest = 1;
        String result = "";

        for(String word: words) {
            Map<Character, Integer> histogram = new HashMap<>();
            for(char c: word.toCharArray()) {
                histogram.merge(c, 1, Integer::sum);
                int curValue = histogram.get(c);
                if(greatest < curValue) {
                    greatest = curValue;
                    result = word;
                }
            }
        }

        return result;
    }
}
