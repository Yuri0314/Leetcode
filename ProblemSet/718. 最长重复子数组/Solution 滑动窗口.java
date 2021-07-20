// 时间复杂度为O((m + n) * min(m, n))
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int tmp = findMaxLength(nums1, nums2, i, 0, Math.min(n - i, m));
            ans = Math.max(ans, tmp);
        }
        for (int j = 0; j < m; ++j) {
            int tmp = findMaxLength(nums1, nums2, 0, j, Math.min(n, m - j));
            ans = Math.max(ans, tmp);
        }
        return ans;
    }

    private int findMaxLength(int[] nums1, int[] nums2,int i, int j, int len) {
        int ans = 0, tmp = 0;
        for (int t = 0; t < len; ++t) {
            if (nums1[i + t] == nums2[j + t]) ++tmp;
            else tmp = 0;
            ans = Math.max(ans, tmp);
        }
        return ans;
    }
}