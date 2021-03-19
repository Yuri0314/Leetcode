#
# @lc app=leetcode id=509 lang=python3
#
# [509] Fibonacci Number
#

# @lc code=start
class Solution:
    def fib(self, n: int) -> int:
        gloden_ratio = (1 + 5 ** 0.5) / 2
        return round(gloden_ratio ** n / (5 ** 0.5))
        
        
# @lc code=end

