/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length <= 0)
            return;
        int nonZeroTail = 0;
        for (int cur = 0; cur < nums.length; ++cur) {
            if (nums[cur] != 0)
                nums[nonZeroTail++] = nums[cur];
        }
        while (nonZeroTail < nums.length)
            nums[nonZeroTail++] = 0;
    }
}
// @lc code=end

