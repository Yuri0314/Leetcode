// 时间复杂度O(nlogn)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        for (int i = nums.length / 2 - 1; i >= 0; --i)
            maxHeapify(nums, i, nums.length);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, i, 0);
            maxHeapify(nums, 0, i);
        }
        return nums[0];
    }

    private void maxHeapify(int[] nums, int root, int len) {
        int tmp = nums[root];
        while ((root * 2) + 1 < len) {
            int child = (root * 2) + 1;
            if (child + 1 != len && nums[child] < nums[child + 1]) ++child;
            if (tmp >= nums[child]) break;
            else nums[root] = nums[child];
            root = child;
        }
        nums[root] = tmp;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}