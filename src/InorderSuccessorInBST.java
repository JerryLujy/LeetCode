import support.TreeNode;

/**
 * <h1>285. Inorder Successor in BST</h1>
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * <p>
 * Note: If the given node has no in-order successor in the tree, return null.
 *
 * @author Jerry
 * @since 2/11/17
 */
public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while (root != null) {
            if (root.val > p.val) { // Go left, root is a potential successor
                succ = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return succ;
    }
}
