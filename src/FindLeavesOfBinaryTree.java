import java.util.ArrayList;
import java.util.List;

/**
 * <h1>366. Find Leaves of Binary Tree</h1>
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.
 * <p>
 * Example:
 * Given binary tree
 * <pre>
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * </pre>
 * Returns [4, 5, 3], [2], [1].
 *
 * @author Jerry
 * @since 3/3/17
 */
public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    private int dfs(TreeNode node, List<List<Integer>> ans) {
        if (node == null) {
            return -1;
        }
        int level = 1 + Math.max(dfs(node.left, ans), dfs(node.right, ans));
        if (level == ans.size()) {
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(node.val);
        return level;
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
