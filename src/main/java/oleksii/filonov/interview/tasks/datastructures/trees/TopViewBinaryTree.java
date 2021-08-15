package oleksii.filonov.interview.tasks.datastructures.trees;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Print top view of the tree
 */
public class TopViewBinaryTree {

    /**
     * @param root - root of the tree
     * @return values of the elements from left to right from the top view.
     */
    public static Integer[] topView(Node root) {
        Map<Integer, Integer> topView = new HashMap<>();
        Queue<Node> nodeQueue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();
        nodeQueue.add(root);
        levelQueue.add(0);
        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.poll();
            Integer level = levelQueue.poll();
            topView.putIfAbsent(level, node.value);
            if (node.right != null) {
                nodeQueue.add(node.right);
                levelQueue.add(level + 1);
            }
            if (node.left != null) {
                nodeQueue.add(node.left);
                levelQueue.add(level - 1);
            }
        }
        return topView.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList())
                .toArray(new Integer[0]);
    }
}
