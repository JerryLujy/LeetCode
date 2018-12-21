import support.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1>173. Binary Search Tree Iterator</h1>
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * <p>
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 *
 * @author Jerry
 * @since 1/26/17
 */
public class BinarySearchTreeIterator {
    Deque<TreeNode> stack = new ArrayDeque<>();

    public BinarySearchTreeIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode cur = stack.pop();
        TreeNode next = cur.right;
        while (next != null) {
            stack.push(next);
            next = next.left;
        }
        return cur.val;
    }
}
