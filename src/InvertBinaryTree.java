import support.TreeNode;

/**
 * <h1>226. Invert Binary Tree</h1>
 * Invert a binary tree.
 * <pre>
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * </pre>
 * to
 * <pre>
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * </pre>
 *
 * @author Jerry
 * @since 1/31/17
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }
}
