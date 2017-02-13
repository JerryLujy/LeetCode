import java.util.HashMap;
import java.util.Map;

/**
 * <h1>337. House Robber III</h1>
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root."
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * <p>
 * Example 1: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * <pre>
 *   3
 *  / \
 * 2   3
 *  \   \
 *   3   1
 * </pre>
 * Example 2: Maximum amount of money the thief can rob = 4 + 5 = 9.
 * <pre>
 *     3
 *    / \
 *   4   5
 *  / \   \
 * 1   3   1
 * </pre>
 *
 * @author Jerry
 * @since 2/12/17
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        return rob(root, new HashMap<>());
    }

    private int rob(TreeNode root, Map<TreeNode, Integer> mem) {
        if (root == null) {
            return 0;
        }
        if (mem.containsKey(root)) {
            return mem.get(root);
        }
        int notRob = rob(root.left, mem) + rob(root.right, mem);
        int rob = root.val;
        if (root.left != null) {
            rob += rob(root.left.left, mem) + rob(root.left.right, mem);
        }
        if (root.right != null) {
            rob += rob(root.right.left, mem) + rob(root.right.right, mem);
        }
        mem.put(root, Math.max(rob, notRob));
        return Math.max(rob, notRob);
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
