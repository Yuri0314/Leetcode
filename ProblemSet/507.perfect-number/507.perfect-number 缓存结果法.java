/*
 * @lc app=leetcode id=507 lang=java
 *
 * [507] Perfect Number
 */

// @lc code=start
class Solution {
    public boolean checkPerfectNumber(int num) {
        int[] perfectNums = {6, 28, 496, 8128, 33550336};
        for (int x : perfectNums) {
            if (x == num)
                return true;
        }
        return false;
    }
}
// @lc code=end

