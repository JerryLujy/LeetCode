import support.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1>114. Flatten Binary Tree to Linked List</h1>
 * Given a binary tree, flatten it to a linked list in-place.
 * <p>
 * For example, Given
 * <pre>
 *      1
 *     / \
 *    2   5
 *   / \   \
 *  3   4   6
 * </pre>
 * The flattened tree should look like:
 * <pre>
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * </pre>
 *
 * @author Jerry
 * @since 1/17/17
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerLast(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pollLast();
            if (curr.right != null) {
                stack.offerLast(curr.right);
            }
            if (curr.left != null) {
                stack.offerLast(curr.left);
                curr.left = null;
            }
            if (!stack.isEmpty()) {
                curr.right = stack.peekLast();
            }
        }
    }

    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        getLastNode(root);
    }

    private TreeNode getLastNode(TreeNode node) {
        if (node.left != null) {
            TreeNode leftTail = getLastNode(node.left);
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
            node = leftTail;
        }
        if (node.right != null) {
            return getLastNode(node.right);
        }
        return node;
    }
}
