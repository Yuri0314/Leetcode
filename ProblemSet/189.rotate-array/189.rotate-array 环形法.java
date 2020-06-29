/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; ++start) {
            int pos = start;
            int pre = nums[start];
            do {
                int next = (pos + k) % nums.length;
                int tmp = nums[next];
                nums[next] = pre;
                pre = tmp;
                pos = next;
                ++count;
            } while (pos != start);
        }
    }
}
// @lc code=end

