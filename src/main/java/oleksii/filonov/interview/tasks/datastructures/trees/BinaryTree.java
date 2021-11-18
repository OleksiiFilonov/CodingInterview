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
