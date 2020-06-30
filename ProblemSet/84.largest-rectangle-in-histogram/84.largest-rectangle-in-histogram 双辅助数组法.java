/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int[] leftLess = new int[heights.length];
        int[] rightLess = new int[heights.length];
        leftLess[0] = -1;
        rightLess[heights.length - 1] = heights.length;
        int ans = 0;
        for (int i = 1; i < heights.length; ++i) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) p = leftLess[p];
            leftLess[i] = p;
        }
        for (int i = heights.length - 2; i >= 0; --i) {
            int p = i + 1;
            while (p < heights.length && heights[p] >= heights[i]) p = rightLess[p];
            rightLess[i] = p;
        }
        for (int i = 0; i < heights.length; ++i)
            ans = Math.max(ans, heights[i] * (rightLess[i] - leftLess[i] - 1));
        return ans;
    }
}
// @lc code=end

