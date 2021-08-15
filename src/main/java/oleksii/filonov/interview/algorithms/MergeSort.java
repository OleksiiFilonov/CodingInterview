package oleksii.filonov.interview.algorithms;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static int[] sortRecursively(int[] array) {
        sortRecursively(array, array.clone(), 0, array.length);
        return array;
    }

    public static int[] sortIteratively(int[] array) {
        for (int size = 2; size < 2 * array.length; size *= 2) {
            int[] temp = array.clone();
            for (int from = 0; from < array.length; from += size) {
                final int middle = Math.min(from + size / 2, array.length);
                final int to = Math.min(from + size, array.length);
                merge(array, temp, from, to, middle);
            }
        }
        return array;
    }

    private static void sortRecursively(int[] mergeTo, int[] mergeFrom, int start, int end) {
        //guarantees at least 1 element will be between start and end, end index excluded
        if (start < end - 1) {
            int middle = calculateMiddle(start, end);
            sortRecursively(mergeFrom, mergeTo, start, middle);
            sortRecursively(mergeFrom, mergeTo, middle, end);
            merge(mergeTo, mergeFrom, start, end, middle);
        }
    }

    private static void merge(int[] mergeTo, int[] mergeFrom, int start, int end, int middle) {
        int left = start, right = middle, current = start;
        //merge left and right sub arrays whichever is smaller
        while (left < middle && right < end) {
            if (mergeFrom[left] < mergeFrom[right])
                mergeTo[current++] = mergeFrom[left++];
            else
                mergeTo[current++] = mergeFrom[right++];
        }
        //merge remaining left
        while (left < middle)
            mergeTo[current++] = mergeFrom[left++];
        //merge remaining right
        while (right < end)
            mergeTo[current++] = mergeFrom[right++];
    }

    private static int calculateMiddle(int begin, int end) {
        return begin + (end - begin) / 2;
    }


    public static List<Integer> merge_sort(List<Integer> arr) {
        return merge_sort(arr, new ArrayList<>(arr), 0, arr.size() - 1);
    }

    private static List<Integer> merge_sort(List<Integer> arr, List<Integer> aux, int start, int end) {
        if(start < end) {
            int mid = start + (end-start)/2;
            merge_sort(arr, aux, start, mid);
            merge_sort(arr, aux, mid+1, end);
            merge(arr, aux, start, mid, end);
        }
        return arr;
    }

    private static void merge(List<Integer> arr, List<Integer> aux, int start, int mid, int end) {
        int left = start, right = mid+1, auxIndx = left;
        while(left <= mid && right <= end) {
            if (arr.get(left) <= arr.get(right))
                aux.set(auxIndx++, arr.get(left++));
            else
                aux.set(auxIndx++, arr.get(right++));
        }
        while(left <= mid)
            aux.set(auxIndx++, arr.get(left++));
        while(right <= end)
            aux.set(auxIndx++, arr.get(right++));
        for(int i = start; i <= end; i++) {
            arr.set(i, aux.get(i));
        }
    }


    public static void main(String[] args) {
        merge_sort(new ArrayList<>(List.of(0, 1, 3, 2))).forEach(System.out::println);
    }
}
