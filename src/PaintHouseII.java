import java.util.Arrays;

/**
 * <h1>265. Paint House II</h1>
 * There are a row of n houses, each house can be painted with one of the k colors.
 * The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 * <p>
 * The cost of painting each house with a certain color is represented by a n x k cost matrix.
 * For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on...
 * Find the minimum cost to paint all houses.
 * <p>
 * Note: All costs are positive integers.
 *
 * @author Jerry
 * @since 2/5/17
 */
public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int n = costs.length, k = costs[0].length;
        int[][] dp = new int[n][k];
        System.arraycopy(costs[0], 0, dp[0], 0, k);
        for (int i = 1; i < n; i++) {
            int l = 0, r = k - 1;
            int lmin = Integer.MAX_VALUE, rmin = Integer.MAX_VALUE;
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int j = 0; j < k - 1; j++) {
                lmin = Math.min(lmin, dp[i - 1][l]);
                rmin = Math.min(rmin, dp[i - 1][r]);
                dp[i][l + 1] = Math.min(dp[i][l + 1], lmin);
                dp[i][r - 1] = Math.min(dp[i][r - 1], rmin);
                l++;
                r--;
            }
            for (int j = 0; j < k; j++) {
                dp[i][j] += costs[i][j];
            }
        }
        int minCost = Integer.MAX_VALUE;
        for (int cost : dp[n - 1]) {
            minCost = Math.min(minCost, cost);
        }
        return minCost;
    }
}
