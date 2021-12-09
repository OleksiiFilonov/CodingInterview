package oleksii.filonov.interview.tasks.datastructures.trees;

/**
 * # Given the root of a Binary Search Tree (BST),
 * # "convert" it to a Greater Tree such that every key of the original BST is
 * # changed to the original key plus sum of all keys greater than the original key in BST.
 * #
 * # Example 1:
 * #
 * # Input: TreeNode(4)
 * #             4
 * #           /   \
 * #          1      6
 * #        /  \    / \
 * #       0    2   5   7
 * #             \       \
 * #              3       8
 * List<Node>
 * time O(N)
 * space O(N) + O(height) - depends on the height of the tree
 * <p>
 * # Output: void
 * #             30
 * #           /   \
 * #          36     21
 * #        /  \    / \
 * #       36  35  26   15
 * #             \       \
 * #             33       8
 * #
 * # Constraints:
 * #
 * # All the values in the tree are unique.
 * # root is guaranteed to be a valid binary search tree.
 * #
 * # == == == == == == == == == == == == == == == == == == == == == =
 */
public class GreaterTreeConverter {

    public static void convert(BinarySearchTree bst) {
         traverse(bst.getRoot(), 0);
    }

    private static int traverse(BinarySearchTree.Node root, int sum) {
        if (root == null)
            return sum;
        root.value += traverse(root.right, sum);
        return traverse(root.left, root.value);
    }
}
