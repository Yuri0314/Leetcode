/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min_price = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < min_price)
                min_price = prices[i];
            else if (prices[i] - min_price > profit)
                profit = prices[i] - min_price;
        }
        return profit;
    }
}
// @lc code=end

