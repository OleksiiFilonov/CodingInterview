package oleksii.filonov.interview.tasks.graph;

import java.util.*;

/**
 * Transfer initial array to sorted and return the minimum necessary number of permutations
 * E.g. give [3, 1, 2]
 * rearrange the elements of the permutation into increasing order, repeatedly making the following operation:
 * Select a sub-portion of the permutation, (a_i, ..., a_j), and reverse its order.
 * It is possible to transfer to [1, 2, 3] in 2 permutations:
 * select (1,2) and reverse so the array will be [3, 2, 1]
 * The goal is to minimize the number of operations
 * Constraints: arrays [1 .. N], N is between 1 and 8
 */
public class PermutationMinimizer {

    public static int minimizeOperations(int[] input) {
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(input);
        visited.add(hash(input));
        int minOperations = -1;
        while (!q.isEmpty()) {
            minOperations++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] permutation = q.poll();
                if (isSorted(permutation)) {
                    return minOperations;
                } else {
                    for (int[] generated : generatePermutations(permutation)) {
                        Integer hashCode = hash(generated);
                        if (!visited.contains(hashCode)) {
                            visited.add(hashCode);
                            q.add(generated);
                        }
                    }
                }
            }
        }
        return minOperations;
    }

    private static int[][] generatePermutations(int[] permutation) {
        int length = permutation.length;
        int[][] result = new int[length * (length - 1) / 2][length];
        int cur = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                result[cur] = Arrays.copyOf(permutation, length);
                int left = i;
                int right = j;
                while (left < right) {
                    int temp = result[cur][left];
                    result[cur][left] = result[cur][right];
                    result[cur][right] = temp;
                    left++;
                    right--;
                }
                cur++;
            }
        }
        return result;
    }

    private static boolean isSorted(int[] permutation) {
        for (int i = 0; i < permutation.length; i++)
            if (permutation[i] != i + 1)
                return false;
        return true;
    }

    private static Integer hash(int[] input) {
        int result = 0;
        for (int val : input) {
            result *= 10;
            result += val;
        }
        return result;
    }
}
