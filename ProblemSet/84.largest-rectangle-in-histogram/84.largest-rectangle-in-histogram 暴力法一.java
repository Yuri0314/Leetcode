/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        for (int i = 0; i < heights.length; ++i) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; ++j) {
                minHeight = Math.min(minHeight, heights[j]);
                ans = Math.max(ans, (j - i + 1) * minHeight);
            }
        }
        return ans;
    }
}
// @lc code=end

