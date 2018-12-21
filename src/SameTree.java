import support.TreeNode;

/**
 * <h1>100. Same Tree</h1>
 * Given two binary trees, write a function to check if they are equal or not.
 * <p>
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 *
 * @author Jerry
 * @since 1/15/17
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.val == q.val;
        } else {
            return p == null && q == null;
        }
    }
}
