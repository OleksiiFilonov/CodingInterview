package oleksii.filonov.interview.tasks.datastructures.arrays;

import java.util.function.Predicate;

public class LargestThreeSum {

    public static long calculateThreeSum(int[] array) {
        if (array == null || array.length < 3)
            throw new IllegalArgumentException("Input array must be at least 3 elements");
        int max1 = findMax(array, (__) -> false);
        final int finalMax1 = max1;
        int max2 = findMax(array, (index) -> index == finalMax1);
        final int finalMax2 = max2;
        int max3 = findMax(array, (index) -> index == finalMax1 || index == finalMax2);

        return array[max1] + array[max2] + array[max3];
    }

    /**
     * @param array      - array to find maximum
     * @param isExcluded - indices to exclude (already found maximums)
     * @return current maximum element in the array excluding excludeIndices
     */
    private static int findMax(int[] array, Predicate<Integer> isExcluded) {
        int maxIndex = 0;
        for (int i = 0; i < 3; i++) {
            if (!isExcluded.test(i))
                maxIndex = i;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[maxIndex] < array[i] && !isExcluded.test(i)) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}
