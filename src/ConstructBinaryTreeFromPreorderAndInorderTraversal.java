/**
 * <h1>105. Construct Binary Tree from Preorder and Inorder Traversal</h1>
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note: You may assume that duplicates do not exist in the tree.
 *
 * @author Jerry
 * @since 1/16/17
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps == pe) {
            return null;
        }
        int rootVal = preorder[ps];
        int pos = is;
        while (inorder[pos] != rootVal) {
            pos++;
        }
        int leftNum = pos - is; // Num of nodes in left sub tree
        int rightNum = ie - pos - 1; // Num of nodes in right sub tree

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, ps + 1, ps + 1 + leftNum, inorder, is, pos);
        root.right = buildTree(preorder, pe - rightNum, pe, inorder, pos + 1, ie);
        return root;
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
