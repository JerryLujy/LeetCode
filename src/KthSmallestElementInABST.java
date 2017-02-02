/**
 * <h1>230. Kth Smallest Element in a BST</h1>
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * Note: You may assume k is always valid, 1 <= k <= BST's total elements.
 *
 * @author Jerry
 * @since 2/1/17
 */
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        int leftNum = numNodes(root.left);
        if (leftNum >= k) {
            return kthSmallest(root.left, k);
        } else if (leftNum == k - 1) {
            return root.val;
        } else {
            return kthSmallest(root.right, k - leftNum - 1);
        }
    }

    private int numNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + numNodes(root.left) + numNodes(root.right);
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
