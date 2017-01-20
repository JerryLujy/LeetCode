/**
 * <h1>129. Sum Root to Leaf Numbers</h1>
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * <p>
 * Find the total sum of all root-to-leaf numbers.
 * <p>
 * For example,
 * <pre>
 *   1
 *  / \
 * 2   3
 * </pre>
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 *
 * @author Jerry
 * @since 1/19/17
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int cur) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return cur * 10 + root.val;
        }
        return sumNumbers(root.left, cur * 10 + root.val) + sumNumbers(root.right, cur * 10 + root.val);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
