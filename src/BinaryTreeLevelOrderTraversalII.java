import support.TreeNode;

import java.util.*;

/**
 * <h1>107. Binary Tree Level Order Traversal II</h1>
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example: Given binary tree [3,9,20,null,null,15,7],
 * return its bottom-up level order traversal as:[[15,7],[9,20],[3]]
 * <pre>
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * </pre>
 *
 * @author Jerry
 * @since 1/16/17
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> level = new ArrayList<>();
            ans.add(0, level);
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                level.add(node.val);
            }
        }
        return ans;
    }
}
