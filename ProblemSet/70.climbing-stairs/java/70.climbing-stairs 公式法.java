/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        double glodenRatio = (1 + Math.sqrt(5)) / 2;
        return (int)Math.round(Math.pow(glodenRatio, n + 1) / Math.sqrt(5));
    }
}
// @lc code=end

