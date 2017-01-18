/**
 * <h1>121. Best Time to Buy and Sell Stock</h1>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction
 * (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Example 1: Input: [7, 1, 5, 3, 6, 4], Output: 5,
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * <p>
 * Example 2: Input: [7, 6, 4, 3, 1], Output: 0,
 * In this case, no transaction is done, i.e. max profit = 0.
 *
 * @author Jerry
 * @since 1/18/17
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProf = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProf = Math.max(maxProf, price - minPrice);
        }
        return maxProf;
    }
}
