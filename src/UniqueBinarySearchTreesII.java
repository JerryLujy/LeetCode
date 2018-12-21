import support.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>95. Unique Binary Search Trees II</h1>
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * <p>
 * For example, Given n = 3, your program should return all 5 unique BST's shown below.
 * <p>
 * 1         3     3      2      1
 *  \       /     /      / \      \
 *   3     2     1      1   3      2
 *  /     /       \                 \
 * 2     1         2                 3
 *
 * @author Jerry
 * @since 1/15/17
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        // dp[i][j] contains all possible trees generated from i to j
        List<List<List<TreeNode>>> dp = new ArrayList<>();
        for (int i = 0; i <= n + 1; i++) {
            dp.add(new ArrayList<>());
            for (int j = 0; j <= n + 1; j++) {
                dp.get(i).add(new ArrayList<>());
            }
        }
        for (int i = 1; i <= n; i++) {
            dp.get(i).get(i).add(new TreeNode(i));
        }
        for (int i = 1; i <= n - 1; i++) {// Interval
            for (int j = 1; j <= n - i; j++) {// Row #
                int start = j;
                int end = j + i;
                for (int k = start; k <= end; k++) { // Each number can be the root
                    List<TreeNode> leftCandidates = dp.get(start).get(k - 1);
                    List<TreeNode> rightCandidates = dp.get(k + 1).get(end);
                    if (leftCandidates.isEmpty()) {
                        for (TreeNode right : rightCandidates) {
                            TreeNode newNode = new TreeNode(k);
                            newNode.right = right;
                            dp.get(start).get(end).add(newNode);
                        }
                    } else if (rightCandidates.isEmpty()) {
                        for (TreeNode left : leftCandidates) {
                            TreeNode newNode = new TreeNode(k);
                            newNode.left = left;
                            dp.get(start).get(end).add(newNode);
                        }
                    } else {
                        for (TreeNode left : leftCandidates) {
                            for (TreeNode right : rightCandidates) {
                                TreeNode newNode = new TreeNode(k);
                                newNode.left = left;
                                newNode.right = right;
                                dp.get(start).get(end).add(newNode);
                            }
                        }
                    }
                }
            }
        }
        return dp.get(1).get(n);
    }
}
