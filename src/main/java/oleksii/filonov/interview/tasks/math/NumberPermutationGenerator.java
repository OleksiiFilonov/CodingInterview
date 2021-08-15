package oleksii.filonov.interview.tasks.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public final class NumberPermutationGenerator {

    /**
     * @param n - maximum number
     * @return list of numbers from 1 .. n
     */
    public static List<Integer> generate(final int n) {
        //new ArrayList required because otherwise immutable array list will be created
        List<Integer> values = IntStream.range(1, n + 1).collect(LinkedList::new, List::add, List::addAll);
        List<Integer> permutations = new ArrayList<>();
        recursion(permutations, values, 0);
        return permutations;
    }

    private static void recursion(List<Integer> permutations, final List<Integer> values, int number) {
        if (values.isEmpty()) {
            permutations.add(number);
        } else {
            for (int i = 0; i < values.size(); i++) {
                Integer value = values.remove(i);
                recursion(permutations, values, number * 10 + value);
                values.add(i, value);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generate(3).toArray()));
    }
}
