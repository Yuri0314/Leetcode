import java.util.Arrays;

/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    private int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return rob(nums, nums.length - 1);
    }

    private int rob(int[] nums, int i) {
        if (i < 0) return 0;
        if (memo[i] >= 0) return memo[i];
        memo[i] = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
        return memo[i];
    }
}
// @lc code=end

