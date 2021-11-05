package oleksii.filonov.interview;

import java.util.HashMap;
import java.util.Map;

public class HighestRepeatedString {


    public static void main(String[] args) {
        HighestRepeatedString highestRepeatedString = new HighestRepeatedString();
        System.out.println("1:'" + highestRepeatedString.highest_repeated("It is really simple and accurate!") + "'- end");
        System.out.println("2:'" + highestRepeatedString.highest_repeated("It is really simple and accurate! ccc") + "'- end");
        System.out.println("3:'" + highestRepeatedString.highest_repeated("a b c d") + "'- end");
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
