/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int left = 0, right = height.length - 1;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) left_max = height[left];
                else sum += left_max - height[left];
                ++left;
            }
            else {
                if (height[right] >= right_max) right_max = height[right];
                else sum += right_max - height[right];
                --right;
            }
        }
        return sum;
    }
}
// @lc code=end

