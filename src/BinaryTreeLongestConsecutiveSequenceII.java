import support.TreeNode;

/**
 * <h1>549. Binary Tree Longest Consecutive Sequence II</h1>
 * Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree.
 * Especially, this path can be either increasing or decreasing.
 * For example, [1,2,3,4] and [4,3,2,1] are both considered valid, but the path [1,2,4,3] is not valid.
 * On the other hand, the path can be in the child-Parent-child order, where not necessarily be parent-child order.
 * <p>
 * Example 1:
 * Input:
 *         1
 *        / \
 *       2   3
 * Output: 2
 * Explanation: The longest consecutive path is [1, 2] or [2, 1].
 * <p>
 * Example 2:
 * Input:
 *         2
 *        / \
 *       1   3
 * Output: 3
 * Explanation: The longest consecutive path is [1, 2, 3] or [3, 2, 1].
 * <p>
 * Note: All the values of tree nodes are in the range of [-1e7, 1e7].
 *
 * @author Jerry
 * @since 1/22/19
 */
public class BinaryTreeLongestConsecutiveSequenceII {
    int ans = 0;

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return ans;
    }

    private int[] helper(TreeNode root) {
        int inc = 1, dec = 1;
        if (root.left != null) {
            int[] l = helper(root.left);
            if (root.val + 1 == root.left.val) {
                inc = l[0] + 1;
            } else if (root.left.val + 1 == root.val) {
                dec = l[1] + 1;
            }
        }
        if (root.right != null) {
            int[] r = helper(root.right);
            if (root.val + 1 == root.right.val) {
                inc = Math.max(inc, r[0] + 1);
            } else if (root.right.val + 1 == root.val) {
                dec = Math.max(dec, r[1] + 1);
            }
        }
        ans = Math.max(ans, inc + dec - 1);
        return new int[]{inc, dec};
    }
}
