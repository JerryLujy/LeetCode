import support.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>652. Find Duplicate Subtrees</h1>
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 * Two trees are duplicate if they have the same structure with same node values.
 * <p>
 * Example 1:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * The following are two duplicate subtrees:
 *       2
 *      /
 *     4
 * and
 *     4
 * Therefore, you need to return above trees' root in the form of a list.
 *
 * @author Jerry
 * @since 1/24/19
 */
public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        helper(root, ans, map);
        return ans;
    }

    private String helper(TreeNode root, List<TreeNode> ans, Map<String, Integer> map) {
        if (root == null) {
            return "#";
        }
        String s = root.val + "," + helper(root.left, ans, map) + "," + helper(root.right, ans, map);
        map.merge(s, 1, Integer::sum);
        if (map.get(s) == 2) {
            ans.add(root);
        }
        return s;
    }
}
