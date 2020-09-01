/*
 * @lc app=leetcode id=912 lang=java
 *
 * [912] Sort an Array
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] nums) {
        int[] tmp = new int[nums.length];
        mergeSort(nums, tmp, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int[] tmp, int left, int right) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            mergeSort(nums, tmp, left, mid);
            mergeSort(nums, tmp, mid + 1, right);
            merge(nums, tmp, left, mid, mid + 1, right);
        }
    }

    private void merge(int[] nums, int[] tmp, int lstart, int lend, int rstart, int rend) {
        int i = lstart, j = rstart, pos = lstart;
        while (i <= lend && j <= rend) tmp[pos++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        while (i <= lend) tmp[pos++] = nums[i++];
        while (j <= rend) tmp[pos++] = nums[j++];
        for (int k = lstart; k <= rend; ++k) nums[k] = tmp[k];
    }
}
// @lc code=end

