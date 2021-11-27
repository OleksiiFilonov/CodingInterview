package oleksii.filonov.interview.tasks.datastructures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * For tasks from http://cslibrary.stanford.edu/110/BinaryTrees.html
 */
public class BinarySearchTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public Node insert(int value) {
        root = insert(root, value);
        return root;
    }

    private Node insert(Node root, int value) {
        if (root == null)
            return new Node(value);

        if (root.value == value)
            return root;
        if (root.value < value) {
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
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null)
            return 0;
        return 1 + size(root.left) + size(root.right);
    }

    public int minValue() {
        if (root == null)
            throw new IllegalStateException("Can't return minimum value of an empty tree");
        return minValue(root);
    }

    private int minValue(Node root) {
        if (root.left == null)
            return root.value;
        else
            return minValue(root.left);
    }

    public List<Integer> inOrder() {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private void inOrder(Node root, List<Integer> result) {
        if (root == null)
            return;
        //left
        inOrder(root.left, result);
        //root
        result.add(root.value);
        //right
        inOrder(root.right, result);
    }

    public List<Integer> postOrder() {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    private void postOrder(Node root, List<Integer> result) {
        if (root == null)
            return;
        //left
        postOrder(root.left, result);
        //right
        postOrder(root.right, result);
        //root
        result.add(root.value);
    }

    public List<Integer> preOrder() {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    private void preOrder(Node root, List<Integer> result) {
        if (root == null)
            return;
        //root
        result.add(root.value);
        //left
        preOrder(root.left, result);
        //right
        preOrder(root.right, result);
    }

    public boolean hasRootToLeafPathSum(int sum) {
        if (root == null)
            return false;
        else
            return hasRootToLeafPathSum(root, sum);
    }

    private boolean hasRootToLeafPathSum(Node root, int remainder) {
        //base cases
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return root.value == remainder;
        //recurring case
        return hasRootToLeafPathSum(root.left, remainder - root.value)
                || hasRootToLeafPathSum(root.right, remainder - root.value);
    }


    /**
     * Print all paths from root to leaf
     *
     * @return All the paths from root to leaf in a tree
     */
    public List<List<Integer>> printPath() {
        List<List<Integer>> paths = new ArrayList<>();
        printPath(this.root, new LinkedList<>(), paths);
        return paths;
    }

    private void printPath(Node root, LinkedList<Integer> path, List<List<Integer>> paths) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            path.add(root.value);
            paths.add(new ArrayList<>(path));
        } else {
            path.add(root.value);
            printPath(root.left, path, paths);
            printPath(root.right, path, paths);
        }
        path.removeLast();
    }

    /**
     * Mirror the tree so left node is swapped with the right node
     */
    public void mirror() {
        mirror(root);
    }

    private void mirror(Node root) {
        if (root == null)
            return;
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
    }

    public void doubleTree() {
        doubleTree(root);
    }

    private void doubleTree(Node root) {
        if (root == null)
            return;
        doubleTree(root.left);
        Node doubled = new Node(root.value);
        doubled.left = root.left;
        root.left = doubled;
        doubleTree(root.right);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        BinarySearchTree that = (BinarySearchTree) other;
        return root.equals(that.root);
    }

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public boolean equals(Object other) {
            if (this == other) return true;
            if (other == null || getClass() != other.getClass()) return false;
            Node node = (Node) other;
            return value == node.value && checkChild(left, node.left) && checkChild(right, node.right);
        }

        private boolean checkChild(Node thisRef, Node otherRef) {
            if (thisRef == null)
                return otherRef == null;
            return thisRef.equals(otherRef);
        }

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
