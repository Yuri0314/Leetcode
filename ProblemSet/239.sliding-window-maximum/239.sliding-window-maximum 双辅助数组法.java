/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] left_max = new int[nums.length];
        int[] right_max = new int[nums.length];

        left_max[0] = nums[0];
        right_max[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; ++i) {
            left_max[i] = (i % k == 0) ? nums[i] : Math.max(left_max[i - 1], nums[i]);
            int j = nums.length - i - 1;
            right_max[j] = (j % k == 0) ? nums[j] : Math.max(right_max[j + 1], nums[j]);
        }

        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; ++i) 
            ans[i] = Math.max(left_max[i + k - 1], right_max[i]);
        return ans;
    }
}
// @lc code=end

