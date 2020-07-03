/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        int sum = 0;
        int[] left_max = new int[height.length];
        int[] right_max = new int[height.length];
        left_max[0] = height[0];
        right_max[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; ++i)
            left_max[i] = Math.max(left_max[i - 1], height[i]);
        for (int i = height.length - 2; i >= 0; --i)
            right_max[i] = Math.max(right_max[i + 1], height[i]);
        for (int i = 1; i < height.length - 1; ++i)
            sum += Math.min(left_max[i], right_max[i]) - height[i];
        return sum;
    }
}
// @lc code=end

