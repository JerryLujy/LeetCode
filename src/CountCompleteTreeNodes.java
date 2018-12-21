import support.TreeNode;

/**
 * <h1>222. Count Complete Tree Nodes</h1>
 * Given a complete binary tree, count the number of nodes.
 *
 * @author Jerry
 * @since 1/31/17
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = 0, rh = 0;
        TreeNode cur = root;
        while (cur.left != null) {
            lh++;
            cur = cur.left;
        }
        cur = root;
        while (cur.right != null) {
            rh++;
            cur = cur.right;
        }
        if (lh == rh) {
            return (2 << lh) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}
