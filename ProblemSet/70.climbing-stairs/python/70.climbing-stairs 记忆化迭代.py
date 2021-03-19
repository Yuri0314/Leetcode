#
# @lc app=leetcode id=70 lang=python3
#
# [70] Climbing Stairs
#

# @lc code=start
class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 2:
            return n
        pre1, pre2 = 1, 2
        for _ in range(3, n + 1):
            pre1, pre2 = pre2, pre1 + pre2
        return pre2
        
# @lc code=end

