import java.util.Arrays;

/**
 * <h1>322. Coin Change</h1>
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1: coins = [1, 2, 5], amount = 11, return 3 (11 = 5 + 5 + 1)
 * <p>
 * Example 2: coins = [2], amount = 3, return -1.
 * <p>
 * Note: You may assume that you have an infinite number of each kind of coin.
 *
 * @author Jerry
 * @since 3/4/17
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[0][i] = i % coins[0] == 0 ? i / coins[0] : -1;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k <= j / coins[i]; k++) {
                    if (dp[i - 1][j - k * coins[i]] != -1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * coins[i]] + k);
                    }
                }
                if (dp[i][j] == Integer.MAX_VALUE) {
                    dp[i][j] = -1;
                }
            }
        }
        return dp[coins.length - 1][amount];
    }

    public int coinChangeFast(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
