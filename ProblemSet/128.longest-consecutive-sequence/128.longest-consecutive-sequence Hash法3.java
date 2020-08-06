import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int ans = 0;
        for (int num : nums) set.add(num);
        for (int num : nums) {
            int length = 1;
            int cur = num;
            while (set.contains(--cur)) {
                ++length;
                set.remove(cur);
            }
            cur = num;
            while (set.contains(++cur)) {
                ++length;
                set.remove(cur);
            }
            set.remove(num);
            ans = Math.max(ans, length);
        }
        return ans;
    }
}
// @lc code=end

