/*
 * @lc app=leetcode id=507 lang=java
 *
 * [507] Perfect Number
 */

// @lc code=start
class Solution {
    public boolean checkPerfectNumber(int num) {
        int[] primes=new int[]{2,3,5,7,13,17,19,31};
        for (int prime : primes) {
            if (pn(prime) == num)
                return true;
        }
        return false;
    }

    private int pn(int p) {
        return (1 << (p - 1)) * ((1 << p) - 1);
    }
}
// @lc code=end

