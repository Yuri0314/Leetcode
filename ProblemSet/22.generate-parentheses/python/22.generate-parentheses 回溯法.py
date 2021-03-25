#
# @lc app=leetcode id=22 lang=python3
#
# [22] Generate Parentheses
#

# @lc code=start
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        ans = []
        def backtrace(cur: List[str], left_num: int, right_num: int) -> None:
            if len(cur) == 2 * n:
                ans.append(''.join(cur))
                return
            if left_num < n:
                cur.append('(')
                backtrace(cur, left_num + 1, right_num)
                cur.pop()
            if right_num < left_num:
                cur.append(')')
                backtrace(cur, left_num, right_num + 1)
                cur.pop()
        
        backtrace([], 0, 0)
        return ans
        
# @lc code=end

