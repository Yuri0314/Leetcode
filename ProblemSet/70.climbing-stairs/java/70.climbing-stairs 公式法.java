/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if (n == 0) return 0;
        double glodenRatio = (1 + Math.sqrt(5)) / 2;
        return (int)Math.round(Math.pow(glodenRatio, n + 1) / Math.sqrt(5));
    }
}
// @lc code=end

