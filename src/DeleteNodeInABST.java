import support.TreeNode;

/**
 * <h1>450. Delete Node in a BST</h1>
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 * <p>
 * Basically, the deletion can be divided into two stages:
 * Search for a node to remove.
 * If the node is found, delete the node.
 * <p>
 * Note: Time complexity should be O(height of tree).
 *
 * @author Jerry
 * @since 2/12/17
 */
public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = null, curr = root;
        while (curr != null && curr.val != key) {
            parent = curr;
            if (curr.val > key) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        if (parent == null) {
            return deleteRoot(root);
        }
        if (parent.left == curr) {
            parent.left = deleteRoot(parent.left);
        } else {
            parent.right = deleteRoot(parent.right);
        }
        return root;
    }

    private TreeNode deleteRoot(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        // Find and return successor
        TreeNode parent = root, succ = root.right;
        while (succ.left != null) {
            parent = succ;
            succ = succ.left;
        }
        succ.left = root.left;
        if (parent.left == succ) {
            parent.left = succ.right;
            succ.right = root.right;
        }
        return succ;
    }
}
