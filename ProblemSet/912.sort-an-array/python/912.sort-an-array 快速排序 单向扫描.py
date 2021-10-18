import random

#
# @lc app=leetcode id=912 lang=python3
#
# [912] Sort an Array
#

# @lc code=start
class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        self.quickSort(nums, 0, len(nums) - 1)
        return nums


    def quickSort(self, nums: List[int], left: int, right: int) -> List[int]:
        if left < right:
            pos = self.partition(nums, left, right)
            self.quickSort(nums, left, pos - 1)
            self.quickSort(nums, pos + 1, right)

    
    def partition(self, nums: List[int], left: int, right: int) -> int:
        pivot = random.randint(0, right - left) + left
        nums[left], nums[pivot] = nums[pivot], nums[left]
        i = left
        for j in range(left + 1, right + 1):
            if nums[j] < nums[left]:
                i += 1
                nums[i], nums[j] = nums[j], nums[i]
        nums[left], nums[i] = nums[i], nums[left]
        return i


# @lc code=end

