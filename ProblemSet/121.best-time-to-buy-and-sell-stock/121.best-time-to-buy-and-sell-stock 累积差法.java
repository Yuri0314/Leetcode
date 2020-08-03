/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int cur_profit = 0;
        for (int i = 1; i < prices.length; ++i) {
            cur_profit += prices[i] - prices[i - 1];
            if (cur_profit > profit)
                profit = cur_profit;
            else if (cur_profit < 0)
                cur_profit = 0;
        }
        return profit;
    }
}
// @lc code=end

