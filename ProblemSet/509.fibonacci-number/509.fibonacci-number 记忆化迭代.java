/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */

// @lc code=start
class Solution {
    public int fib(int N) {
        if (N <= 1) return N;
        int pre1 = 0, pre2 = 1, cur = 1;
        for (int i = 2; i <= N; ++i) {
            cur = pre1 + pre2;
            pre1 = pre2;
            pre2 = cur;
        }
        return cur;
    }
}
// @lc code=end

