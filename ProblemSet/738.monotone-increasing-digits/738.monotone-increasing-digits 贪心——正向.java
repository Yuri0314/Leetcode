/*
 * @lc app=leetcode id=738 lang=java
 *
 * [738] Monotone Increasing Digits
 */

// @lc code=start
class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] str = String.valueOf(N).toCharArray();
        int pos = 1;
        while (pos < str.length && str[pos - 1] <= str[pos]) ++pos;
        if (pos != str.length) {    // 如果不是到达结尾，说明原数字并不是单调递增的
            while (pos > 0 && str[pos - 1] > str[pos]) --str[--pos];
            while (pos < str.length - 1) str[++pos] = '9';
        }
        return Integer.parseInt(String.valueOf(str));
    }
}
// @lc code=end

