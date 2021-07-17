/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = cleanSpaces(s);
        reverse(sb, 0, sb.length() - 1);
        reverseWords(sb);
        return sb.toString();
    }

    private StringBuilder cleanSpaces(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r && s.charAt(l) == ' ') ++l;
        while (l <= r && s.charAt(r) == ' ') -- r;
        StringBuilder sb = new StringBuilder();
        while (l <= r) {
            char c = s.charAt(l);
            if (c != ' ' || s.charAt(l - 1) != ' ')
                sb.append(c);
            ++l;
        }
        return sb;
    }

    private void reverse(StringBuilder sb, int l, int r) {
        while (l < r) {
            char t = sb.charAt(l);
            sb.setCharAt(l++, sb.charAt(r));
            sb.setCharAt(r--, t);
        }
    }

    private void reverseWords(StringBuilder sb) {
        int l = 0, r = 0;
        int n = sb.length();
        while (l < n) {
            while (r < n && sb.charAt(r) != ' ') ++r;
            reverse(sb, l, r - 1);
            l = r + 1;
            ++r;
        }
    }
}


// @lc code=end

