package oleksii.filonov.interview.tasks.math;

/**
 * You are at the bottom of a staircase with n stairs. You can jump 1, 2 or 3 stairs at a time.
 * How many different ways you can jump up the stairs?
 * Example Input: n: 3
 * Example Output: 4
 * Explanation:
 * There are 4 differnt ways you can jump up to the top of the stairs:
 * 1 jump, 1 jump, 1 jump
 * 1 jump, 2 jumps,
 * 2 jumps, 1 jump,
 * 3 jumps
 */
public class Jumps {

    public static long recursion(long steps, int [] jumps) {
        if (steps == 0) return 1;
        int total = 0;
        if (steps > 0) {
            for (int jump : jumps) {
                total += recursion(steps - jump, jumps);
            }
        }
        return total;
    }

    public static long dynamicProgramming(int steps, int [] jumps) {
        if (steps == 0) return 1;
        int[] iterations = new int[steps + 1];
        iterations[0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int jump : jumps) {
                if (i - jump >= 0) iterations[i] += iterations[i - jump];
            }
        }
        return iterations[steps];
    }

}
