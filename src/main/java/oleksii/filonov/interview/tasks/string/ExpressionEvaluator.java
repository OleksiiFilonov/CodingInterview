package oleksii.filonov.interview.tasks.string;

/*
Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
The string can contain a combination of digits, +, -.
Input: s = "1+1"
Output: 2
Input: s = “5+3-2+1”
Output: 7

How code will change when multiplication, division, braces in place?
 */
public class ExpressionEvaluator {

    public static int evaluate(String s) {
        int result = 0;
        int sign = 0;
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '+' || cur == '-') {
                //add existing number, start new one
                result += Integer.parseInt(s, sign, i, 10);
                sign = i;
            }
        }
        result += Integer.parseInt(s, sign, s.length(), 10);
        return result;
    }
}
