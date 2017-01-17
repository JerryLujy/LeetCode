import java.util.ArrayList;
import java.util.List;

/**
 * <h1>113. Path Sum II</h1>
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * <p>
 * For example: Given the below binary tree and sum = 22,
 * <pre>
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * </pre>
 * return [[5,4,11,2],[5,8,4,5]]
 *
 * @author Jerry
 * @since 1/17/17
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        findPaths(ans, path, root, sum);
        return ans;
    }

    private void findPaths(List<List<Integer>> ans, List<Integer> path, TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        if (node.val == sum && node.left == null && node.right == null) {
            ans.add(new ArrayList<>(path));
        } else {
            findPaths(ans, path, node.left, sum - node.val);
            findPaths(ans, path, node.right, sum - node.val);
        }
        path.remove(path.size() - 1);
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
