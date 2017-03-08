import support.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <h1>94. Binary Tree Inorder Traversal</h1>
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * For example: Given binary tree [1,null,2,3],
 * <pre>
 * 1
 *  \
 *   2
 *  /
 * 3
 * </pre>
 * return [1,3,2].
 *
 * @author Jerry
 * @since 1/14/17
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }

    public List<Integer> inorderTraversalMorris(TreeNode root) {
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
                    pred.right = root;
                    root = root.left;
                } else {
                    ans.add(root.val);
                    pred.right = null;
                    root = root.right;
                }
            }
        }
        return ans;
    }
}
