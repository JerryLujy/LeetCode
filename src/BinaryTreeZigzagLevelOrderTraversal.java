import support.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <h1>103. Binary Tree Zigzag Level Order Traversal</h1>
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 * For example: Given binary tree [3,9,20,null,null,15,7],
 * return its zigzag level order traversal as:[[3],[20,9],[15,7]]
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
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root == null) {
            return ans;
        }
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            int count = deque.size();
            List<Integer> level = new ArrayList<>();
            ans.add(level);
            for (int i = 0; i < count; i++) {
                TreeNode node;
                if (ans.size() % 2 == 1) { // Left to right
                    node = deque.pollFirst();
                    if (node.left != null) {
                        deque.offerLast(node.left);
                    }
                    if (node.right != null) {
                        deque.offerLast(node.right);
                    }
                } else {
                    node = deque.pollLast();
                    if (node.right != null) {
                        deque.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        deque.offerFirst(node.left);
                    }
                }
                level.add(node.val);
            }
        }
        return ans;
    }
}
