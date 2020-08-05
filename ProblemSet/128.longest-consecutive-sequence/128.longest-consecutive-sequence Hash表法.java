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
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums)
            num_set.add(num);
        
        int longestStrak = 0;
        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int curNum = num;
                int curStrak = 1;
                while (num_set.contains(++curNum)) ++curStrak;
                longestStrak = Math.max(longestStrak, curStrak);
            }
        }
        return longestStrak;
    }
}
// @lc code=end

