import support.TreeNode;

/**
 * <h1>106. Construct Binary Tree from Inorder and Postorder Traversal</h1>
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * Note: You may assume that duplicates do not exist in the tree.
 *
 * @author Jerry
 * @since 1/16/17
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode buildTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if (ps == pe) {
            return null;
        }
        int rootVal = postorder[pe - 1], pos = is, leftNum = 0;
        while (inorder[pos++] != rootVal) {
            leftNum++;
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inorder, is, is + leftNum, postorder, ps, ps + leftNum);
        root.right = buildTree(inorder, is + leftNum + 1, ie, postorder, ps + leftNum, pe - 1);
        return root;
    }
}
