/**
 * <h1>298. Binary Tree Longest Consecutive Sequence</h1>
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The longest consecutive path need to be from parent to child (cannot be the reverse).
 * <p>
 * For example,
 * <pre>
 * 1
 *  \
 *   3
 *  / \
 * 2   4
 *      \
 *       5
 * </pre>
 * Longest consecutive sequence path is 3-4-5, so return 3.
 * <pre>
 *   2
 *    \
 *     3
 *    /
 *   2
 *  /
 * 1
 * </pre>
 * Longest consecutive sequence path is 2-3,not 3-2-1, so return 2.
 *
 * @author Jerry
 * @since 2/14/17
 */
public class BinaryTreeLongestConsecutiveSequence {
    public int longestConsecutive(TreeNode root) {
        return dfs(root, null, 0);
    }

    private int dfs(TreeNode root, TreeNode parent, int length) {
        if (root == null) {
            return length;
        }
        int newLength = (parent != null && parent.val + 1 == root.val) ? length + 1 : 1;
        int leftLen = dfs(root.left, root, newLength);
        int rightLen = dfs(root.right, root, newLength);
        return Math.max(length, Math.max(leftLen, rightLen));
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
