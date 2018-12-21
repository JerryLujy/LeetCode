import support.TreeNode;

/**
 * <h1>110. Balanced Binary Tree</h1>
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which
 * the depth of the two subtrees of every node never differ by more than 1.
 *
 * @author Jerry
 * @since 1/17/17
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth, rightDepth;
        if ((leftDepth = depth(root.left)) == -1 || (rightDepth = depth(root.right)) == -1) {
            return -1;
        }
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
