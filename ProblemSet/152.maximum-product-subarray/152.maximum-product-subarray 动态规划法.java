/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0], minP = nums[0], maxP = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int mx = maxP, mn = minP;
            minP = Math.min(nums[i], Math.min(mx * nums[i], mn * nums[i]));
            maxP = Math.max(nums[i], Math.max(mx * nums[i], mn * nums[i]));
            ans = Math.max(ans, maxP);
        }
        return ans;
    }
}
// @lc code=end

