package oleksii.filonov.interview.tasks.datastructures.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidBSTTest {

    @Test
    void shouldBeValid() {
        ValidBST.TreeNode _10 = buildInvalidBST();
        ValidBST validBST = new ValidBST();
        Assertions.assertFalse(validBST.isValidBST(_10));
    }

    private ValidBST.TreeNode buildInvalidBST() {
        ValidBST.TreeNode _10 = new ValidBST.TreeNode(10);
        ValidBST.TreeNode _5 = new ValidBST.TreeNode(5);
        ValidBST.TreeNode _15 = new ValidBST.TreeNode(15);
        ValidBST.TreeNode _6 = new ValidBST.TreeNode(6);
        ValidBST.TreeNode _20 = new ValidBST.TreeNode(20);
        _10.left = _5;
        _10.right = _15;
        _15.left = _6;
        _15.right = _20;
        return _10;
    }
}