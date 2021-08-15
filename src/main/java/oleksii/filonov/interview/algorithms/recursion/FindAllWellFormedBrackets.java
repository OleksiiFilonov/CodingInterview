package oleksii.filonov.interview.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a positive integer n, return ALL strings of length 2*n with well formed round brackets.
 */
public class FindAllWellFormedBrackets {

    public String[] find(int n) {
        if (n < 1)
            return new String[0];
        List<String> result = new ArrayList<>();
        char[] slate = new char[2 * n];
        generate(slate, 0, 0, 0, n, result);
        return result.toArray(new String[0]);
    }

    private void generate(char[] slate, int open, int closed, int offset, int n, List<String> result) {
        if (open > n || closed > n)
            return;
        if (closed > open)
            return;
        if (closed == n) {
            result.add(new String(slate));
            return;
        }
        slate[offset] = '(';
        generate(slate, open + 1, closed, offset + 1, n, result);
        slate[offset] = ')';
        generate(slate, open, closed + 1, offset + 1, n, result);
    }
}
