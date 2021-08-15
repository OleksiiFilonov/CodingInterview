package oleksii.filonov.interview.tasks.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Builds binary tree from array.
 * Requires N+1 array size from the number of nodes. The root node is array[1], array[0] is ignored but required for proper math calculation
 */
public class TreeUtils {

    public static Node buildLevelOrderTree(Integer[] array) {
        Node root = new Node(array[1]);
        Queue<Pair> queue = new LinkedList<>();
        queue.add(Pair.valueOf(root, 1));
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            addLeft(array, queue, current);
            addRight(array, queue, current);
        }
        return root;
    }

    private static void addRight(Integer[] array, Queue<Pair> queue, Pair current) {
        int right = current.index * 2 + 1;
        if (right < array.length && array[right] != null) {
            Node node = new Node(array[right]);
            current.node.right = node;
            queue.add(Pair.valueOf(node, right));
        }
    }

    private static void addLeft(Integer[] array, Queue<Pair> queue, Pair current) {
        int left = current.index * 2;
        if (left < array.length && array[left] != null) {
            Node node = new Node(array[left]);
            current.node.left = node;
            queue.add(Pair.valueOf(node, left));
        }
    }

    private static class Pair {
        private final Node node;
        private final int index;

        private Pair(Node node, int index) {
            this.node = node;
            this.index = index;
        }

        public static Pair valueOf(Node node, int index) {
            return new Pair(node, index);
        }
    }
}
