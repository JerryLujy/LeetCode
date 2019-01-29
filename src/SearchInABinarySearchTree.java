import support.TreeNode;

/**
 * <h1>700. Search in a Binary Search Tree</h1>
 * Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value.
 * Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
 * <p>
 * For example, Given the tree:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 * And the value to search: 2
 * You should return this subtree:
 *       2
 *      / \
 *     1   3
 * In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.
 * <p>
 * Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [], not null.
 *
 * @author Jerry
 * @since 1/28/19
 */
public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = root.val < val ? root.right : root.left;
        }
        return root;
    }
}
