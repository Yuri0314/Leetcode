/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int pos = 0;
        int maxProfit = 0;
        while (pos < prices.length - 1) {
            while (pos < prices.length - 1 && prices[pos] >= prices[pos + 1]) ++pos;
            int valley = prices[pos];
            while (pos < prices.length - 1 && prices[pos] <= prices[pos + 1]) ++pos;
            int peak = prices[pos];
            maxProfit += peak - valley;
        }
        return maxProfit;
    }
}
// @lc code=end

