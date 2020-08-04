/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0], lProduct = 0, rProduct = 0;
        for (int i = 0; i < nums.length; ++i) {
            lProduct = (lProduct == 0 ? 1 : lProduct) * nums[i];
            rProduct = (rProduct == 0 ? 1 : rProduct) * nums[nums.length - 1 - i];
            ans = Math.max(ans, Math.max(lProduct, rProduct));
        }
        return ans;
    }
}
// @lc code=end

