/**
 * <h1>518. Coin Change 2</h1>
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
 * <p>
 * Example 1: Input: amount = 5, coins = [1, 2, 5], Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * <p>
 * Example 2: Input: amount = 3, coins = [2], Output: 0, Explanation: the amount of 3 cannot be made up just with coins of 2.
 * <p>
 * Example 3: Input: amount = 10, coins = [10], Output: 1
 * <p>
 * Note: You can assume that
 * 0 <= amount <= 5000
 * 1 <= coin <= 5000
 * the number of coins is less than 500
 * the answer is guaranteed to fit into signed 32-bit integer
 *
 * @author Jerry
 * @since 1/20/19
 */
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                for (int k = 0; k <= j / coins[i - 1]; k++) {
                    dp[i][j] += dp[i - 1][j - k * coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
