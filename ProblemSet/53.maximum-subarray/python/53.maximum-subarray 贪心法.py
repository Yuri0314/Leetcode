import sys

#
# @lc app=leetcode id=53 lang=python3
#
# [53] Maximum Subarray
#

# @lc code=start
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        maxSum, cur = -sys.maxsize - 1, 0
        for num in nums:
            cur += num
            maxSum = max(maxSum, cur)
            cur = max(cur, 0) 
        return maxSum
# @lc code=end

