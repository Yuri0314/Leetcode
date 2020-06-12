/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int cur, nonZeroTail;
        if (nums.length <= 0)
            return;
        for (cur = nonZeroTail = 0; cur < nums.length; ++cur) {
            if (nums[cur] == 0) continue;
            else nums[nonZeroTail++] = nums[cur];
        }
        while (nonZeroTail < nums.length)
            nums[nonZeroTail++] = 0;
    }
}
// @lc code=end

