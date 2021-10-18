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
        pivotIdx = random.randint(0, right - left) + left
        nums[left], nums[pivotIdx] = nums[pivotIdx], nums[left]
        low, high, pivot = left + 1, right, nums[left]
        while True:
            while low <= high and nums[low] < pivot:
                low += 1
            while low <= high and nums[high] > pivot:
                high -= 1
            if low < high:
                nums[low], nums[high] = nums[high], nums[low]
                low += 1
                high -= 1
            else:
                break
        nums[left], nums[high] = nums[high], nums[left]
        return high


# @lc code=end

