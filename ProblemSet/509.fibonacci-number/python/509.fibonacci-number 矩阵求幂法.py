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
        ans = [[1, 0], [0, 1]]
        a = [[1, 1], [1, 0]]
        n -= 1
        while n > 0:
            if n & 1:
                self.matrix_mul(ans, a)
            self.matrix_mul(a, a)
            n >>= 1
        return ans[0][0]
        
    def matrix_mul(self, a: List[List[int]], b: List[List[int]]):
        x11 = a[0][0] * b[0][0] + a[0][1] * b[1][0]
        x12 = a[0][0] * b[0][1] + a[0][1] * b[1][1]
        x21 = a[1][0] * b[0][0] + a[1][1] * b[1][0]
        x22 = a[1][0] * b[0][1] + a[1][1] * b[1][1]

        a[0][0], a[0][1], a[1][0], a[1][1] = x11, x12, x21, x22
        
# @lc code=end

