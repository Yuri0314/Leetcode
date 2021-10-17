import java.util.Random;

/*
 * @lc app=leetcode id=912 lang=java
 *
 * [912] Sort an Array
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pos = partition(nums, left, right);
            quickSort(nums, left, pos - 1);
            quickSort(nums, pos + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivotIndex = new Random().nextInt(right - left + 1) + left;
        swap(nums, left, pivotIndex);
        int low = left + 1, high = right, pivot = nums[left];
        while (true) {
            while (low <= high && nums[low] < pivot) ++low;
            while (low <= high && nums[high] > pivot) --high;
            if (low < high) {
                swap(nums, low, high);
                ++low;
                --high;
            }
            else break;
        }
        swap(nums, left, high);
        return high;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
// @lc code=end

