package oleksii.filonov.interview.tasks.string;

/**
 *  https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings&h_r=next-challenge&h_v=zen
 */
public class SherlockValidString {
	
    // Complete the isValid function below.
    public static String isValid(String s) {
        if(s == null || s.trim().length() == 0) return "NO";
        int[] histogram = new int [26];
        s.chars().map(e -> e - 'a').forEach(e -> histogram[e]++);
        int index = 0;
        while(histogram[index] == 0) {
            index++;
        }
        int differenceCounter = 0;
        int initial = histogram[index];
        for(index++; index < histogram.length; index++) {
            if(histogram[index] > 0 && initial - histogram[index] != 0)
                differenceCounter++;
            if(differenceCounter > 1)
                return "NO";
        }
        return "YES";
    }

}
