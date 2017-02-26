/**
 * <h1>333. Largest BST Subtree</h1>
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.
 * Note: A subtree must include all of its descendants.
 * <p>
 * Here's an example:
 * <pre>
 *     10
 *    / \
 *   5  15
 *  / \   \
 * 1   8   7
 * </pre>
 * The Largest BST Subtree in this case is the 5(1)(8). The return value is the subtree's size, which is 3.
 *
 * @author Jerry
 * @since 2/25/17
 */
public class LargestBSTSubtree {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (isBST(root, Long.MIN_VALUE, Long.MAX_VALUE)) {
            return count(root);
        }
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    private boolean isBST(TreeNode root, long lb, long ub) {
        return root == null || root.val > lb && root.val < ub && isBST(root.left, lb, root.val) && isBST(root.right, root.val, ub);
    }

    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
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
