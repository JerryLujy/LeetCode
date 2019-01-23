import support.TreeNode;

/**
 * <h1>543. Diameter of Binary Tree</h1>
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * <p>
 * Example: Given a binary tree
 *
 *      1
 *     / \
 *    2   3
 *   / \
 *  4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 * @author Jerry
 * @since 1/22/19
 */
public class DiameterOfBinaryTree {
    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        helper(root);
        return ans;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int l = helper(root.left), r = helper(root.right);
        ans = Math.max(ans, l + r + 2);
        return Math.max(l + 1, r + 1);
    }
}
