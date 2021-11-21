package oleksii.filonov.interview.tasks.datastructures.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * http://cslibrary.stanford.edu/110/BinaryTrees.html
 * first problem - insert 1,2,3 in the Binary Tree
 */
public class BinarySearchTreeBuilderTest {

    @Test
    public void buildTree() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        BinarySearchTree.Node root = binarySearchTree.getRoot();
        assertEquals(2, root.getValue());
        assertEquals(1, root.getLeft().getValue());
        assertEquals(3, root.getRight().getValue());
    }
}
