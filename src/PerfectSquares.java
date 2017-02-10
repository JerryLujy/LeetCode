/**
 * <h1>279. Perfect Squares</h1>
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * <p>
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 *
 * @author Jerry
 * @since 2/10/17
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (long j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - (int) (j * j)] + 1);
            }
        }
        return dp[n];
    }
}
