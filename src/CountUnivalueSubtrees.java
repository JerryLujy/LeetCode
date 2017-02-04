import java.util.HashMap;
import java.util.Map;

/**
 * <h1>250. Count Univalue Subtrees</h1>
 * Given a binary tree, count the number of uni-value subtrees. A Uni-value subtree means all nodes of the subtree have the same value.
 * <p>
 * For example: Given binary tree,
 * <pre>
 *     5
 *    / \
 *   1   5
 *  / \   \
 * 5   5   5
 * </pre>
 * return 4.
 *
 * @author Jerry
 * @since 2/4/17
 */
public class CountUnivalueSubtrees {
    private Map<TreeNode, Boolean> isUnivalue = new HashMap<>();

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            isUnivalue.put(root, true);
            return 1;
        }
        int leftCount = countUnivalSubtrees(root.left);
        int rightCount = countUnivalSubtrees(root.right);
        boolean univalue = (root.left == null || isUnivalue.get(root.left) && root.val == root.left.val) &&
                (root.right == null || isUnivalue.get(root.right) && root.val == root.right.val);
        isUnivalue.put(root, univalue);
        return (univalue ? 1 : 0) + leftCount + rightCount;
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
