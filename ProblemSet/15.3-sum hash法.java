import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Set<Integer> set = new HashSet<Integer>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; ++j) {
                Integer value = -nums[i] - nums[j];
                if (set.contains(value)) {
                    ans.add(Arrays.asList(nums[i], value, nums[j]));
                    while ((j + 1) < nums.length && nums[j] == nums[j + 1]) 
                        ++j;
                }
                else set.add(nums[j]);
            }
            set.clear();
        }
        return ans;
    } 
}
// @lc code=end

