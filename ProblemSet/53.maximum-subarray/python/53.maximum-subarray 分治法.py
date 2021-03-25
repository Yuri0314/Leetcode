#
# @lc app=leetcode id=53 lang=python3
#
# [53] Maximum Subarray
#

# @lc code=start
class Status:
    def __init__(self, lSum: int, rSum: int, mSum: int, tSum: int) -> None:
        self.lSum = lSum
        self.rSum = rSum
        self.mSum = mSum
        self.tSum = tSum

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        self.nums = nums
        return self.getSumInfo(0, len(nums) - 1).mSum

    def getSumInfo(self, l: int, r: int) -> Status:
        if l == r:
            return Status(self.nums[l], self.nums[l], self.nums[l], self.nums[l])
        
        m = l + ((r - l) >> 1)
        lStatus = self.getSumInfo(l, m)
        rStatus = self.getSumInfo(m + 1, r)
        lSum = max(lStatus.lSum, lStatus.tSum + rStatus.lSum)
        rSum = max(rStatus.rSum, rStatus.tSum + lStatus.rSum)
        mSum = max(lStatus.rSum + rStatus.lSum, max(lStatus.mSum, rStatus.mSum))
        tSum = lStatus.tSum + rStatus.tSum
        return Status(lSum, rSum, mSum, tSum)

# @lc code=end

