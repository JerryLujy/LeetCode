/**
 * <h1>188. Best Time to Buy and Sell Stock IV</h1>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * <p>
 * Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * @author Jerry
 * @since 1/18/17
 */
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (k > prices.length) {// Can greedily buy and sell
            int prof = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    prof += prices[i] - prices[i - 1];
                }
            }
            return prof;
        }
        int[][] dp = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            int wealth = -prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], wealth + prices[j]);
                wealth = Math.max(wealth, dp[i - 1][j - 1] - prices[j]);
            }
        }
        return dp[k][prices.length - 1];
    }
}
