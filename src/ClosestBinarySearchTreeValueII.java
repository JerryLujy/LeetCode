import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <h1>272. Closest Binary Search Tree Value II</h1>
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 * <p>
 * Note:
 * Given target value is a floating point.
 * You may assume k is always valid, that is: k ≤ total nodes.
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 *
 * @author Jerry
 * @since 2/6/17
 */
public class ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> ans = new ArrayDeque<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            if (ans.size() == k && Math.abs(root.val - target) >
                    Math.max(Math.abs(ans.peekFirst() - target), Math.abs(ans.peekLast() - target))) {
                break;
            }
            ans.offerLast(root.val);
            if (ans.size() > k) {
                ans.pollFirst();
            }

            root = root.right;
        }
        return new ArrayList<>(ans);
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
