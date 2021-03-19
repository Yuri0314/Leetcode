#
# @lc app=leetcode id=509 lang=python3
#
# [509] Fibonacci Number
#

# @lc code=start
class Solution:
    def fib(self, n: int) -> int:
        if n <= 1:
            return n
        pre1, pre2 = 0, 1
        for _ in range(2, n + 1):
            pre1, pre2 = pre2, pre1 + pre2
        return pre2
        
# @lc code=end

