package oleksii.filonov.interview.tasks.datastructures.trees;

import java.util.Collection;
import java.util.stream.Collectors;

public class BSTTestHelper {

    /**
     * 4
     * 2        5
     * 1    3
     *
     * @return binary  tree
     */
    public static BinarySearchTree createBST() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(5);
        return binarySearchTree;
    }


    public static String printCollection(Collection<Integer> actualBSTOrder) {
        return "actual: " + actualBSTOrder.stream().map(Object::toString).collect(Collectors.joining(","));
    }
}
