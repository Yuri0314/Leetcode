import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int ans = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int leftLength = (map.containsKey(num - 1)) ? map.get(num - 1) : 0;
                int rightLength = (map.containsKey(num + 1)) ? map.get(num + 1) : 0;
                int curLength = leftLength + rightLength + 1;
                map.put(num - leftLength, curLength);
                map.put(num + rightLength, curLength);
                map.put(num, curLength);
                ans = Math.max(ans, curLength);
            }
        }
        return ans;
    }
}
// @lc code=end

