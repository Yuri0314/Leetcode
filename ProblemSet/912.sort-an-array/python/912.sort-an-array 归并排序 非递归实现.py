#
# @lc app=leetcode id=912 lang=python3
#
# [912] Sort an Array
#

# @lc code=start
class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        self.n = len(nums)
        self.mergeSort(nums)
        return nums

    def mergeSort(self, nums: List[int]) -> None:
        tmp = [None] * (self.n)
        subLen = 1
        while subLen < self.n:
            self.mergePass(nums, tmp, subLen)
            subLen <<= 1
            self.mergePass(tmp, nums, subLen)
            subLen <<= 1

    def mergePass(self, nums: List[int], tmp: List[int], subLen: int) -> None:
        pos = 0
        while pos <= self.n - 2 * subLen:
            self.merge(nums, tmp, pos, pos + subLen - 1, pos + subLen, pos + 2 * subLen - 1)
            pos += 2 * subLen
        if pos + subLen < self.n:
            self.merge(nums, tmp, pos, pos + subLen - 1, pos + subLen, self.n - 1)
        else:
            tmp[pos : self.n] = nums[pos : self.n]

    def merge(self, nums: List[int], tmp: List[int], lStart: int, lEnd: int, rStart: int, rEnd: int) -> None:
        i, j, pos = lStart, rStart, lStart
        while i <= lEnd and j <= rEnd:
            if nums[i] <= nums[j]:
                tmp[pos] = nums[i]
                i += 1
            else:
                tmp[pos] = nums[j]
                j += 1
            pos += 1
        tmp[pos : rEnd + 1] = nums[i : lEnd + 1] if i <= lEnd else nums[j : rEnd + 1]
        

# @lc code=end

