class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int start = 0, end = 0; end < n; ++end) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}