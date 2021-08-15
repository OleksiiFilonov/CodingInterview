package oleksii.filonov.interview.tasks.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pancake-sorting/
 */
public class PancakeSorting {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> permutations = new ArrayList<>();
        int last = A.length;
        while (!isSorted(A) && last > 0) {
            int largestIndex = findLargestIndex(A, last);
            flip(A, largestIndex);
            permutations.add(largestIndex + 1);
            flip(A, last - 1);
            permutations.add(last);
            last--;
        }
        return permutations;
    }

    private void flip(int[] array, int last) {
        for(int i = 0; i < last; i++, last--) {
            var temp = array[i];
            array[i] = array[last];
            array[last] = temp;
        }
    }

    private int findLargestIndex(int[] array, int last) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < last; i++) {
            if (max < array[i]) {
                max = array[i];
                index = i;
            }
        }
        return index;
    }

    //recursive way, backtracking - time limit exceeded
    private boolean find(int[] array, int index, List<Integer> permutations) {
        if (permutations.size() > array.length)
            return false;
        if (isSorted(array))
            return true;
        for (int i = 1; i < array.length; i++) {
            if (index == i) continue;
            permutations.add(i);
            if (find(reverse(array, i), i, permutations)) {
                return true;
            } else {
                permutations.remove(permutations.size() - 1);
            }
        }
        return false;
    }

    private int[] reverse(int[] initial, int index) {
        int[] copy = Arrays.copyOf(initial, initial.length);
        for (int i = 0; i <= index; i++) {
            copy[i] = initial[index - i];
        }
        return copy;
    }

    private boolean isSorted(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != i + 1)
                return false;
        }
        return true;
    }
}
