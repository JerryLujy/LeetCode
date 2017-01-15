/**
 * <h1>96. Unique Binary Search Trees</h1>
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * <p>
 * For example, Given n = 3, there are a total of 5 unique BST's.
 * <p>
 * 1         3     3      2      1
 *  \       /     /      / \      \
 *   3     2     1      1   3      2
 *  /     /       \                 \
 * 2     1         2                 3
 *
 * @author Jerry
 * @since 1/14/17
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1]; // dp[i] is num of trees using 1...i
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // Use any of 1...i as root, left and right trees have j and i-j-1 possibilities respectively
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
