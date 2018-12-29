import support.TreeNode;

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
        int rootVal = preorder[ps], pos = is, leftNum = 0;
        while (inorder[pos++] != rootVal) {
            leftNum++;
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, ps + 1, ps + leftNum + 1, inorder, is, is + leftNum);
        root.right = buildTree(preorder, ps + leftNum + 1, pe, inorder, is + leftNum + 1, ie);
        return root;
    }
}
