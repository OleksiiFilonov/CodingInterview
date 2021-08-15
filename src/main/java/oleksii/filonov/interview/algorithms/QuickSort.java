package oleksii.filonov.interview.algorithms;

public class QuickSort {

	public static int[] sort(int[] array) {
		//required to be uniformly shuffle before - O(n) complexity
		sort(array, 0, array.length - 1);
		return array;
	}

	private static void sort(int[] array, int low, int high) {
		if (low < high) {
			int inPlaceIndex = partition(array, low, high);
			sort(array, low, inPlaceIndex - 1);
			sort(array, inPlaceIndex + 1, high);
		}

	}

	private static int partition(int[] array, final int pivotIndex, int high) {
		int low = pivotIndex + 1;
		while (low <= high) {
			while (low <= high && less(array[low], array[pivotIndex]))
				low++;
			while (less(array[pivotIndex], array[high]))
				high--;
			if (low <= high) {
				exchange(array, low, high);
				low++;
				high--;
			}
		}
		exchange(array, pivotIndex, high);
		return high;// in place now
	}

	private static boolean less(int i, int j) {
		return i < j;
	}

	private static void exchange(int[] array, int low, int high) {
		int temp = array[low];
		array[low] = array[high];
		array[high] = temp;
	}

}