/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; ++i) {
            int max_left = 0, max_right = 0;
            for (int l = i - 1; l >= 0; --l)
                max_left = Math.max(max_left, height[l]);
            for (int r = i + 1; r < height.length; ++r) 
                max_right = Math.max(max_right, height[r]);
            int min_height = Math.min(max_left, max_right);
            if (min_height > height[i])
                sum += min_height - height[i];
        }
        return sum;
    }
}
// @lc code=end

