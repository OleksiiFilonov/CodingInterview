package oleksii.filonov.interview.algorithms;

import java.util.Arrays;

/**
 * Remove duplicates from the sorted array. do it in place!
 * e.g. 
 * [1, 2, 2, 2, 2, 3, 3, 4, 5]
 * [1, 2, 3, 4, 5, *, *, *, *]
 * The trick is to replace, not swapping. So replaced elements are not required to be stored
 */
public class RemoveDuplicates {
	
	public static int [] removeDuplicates(int [] array) {
		int current = 0;
		int next = 1;
		while(next < array.length) {
			if(array[current] != array[next]) {
				current++;
				array[current] = array[next];
			}
			next++;
		}
		return array;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(removeDuplicates(new int[] {1, 2, 2, 2, 2, 3, 3, 4, 5})));
	}


}
