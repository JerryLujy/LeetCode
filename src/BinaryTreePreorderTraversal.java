import support.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <h1>144. Binary Tree Preorder Traversal</h1>
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * For example: Given binary tree {1,#,2,3},
 * <pre>
 * 1
 *  \
 *   2
 *  /
 * 3
 * </pre>
 * return [1,2,3].
 *
 * @author Jerry
 * @since 1/21/17
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                ans.add(root.val);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return ans;
    }

    public List<Integer> preorderTraversalMorris(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        while (root != null) {
            if (root.left == null) {
                ans.add(root.val);
                root = root.right;
            } else {
                TreeNode pred = root.left;
                while (pred.right != null && pred.right != root) {
                    pred = pred.right;
                }
                if (pred.right == null) {
                    ans.add(root.val);
                    pred.right = root;
                    root = root.left;
                } else {
                    pred.right = null;
                    root = root.right;
                }
            }
        }
        return ans;
    }
}
