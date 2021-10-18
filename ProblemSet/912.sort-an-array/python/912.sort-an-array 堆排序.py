#
# @lc app=leetcode id=912 lang=python3
#
# [912] Sort an Array
#

# @lc code=start
class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        self.n = len(nums)
        self.heapSort(nums)
        return nums

    def heapSort(self, nums: List[int]) -> None:
        for i in range((self.n >> 1) - 1, -1, -1):
            self.maxHeapify(nums, i, self.n)
        for i in range(self.n - 1, 0, -1):
            nums[0], nums[i] = nums[i], nums[0]
            self.maxHeapify(nums, 0, i)

    def maxHeapify(self, nums: List[int], root: int, len: int) -> None:
        tmp = nums[root]
        while (root << 1) + 1 < len:
            child = (root << 1) + 1
            if child + 1 != len and nums[child] < nums[child + 1]:
                child += 1
            if tmp >= nums[child]:
                break
            else:
                nums[root] = nums[child]
            root = child
        nums[root] = tmp

# @lc code=end

