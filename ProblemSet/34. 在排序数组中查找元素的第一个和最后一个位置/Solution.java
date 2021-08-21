class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        ans[0] = binarySearch(nums, target, true); // 查找左边界
        ans[1] = binarySearch(nums, target, false); // 查找右边界

        return ans;
    }
    
    /**
     * @param leftRight 为true寻找左边界，为false则寻找右边界
     */
    public int binarySearch(int[] nums, int target, boolean leftRight) {
        int ans = -1;
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans = mid;
                if (leftRight) right = mid - 1; // 寻找左边界，则在mid左边继续找
                else left = mid + 1; // 寻找右边界，则在mid右边继续找
            } else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return ans;
    }
}
