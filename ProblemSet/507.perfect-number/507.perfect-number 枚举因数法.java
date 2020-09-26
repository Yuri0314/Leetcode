/*
 * @lc app=leetcode id=507 lang=java
 *
 * [507] Perfect Number
 */

// @lc code=start
class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;
        int sum = 1;
        double sqrt = Math.sqrt(num);
        int i = 2;
        for (; i < sqrt; ++i) {
            if (num % i == 0) 
                sum += i + num / i;
        }
        if (i * i == num) sum += i;
        return sum == num;
    }
}
// @lc code=end

