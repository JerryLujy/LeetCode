import java.util.ArrayDeque;
import java.util.Deque;

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
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.offerLast(root);
                root = root.left;
            }
            TreeNode curr = stack.pollLast();
            if (prev != null && curr.val <= prev.val) {
                return false;
            }
            prev = curr;
            root = curr.right;
        }
        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
