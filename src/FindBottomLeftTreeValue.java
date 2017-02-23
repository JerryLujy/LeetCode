import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <h1>513. Find Bottom Left Tree Value</h1>
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * <p>
 * Example 1: Input:
 * <pre>
 *   2
 *  / \
 * 1   3
 * </pre>
 * Output: 1
 * <p>
 * Example 2: Input:
 * <pre>
 *     1
 *    / \
 *   2   3
 *  /   / \
 * 4   5   6
 *    /
 *   7
 * </pre>
 * Output: 7
 * <p>
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 *
 * @author Jerry
 * @since 2/22/17
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            ans = queue.peek().val;
            for (int i = 0; i < count; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return ans;
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
