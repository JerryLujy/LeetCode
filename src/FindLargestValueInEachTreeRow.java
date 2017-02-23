import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <h1>515. Find Largest Value in Each Tree Row</h1>
 * You need to find the largest value in each row of a binary tree.
 * <p>
 * Example: Input:
 * <pre>
 *     1
 *    / \
 *   3   2
 *  / \   \
 * 5   3   9
 * </pre>
 * Output: [1, 3, 9]
 *
 * @author Jerry
 * @since 2/23/17
 */
public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < count; i++) {
                TreeNode cur = queue.poll();
                max = Math.max(max, cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            ans.add(max);
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
