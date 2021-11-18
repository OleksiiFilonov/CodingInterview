package oleksii.filonov.interview.tasks.datastructures.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * http://cslibrary.stanford.edu/110/BinaryTrees.html
 * first problem - insert 1,2,3 in the Binary Tree
 */
public class BinaryTreeBuilderTest {

    @Test
    public void buildTree() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(2);
        binaryTree.insert(1);
        binaryTree.insert(3);
        BinaryTree.Node root = binaryTree.getRoot();
        assertEquals(2, root.getValue());
        assertEquals(1, root.getLeft().getValue());
        assertEquals(3, root.getRight().getValue());
    }
}
