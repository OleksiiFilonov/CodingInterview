package oleksii.filonov.interview.tasks.math;

/**
 * Calculate number of k combination of n variants
 */
public class Combinations {

    /**
     * Calculates number of combinations
     *
     * @param n - the size of variants
     * @param k - size of subset (combination)
     * @return number of combinations of size k from n
     */
    public static int calculate(int n, int k) {
        if (k == 0 || n == k)
            return 1;
        else
            return calculate(n - 1, k - 1) + calculate(n - 1, k);
    }
}
