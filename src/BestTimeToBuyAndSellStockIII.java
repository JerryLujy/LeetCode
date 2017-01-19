/**
 * <h1>123. Best Time to Buy and Sell Stock III</h1>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most <b>two</b> transactions.
 * <p>
 * Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * @author Jerry
 * @since 1/18/17
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;
        for (int price : prices) {
            buy1 = Math.min(buy1, price);
            sell1 = Math.max(sell1, price - buy1);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }
        return sell2;
    }
}
