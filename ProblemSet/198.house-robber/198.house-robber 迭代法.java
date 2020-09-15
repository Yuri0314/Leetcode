import java.util.Arrays;

/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int first = 0;
        int second = 0;
        for (int num : nums) {
            int tmp = second;
            second = Math.max(num + first, second);
            first = tmp;
        }
        return second;
    }
}
// @lc code=end

