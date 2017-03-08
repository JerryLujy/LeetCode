import support.TreeNode;

/**
 * <h1>98. Validate Binary Search Tree</h1>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * @author Jerry
 * @since 1/15/17
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode root, long lb, long ub) {
        return root == null || root.val > lb && root.val < ub &&
                validate(root.left, lb, root.val) && validate(root.right, root.val, ub);
    }
}
