/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        long N = n; // 防止n取绝对值之后越界
        return N >= 0 ? fastPow(x, N) : 1.0 / fastPow(x, -N);
    }

    private double fastPow(double x, long N) {
        double ans = 1.0, tmp = x;
        while (N > 0) {
            if (N % 2 == 1) ans *= tmp;
            tmp *= tmp;
            N /= 2;
        }
        return ans;
    }
}
// @lc code=end

