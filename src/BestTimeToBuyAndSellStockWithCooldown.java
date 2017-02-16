/**
 * <h1>309. Best Time to Buy and Sell Stock with Cooldown</h1>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * <p>
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * <p>
 * Example:
 * prices = [1, 2, 3, 0, 2],
 * maxProfit = 3,
 * transactions = [buy, sell, cooldown, buy, sell]
 *
 * @author Jerry
 * @since 2/16/17
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];
        buy[0] = -prices[0]; // Buy at day 0
        sell[0] = 0; // Cannot sell at day 0
        buy[1] = Math.max(buy[0], -prices[1]); // Buy at day 1
        sell[1] = Math.max(sell[0], buy[0] + prices[1]); // Sell at day 1
        for (int i = 2; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]); // Have to rest one day before can buy again
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[prices.length - 1];
    }
}
