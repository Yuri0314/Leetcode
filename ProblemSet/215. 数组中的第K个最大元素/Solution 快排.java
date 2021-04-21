// 期望时间复杂度O(n)
class Solution {
    private int[] nums;
    private int index;
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        this.index = nums.length - k;
        return quickSearch(0, nums.length - 1);
    }

    private int quickSearch(int l, int r) {
        int pos = partition(l, r);
        if (pos == index) return nums[pos];
        else return pos < index ? quickSearch(pos + 1, r) : quickSearch(l, pos - 1);
    }

    private int partition(int l, int r) {
        int pivotIndex = new Random().nextInt(r - l + 1) + l;
        int tmp = nums[l];
        nums[l] = nums[pivotIndex];
        nums[pivotIndex] = tmp;
        int low = l, high = r, pivot = nums[l];
        while (low < high) {
            while (low < high && nums[high] >= pivot) --high;
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot) ++low;
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }
}