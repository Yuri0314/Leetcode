/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        for (int pos = 0; pos < heights.length; ++pos) {
            int height = heights[pos];
            int left = pos, right = pos;
            while (left - 1 >= 0 && heights[left - 1] >= height) --left;
            while (right + 1 < heights.length && heights[right + 1] >= height) ++right;
            ans = Math.max(ans, (right - left + 1) * height);
        }
        return ans;
    }
}
// @lc code=end

