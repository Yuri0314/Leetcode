/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int cur = 0;
        int start = 0;
        for (int i = 0; i < gas.length; ++i) {
            int tmp = gas[i] - cost[i];
            total += tmp;
            cur += tmp;
            if (cur < 0) {
                cur = 0;
                start = i + 1;
            }
        }
        return total < 0 ? -1 : start;
    }
}
// @lc code=end

