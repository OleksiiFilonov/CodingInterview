package oleksii.filonov.interview.tasks.datastructures.trees;

/**
 * For tasks from http://cslibrary.stanford.edu/110/BinaryTrees.html
 */
public class BinaryTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public Node insert(int value) {
        root = insert(root, value);
        return root;
    }

    private Node insert(Node root, int value) {
        if(root == null)
            return new Node(value);

        if(root.value == value)
            return root;
        if(root.value < value) {
            //go right
            root.right = insert(root.right, value);
        } else {
            //go left
            root.left = insert(root.left, value);
        }
        return root;
    }

    public int maxDepth() {
        return maxDepth(root);
    }

    private int maxDepth(Node root) {
        if(root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if(root == null)
            return 0;
        return 1 + size(root.left) + size(root.right);
    }

    public int minValue() {
        if(root == null)
            throw new IllegalStateException("Can't return minimum value of an empty tree");
        return minValue(root);
    }

    private int minValue(Node root) {
        if(root.left == null)
            return root.value;
        else
            return minValue(root.left);
    }

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
