package oleksii.filonov.interview.tasks.datastructures.trees;

/**
 * 				   4/10
 * 					^
 * 					|
 *	Given a tree   0/-2 -> 1/10 -> 2/10 -> 3/-3
 *	Find the maximum sum of nodes - node 1 + node 2 = 20 
 */
public class FindMaxSum {
	public static int maximumSum(int[] parent, int[] values) {
		int length = parent.length;
		boolean [] visited = new boolean [length];
		int max = values[0];
		for (int i = 1; i < length; i++) {
			int nodeSum = lookupFrom(i, parent, values, visited);
			if (max < nodeSum)
				max = nodeSum;
		}
		return max;
	}

	private static int lookupFrom(int from, int[] parent, int[] values, boolean [] visited) {
		int parentIndex = parent[from];
		visited[from] = true;
		if (visited[parentIndex]) {
			if(values[parentIndex] > 0)
				values[from] = values[parentIndex];
		} else if (parentIndex > -1) {
			values[from] += lookupFrom(parentIndex, parent, values, visited);
		}
		return values[from];
	}
}
