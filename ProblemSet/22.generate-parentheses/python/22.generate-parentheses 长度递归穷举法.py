from functools import lru_cache

#
# @lc app=leetcode id=22 lang=python3
#
# [22] Generate Parentheses
#

# @lc code=start
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        @lru_cache(n + 1)
        def generate(n: int) -> List[str]:
            if n == 0:
                return ['']
            ans = []
            for i in range(n):
                for a in generate(i):
                    for b in generate(n - i - 1):
                        ans.append('({}){}'.format(a, b))
            return ans
        
        return generate(n)
        
# @lc code=end

