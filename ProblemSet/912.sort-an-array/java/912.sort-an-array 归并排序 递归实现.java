/*
 * @lc app=leetcode id=912 lang=java
 *
 * [912] Sort an Array
 */

// @lc code=start
class Solution {
    private int[] tmp;
    public int[] sortArray(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, mid + 1, right);
        }
    }

    private void merge(int[] nums, int lStart, int lEnd, int rStart, int rEnd) {
        int i = lStart, j = rStart, pos = lStart;
        while (i <= lEnd && j <= rEnd) tmp[pos++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        while (i <= lEnd) tmp[pos++] = nums[i++];
        while (j <= rEnd) tmp[pos++] = nums[j++];
        for (int k = lStart; k <= rEnd; ++k) nums[k] = tmp[k];
    }
}
// @lc code=end

