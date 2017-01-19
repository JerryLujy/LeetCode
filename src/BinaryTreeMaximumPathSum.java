/**
 * <h1>124. Binary Tree Maximum Path Sum</h1>
 * Given a binary tree, find the maximum path sum. For this problem, a path is defined as
 * any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 * <p>
 * For example: Given the below binary tree,
 * <pre>
 *   1
 *  / \
 * 2   3
 * </pre>
 * Return 6.
 *
 * @author Jerry
 * @since 1/18/17
 */
public class BinaryTreeMaximumPathSum {
    private int maxSum = 0;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMaxPath(root);
        return maxSum;
    }

    private int findMaxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = Math.max(findMaxPath(root.left), 0);
        int rightSum = Math.max(findMaxPath(root.right), 0);
        maxSum = Math.max(maxSum, leftSum + rightSum + root.val);
        return root.val + Math.max(leftSum, rightSum);
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
