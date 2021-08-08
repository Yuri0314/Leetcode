#
# @lc app=leetcode id=912 lang=python3
#
# [912] Sort an Array
#

# @lc code=start
class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        self.tmp = [None] * len(nums)
        self.mergeSort(nums, 0, len(nums) - 1)
        return nums

    def mergeSort(self, nums: List[int], left: int, right: int) -> None:
        if left < right:
            mid = left + ((right - left) >> 1)
            self.mergeSort(nums, left, mid)
            self.mergeSort(nums, mid + 1, right)
            self.merge(nums, left, mid, mid + 1, right)

    def merge(self, nums: List[int], lStart: int, lEnd: int, rStart: int, rEnd: int) -> None:
        i, j, pos = lStart, rStart, lStart
        while i <= lEnd and j <= rEnd:
            if nums[i] <= nums[j]:
                self.tmp[pos] = nums[i]
                i += 1
            else:
                self.tmp[pos] = nums[j]
                j += 1
            pos += 1
        self.tmp[pos : rEnd + 1] = nums[i : lEnd + 1] if i <= lEnd else nums[j : rEnd + 1]
        nums[lStart : rEnd + 1] = self.tmp[lStart : rEnd + 1]
        

# @lc code=end

