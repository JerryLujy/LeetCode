/**
 * <h1>837. New 21 Game</h1>
 * Alice plays the following game, loosely based on the card game "21".
 * Alice starts with 0 points, and draws numbers while she has less than K points.
 * During each draw, she gains an integer number of points randomly from the range [1, W], where W is an integer.
 * Each draw is independent and the outcomes have equal probabilities.
 * Alice stops drawing numbers when she gets K or more points.
 * What is the probability that she has N or less points?
 * <p>
 * Example 1: Input: N = 10, K = 1, W = 10. Output: 1.00000. Explanation:  Alice gets a single card, then stops.
 * <p>
 * Example 2: Input: N = 6, K = 1, W = 10. Output: 0.60000
 * Explanation:  Alice gets a single card, then stops.
 * In 6 out of W = 10 possibilities, she is at or below N = 6 points.
 * <p>
 * Example 3: Input: N = 21, K = 17, W = 10. Output: 0.73278
 * <p>
 * Note:
 * 0 <= K <= N <= 10000
 * 1 <= W <= 10000
 *
 * @author Jerry
 * @since 2/1/19
 */
public class New21Game {
    public double new21Game(int N, int K, int W) {
        if (N >= K + W - 1) {
            return 1.0;
        }
        // dp[i] = prob of win when having i points
        double[] dp = new double[K + W];
        for (int i = K; i <= N; i++) {
            dp[i] = 1.0;
        }
        // dp[i] = (dp[i + 1] +...+ dp[i + W]) / W;
        // Maintain S = dp[i + 1] +...+ dp[i + W]
        double S = Math.min(N - K + 1, W);
        for (int i = K - 1; i >= 0; i--) {
            dp[i] = S / W;
            S = S - dp[i + W] + dp[i];
        }
        return dp[0];
    }
}
