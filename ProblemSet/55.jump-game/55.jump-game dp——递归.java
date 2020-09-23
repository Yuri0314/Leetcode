/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    private int[] nums;
    private boolean[] memo; // true表示访问过，false表示未访问过
    public boolean canJump(int[] nums) {
        this.nums = nums;
        memo = new boolean[nums.length];
        return search(0);
    }

    private boolean search(int pos) { 
        if (pos == nums.length  - 1) return true;
        if (memo[pos]) return false;    // 若当前位置访问过，说明该位置无法到达
        int furthestPos = Math.min(pos + nums[pos], nums.length - 1);
        for (int nextPos = furthestPos; nextPos > pos && !memo[nextPos]; --nextPos) {
            if (search(nextPos))
                return true;
        }
        memo[pos] = true;
        return false;
    }
}
// @lc code=end

