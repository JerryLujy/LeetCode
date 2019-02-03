import support.TreeNode;

/**
 * <h1>889. Construct Binary Tree from Preorder and Postorder Traversal</h1>
 * Return any binary tree that matches the given preorder and postorder traversals.
 * Values in the traversals pre and post are distinct positive integers.
 * <p>
 * Example 1: Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]. Output: [1,2,3,4,5,6,7]
 * <p>
 * Note:
 * 1 <= pre.length == post.length <= 30
 * pre[] and post[] are both permutations of 1, 2, ..., pre.length.
 * It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
 *
 * @author Jerry
 * @since 12/28/18
 */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return construct(pre, 0, pre.length, post, 0, post.length);
    }

    private TreeNode construct(int[] pre, int preS, int preE, int[] post, int postS, int postE) {
        if (preS == preE) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preS]);
        if (preS + 1 == preE) {
            return root;
        }
        int leftRoot = pre[preS + 1], leftNum = 1;
        int pos = postS;
        while (post[pos++] != leftRoot) {
            leftNum++;
        }
        root.left = construct(pre, preS + 1, preS + leftNum + 1, post, postS, postS + leftNum);
        root.right = construct(pre, preS + leftNum + 1, preE, post, postS + leftNum, postE - 1);
        return root;
    }
}
