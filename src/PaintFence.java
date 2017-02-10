/**
 * <h1>276. Paint Fence</h1>
 * There is a fence with n posts, each post can be painted with one of the k colors.
 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 * Return the total number of ways you can paint the fence.
 * <p>
 * Note: n and k are non-negative integers.
 *
 * @author Jerry
 * @since 2/10/17
 */
public class PaintFence {
    public int numWays(int n, int k) {
        if (n < 2) {
            return k * n;
        }
        int[] dp = new int[n];
        dp[0] = k;
        dp[1] = k * k;
        for (int i = 2; i < n; i++) {
            dp[i] = (k - 1) * (dp[i - 1] + dp[i - 2]);
        }
        return dp[n - 1];
    }
}
