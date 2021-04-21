class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if ((long)mid * mid <= x) {
                l = mid + 1;
                ans = mid;
            }
            else r = mid - 1;
        }
        return ans;
    }
}