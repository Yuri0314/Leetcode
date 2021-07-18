/*
 * @lc app=leetcode id=912 lang=java
 *
 * [912] Sort an Array
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums);
        return nums;
    }

    private void mergeSort(int[] nums) {
        int[] tmp = new int[nums.length];
        int sublen = 1;
        while (sublen < nums.length) {
            mergePass(nums, tmp, sublen);
            sublen *= 2;
            mergePass(tmp, nums, sublen);
            sublen *= 2;
        }
    }

    private void mergePass(int[] nums, int[] tmp, int sublen) {
        int pos = 0;
        while (pos <= nums.length - 2 * sublen) {
            merge(nums, tmp, pos, pos + sublen - 1, pos + sublen, pos + 2 * sublen - 1);
            pos += 2 * sublen;
        }
        if (pos + sublen < nums.length) merge(nums, tmp, pos, pos + sublen - 1, pos + sublen, nums.length - 1);
        else for (int i = pos; i < nums.length; ++i) tmp[i] = nums[i];
    }

    private void merge(int[] nums, int[] tmp, int lstart, int lend, int rstart, int rend) {
        int i = lstart, j = rstart, pos = lstart;
        while (i <= lend && j <= rend) tmp[pos++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        while (i <= lend) tmp[pos++] = nums[i++];
        while (j <= rend) tmp[pos++] = nums[j++];
    }
}
// @lc code=end

