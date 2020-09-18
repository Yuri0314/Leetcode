import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> seen = new HashSet<Integer>();
        queue.add(0);
        int steps = 0;
        while (!queue.isEmpty()) {
            ++steps;
            for (int sz = queue.size(); sz > 0; --sz) {
                int cur = queue.remove();
                for (int i = 0; i < coins.length; ++i) {
                    int next = cur + coins[i];
                    if (next == amount) return steps;
                    if (next < amount && seen.add(next)) queue.add(next);
                }
            }
        }
        return -1;
    }
}
// @lc code=end

