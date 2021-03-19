/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */

// @lc code=start
class Solution {
    public int fib(int N) {
        double glodenRatio = (1 + Math.sqrt(5)) / 2;
        return (int)Math.round(Math.pow(glodenRatio, N) / Math.sqrt(5));
    }
}
// @lc code=end

