package oleksii.filonov.interview.tasks.datastructures.arrays;

/**
 * https://www.hackerrank.com/challenges/crush/problem
 */
public class ArrayManipulation {
	
    public static long max(int n, int[][] queries) {
        long[] arr = new long [n];
        long max = 0;
        for(int i = 0; i < queries.length; i++) {
            int [] tasks = queries[i];
            arr[tasks[0]-1] += tasks[2];
            if(tasks[1] < n) arr[tasks[1]] -= tasks[2];
        }
        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            if(max < sum)
                max = sum;
        }
        return max;
    }

}
