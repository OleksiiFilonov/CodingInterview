package oleksii.filonov.interview.tasks.screening;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class WellFormattedParenthesesGenerator {

    public List<String> generateParenthesisAllCases(int n) {
        Set<String> result = generate(n-1);
        return result.stream().map(value -> "(" + value + ")").filter(value -> isWellFormatted(value)).collect(Collectors.toList());
    }

    private Set<String> generate(int numOpen) {
        Set<String> set = new HashSet<>();
        randomGenerator(set, numOpen*2, new StringBuilder());
        return set;
    }

    private void randomGenerator(Set<String> set, int total, StringBuilder generated) {
        if (total == 0) {
            set.add(generated.toString());
        } else {
            StringBuilder openGenerated = new StringBuilder(generated).append("(");
            randomGenerator(set, total - 1, openGenerated);
            StringBuilder closeGenerated = new StringBuilder(generated).append(")");
            randomGenerator(set, total - 1, closeGenerated);
        }
    }

    private boolean isWellFormatted(String value) {
        int counter = 0;
        for (char c: value.toCharArray()) {
            if (c == '(') {
                counter++;
            } else {
                counter--;
                if (counter < 0)
                    return false;
            }
        }
        return counter == 0;
    }

    public static void main(String[] args) {
        WellFormattedParenthesesGenerator wellFormattedParenthesesGenerator = new WellFormattedParenthesesGenerator();
        wellFormattedParenthesesGenerator.generateParenthesisAllCases(3).forEach(System.out::println);
        wellFormattedParenthesesGenerator.generateParenthesis(3).forEach(System.out::println);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(result, "", n, n);
        return result;
    }

    private void backtracking(List<String> result, String s, int open, int close) {
        if (close == 0 && open == 0) {
            result.add(s);
        } else {
            if(open > 0) {
                backtracking(result, s.concat("("), open - 1, close);
            }
            if(close > open) {
                backtracking(result, s.concat(")"), open, close - 1);
            }
        }
    }

}
