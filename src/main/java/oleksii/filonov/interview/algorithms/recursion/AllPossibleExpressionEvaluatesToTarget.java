package oleksii.filonov.interview.algorithms.recursion;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AllPossibleExpressionEvaluatesToTarget {

    public static void main(String[] args) {
        //generate_all_expressions("050505", 5L);
        //System.out.println(Arrays.toString(generate_all_expressions("050505", 5L)));
        //System.out.println(evaluate(new StringBuilder("0.5.0.5*0+5")));
        Set<Integer> set = new HashSet<>(IntStream.range(1, 10).mapToObj(value -> Integer.valueOf(value)).collect(Collectors.toSet()));
    }

    static String[] generate_all_expressions(String s, long target) {
        List<String> result = new ArrayList<>();
        StringBuilder slate = new StringBuilder();
        slate.append(s.charAt(0));
        generate(slate, s, 1, result, target);
        return result.toArray(new String[]{});
    }

    private static char[] OPERATORS = new char[]{'+', '*', '.'};

    private static void generate(StringBuilder slate, String s, int subIndex, List<String> result, long target) {
        if (subIndex == s.length()) {
            if (matchTarget(slate, target))
                result.add(slate.toString().replace(".", ""));
            System.out.println(slate);
            return;
        }
        for (Character operator : OPERATORS) {
            slate.append(operator).append(s.charAt(subIndex));
            generate(slate, s, subIndex + 1, result, target);
            slate.delete(slate.length() - 2, slate.length());
        }
    }

    private static boolean matchTarget(StringBuilder expression, long target) {
        return evaluate(expression) == target;
    }

    private static long evaluate(StringBuilder expression) {
        Deque<String> operand = new LinkedList<>();
        Deque<Integer> operator = new LinkedList<>();
        //System.out.println("Expression: " + expression);
        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);
            //System.out.println("Symbol:" + symbol);
            int nextPriority = findOperator(symbol);
            //System.out.println("Next priority: " + nextPriority);
            if (nextPriority > -1) {
                while (!operator.isEmpty() && operator.peek() > nextPriority) {
                    rearange(operand, operator);
                }
                operator.push(nextPriority);
            } else {
                //System.out.println("Push to operands: " + value);
                operand.push(Character.toString(symbol));
            }
        }
        while (!operator.isEmpty()) {
            rearange(operand, operator);
        }
        return Long.parseLong(operand.pop());
    }

    private static void rearange(Deque<String> operand, Deque<Integer> operator) {
        //1*2+3
        String second = operand.pop(); //2
        String first = operand.pop(); //1
        String back = "";
        switch (OPERATORS[operator.pop()]) {
            case '.':
                back = first + second;
                break;
            case '*':
                Long product = Long.parseLong(first) * Long.parseLong(second);
                back = product.toString();
                break;
            case '+':
                Long sum = Long.parseLong(first) + Long.parseLong(second);
                back = sum.toString();
                break;
        }
        operand.push(back);
    }

    private static int defineExp(long value) {
        int exp = 0;
        while (value > 0) {
            value /= 10;
            exp++;
        }
        return exp;
    }

    private static int findOperator(char symbol) {
        for (int i = 0; i < OPERATORS.length; i++) {
            if (symbol == OPERATORS[i])
                return i;
        }
        return -1;
    }
}
