package oleksii.filonov.interview.tasks.datastructures.trees;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *	https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/790/
 */
public class KthSmallestElement {
	
    public static int kthSmallest(Node root, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        dps(root, stack, k);
        System.out.println();
        return stack.pop();
    }

	private static void dps(Node root, Deque<Integer> stack, int k) {
		if(root == null) return;
        System.out.print(root.value + " ");
        dps(root.left, stack, k);
        if(stack.size() == k) return;
        stack.push(root.value);
        if(stack.size() == k) return;
        dps(root.right, stack, k);
	}

}
