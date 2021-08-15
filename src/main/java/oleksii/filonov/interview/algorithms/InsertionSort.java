package oleksii.filonov.interview.algorithms;

public class InsertionSort {

    public static int [] iterativeSort(int[] array) {
        if (array.length <= 1) return array;
        for (int i = 1; i < array.length; i++) {
            int ith = array[i];
            int j = i-1;
            while(j >= 0 && array[j] > ith) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = ith;
        }
        return array;
    }
}
