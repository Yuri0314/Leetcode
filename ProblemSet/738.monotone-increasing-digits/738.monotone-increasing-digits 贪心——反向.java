/*
 * @lc app=leetcode id=738 lang=java
 *
 * [738] Monotone Increasing Digits
 */

// @lc code=start
class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] str = String.valueOf(N).toCharArray();
        int pos = str.length;   // pos表示从末尾起最左边的违反单调递增的位置
        for (int i = str.length - 1; i > 0; --i) {
            if (str[i - 1] > str[i]) {
                --str[i - 1];
                pos = i;
            }
        }
        for (int i = pos; i < str.length; ++i)
            str[i] = '9';
        return Integer.parseInt(String.valueOf(str));
    }
}
// @lc code=end

