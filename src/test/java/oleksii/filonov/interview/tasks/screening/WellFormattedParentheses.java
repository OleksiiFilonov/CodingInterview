package oleksii.filonov.interview.tasks.screening;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class WellFormattedParentheses {

    private static Set<Character> OPEN = Set.of('(', '[', '{');

    public static boolean check(String parentheses) {
        if (parentheses == null || parentheses.length() == 1)
            return true;
        Deque<Character> deque = new ArrayDeque<>();
        int index = 0;
        deque.push(parentheses.charAt(index++));
        while (index < parentheses.length()) {
            char current = parentheses.charAt(index++);
            if (OPEN.contains(current)) {
                deque.push(current);
            } else {
                switch (current) {
                    case ')' -> {
                        if (deque.isEmpty() || deque.pop() != '(')
                            return false;
                    }
                    case ']' -> {
                        if (deque.isEmpty() || deque.pop() != '[')
                            return false;
                    }
                    case '}' -> {
                        if (deque.isEmpty() || deque.pop() != '{')
                            return false;
                    }
                }
            }
        }
        return deque.isEmpty();
    }
}
