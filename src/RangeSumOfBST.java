import support.TreeNode;

/**
 * <h1>938. Range Sum of BST</h1>
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
 * The binary search tree is guaranteed to have unique values.
 * <p>
 * Example 1: Input: root = [10,5,15,3,7,null,18], L = 7, R = 15. Output: 32
 * <p>
 * Example 2: Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10. Output: 23
 * <p>
 * Note:
 * The number of nodes in the tree is at most 10000.
 * The final answer is guaranteed to be less than 2^31.
 *
 * @author Jerry
 * @since 2/4/19
 */
public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        } else if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        } else {
            return root.val + rangeSumBST(root.left, L, root.val) + rangeSumBST(root.right, root.val, R);
        }
    }
}
