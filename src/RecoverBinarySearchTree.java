import support.TreeNode;

/**
 * <h1>99. Recover Binary Search Tree</h1>
 * Two elements of a binary search tree (BST) are swapped by mistake. Recover the tree without changing its structure.
 * <p>
 * Note: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 *
 * @author Jerry
 * @since 1/15/17
 */
public class RecoverBinarySearchTree {
    private TreeNode first, second; // The two misplaced nodes
    private TreeNode prev;

    public void recoverTree(TreeNode root) {
        first = second = prev = null;
        dfs(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        checkMisplacement(root);
        dfs(root.right);
    }

    public void recoverTreeMorris(TreeNode root) {
        first = second = prev = null;

        // Morris In-order Traversal
        while (root != null) {
            if (root.left == null) {
                checkMisplacement(root);
                root = root.right;
            } else {
                // Find predecessor
                TreeNode pred = root.left;
                while (pred.right != null && pred.right != root) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    pred.right = root;
                    root = root.left;
                } else {
                    pred.right = null;
                    checkMisplacement(root);
                    root = root.right;
                }
            }
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void checkMisplacement(TreeNode curr) {
        if (prev != null && curr.val <= prev.val) {
            if (first == null) {
                first = prev;
            }
            second = curr;
        }
        prev = curr;
    }
}
