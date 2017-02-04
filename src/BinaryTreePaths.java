import java.util.ArrayList;
import java.util.List;

/**
 * <h1>257. Binary Tree Paths</h1>
 * Given a binary tree, return all root-to-leaf paths.
 * <p>
 * For example, given the following binary tree:
 * <pre>
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * </pre>
 * All root-to-leaf paths are: ["1->2->5", "1->3"]
 *
 * @author Jerry
 * @since 2/4/17
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        dfs(root, "", ans);
        return ans;
    }

    private void dfs(TreeNode root, String path, List<String> ans) {
        if (root.left == null && root.right == null) {
            ans.add(path + String.valueOf(root.val));
        }
        if (root.left != null) {
            dfs(root.left, path + String.valueOf(root.val) + "->", ans);
        }
        if (root.right != null) {
            dfs(root.right, path + String.valueOf(root.val) + "->", ans);
        }
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
