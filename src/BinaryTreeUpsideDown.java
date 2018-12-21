import support.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1>156. Binary Tree Upside Down</h1>
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling
 * (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree
 * where the original right nodes turned into left leaf nodes. Return the new root.
 * <p>
 * For example: Given a binary tree {1,2,3,4,5},
 * <pre>
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * </pre>
 * return the root of the binary tree [4,5,2,#,#,3,1].
 * <pre>
 *   4
 *  / \
 * 5   2
 *    / \
 *   3   1
 * </pre>
 *
 * @author Jerry
 * @since 1/24/17
 */
public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root.left != null) {
            stack.push(root);
            root = root.left;
        }
        TreeNode curr = root;
        while (!stack.isEmpty()) {
            TreeNode father = stack.pop();
            curr.left = father.right;
            curr.right = father;
            curr = father;
        }
        curr.left = curr.right = null;
        return root;
    }
}
