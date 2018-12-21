import support.TreeNode;

/**
 * <h1>270. Closest Binary Search Tree Value</h1>
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * <p>
 * Note:
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 *
 * @author Jerry
 * @since 2/6/17
 */
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        TreeNode next = root.val > target ? root.left : root.right;
        if (next == null) {
            return root.val;
        }
        int closest = closestValue(next, target);
        return Math.abs(root.val - target) > Math.abs(closest - target) ? closest : root.val;
    }
}
