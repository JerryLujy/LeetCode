import support.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>872. Leaf-Similar Trees</h1>
 * Consider all the leaves of a binary tree. From left to right order, the values of those leaves form a leaf value sequence.
 *        3
 *      /   \
 *     5     1
 *    / \   / \
 *   6   2 9   8
 *      / \
 *     7  4
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 * <p>
 * Note: Both of the given trees will have between 1 and 100 nodes.
 *
 * @author Jerry
 * @since 2/2/19
 */
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> seq1 = new ArrayList<>(), seq2 = new ArrayList<>();
        getLeaves(root1, seq1);
        getLeaves(root2, seq2);
        return seq1.equals(seq2);
    }

    private void getLeaves(TreeNode root, List<Integer> seq) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            seq.add(root.val);
            return;
        }
        getLeaves(root.left, seq);
        getLeaves(root.right, seq);
    }
}
