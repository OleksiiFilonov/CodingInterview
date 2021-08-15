package oleksii.filonov.interview.tasks.datastructures.trees;

import org.junit.jupiter.api.Test;

import static oleksii.filonov.interview.tasks.datastructures.trees.TopViewBinaryTree.topView;
import static org.junit.jupiter.api.Assertions.*;

class TopViewBinaryTreeTest {

    @Test
    void shouldPrintTopView() {
        Node root = new Node(5);
        assertArrayEquals(new Integer[]{5}, topView(root));
        Node _4 = new Node(4);
        Node _1 = new Node(1);
        Node _3 = new Node(3);
        Node _2 = new Node(2);
        Node _8 = new Node(8);
        Node _6 = new Node(6);
        Node _15 = new Node(15);
        Node _10 = new Node(10);
        root.left = _4;
        root.right = _8;
        _4.left = _1;
        _4.right = _3;
        _8.left = _6;
        _8.right = _15;
        _3.left = _2;
        _15.left = _10;
        assertArrayEquals(new Integer[]{1, 4, 5, 8, 15}, topView(root));
    }
}