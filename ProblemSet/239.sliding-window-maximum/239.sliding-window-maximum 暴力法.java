/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; ++i) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; ++j) {
                max = Math.max(max, nums[j]);
            }
            ans[i] = max;
        }
        return ans;
    }
}
// @lc code=end

