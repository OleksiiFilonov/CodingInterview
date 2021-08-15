package oleksii.filonov.interview.tasks.datastructures.trees;

/**
 * https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/
 */
public class NumberGoodLeafNodesPairs {

    private int result = 0;

    public int countPairs(Node root, int distance) {
        dfs(root, distance);
        return result;
    }

    private int[] dfs(Node root, int distance) {
        if (root == null)
            return new int[distance];
        if (root.left == null && root.right == null) {
            int[] leafs = new int[distance];
            leafs[0] = 1;
            return leafs;
        }

        int[] left = dfs(root.left, distance);
        int[] right = dfs(root.right, distance);

        return null;
    }
}
