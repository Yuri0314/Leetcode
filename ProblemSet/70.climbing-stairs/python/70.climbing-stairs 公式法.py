#
# @lc app=leetcode id=70 lang=python3
#
# [70] Climbing Stairs
#

# @lc code=start
class Solution:
    def climbStairs(self, n: int) -> int:
        if n == 0:
            return 0
        gloden_ratio = (1 + 5 ** 0.5) / 2
        return round(gloden_ratio ** (n + 1) / (5 ** 0.5))
        
# @lc code=end

