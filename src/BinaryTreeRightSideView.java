import support.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>199. Binary Tree Right Side View</h1>
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes
 * you can see ordered from top to bottom.
 * <p>
 * For example: Given the following binary tree,
 * <pre>
 *   1           <---
 *  / \
 * 2   3         <---
 *  \   \
 *   5   4       <---
 * </pre>
 * You should return [1, 3, 4].
 *
 * @author Jerry
 * @since 1/27/17
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        getRightNodes(root, ans, 0);
        return ans;
    }

    private void getRightNodes(TreeNode root, List<Integer> ans, int depth) {
        if (root == null) {
            return;
        }
        if (depth == ans.size()) {
            ans.add(root.val);
        }
        getRightNodes(root.right, ans, depth + 1);
        getRightNodes(root.left, ans, depth + 1);
    }
}
